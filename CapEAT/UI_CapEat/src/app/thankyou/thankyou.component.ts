import { Component, OnInit } from '@angular/core';
import { PaymentService } from '../Services/payments.service';

@Component({
  selector: 'app-thankyou',
  templateUrl: './thankyou.component.html',
  styleUrls: ['./thankyou.component.css']
})
export class ThankyouComponent implements OnInit {
  public orderid;


public showDialog;
  constructor() {  this.orderid = JSON.stringify(localStorage.getItem("orderid"));
}

  ngOnInit() {
  
  }

}
