import {Addition} from './addition';

export class Table {
  constructor(
    public idTable: number,
    public numero: number,
    public capaciteTable: number,
    public addition: Addition,
    public additionProvisoire: Addition,
    public estLibre: boolean,
  ) {  }
}
