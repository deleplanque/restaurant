import { Component, OnInit } from '@angular/core';
import {Table} from '../bean/table';
import {TableService} from './table.service';
import {Boisson} from '../bean/boisson';
import {Plat} from '../bean/plat';
import {AppPage} from '../../../e2e/app.po';
import {AppComponent} from '../app.component';

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
  boissonsAddition: Boisson[];

  constructor(private tableService: TableService, private app: AppComponent) { }

  ngOnInit() {

    this.table = JSON.parse(sessionStorage.getItem('table'));
    this.app.numTable = this.table.numero;
    this.getBoissons();
    this.getPlats();
    this.getBoissonsAddition();
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

  getBoissonsAddition(): void {
    this.tableService.getBoissonsAddition(this.table.idTable)
      .subscribe(data => {
      this.boissonsAddition = data;
      console.log(data);
    }, error => {
      console.log(error);
    });
  }

  ajouterBoisson(id: number): void {
    this.tableService.addBoisson(this.table.idTable, id).subscribe(data => {
      this.boissonsAddition = data.addition.boissons;
      console.log(data.addition.boissons);
    }, error => {
      console.log(error);
    });
  }

  supprimerBoisson(id: number): void {
    this.tableService.removeBoisson(this.table.idTable, id).subscribe(data => {
      this.boissonsAddition = data.addition.boissons;
    }, error => {
      console.log(error);
    });
  }

}
