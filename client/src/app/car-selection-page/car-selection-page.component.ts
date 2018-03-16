import { Component, OnInit } from '@angular/core';
import {HttpService} from "../service/http.service";
import {Car} from "../json-models/car";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-car-selection-page',
  templateUrl: './car-selection-page.component.html',
  styleUrls: ['./car-selection-page.component.scss'],
  providers: [HttpService]
})
export class CarSelectionPageComponent implements OnInit {

  constructor(private httpService: HttpService, private activateRoute: ActivatedRoute) { }

  displayedColumns = ['brand', 'model', 'year', 'typeOfFuel', 'engineCapacity'];

  cars: Car[] = [
    {id: 1, brand: 'brand', model: 'model', year: 10, engineCapacity: 10, typeOfFuel: 'gas'    }
  ];

  ngOnInit() {
    this.httpService.get('http://localhost:8080/getAllCars')
      .subscribe((data: Car[]) => this.cars = data);
  }

}
