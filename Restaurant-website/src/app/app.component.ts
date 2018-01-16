import {Component, OnInit} from '@angular/core';
import {AppService} from "./app.service";
import {Boisson} from "./bean/boisson";
import {Plat} from "./bean/plat";
declare var $: any;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  host: {
    '(window:resize)': 'onResize($event)'
  }
})
export class AppComponent implements OnInit{

  boissons: Boisson[];
  plats: Plat[];
  softs: Boisson[] = [];
  chaudes: Boisson[] = [];
  aperitifs: Boisson[] = [];
  digestifs: Boisson[] = [];
  vins: Boisson[] = [];
  bieres: Boisson[] = [];
  pizzas: Plat[] = [];
  entrees: Plat[] = [];
  pates: Plat[] = [];
  desserts: Plat[] = [];
  gpizzas: Plat[] = [];
  ppizzas: Plat[] = [];
  gpates: Plat[] = [];
  ppates: Plat[] = [];



  onResize(event){
    event.target.innerHeight;
    $('#content').css('margin-top', event.target.innerHeight+'px');
    $('.horraire').css('height', $('#imageRestaurant').height()-10+'px');
  }

  ngOnInit(): void {
    $('ul.tabs').tabs();
    this.getBoissons();
    this.getPlats();
    console.log(this.gpizzas)
    $(".button-collapse").sideNav();

    $(document).ready(function(){
      $('.slider').slider();
    });

    $('#content').css('margin-top', $(window).height()+'px');

    $(window).scroll(function(){
      $('.horraire').css('height', $('#imageRestaurant').height()-10+'px');
    });

  }

  constructor(private appService: AppService) {}

  getBoissons(): void {
    this.appService.getBoissons()
      .subscribe(data => {
        this.boissons = data;
        for (let i = 0; i < this.boissons.length; i++) {
          switch (this.boissons[i].categorie) {
            case 'soft':
              this.softs.push(this.boissons[i]);
              break;
            case 'biere':
              this.bieres.push(this.boissons[i]);
              break;
            case 'aperitif':
              this.aperitifs.push(this.boissons[i]);
              break;
            case 'vin':
              this.vins.push(this.boissons[i]);
              break;
            case 'digestif':
              this.digestifs.push(this.boissons[i]);
              break;
            case 'chaude':
              this.chaudes.push(this.boissons[i]);
              break;
          }
        }
      }, error => {
        console.log(error);
      });
  }

  getPlats(): void {
    this.appService.getPlats()
      .subscribe(data => {
        console.log(data);
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


