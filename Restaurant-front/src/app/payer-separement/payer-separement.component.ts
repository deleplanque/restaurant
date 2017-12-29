import { Component, OnInit } from '@angular/core';
import {Table} from '../bean/table';
import {PayerSeparementService} from './payer-separement.service';
import {Boisson} from '../bean/boisson';
import {Plat} from '../bean/plat';
import {TableService} from '../table/table.service';
import {Addition} from '../bean/addition';

@Component({
  selector: 'app-payer-separement',
  templateUrl: './payer-separement.component.html',
  styleUrls: ['./payer-separement.component.css'],
  providers: [TableService]
})
export class PayerSeparementComponent implements OnInit {

  constructor(private payerSeparementService: PayerSeparementService, private tableService: TableService) { }

  table: Table;
  boissonsAddition: Boisson[];
  platsAddition: Plat[];
  boissonMap: Map<Boisson, number> = new Map<Boisson, number>();
  platMap: Map<Plat, number> = new Map<Plat, number>();
  tabBoissons: any;
  tabPlats: any;


  ngOnInit() {
    this.table = JSON.parse(sessionStorage.getItem('table'));
    this.getBoissonsAddition();
   // this.getPlatsAddition();
  }


  addBoissonToProvisoire(idBoisson: number) {
    this.payerSeparementService.addBoissonToProvisoire(this.table.idTable, idBoisson).subscribe(data => {
    this.getBoissonsAddition();
    }, error => {
      console.log(error);
    });
  }


  addBoissonToAddition(idBoisson: number) {
    this.payerSeparementService.addBoissonToAddition(this.table.idTable, idBoisson).subscribe(data => {
      sessionStorage.setItem('table', JSON.stringify(data));
      this.getBoissonsAddition();
    }, error => {
      console.log(error);
    });
  }


  getMontantTotal(addition: Addition) {
    addition.montantTotal = 0;
    if (this.boissonsAddition != null) {
      for (let i = 0; i < this.boissonsAddition.length; i++) {
        addition.montantTotal = addition.montantTotal + this.boissonsAddition[i].prix;
      }
    }

    if (this.platsAddition != null) {
      for (let i = 0; i < this.platsAddition.length; i++) {
        addition.montantTotal = addition.montantTotal + this.platsAddition[i].prix;
      }
    }
    return addition.montantTotal;
  }

  getBoissonsAddition(): void {
    this.table = JSON.parse(sessionStorage.getItem('table'));
    this.tableService.getBoissonsAddition(this.table.idTable)
      .subscribe(data => {

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
        this.table.addition.tabBoissons = this.tabBoissons;
        this.table.addition.montantTotal = this.getMontantTotal(this.table.addition);
        this.boissonMap.clear();
        this.boissonsAddition = data.additionProvisoire.boissons;
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
        this.table.additionProvisoire.tabBoissons = this.tabBoissons;
        this.table.additionProvisoire.montantTotal = this.getMontantTotal(this.table.additionProvisoire);

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

  getKeyBoisson(libelle: string): Boisson {
    const listKey = Array.from(this.boissonMap.keys())
    for (let i = 0; i < listKey.length; i++) {
      if (listKey[i].libelleBoisson === libelle) {
        return listKey[i];
      }
    }
    return null;
  }


}
