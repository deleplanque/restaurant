import { Component, OnInit } from '@angular/core';
import {BoissonService} from './boisson.service';
import {Boisson} from '../bean/boisson';
declare var $: any;
@Component({
  selector: 'app-boisson',
  templateUrl: './boisson.component.html',
  styleUrls: ['./boisson.component.css']
})
export class BoissonComponent implements OnInit {

  constructor(private boissonService: BoissonService) { }

  softs: Boisson[] = [];
  bieres: Boisson[] = [];
  aperitifs: Boisson[] = [];
  vins: Boisson[] = [];
  digestifs: Boisson[] = [];
  chaudes: Boisson[] = [];

  ngOnInit() {
    $('ul.tabs').tabs();
    this.getBoissons();
  }

  getBoissons(): void {
    this.boissonService.getBoissons()
      .subscribe(data => {
        for (let i = 0; i < data.length; i++) {
          switch (data[i].categorie) {
            case 'soft':
              this.softs.push(data[i]);
              break;
            case 'biere':
              this.bieres.push(data[i]);
              break;
            case 'aperitif':
              this.aperitifs.push(data[i]);
              break;
            case 'vin':
              this.vins.push(data[i]);
              break;
            case 'digestif':
              this.digestifs.push(data[i]);
              break;
            case 'chaude':
              this.chaudes.push(data[i]);
              break;
          }
        }
      }, error => {
        console.log(error);
      });
  }

}
