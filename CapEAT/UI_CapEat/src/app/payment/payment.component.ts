import { Component,  OnInit } from '@angular/core';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
 constructor() {


  }

  ngOnInit()  {
   }
   // tslint:disable-next-line:member-ordering
   public option = 1;
 }