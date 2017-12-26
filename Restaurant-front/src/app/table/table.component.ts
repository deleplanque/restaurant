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
  platsAddition: Plat[];
  boissonMap: Map<Boisson, number> = new Map<Boisson, number>();
  platMap: Map<Plat, number> = new Map<Plat, number>();
  tabBoissons: any;
  tabPlats: any;
  pizzas: Plat[] = [];
  entrees: Plat[] = [];
  pates: Plat[] = [];
  desserts: Plat[] = [];
  gpizzas: Plat[] = [];
  ppizzas: Plat[] = [];
  gpates: Plat[] = [];
  ppates: Plat[] = [];

  constructor(private tableService: TableService, private app: AppComponent) { }

  ngOnInit() {

    this.table = JSON.parse(sessionStorage.getItem('table'));
    this.app.numTable = this.table.numero;
    this.getBoissons();
    this.getPlats();
    this.getBoissonsAddition();
    this.getPlatsAddition();
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

  getBoissonsAddition(): void {
    this.tableService.getBoissonsAddition(this.table.idTable)
      .subscribe(data => {
        this.boissonMap.clear();
        this.table = data;
      this.boissonsAddition = data.addition.boissons;
        for (let i = 0; i < this.boissonsAddition.length; i++) {
          if (this.mapBoissonContainKey(this.boissonsAddition[i].libelleBoisson)) {
            const  b = this.getKeyBoisson(this.boissonsAddition[i].libelleBoisson);
            let quantite: number;
            quantite = this.boissonMap.get(b);
            this.boissonMap.set(b, ++quantite);
          }else {
           this.boissonMap.set(this.boissonsAddition[i], 1);
          }
        }
      this.tabBoissons = Array.from(this.boissonMap);
    }, error => {
      console.log(error);
    });
  }

  getPlatsAddition(): void {
    this.tableService.getPlatsAddition(this.table.idTable)
      .subscribe(data => {
        this.platMap.clear();
        this.table = data;
        this.platsAddition = data.addition.plats;
        for (let i = 0; i < this.platsAddition.length; i++) {
          if (this.mapPlatContainKey(this.platsAddition[i].libellePlat)) {
            const  p = this.getKeyPlat(this.platsAddition[i].libellePlat);
            let quantite: number;
            quantite = this.platMap.get(p);
            this.platMap.set(p, ++quantite);
          }else {
            this.platMap.set(this.platsAddition[i], 1);
          }
        }
        this.tabPlats = Array.from(this.platMap);
        console.log(this.tabPlats);
      }, error => {
        console.log(error);
      });
  }


  mapBoissonContainKey(libelle: string): boolean {
    const listKey = Array.from(this.boissonMap.keys())
    for (let i = 0; i < listKey.length; i++) {
      if (listKey[i].libelleBoisson ===  libelle) {
        return true;
      }
    }
    return false;
  }

  mapPlatContainKey(libelle: string): boolean {
    const listKey = Array.from(this.platMap.keys())
    for (let i = 0; i < listKey.length; i++) {
      if (listKey[i].libellePlat ===  libelle) {
        return true;
      }
    }
    return false;
  }

  getKeyPlat(libelle: string): Plat {
    const listKey = Array.from(this.platMap.keys())
    for (let i = 0; i < listKey.length; i++) {
      if (listKey[i].libellePlat === libelle) {
        return listKey[i];
      }
    }
    return null;
  }

  getKeyBoisson(libelle: string): Boisson {
    const listKey = Array.from(this.boissonMap.keys())
    for (let i = 0; i < listKey.length; i++) {
      if (listKey[i].libelleBoisson === libelle) {
        return listKey[i];
      }
    }
    return null;
  }

  ajouterBoisson(id: number): void {
    this.tableService.addBoisson(this.table.idTable, id).subscribe(data => {
      this.getBoissonsAddition();
    }, error => {
      console.log(error);
    });
  }

  supprimerBoisson(id: number): void {
    this.tableService.removeBoisson(this.table.idTable, id).subscribe(data => {
      this.getBoissonsAddition();
    }, error => {
      console.log(error);
    });
  }


  ajouterPlat(id: number): void {
    this.tableService.addPlat(this.table.idTable, id).subscribe(data => {
      this.getPlatsAddition();
    }, error => {
      console.log(error);
    });
  }

  supprimerPlat(id: number): void {
    this.tableService.removePlat(this.table.idTable, id).subscribe(data => {
      this.getPlatsAddition();
    }, error => {
      console.log(error);
    });
  }



}
