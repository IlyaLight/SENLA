import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';

@Injectable()
export class HttpService {

  constructor(private http: HttpClient) {}

  post( url: string, data: any) {
    const myHeaders = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.post(url, JSON.stringify(data) , { withCredentials: true, headers: myHeaders});
  }
}
