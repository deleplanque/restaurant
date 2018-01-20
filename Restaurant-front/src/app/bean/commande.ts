import {Addition} from './addition';

export class Commande {
  constructor(
      public idCommande: number,
      public addition: Addition,
      public additionProvisoire: Addition,
      public estTermine: boolean,
      public heure: string,
      public estEmporter: boolean,
      public commentaire: string,
      public nom: string
  ) {  }
}
