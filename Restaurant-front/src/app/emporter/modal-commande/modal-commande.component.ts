import { Component, OnInit } from '@angular/core';
import {Plat} from '../../bean/plat';
import {Boisson} from '../../bean/boisson';
import {TableService} from '../../table/table.service';
declare var $: any;
@Component({
  selector: 'app-modal-commande',
  templateUrl: './modal-commande.component.html',
  styleUrls: ['./modal-commande.component.css'],
  providers: [TableService]
})
export class ModalCommandeComponent implements OnInit {

  nom;
  heure;
  commentaire;

  constructor(private tableService: TableService) {}

  ngOnInit() {
    this.tableService.getPlats()
      .subscribe(data => {
        const dataPlat = [];
        data.forEach(function (element) {
          dataPlat[element.libellePlat] = null;
        });
        $('#plat').material_chip({
          placeholder: 'Plat',
          secondaryPlaceholder: '+Plat',
          autocompleteOptions: {
            data: dataPlat,
            limit: 3,
            minLength: 1
          }
        });

      }, error => {
        console.log(error);
      });

    this.tableService.getBoissons()
      .subscribe(data => {
        const dataBoisson = [];
        data.forEach(function (element) {
          dataBoisson[element.libelleBoisson] = null;
        });
        $('#boisson').material_chip({
          placeholder: 'Boisson',
          secondaryPlaceholder: '+Boisson',
          autocompleteOptions: {
            data: dataBoisson,
            limit: 3,
            minLength: 1
          }
        });

      }, error => {
        console.log(error);
      });
  }
}
