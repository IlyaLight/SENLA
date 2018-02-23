import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Account} from './account';

@Injectable()
export class HttpService {

  constructor(private http: HttpClient) { }

  postData(account: Account) {
    // const myHeaders = new HttpHeaders().set('Content-Type', 'application/json'); // testing after

    return this.http.post('http://localhost:8080/login', account);
  }
}
