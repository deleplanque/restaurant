import {Boisson} from './boisson';
import {Plat} from './plat';

export class Addition {
  constructor(
    public idAddition: number,
    public montantTotal: number,
    public boissons: Boisson[],
    public plats: Plat[]
  ) {  }
}
