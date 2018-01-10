import { Component, OnInit } from '@angular/core';
declare var $: any;
@Component({
  selector: 'app-emporter',
  templateUrl: './emporter.component.html',
  styleUrls: ['./emporter.component.css']
})
export class EmporterComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    $('.modal').modal({
      dismissible: true, // Modal can be dismissed by clicking outside of the modal
      opacity: .5, // Opacity of modal background
      inDuration: 300, // Transition in duration
      outDuration: 200, // Transition out duration
      startingTop: '4%', // Starting top style attribute
      endingTop: '5%', // Ending top style attribute
    });
  }

  showModal(): void {
    $('#modal1').modal('open');
  }

}
