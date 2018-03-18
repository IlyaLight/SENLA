import {AfterViewInit, Component, ViewChild} from '@angular/core';
import {HttpService} from '../service/http.service';
import {Car} from '../json-models/car';
import {ActivatedRoute} from '@angular/router';
import {MatTableDataSource, MatSort} from '@angular/material';

@Component({
  selector: 'app-car-selection-page',
  templateUrl: './car-selection-page.component.html',
  styleUrls: ['./car-selection-page.component.scss'],
  providers: [HttpService]
})
export class CarSelectionPageComponent implements AfterViewInit {

  constructor(private httpService: HttpService, private activateRoute: ActivatedRoute) {
    this.httpService.get('http://localhost:8080/getAllCars')
      .subscribe(
       (data: Car[]) => this.dataSource = new MatTableDataSource(data)
      );
  }

  displayedColumns = ['brand', 'model', 'year', 'typeOfFuel', 'engineCapacity'];
  dataSource: MatTableDataSource<Car> = new MatTableDataSource();

  @ViewChild(MatSort)
  sort: MatSort;

  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
  }

  // ngOnInit() {
  //   this.httpService.get('http://localhost:8080/getAllCars')
  //     .subscribe(
  //       (data: Car[]) => this.dataSource = new MatTableDataSource(data)
  //     );
  // }

}
