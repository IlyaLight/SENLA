
import {HttpClient, HttpHeaders} from '@angular/common/http';
import 'rxjs/add/operator/map';
import {Injectable} from "@angular/core";

@Injectable()
export class ImgService {

  constructor(private http: HttpClient) {}

  getImg( filePah: string) {
    const  url = 'http://via.placeholder.com/350x200';
    const myHeaders = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.get('http://via.placeholder.com/350x200')
      ;
  }
}
