import {Component, ViewChild} from '@angular/core';
import {HttpService} from '../service/http.service';
import {Car} from '../json-models/car';
import {ActivatedRoute} from '@angular/router';
import {MatTableDataSource, MatSort} from '@angular/material';
import {SelectionModel} from "@angular/cdk/collections";

@Component({
  selector: 'app-car-selection-page',
  templateUrl: './car-selection-page.component.html',
  styleUrls: ['./car-selection-page.component.scss'],
  providers: [HttpService]
})
export class CarSelectionPageComponent {

  constructor(private httpService: HttpService, public activatedRoute: ActivatedRoute) {
  }

  displayedColumns = ['select', 'brand', 'model', 'year', 'typeOfFuel', 'engineCapacity'];
  dataSource = new MatTableDataSource();
  selection = new SelectionModel<Element>(true, []);

  @ViewChild(MatSort)
  sort: MatSort;

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // MatTableDataSource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }

  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
  }

  ngOnInit(){
    this.httpService.get('http://localhost:8080/getAllCars')
      .subscribe(
        (data: Car[]) => this.dataSource.data = data);
  }

  /** Whether the number of selected elements matches the total number of rows. */
  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.dataSource.filteredData.length;
    return numSelected === numRows;
  }

  /** Selects all rows if they are not all selected; otherwise clear selection. */
  masterToggle() {
    this.isAllSelected() ?
      this.selection.clear() :
      this.dataSource.filteredData.forEach(row => this.selection.select(<Element>row));
  }
}
