import { Component, OnInit } from '@angular/core';
import {Plat} from '../../bean/plat';
import {Boisson} from '../../bean/boisson';
import {TableService} from '../../table/table.service';
import {ModelCommandeService} from './modal-commande.service';
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

  constructor(private tableService: TableService, private modalCommandeService: ModelCommandeService) {}

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

   validerCommande(): void {
     const plats = $('#plat').material_chip('data');
     const listeplats = [];
     plats.forEach(function (element) {
       const libellePlat = element['tag'];
       listeplats.push(
         {
           idPlat: null,
           libellePlat: libellePlat,
           prix: 0,
           categorie: null,
           sousCategorie: null,
           photo: null
         });
     });

     const boissons = $('#boisson').material_chip('data');
     const listeBoissons = [];
     boissons.forEach(function (element) {
       const libelleBoisson = element['tag'];
       listeBoissons.push(
         {
           idBoisson: null,
           libelleBoisson: libelleBoisson,
           prix: 0,
           categorie: null,
           sousCategorie: null,
           logo: null
         });
     });
     this.modalCommandeService.validerCommande(this.nom, this.heure, listeplats, listeBoissons, this.commentaire)
       .subscribe(data => {
         $('#modal1').modal('close');
       }, error => {
         console.log(error);
       });
   }
}
