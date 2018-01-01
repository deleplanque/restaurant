import { Component, OnInit } from '@angular/core';
import {Table} from '../bean/table';
import {TableService} from './table.service';
import {Boisson} from '../bean/boisson';
import {Plat} from '../bean/plat';
import {AppComponent} from '../app.component';
import {Addition} from '../bean/addition';
import {BoissonAddition} from '../bean/boissonAddition';
import {PlatAddition} from '../bean/platAddition';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  table: Table;

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
    this.getTable();
  }

  getMontantTotal(addition: Addition) {
    let montantTotal = 0;

    if (addition.tabBoissons != null) {
      for (const [boisson, quantite] of addition.tabBoissons) {
        montantTotal = montantTotal + (boisson.prix * quantite);
      }
    }

    if (addition.tabPlats != null) {
      for (const [plat, quantite] of addition.tabPlats) {
        montantTotal = montantTotal + (plat.prix * quantite);
      }
    }

    return montantTotal;
  }

  getTable(): void {
    this.table = JSON.parse(sessionStorage.getItem('table'));
    this.tableService.getTable(this.table.idTable)
      .subscribe(data => {
        this.transformArrayBoissonInMap(data.addition.listBoissons, this.table, 'addition');
        this.transformArrayPlatInMap(data.addition.listPlats, this.table, 'addition');
        this.transformArrayBoissonInMap(data.additionProvisoire.listBoissons, this.table, 'provisoire');
        this.transformArrayPlatInMap(data.additionProvisoire.listPlats, this.table, 'provisoire');
        sessionStorage.setItem('table', JSON.stringify(this.table));
      }, error => {
        console.log(error);
      });
  }

  /*getBoissonsAddition(): void {
    this.table = JSON.parse(sessionStorage.getItem('table'));
    this.tableService.getBoissonsAddition(this.table.addition.idAddition)
      .subscribe(data => {
        this.transformArrayBoissonInMap(data, this.table, 'addition');
    }, error => {
      console.log(error);
    });
  }

  getPlatsAddition(): void {
    this.table = JSON.parse(sessionStorage.getItem('table'));
    this.tableService.getPlatsAddition(this.table.addition.idAddition)
      .subscribe(data => {
        this.transformArrayPlatInMap(data, this.table, 'addition');
      }, error => {
        console.log(error);
      });
  }*/

  transformArrayBoissonInMap(boissonsAddition: BoissonAddition[], table: Table, addition: string): void  {
    const boissonMap: Map<Boisson, number> = new Map<Boisson, number>();
    for (let i = 0; i < boissonsAddition.length; i++) {
      if (this.mapBoissonContainKey(boissonsAddition[i].boisson.libelleBoisson, boissonMap)) {
        const  b = this.getKeyBoisson(boissonsAddition[i].boisson.libelleBoisson, boissonMap);
        let quantite: number;
        quantite = boissonMap.get(b);
        boissonMap.set(b, ++quantite);
      }else {
        boissonMap.set(boissonsAddition[i].boisson, 1);
      }
    }
    switch (addition) {
      case 'addition':
        table.addition.tabBoissons =  Array.from(boissonMap);
        table.addition.montantTotal = this.getMontantTotal(table.addition);
        break;
      case 'provisoire':
        table.additionProvisoire.tabBoissons = Array.from(boissonMap);
        table.additionProvisoire.montantTotal = this.getMontantTotal(table.additionProvisoire);
        break;
    }
    sessionStorage.setItem('table', JSON.stringify(this.table));
  }

  transformArrayPlatInMap(platsAddition: PlatAddition[], table: Table, addition: string): void  {
    const platMap: Map<Plat, number> = new Map<Plat, number>();
    for (let i = 0; i < platsAddition.length; i++) {
      if (this.mapPlatContainKey(platsAddition[i].plat.libellePlat, platMap)) {
        const  b = this.getKeyPlat(platsAddition[i].plat.libellePlat, platMap);
        let quantite: number;
        quantite = platMap.get(b);
        platMap.set(b, ++quantite);
      }else {
        platMap.set(platsAddition[i].plat, 1);
      }
    }
    switch (addition) {
      case 'addition':
        table.addition.tabPlats =  Array.from(platMap);
        table.addition.montantTotal = this.getMontantTotal(table.addition);
        break;
      case 'provisoire':
        table.additionProvisoire.tabPlats = Array.from(platMap);
        table.additionProvisoire.montantTotal = this.getMontantTotal(table.additionProvisoire);
        break;
    }
    sessionStorage.setItem('table', JSON.stringify(this.table));
  }




  mapBoissonContainKey(libelle: string, boissonMap: Map<Boisson, number>): boolean {
    const listKey = Array.from(boissonMap.keys())
    for (let i = 0; i < listKey.length; i++) {
      if (listKey[i].libelleBoisson ===  libelle) {
        return true;
      }
    }
    return false;
  }

  mapPlatContainKey(libelle: string, platMap: Map<Plat, number>): boolean {
    const listKey = Array.from(platMap.keys())
    for (let i = 0; i < listKey.length; i++) {
      if (listKey[i].libellePlat ===  libelle) {
        return true;
      }
    }
    return false;
  }

  getKeyPlat(libelle: string,  platMap: Map<Plat, number>): Plat {
    const listKey = Array.from(platMap.keys())
    for (let i = 0; i < listKey.length; i++) {
      if (listKey[i].libellePlat === libelle) {
        return listKey[i];
      }
    }
    return null;
  }

  getKeyBoisson(libelle: string, boissonMap: Map<Boisson, number>): Boisson {
    const listKey = Array.from(boissonMap.keys())
    for (let i = 0; i < listKey.length; i++) {
      if (listKey[i].libelleBoisson === libelle) {
        return listKey[i];
      }
    }
    return null;
  }

  ajouterBoisson(id: number): void {
    this.tableService.addBoisson(this.table.addition.idAddition, id).subscribe(data => {
      this.transformArrayBoissonInMap(data, this.table, 'addition');
    }, error => {
      console.log(error);
    });
  }

  supprimerBoisson(id: number): void {
    this.tableService.removeBoisson(this.table.addition.idAddition, id).subscribe(data => {
      this.transformArrayBoissonInMap(data, this.table, 'addition');
    }, error => {
      console.log(error);
    });
  }


  ajouterPlat(id: number): void {
    this.tableService.addPlat(this.table.addition.idAddition, id).subscribe(data => {
      this.transformArrayPlatInMap(data, this.table, 'addition');
    }, error => {
      console.log(error);
    });
  }

  supprimerPlat(id: number): void {
    this.tableService.removePlat(this.table.addition.idAddition, id).subscribe(data => {
      this.transformArrayPlatInMap(data, this.table, 'addition');
    }, error => {
      console.log(error);
    });
  }


  payerAddition(moyen: string) {
    this.tableService.payerAddition(moyen, this.table.addition).subscribe(data => {
      this.tableService.resetAddition(this.table.idTable).subscribe(data2 => {
        this.table.addition.listBoissons = data2.addition.listBoissons;
        this.transformArrayBoissonInMap(this.table.addition.listBoissons, this.table, 'addition');
        this.table.addition.listPlats = data2.addition.listPlats;
        this.transformArrayPlatInMap(this.table.addition.listPlats, this.table, 'addition');
        sessionStorage.setItem('table', JSON.stringify(this.table));
      }, error => {
        console.log(error);
      });
    }, error => {
      console.log(error);
    });
  }

}
