import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {Ingredient} from '../../bean/ingredient';
import {ModelEditionService} from './model-edition.service';
import {Plat} from '../../bean/plat';
declare var $: any;

@Component({
  selector: 'app-modal-edition',
  templateUrl: './modal-edition.component.html',
  styleUrls: ['./modal-edition.component.css']
})
export class ModalEditionComponent implements OnInit {


  constructor(public dialogRef: MatDialogRef<ModalEditionComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any, private modalEditionService: ModelEditionService) {
  }


  ngOnInit(): void {
    this.getIngredients();
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  getIngredients(): void {
    this.modalEditionService.getIngredients()
      .subscribe(data => {
        const authData = [];
        this.data.plat.listeIngredients.forEach(function (element) {
          const tag = {};
          tag['tag'] = element.indredient.libelleIngredient;
          authData.push(tag);
        });

        const dataIngredients = {};
        data.forEach(function (element) {
          dataIngredients[element.libelleIngredient] = null;
        });
        console.log(dataIngredients);
        $('.chips').material_chip({
          placeholder: 'Ingredient',
          secondaryPlaceholder: '+ingrédient',
          data: authData,
          autocompleteOptions: {
            data: dataIngredients,
            limit: 3,
            minLength: 1
          }
        });
      }, error => {
        console.log(error);
      });
  }


  modifierPlat(plat: Plat): void {
    const ingredients = $('.chips').material_chip('data');
    const listIngredients = [];
    ingredients.forEach(function (element) {
      const ingredient = element['tag'];
      listIngredients.push(
        {
          idIngredient: null,
          libelleIngredient: ingredient,
          prix: 0
        });
    });
    this.modalEditionService.modifierPlat(plat, listIngredients)
      .subscribe(data => {
        console.log(data);
      }, error => {
        console.log(error);
      });
    this.dialogRef.close();
  }
  
}
