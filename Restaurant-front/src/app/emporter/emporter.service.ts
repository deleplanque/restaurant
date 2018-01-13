import { Injectable } from '@angular/core';
import {Commande} from '../bean/commande';
import {Observable} from 'rxjs/Observable';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class EmporterService {

  private commandesUrl = 'api/getCommandes';

  constructor(private _http: HttpClient) { }

  getCommandes(): Observable<Commande[]> {
    return this._http.get<Commande[]>(this.commandesUrl);
  }
}
