import { Component, OnInit } from '@angular/core';
import {Plat} from '../../bean/plat';
declare var $: any;
@Component({
  selector: 'app-modal-edition',
  templateUrl: './modal-edition.component.html',
  styleUrls: ['./modal-edition.component.css']
})
export class ModalEditionComponent implements OnInit {

  constructor() { }
  plat: Plat;

  ngOnInit() {
  }

  closeModal(): void {
    $('#modal1').modal('close');
  }

  setDatatModal(plat: Plat): void {
    this.plat = plat;
    $('.modal').modal();
    $('#modal1').modal('open');
  }
}
