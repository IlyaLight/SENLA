import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Login} from '../json-models/login';
import {Person} from '../json-models/person';
import {PersonStatus} from '../json-models/personStatusEnum';
import {HttpService} from '../service/http.service';

@Component({
  selector: 'app-buyer-registration-page',
  templateUrl: './buyer-registration-page.component.html',
  styleUrls: ['./buyer-registration-page.component.scss'],
  providers: [HttpService]
})
export class BuyerRegistrationPageComponent  {

  constructor(private httpService: HttpService) {}

  login: Login = new Login();
  person: Person = new Person();

  registration() {
    this.person.active = true;
    this.person.status = PersonStatus.BUYER;
    this.person.login = this.login; // почему так?
    this.httpService.post('http://localhost:8080/createBuyer', this.person )
      .subscribe(
        value => {
          // value - результат
          alert(value);
          location.href = '/';
          },
          error => {
          }
      );
  }
}
