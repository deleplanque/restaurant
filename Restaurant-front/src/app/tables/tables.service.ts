import { Injectable } from '@angular/core';
import {Table} from '../bean/table';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class TablesService {

  private headers = new Headers({'Content-Type': 'application/json'});
  private tablesUrl = 'api/getTables';

  constructor(private _http: HttpClient) { }


  getTables() {
    return this._http.get<Table[]>(this.tablesUrl);
  }

  getTablesByIdSalle(id: number): Observable<Table[]> {
    const url = `${this.tablesUrl}/${id}`;
    return this._http.get<Table[]>(url);
  }


}
