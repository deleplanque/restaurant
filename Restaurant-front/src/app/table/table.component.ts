import { Component, OnInit } from '@angular/core';
import {Table} from '../bean/table';
import {TableService} from './table.service';
import {Boisson} from '../bean/boisson';
import {Plat} from '../bean/plat';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  table: Table;
  boissons: Boisson[];
  plats: Plat[];
  softs: Boisson[] = [];
  chaudes: Boisson[] = [];
  aperitifs: Boisson[] = [];
  digestifs: Boisson[] = [];
  vins: Boisson[] = [];
  bieres: Boisson[] = [];


  constructor(private tableService: TableService) { }

  ngOnInit() {

    this.table = JSON.parse(sessionStorage.getItem('table'));
    console.log(this.table);
    this.getBoissons();
    this.getPlats();
  }

  getBoissons(): void {
    this.tableService.getBoissons()
      .subscribe(data => {
        this.boissons = data;
        for (let i = 0; i < this.boissons.length; i++) {
          switch (this.boissons[i].categorie) {
            case 'soft':
              this.softs.push(this.boissons[i]);
              break;
            case 'biere':
              this.bieres.push(this.boissons[i]);
              break;
            case 'aperitif':
              console.log(this.boissons[i].categorie);
              this.aperitifs.push(this.boissons[i]);
              break;
            case 'vin':
              this.vins.push(this.boissons[i]);
              break;
            case 'digestif':
              this.digestifs.push(this.boissons[i]);
              break;
            case 'chaude':
              this.chaudes.push(this.boissons[i]);
              break;
          }
        }
        console.log(data);
      }, error => {
        console.log(error);
      });
  }

  getPlats(): void {
    this.tableService.getPlats()
      .subscribe(data => {
        this.plats = data;
        console.log(data);
      }, error => {
        console.log(error);
      });
  }

}
