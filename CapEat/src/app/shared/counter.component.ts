import { Component, OnChanges, Input, EventEmitter, Output } from '@angular/core';


@Component({
    selector: 'counter',
    template: `<div class="float-l">
    <button class="float-l" type="button" class="btn btn-primary" (click)="increment()">+</button>
    <div class="">{{counter}}</div>
    <button class="float-l" type="button" class="btn btn-primary" (click)="decrement()">-</button></div>
`
})
export class CounterComponent {
    public counter : number = 0;
    
    increment(){
      this.counter += 1;
    }
    
    decrement(){
      this.counter -= 1;
    }
}