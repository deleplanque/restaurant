import { Component, OnInit } from '@angular/core';
import {Table} from '../bean/table';
import {TableService} from '../table/table.service';
import {Router} from '@angular/router';
import {AppComponent} from '../app.component';

declare var $: any;
@Component({
  selector: 'app-tables',
  templateUrl: './tables.component.html',
  styleUrls: ['./tables.component.css']
})
export class TablesComponent implements OnInit {

  constructor(private  tableService: TableService, private router: Router, private app: AppComponent) { }

  tables: Table[];
  editer= false;

  ngOnInit() {
    this.tables = JSON.parse(sessionStorage.getItem('tables'));
    $( '.draggable' ).draggable();
  }

  editerSalle(edit) {
    this.editer = edit;
  }

  getTable(id: number): void {
    this.tableService.getTable(id)
      .subscribe(data => {
        this.app.hasTable = true;
        sessionStorage.setItem('table', JSON.stringify(data));
        this.router.navigate(['/table']);
      }, error => {
        console.log(error);
      });
  }

}

