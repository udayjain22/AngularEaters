import { Component, OnInit,Input } from '@angular/core';
import { HistoryService } from '../Services/history.service';
import { HistoryItem} from './history-item';
import { HomeComponent } from '../Home/home.component';


@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {

  
  public sid;
  public newuser;
  
  public orderHistory: Array<HistoryItem> = [];
  public selectedOrders: Array<HistoryItem> = [];

  constructor(public history: HistoryService) {
    
   }

  ngOnInit() {
    this.sid = localStorage.getItem("sid");
  //  console.log(this.sid);
    this.history.getHistory(this.sid).subscribe((resp) => {
      this.orderHistory = resp.json();
      if(this.orderHistory.length===0){
        this.newuser = "newuser";
      }
  //    console.log(this.orderHistory);
    });

  }
  addItemToCart(order: any) {
        this.history.addToTheCart(order);
    }
}