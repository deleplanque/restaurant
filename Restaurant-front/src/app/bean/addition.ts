import {Boisson} from './boisson';
import {Plat} from './plat';
import {BoissonAddition} from './boissonAddition';
import {PlatAddition} from './platAddition';

export class Addition {
  constructor(
    public idAddition: number,
    public montantTotal: number,
    public listBoissons: BoissonAddition[],
    public listPlats: PlatAddition[],
    public tabBoissons: any,
    public tabPlats: any,
    public paiement: string,
  ) {  }
}
