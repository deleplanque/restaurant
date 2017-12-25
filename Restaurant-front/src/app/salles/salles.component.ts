import { Component, OnInit } from '@angular/core';
import {SallesService} from './salles.service';
import {Salle} from '../bean/salle';
import {TablesService} from '../tables/tables.service';
import {Router} from '@angular/router';
import {AppComponent} from "../app.component";

@Component({
  selector: 'app-salles',
  templateUrl: './salles.component.html',
  styleUrls: ['./salles.component.css'],
  providers: [SallesService]
})
export class SallesComponent implements OnInit {

  constructor(private sallesService: SallesService, private tablesService: TablesService, private router: Router, private app: AppComponent) { }

  salles: Salle[];

  ngOnInit() {
    this.getSalles();
  }

  getSalles(): void {
    this.sallesService.getSalles()
      .subscribe(data => {
        this.salles = data;
      }, error => {
        console.log(error);
      });
  }
  getTablesByIdSalle(idSalle: number): void {
    console.log(idSalle);
    this.tablesService.getTablesByIdSalle(idSalle)
      .subscribe(data => {
        this.app.hasSalle = true;
        sessionStorage.setItem('tables', JSON.stringify(data));
        this.router.navigate(['/tables']);
      }, error => {
        console.log(error);
      });
  }


}
