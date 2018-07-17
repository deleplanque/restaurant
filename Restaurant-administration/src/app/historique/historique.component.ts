import { Component, OnInit } from '@angular/core';
import {HistoriqueService} from './historique.service';
import {Addition} from '../bean/addition';
declare var $: any;

@Component({
  selector: 'app-historique',
  templateUrl: './historique.component.html',
  styleUrls: ['./historique.component.css'],
})
export class HistoriqueComponent implements OnInit {
  constructor(private historiqueService: HistoriqueService) { }

  additions: Addition[];

  ngOnInit() {
    $('.collapsible').collapsible();
    this.getAddition();
  }

  getAddition(): void {
    this.historiqueService.getAdditions()
      .subscribe(data => {
        this.additions = data;
        console.log(data);
      }, error => {
        console.log(error);
      });
  }


}
