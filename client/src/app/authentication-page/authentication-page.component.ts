import {Component} from '@angular/core';
import {Login} from '../json-models/login';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './authentication-page.component.html',
  styleUrls: ['./authentication-page.component.scss']
})
export class AuthenticationPageComponent {
  hide = true;       // for password input
  message: string = null;

  login: Login = new Login();
  constructor(private http: HttpClient) {}
  authentication() {
    const myHeaders = new HttpHeaders().set('Content-Type', 'application/json'); // testing after
    this.http.post('http://localhost:8080/authentication', JSON.stringify(this.login), { withCredentials: true, headers: myHeaders})
      .subscribe(
        value => {
          // value - результат
          alert(value);
          this.message = null;
          location.href = '/';
        },
      error => {
          if (error.status === 401) {
            this.message = 'could not find user with such data';
          } else {
            alert(error);
          }
            this.login.login = null;
            this.login.password = null;
        }
      );
  }
}
