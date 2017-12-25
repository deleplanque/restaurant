import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  hasSalle = false;
  hasTable = false;
  nomSalle = '';
  numTable: number;


}
