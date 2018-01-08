import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Ingredient} from '../../bean/ingredient';
import {Plat} from '../../bean/plat';

@Injectable()
export class ModelEditionService {

  private ingredientsUrl = 'api/getIngredients';
  private momodifierPlatUrl = 'api/modifierPlat';
  constructor(private _http: HttpClient) { }


  getIngredients(): Observable<Ingredient[]> {
    return this._http.get<Ingredient[]>(this.ingredientsUrl);
  }

  modifierPlat(plat: Plat, listIngredients: Ingredient[]): Observable<Plat[]> {
    const body = {
      plat: plat,
      listIngredients: listIngredients
    };
    return this._http.post<Plat[]>(this.momodifierPlatUrl, body);
}
}
