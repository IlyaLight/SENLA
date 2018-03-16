import { Component, OnInit } from '@angular/core';
import {Goods} from '../json-models/goods';
import {ImgService} from '../service/img.service';
import {Car} from '../json-models/car';
import {CookieService} from 'angular2-cookie/core';

@Component({
  selector: 'app-good-registration-page',
  templateUrl: './good-registration-page.component.html',
  styleUrls: ['./good-registration-page.component.scss'],
  providers: [ImgService]
})
export class GoodRegistrationPageComponent implements OnInit {

  constructor(private imgService: ImgService, private cookieService: CookieService) {}

  displayedColumns = ['brand', 'model', 'year', 'typeOfFuel', 'engineCapacity'];

  cars: Car[] = [
    {id: 1, brand: 'brand', model: 'model', year: 10, engineCapacity: 10, typeOfFuel: 'gas'    }
  ];
  goods: Goods = new Goods();

  setCookie(name: string, val: Goods) {
    this.cookieService.putObject(name, val);
  }

  getCookie(name: string) {
    return this.cookieService.getObject(name);
  }

  ngOnInit() {
    // this.goods = <Goods>this.getCookie('good');
  }

}
