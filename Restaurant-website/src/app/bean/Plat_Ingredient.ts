import {Ingredient} from "./ingredient";
import {Plat} from "./plat";

export class Plat_Ingredient {
  constructor(
    public id: number,
    public indredient : Ingredient,
    public plat: Plat
  ) {  }
}
