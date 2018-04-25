import { Injectable } from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {Table} from '../bean/table';
import {HttpClient} from '@angular/common/http';
import {Boisson} from '../bean/boisson';
import {Plat} from '../bean/plat';
import {BoissonAddition} from '../bean/boissonAddition';
import {PlatAddition} from '../bean/platAddition';
import {Addition} from '../bean/addition';

@Injectable()
export class TableService {

  private tableUrl = 'api/getTable';
  private boissonsUrl = 'api/getBoissons';
  private platsUrl = 'api/getPlats';
  private addBoissonsUrl = 'api/addBoisson';
  private removeBoissonsUrl = 'api/removeBoisson';
  private addPlatUrl = 'api/addPlat';
  private removePlatUrl = 'api/removePlat';
  private resetAdditionUrl = 'api/resetAddition';
  private payerAdditionUrl = 'apiHistorique/ajouterAddition';

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


  addBoisson(idAddition: number, boisson: Boisson): Observable<BoissonAddition[]> {
    const url = `${this.addBoissonsUrl}/${idAddition}`;
    return this._http.post<BoissonAddition[]>(url, boisson);
  }

  removeBoisson(idAddition: number, boisson: Boisson): Observable<BoissonAddition[]> {
    const url = `${this.removeBoissonsUrl}/${idAddition}`;
    return this._http.post<BoissonAddition[]>(url, boisson);
  }

  addPlat(idAddition: number, plat: Plat): Observable<PlatAddition[]> {
    const url = `${this.addPlatUrl}/${idAddition}`;
    return this._http.post<PlatAddition[]>(url, plat);
  }

  removePlat(idAddition: number, plat: Plat): Observable<PlatAddition[]> {
    const url = `${this.removePlatUrl}/${idAddition}`;
    return this._http.post<PlatAddition[]>(url, plat);
  }

  payerAddition(moyen: string, addition: Addition): Observable<Table> {
    const url = `${this.payerAdditionUrl}/${moyen}`;
    return this._http.post<Table>(url, addition);
  }

  resetAddition(idTable: number): Observable<Table> {
    const url = `${this.resetAdditionUrl}/${idTable}`;
    return this._http.get<Table>(url);
  }
}
