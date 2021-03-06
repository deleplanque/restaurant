import { Component, OnInit } from '@angular/core';
import {Table} from '../bean/table';
import {PayerSeparementService} from './payer-separement.service';
import {TableComponent} from '../table/table.component';
declare var $: any;

@Component({
  selector: 'app-payer-separement',
  templateUrl: './payer-separement.component.html',
  styleUrls: ['./payer-separement.component.css'],
  providers: [TableComponent]
})
export class PayerSeparementComponent implements OnInit {

  constructor(private payerSeparementService: PayerSeparementService, private tableComponent: TableComponent) { }

  table: Table;

  ngOnInit() {
    this.table = JSON.parse(sessionStorage.getItem('table'));
    $('#note').css('height', $(window).height() - ($('.nav-wrapper').height() + 40 ) + 'px');
    $('#noteProvisoire').css('height', $(window).height() - ($('.nav-wrapper').height() + 55 + $('.montant').height()) + 'px');
  }


  addBoissonToProvisoire(idBoisson: number) {
    this.payerSeparementService.addBoissonToProvisoire(this.table.idTable, idBoisson).subscribe(data => {
      this.table.addition.listBoissons = data.addition.listBoissons;
      this.tableComponent.transformArrayBoissonInMap(this.table.addition.listBoissons, this.table, 'addition');
      this.table.additionProvisoire.listBoissons = data.additionProvisoire.listBoissons;
      this.tableComponent.transformArrayBoissonInMap(this.table.additionProvisoire.listBoissons, this.table, 'provisoire');
      sessionStorage.setItem('table', JSON.stringify(this.table));
    }, error => {
      console.log(error);
    });
  }


  addBoissonToAddition(idBoisson: number) {
    this.payerSeparementService.addBoissonToAddition(this.table.idTable, idBoisson).subscribe(data => {
      this.table.addition.listBoissons = data.addition.listBoissons;
      this.tableComponent.transformArrayBoissonInMap(this.table.addition.listBoissons, this.table, 'addition');
      this.table.additionProvisoire.listBoissons = data.additionProvisoire.listBoissons;
      this.tableComponent.transformArrayBoissonInMap(this.table.additionProvisoire.listBoissons, this.table, 'provisoire');
      sessionStorage.setItem('table', JSON.stringify(this.table));
    }, error => {
      console.log(error);
    });
  }

  addPlatToProvisoire(idPlat: number) {
    this.payerSeparementService.addPlatToProvisoire(this.table.idTable, idPlat).subscribe(data => {
      this.table.addition.listPlats = data.addition.listPlats;
      this.tableComponent.transformArrayPlatInMap(this.table.addition.listPlats, this.table, 'addition');
      this.table.additionProvisoire.listPlats = data.additionProvisoire.listPlats;
      this.tableComponent.transformArrayPlatInMap(this.table.additionProvisoire.listPlats, this.table, 'provisoire');
      sessionStorage.setItem('table', JSON.stringify(this.table));
    }, error => {
      console.log(error);
    });
  }


  addPlatToAddition(idPlat: number) {
    this.payerSeparementService.addPlatToAddition(this.table.idTable, idPlat).subscribe(data => {
      this.table.addition.listPlats = data.addition.listPlats;
      this.tableComponent.transformArrayPlatInMap(this.table.addition.listPlats, this.table, 'addition');
      this.table.additionProvisoire.listPlats = data.additionProvisoire.listPlats;
      this.tableComponent.transformArrayPlatInMap(this.table.additionProvisoire.listPlats, this.table, 'provisoire');
      sessionStorage.setItem('table', JSON.stringify(this.table));
    }, error => {
      console.log(error);
    });
  }

  payerAdditionProvisoire(moyen: string) {
    this.payerSeparementService.payerAdditionProvisoire(moyen, this.table.additionProvisoire).subscribe(data => {
      this.payerSeparementService.resetAdditionProvisoire(this.table.idTable).subscribe(data2 => {
        this.table.additionProvisoire.listBoissons = data2.additionProvisoire.listBoissons;
        this.tableComponent.transformArrayBoissonInMap(this.table.additionProvisoire.listBoissons, this.table, 'provisoire');
        this.table.additionProvisoire.listPlats = data2.additionProvisoire.listPlats;
        this.tableComponent.transformArrayPlatInMap(this.table.additionProvisoire.listPlats, this.table, 'provisoire');
        sessionStorage.setItem('table', JSON.stringify(this.table));
      }, error => {
        console.log(error);
      });
    }, error => {
      console.log(error);
    });
  }

}
