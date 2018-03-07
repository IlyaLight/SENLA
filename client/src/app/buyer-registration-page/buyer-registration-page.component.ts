import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Login} from '../json-models/login';
import {Person} from '../json-models/person';
import {PersonStatus} from '../json-models/personStatusEnum';

@Component({
  selector: 'app-buyer-registration-page',
  templateUrl: './buyer-registration-page.component.html',
  styleUrls: ['./buyer-registration-page.component.scss']
})
export class BuyerRegistrationPageComponent  {

  constructor(private http: HttpClient) {}

  login: Login = new Login();
  person: Person = new Person();

  registration() {
    this.person.active = true;
    this.person.status = PersonStatus.BUYER;
    this.person.login = this.login;
    const myHeaders = new HttpHeaders().set('Content-Type', 'application/json'); // testing after
    // const body: Array<string> = [ JSON.stringify(this.login),  JSON.stringify(this.person)];
    this.http.post('http://localhost:8080/createPerson', JSON.stringify(this.person) , { withCredentials: true, headers: myHeaders})
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
