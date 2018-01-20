import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Boisson} from '../bean/boisson';

@Injectable()
export class BoissonService {

  private boissonsUrl = 'api/getBoissons';

  constructor(private _http: HttpClient) { }

  getBoissons(): Observable<Boisson[]> {
    return this._http.get<Boisson[]>(this.boissonsUrl);
  }

}
