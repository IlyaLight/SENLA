import { Component, OnInit } from '@angular/core';
import {Car} from '../json-models/car';
import {HttpService} from '../service/http.service';

@Component({
  selector: 'app-car-registration-page',
  templateUrl: './car-registration-page.component.html',
  styleUrls: ['./car-registration-page.component.scss']
})
export class CarRegistrationPageComponent implements OnInit {

  constructor(private httpService: HttpService) { }

  car: Car = new Car();

  registration() {
    this.httpService.post('http://localhost:8080/createCar', this.car )
      .subscribe(
        value => {},
        error => {}
      );
  }

  ngOnInit() {
  }

}
