import {Component, OnInit} from '@angular/core';
declare var $: any;
@Component({
  moduleId: module.id,
  selector: 'app-calculatrice',
  templateUrl: 'calculatrice.component.html',
  styleUrls: ['calculatrice.component.css']
})
export class CalculatriceComponent implements OnInit {


  result: any;
  value: any;
  decimal: boolean;
  answer: number;
  total: Array<number>;
  clear: boolean;
  previous_operator: any;
  visibleAdditionButtons: boolean;
  history: string;
  input: any;
  typeOfFunction: any;
  inputFsl: any;
  expresForDB: any;

  ngOnInit(): void {
    $('.modal').modal({
      dismissible: true, // Modal can be dismissed by clicking outside of the modal
      opacity: .5, // Opacity of modal background
      inDuration: 300, // Transition in duration
      outDuration: 200, // Transition out duration
      startingTop: '4%', // Starting top style attribute
      endingTop: '5%', // Ending top style attribute
    });
  }

  constructor() {
    this.result = '';
    this.decimal = false;
    this.answer = 0;
    this.total = [];
    this.clear = false;
    this.previous_operator = false;
    this.visibleAdditionButtons = false;
    this.history = '';
    this.inputFsl = false;
  }

  addToCalculation(value: any) {
    if (this.clear === true) {
      this.result = 0;
      this.clear = false;
    }
    if (value === '.') {
      if (this.decimal === true) {
        return false;
      }
      this.decimal = true;

    }
    this.result += value;
    this.history += value + '';
    this.inputFsl = false;

  }

  calculate(operator: any) {
    if (operator.length >= 1) {
      if (this.inputFsl === true) {
        return  false;
      }
      this.inputFsl = true;
    }
    this.history += operator;
    this.total.push(this.result);
    this.result = ' ';

    if (this.total.length === 2) {

      const a = Number(this.total[0]);
      const b = Number(this.total[1]);

      let total = 0;
      if (this.previous_operator === '+') {
        total = a + b;
      } else if (this.previous_operator === '-') {
        total = a - b;
      } else if (this.previous_operator === '*') {
        total = a * b;
      } else {
        total = a / b;
      }
      const answer = total;

      this.total = [];
      this.total.push(answer);
      this.result = total;
      this.clear = true;
    } else {
      this.clear = false;
    }

    this.decimal = false;
    this.previous_operator = operator;
  }

  getTotal() {

    const a = Number(this.total[0]);
    const b = Number(this.result);
    let total = 0;
    if (this.previous_operator === '+') {
      total = a + b;
    } else if (this.previous_operator === '-') {
      total = a - b;
    } else if (this.previous_operator === '*') {
      total = a * b;
    } else {
      total = a / b;
    }
    if (isNaN(total)) {
      return false;
    }
    this.result = total;
    this.history = this.result;
    this.total = [];
    this.clear = true;
    this.inputFsl = false;
  }


  removeLast() {
    this.input = document.querySelector('.mini-screen').innerHTML;
    const removeResult = this.input.substring(0, this.input.length - 1);
    this.result = removeResult;
    this.history = this.result;
    this.inputFsl = false;
  }
  onClickClear() {
    this.result = '';
    this.decimal = false;
    this.answer = 0;
    this.total = [];
    this.clear = false;
    this.history = '';
  }
  visible() {
    if (this.visibleAdditionButtons === true) {
      this.visibleAdditionButtons = false;
    } else if (this.visibleAdditionButtons === false) {
      this.visibleAdditionButtons = true;
    }
  }
  onClickMathFunction(typeOfFunction: string) {
    this.input = document.querySelector('.mini-screen').innerHTML;
    console.log(this.input);

    if (typeOfFunction === 'sin') {
      this.result = Math.sin(this.input);
      this.history = this.result;
    } else if (typeOfFunction === 'cos') {
      this.result = Math.cos(this.input);
      this.history = this.result;
    } else if (typeOfFunction === 'tan') {
      this.result = Math.tan(this.input);
      this.history = this.result;
    } else if (typeOfFunction === 'log') {
      this.result = Math.log(this.input);
      this.history = this.result;
    } else if (typeOfFunction === '√') {
      this.result = Math.sqrt(this.input);
      this.history = this.result;
    } else if (typeOfFunction === 'exp') {
      this.result = Math.exp(this.input);
      this.history = this.result;
    } else {
      this.history = 'Not a function!';
    }

  }

}
