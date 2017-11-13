import { Component, OnInit } from '@angular/core';
import { HistoryService } from '../Services/history.service';
import { HistoryItem} from './history-item';


@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {

  public orderHistory: Array<HistoryItem> = [];
  public selectedOrders: Array<HistoryItem> = [];

  constructor(public history: HistoryService) {
    this.history.getHistory().subscribe((resp) => {
      this.orderHistory = resp.json();
    });

   }

  ngOnInit() {

  }
  addItemToCart(order: any) {
        this.history.addToTheCart(order);
    }
}