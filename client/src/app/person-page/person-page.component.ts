import { Component, OnInit } from '@angular/core';
import {Person} from '../json-models/person';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-person-page',
  templateUrl: './person-page.component.html',
  styleUrls: ['./person-page.component.scss']
})
export class PersonPageComponent implements OnInit {

  person: Person = new Person();

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.http.get('http://localhost:8080/security/getUser')
      .subscribe((data: Person) => {
        this.person = data; },
      error => {
        console.log(error); });
  }

}
