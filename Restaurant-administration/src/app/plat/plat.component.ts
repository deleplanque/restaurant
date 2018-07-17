import { Component, OnInit } from '@angular/core';
import {Plat} from '../bean/plat';
import {PlatService} from './plat.service';
import {ModalEditionComponent} from './modal-edition/modal-edition.component';
import {MatDialog} from '@angular/material';
declare var $: any;

@Component({
  selector: 'app-plat',
  templateUrl: './plat.component.html',
  styleUrls: ['./plat.component.css'],
  providers: [ModalEditionComponent]
})
export class PlatComponent implements OnInit {

  plats: Plat[];
  pizzas: Plat[] = [];
  entrees: Plat[] = [];
  pates: Plat[] = [];
  desserts: Plat[] = [];
  gpizzas: Plat[] = [];
  ppizzas: Plat[] = [];

  constructor(private platService: PlatService, public dialog: MatDialog) { }

  openDialog(plat: Plat): void {
    const dialogRef = this.dialog.open(ModalEditionComponent, {
      width: '40%',
      data: { plat: plat }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }


  ngOnInit() {
    $('.modal').modal();
    $('#modalCreation').modal();
    this.getPlats();
  }

  showModal(): void {
    $('#modalCreation').modal('open');
  }


  getPlats(): void {
    this.platService.getPlats()
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
