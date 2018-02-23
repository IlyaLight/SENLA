import { Component, OnInit } from '@angular/core';
import {User} from './user';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.scss']
})
export class UserPageComponent implements OnInit {

  users: User = new User();

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.http.get('http://localhost:8080/security/getUser')
      .subscribe((data: User) => {
        this.users = data; },
      error => {
        this.users.userName = error.massag;
        console.log(error); });
  }

}
