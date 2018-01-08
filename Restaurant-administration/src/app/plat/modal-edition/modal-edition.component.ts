import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';


@Component({
  selector: 'app-modal-edition',
  templateUrl: './modal-edition.component.html',
  styleUrls: ['./modal-edition.component.css']
})
export class ModalEditionComponent {

  constructor(
    public dialogRef: MatDialogRef<ModalEditionComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) { }


  onNoClick(): void {
    this.dialogRef.close();
  }

}
