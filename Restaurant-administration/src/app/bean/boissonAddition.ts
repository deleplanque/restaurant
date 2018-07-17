import {Boisson} from './boisson';
import {Addition} from './addition';

export class BoissonAddition {
  constructor(
    public id: number,
    public addition: Addition,
    public boisson: Boisson
  ) {  }
}
