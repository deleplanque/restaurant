import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Addition} from '../bean/addition';

@Injectable()
export class HistoriqueService {

  private getAdditionsUrl = 'apiHistorique/getAdditions';

  constructor(private _http: HttpClient) { }


  getAdditions(): Observable<Addition[]> {
    return this._http.get<Addition[]>(this.getAdditionsUrl);
  }

}
