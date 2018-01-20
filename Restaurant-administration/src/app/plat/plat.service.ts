import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Plat} from '../bean/plat';

@Injectable()
export class PlatService {

  private platsUrl = 'api/getPlats';

  constructor(private _http: HttpClient) { }


  getPlats(): Observable<Plat[]> {
    return this._http.get<Plat[]>(this.platsUrl);
  }

}
