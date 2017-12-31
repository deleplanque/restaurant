import { Injectable } from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {Table} from '../bean/table';
import {HttpClient} from '@angular/common/http';
import {Boisson} from '../bean/boisson';
import {Plat} from '../bean/plat';
import {BoissonAddition} from '../bean/boissonAddition';
import {PlatAddition} from '../bean/platAddition';

@Injectable()
export class TableService {

  private tableUrl = 'api/getTable';
  private boissonsUrl = 'api/getBoissons';
  private platsUrl = 'api/getPlats';
  private addBoissonsUrl = 'api/addBoisson';
  private removeBoissonsUrl = 'api/removeBoisson';
  private addPlatUrl = 'api/addPlat';
  private removePlatUrl = 'api/removePlat';

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

  getBoissonsAddition(id: number): Observable<BoissonAddition[]> {
    const url = `${this.boissonsUrl}/${id}`;
    return this._http.get<BoissonAddition[]>(url);
  }

  getPlatsAddition(id: number): Observable<PlatAddition[]> {
    const url = `${this.platsUrl}/${id}`;
    return this._http.get<PlatAddition[]>(url);
  }


  addBoisson(idAddition: number, id: number): Observable<BoissonAddition[]> {
    const url = `${this.addBoissonsUrl}/${idAddition}/${id}`;
    return this._http.get<BoissonAddition[]>(url);
  }

  removeBoisson(idAddition: number, id: number): Observable<BoissonAddition[]> {
    const url = `${this.removeBoissonsUrl}/${idAddition}/${id}`;
    return this._http.get<BoissonAddition[]>(url);
  }

  addPlat(idAddition: number, id: number): Observable<PlatAddition[]> {
    const url = `${this.addPlatUrl}/${idAddition}/${id}`;
    return this._http.get<PlatAddition[]>(url);
  }

  removePlat(idAddition: number, id: number): Observable<PlatAddition[]> {
    const url = `${this.removePlatUrl}/${idAddition}/${id}`;
    return this._http.get<PlatAddition[]>(url);
  }
}
