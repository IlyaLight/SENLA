import { Component, OnInit } from '@angular/core';
import {Goods} from '../json-models/goods';
import {ImgService} from '../service/img.service';

@Component({
  selector: 'app-good-registration-page',
  templateUrl: './good-registration-page.component.html',
  styleUrls: ['./good-registration-page.component.scss'],
  providers: [ImgService]
})
export class GoodRegistrationPageComponent implements OnInit {

  constructor(private imgService: ImgService ) {}

  goods: Goods = new Goods();
  ngOnInit() {
  }

}
