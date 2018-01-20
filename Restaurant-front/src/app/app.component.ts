import {Component, OnInit} from '@angular/core';
import {TableService} from './table/table.service';
import {Boisson} from './bean/boisson';
import {Plat} from './bean/plat';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  hasSalle = false;
  hasTable = false;
  nomSalle = '';
  numTable: number;
  boissons: Boisson[] = [];
  plats: Plat[] = [];
  softs: Boisson[] = [];
  chaudes: Boisson[] = [];
  aperitifs: Boisson[] = [];
  digestifs: Boisson[] = [];
  vins: Boisson[] = [];
  bieres: Boisson[] = [];
  pizzas: Plat[] = [];
  entrees: Plat[] = [];
  pates: Plat[] = [];
  desserts: Plat[] = [];
  gpizzas: Plat[] = [];
  ppizzas: Plat[] = [];
  gpates: Plat[] = [];
  ppates: Plat[] = [];

  ngOnInit(): void {
    this.getBoissons();
    this.getPlats();
  }

   constructor(private tableService: TableService) {}

  getBoissons(): void {
    this.tableService.getBoissons()
      .subscribe(data => {
        for (let i = 0; i < data.length; i++) {
          switch (data[i].categorie) {
            case 'soft':
              this.softs.push(data[i]);
              break;
            case 'biere':
              this.bieres.push(data[i]);
              break;
            case 'aperitif':
              this.aperitifs.push(data[i]);
              break;
            case 'vin':
              this.vins.push(data[i]);
              break;
            case 'digestif':
              this.digestifs.push(data[i]);
              break;
            case 'chaude':
              this.chaudes.push(data[i]);
              break;
          }
        }
      }, error => {
        console.log(error);
      });
  }

  getPlats(): void {
    this.tableService.getPlats()
      .subscribe(data => {
        this.plats = data;
        for (let i = 0; i < this.plats.length; i++) {
          switch (this.plats[i].categorie) {
            case 'pizza':
              this.pizzas.push(this.plats[i]);
              break;
            case 'pates':
              this.pates.push(this.plats[i]);
              break;
            case 'dessert':
              this.desserts.push(this.plats[i]);
              break;
            case 'entree':
              this.entrees.push(this.plats[i]);
              break;
          }
        }
        for (let i = 0; i < this.pizzas.length; i++) {
          switch (this.pizzas[i].sousCategorie) {
            case 'grande':
              this.gpizzas.push(this.pizzas[i]);
              break;
            case 'petite':
              this.ppizzas.push(this.pizzas[i]);
              break;
          }
        }
      }, error => {
        console.log(error);
      });
  }

}
