import {Component} from '@angular/core';
import {Account} from './account';
import {HttpClient, HttpHeaders} from '@angular/common/http';


@Component({
  selector: 'app-login',
  templateUrl: './authentication.component.html',
  styleUrls: ['./authentication.component.scss']
})
export class AuthenticationComponent {
  hide = true;       // for password input
  massag: string = null;

  account: Account = new Account();
  constructor(private http: HttpClient) {}
  login() {
    const myHeaders = new HttpHeaders().set('Content-Type', 'application/json'); // testing after
    this.http.post('http://localhost:8080/login', JSON.stringify(this.account), {headers: myHeaders})
      .subscribe(value => {
        // value - результат
        this.massag = null;
        location.href = '/user';
      },
      error => {
      if (error.status === 401) {
        this.massag = 'could not find user with such data';
        this.account.login = null;
        this.account.pass = null;
      }
        // location.reload();
        // error - объект ошибки
      });
  }
    // this.httpService.postData(this.account);
       // }
}
