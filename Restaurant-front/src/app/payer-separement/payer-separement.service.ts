import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Table} from '../bean/table';
import {Addition} from '../bean/addition';

@Injectable()
export class PayerSeparementService {

  private addBoissonToProvisoireUrl = 'api/addBoissonAdditionToAdditionProvisoire';
  private addBoissonToAdditionUrl = 'api/addBoissonAdditionProvisoireToAddition';
  private addPlatToProvisoireUrl = 'api/addPlatAdditionToAdditionProvisoire';
  private addPlatToAdditionUrl = 'api/addPlatAdditionProvisoireToAddition';
  private helloUrl = 'apiHistorique/helloWorld';

  private payerAdditionProvisoireUrl = 'apiHistorique/ajouterAddition';

  constructor(private _http: HttpClient) { }

  addBoissonToProvisoire(idTable: number, idBoisson: number): Observable<Table> {
    const url = `${this.addBoissonToProvisoireUrl}/${idTable}/${idBoisson}`;
    return this._http.get<Table>(url);
  }

  addBoissonToAddition(idTable: number, idBoisson: number): Observable<Table> {
    const url = `${this.addBoissonToAdditionUrl}/${idTable}/${idBoisson}`;
    return this._http.get<Table>(url);
  }

  addPlatToProvisoire(idTable: number, idPlat: number): Observable<Table> {
    const url = `${this.addPlatToProvisoireUrl}/${idTable}/${idPlat}`;
    return this._http.get<Table>(url);
  }

  addPlatToAddition(idTable: number, idPlat: number): Observable<Table> {
    const url = `${this.addPlatToAdditionUrl}/${idTable}/${idPlat}`;
    return this._http.get<Table>(url);
  }

  payerAdditionProvisoire(moyen: string, additionProvisoire: Addition) {
    const url = `${this.payerAdditionProvisoireUrl}/${moyen}`;
   return this._http.post(url, additionProvisoire);
  }
}
