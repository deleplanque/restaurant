import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from "rxjs/Observable";
import {Boisson} from "./bean/boisson";
import {Plat} from "./bean/plat";

@Injectable()
export class AppService {

  private boissonsUrl = 'api/getBoissons';
  private platsUrl = 'api/getPlats';

  constructor(private _http: HttpClient) { }

  getBoissons(): Observable<Boisson[]> {
    return this._http.get<Boisson[]>(this.boissonsUrl);
  }

  getPlats(): Observable<Plat[]> {
    return this._http.get<Plat[]>(this.platsUrl);
  }

}
