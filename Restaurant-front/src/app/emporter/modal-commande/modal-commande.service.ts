import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Commande} from '../../bean/commande';
import {Plat} from '../../bean/plat';
import {Boisson} from '../../bean/boisson';

@Injectable()
export class ModelCommandeService {

  private validerCommandeUrl = 'api/creerCommande';
  constructor(private _http: HttpClient) { }


  validerCommande(nom: string, heure: string, listeplats: Plat[], listeBoissons: Boisson[], commentaire: string): Observable<Commande[]> {
    const body = {
      nomCommande: nom,
      heure: heure,
      listePlats: listeplats,
      listeBoissons: listeBoissons,
      commentaire: commentaire
    };
    return this._http.post<Commande[]>(this.validerCommandeUrl, body);
  }
}
