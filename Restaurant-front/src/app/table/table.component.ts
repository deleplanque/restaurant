import { Component, OnInit } from '@angular/core';
import {Table} from '../bean/table';
import {TableService} from './table.service';
import {Boisson} from '../bean/boisson';
import {Plat} from '../bean/plat';
import {AppComponent} from '../app.component';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  table: Table;
  boissonsAddition: Boisson[];
  platsAddition: Plat[];
  boissonMap: Map<Boisson, number> = new Map<Boisson, number>();
  platMap: Map<Plat, number> = new Map<Plat, number>();
  tabBoissons: any;
  tabPlats: any;

  constructor(private tableService: TableService, private app: AppComponent) { }

  softs = this.app.softs;
  chaudes= this.app.chaudes;
  aperitifs= this.app.aperitifs;
  digestifs= this.app.digestifs;
  vins= this.app.vins;
  bieres= this.app.bieres;
  entrees= this.app.entrees;
  desserts= this.app.desserts;
  gpizzas= this.app.gpizzas;
  ppizzas= this.app.ppizzas;
  gpates= this.app.gpates;
  ppates= this.app.ppates;


  ngOnInit() {

    this.table = JSON.parse(sessionStorage.getItem('table'));
    this.app.numTable = this.table.numero;
    this.getBoissonsAddition();
    this.getPlatsAddition();
  }



  getBoissonsAddition(): void {
    this.tableService.getBoissonsAddition(this.table.idTable)
      .subscribe(data => {
        this.table.addition.montantTotal = data.addition.montantTotal;
        this.boissonMap.clear();
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
      this.table.tabBoissons = this.tabBoissons;
      console.log(this.table);
      sessionStorage.setItem('table', JSON.stringify(this.table));
    }, error => {
      console.log(error);
    });
  }

  getPlatsAddition(): void {
    this.tableService.getPlatsAddition(this.table.idTable)
      .subscribe(data => {
        this.table.addition.montantTotal = data.addition.montantTotal;
        this.platMap.clear();
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
        this.table.tabPlats = this.tabPlats;
        console.log(this.table);
        sessionStorage.setItem('table', JSON.stringify(this.table));
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
