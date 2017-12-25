import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Salle} from '../bean/salle';

@Injectable()
export class SallesService {

  private headers = new Headers({'Content-Type': 'application/json'});
  private sallesUrl = 'api/getSalles';

  constructor(private _http: HttpClient) {

  }

  getSalles() {
    return this._http.get<Salle[]>(this.sallesUrl);
  }

}
