import { Component, OnInit } from '@angular/core';
import {ModelEditionService} from '../modal-edition/model-edition.service';
declare var $: any;
@Component({
  selector: 'app-modal-creation-plat',
  templateUrl: './modal-creation-plat.component.html',
  styleUrls: ['./modal-creation-plat.component.css']
})
export class ModalCreationPlatComponent implements OnInit {

  constructor(private modalEditionService: ModelEditionService ) { }

  ngOnInit() {
    $('#modalCreation').modal();
    this.getIngredients();
  }

  getIngredients(): void {
    this.modalEditionService.getIngredients()
      .subscribe(data => {
        const dataIngredients = [];
        data.forEach(function (element) {
          dataIngredients[element.libelleIngredient] = null;
        });
        $('#creation').material_chip({
          placeholder: 'Ingredient',
          secondaryPlaceholder: '+ingrédient',
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
}
