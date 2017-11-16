import { Component,  OnInit } from '@angular/core';
import { AddCartComponent } from '../Addcart/addcart.component';
import { PaymentService } from '../Services/payments.service';
@Component({
  selector: 'app-paymentone',
  templateUrl: './paymentone.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentoneComponent implements OnInit {
 
  public total;
  public savecard = false;
  public deletecard = false;  
  public name;
  public cardnum;
  public exp;
  public seccode;
  public addcartobj;
  public postalcode;
  public carddet : Object;
  public ordercredit : Object;
  public existingcard;
  public sid;
  public decision;
  public option = 1;
  public userstatus;
  constructor(public addcart:AddCartComponent, public pay: PaymentService) {
  }
  ngOnInit()  {
   this.addcartobj = this.addcart.arr;
   this.total = localStorage.getItem("total");
   this.sid = localStorage.getItem("sid");
   this.userstatus = localStorage.getItem("userstatus");
   
   this.existingcard = localStorage.getItem("existingcard");  
  }
  fetch() {
    console.log(this.deletecard);
    if((this.savecard === true) && ( this.userstatus === 'HasData')){
      this.decision = "update";
    }
    if((this.savecard === true) && (this.userstatus === 'NoData')){
      this.decision = "insert";
    }
    if(this.deletecard === true){
      this.decision = "delete";
    }
    this.carddet = {
      "nameOnCard" :this.name,
      "cardNum" :this.cardnum,
      "exp" :this.exp,
      "cvc" :this.seccode,
      "zipCode": this.postalcode,
      "decision": this.decision
    };
    
    this.ordercredit = {
      "order": this.addcartobj,      
      "creditCard": this.carddet,
      "amount": this.total,
      "sid" : this.sid
    };
    this.pay.paynow(this.ordercredit).subscribe((resp) => {
        console.log(resp.json());
        localStorage.setItem("orderid",resp.json());
    });
 }
 
}




