import {Plat_Ingredient} from './Plat_Ingredient';

export class Plat {
  constructor(
    public idPlat: number,
    public libellePlat: string,
    public prix: number,
    public categorie: string,
    public sousCategorie: string,
    public photo: string,
    public listeIngredients: Plat_Ingredient[]
  ) {  }
}
