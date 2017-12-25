import { Injectable } from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {Table} from '../bean/table';
import {HttpClient} from '@angular/common/http';
import {Boisson} from '../bean/boisson';
import {Plat} from '../bean/plat';

@Injectable()
export class TableService {

  private tableUrl = 'api/getTable';
  private boissonsUrl = 'api/getBoissons';
  private platsUrl = 'api/getPlats';

  constructor(private _http: HttpClient) { }

  getTable(id: number): Observable<Table> {
    const url = `${this.tableUrl}/${id}`;
    return this._http.get<Table>(url);
  }

  getBoissons(): Observable<Boisson[]> {
    return this._http.get<Boisson[]>(this.boissonsUrl);
  }

  getPlats(): Observable<Plat[]> {
    return this._http.get<Plat[]>(this.platsUrl);
  }
}
