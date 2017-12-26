import { Component, OnInit } from '@angular/core';
import {Table} from '../bean/table';

@Component({
  selector: 'app-payer-separement',
  templateUrl: './payer-separement.component.html',
  styleUrls: ['./payer-separement.component.css']
})
export class PayerSeparementComponent implements OnInit {

  constructor() { }

  table: Table;
  tabBoissons: any;
  tabPlats: any;

  ngOnInit() {
    this.table = JSON.parse(sessionStorage.getItem('table'));
    this.tabBoissons = this.table.tabBoissons;
    this.tabPlats = this.table.tabPlats;
  }

}
