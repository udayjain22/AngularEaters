import { Component, OnInit } from '@angular/core';
import { MenuItem } from '../Menu/menu-item';
import { MenuService } from '../Services/menu.service';
import { BewellService } from '../Services/bewell.service';
import { HistoryService } from '../Services/history.service';
import {HistoryItem} from '../history/history-item';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-addcart',
  templateUrl: './addcart.component.html',
  styleUrls: ['./addcart.component.css']
})


export class AddCartComponent {
  serviceName: string;
  public sub: any;
  public service: any;
  public continueShopping: string;
  public arr: any[];
  public total;
  public value;
  remove(index: number) {
    this.arr.splice(index, 1);

  }
  getTotal = function () {
    this.total = 0;
    this.arr.forEach(element => {
      this.total += element.price * element.orderCount + 0.5;
    });
    return this.total;
  };
  getValue(value: number) {
    console.log(value);
    return value;
  }



  constructor(public menuService: MenuService, public historyService: HistoryService,
    public bewellService: BewellService, public route: ActivatedRoute ) {
    this.arr = menuService.cartItems;
    this.value = 0;
    this.sub = this.route.params.subscribe(params => {
      this.serviceName = params['serviceName'];
      if (this.serviceName === 'menu') {
        this.service = menuService;
        this.continueShopping = '/menu';
      }else if (this.serviceName === 'history') {
        this.service = historyService;
        this.continueShopping = '/history';
    historyService.cartItems.forEach((item: HistoryItem) => {
        item['productName'] = item.itemName;
        item['orderCount'] = item.orderQuantity;
        item['spice'] = item.spiceLevel;
        item['price'] = item.itemPrice;

  }
);

      } else {
        this.service = bewellService;
        this.continueShopping = '/bewell';
      }
    });

  }
}
