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
  public userStatus;

  remove(index: number) {
    this.arr.splice(index, 1);

  }
  getTotal = function () {
    this.total = 0;
    this.arr.forEach(element => {
      this.total += element.price * element.orderCount + 0.5;
    });
    localStorage.setItem("total", this.total); 
    return this.total;
  };
  getValue(value: number) {
   // console.log(value);
    return value;
  }



  constructor(public menuService: MenuService, public historyService: HistoryService,
    public bewellService: BewellService, public route: ActivatedRoute ) {
      this.userStatus = localStorage.getItem("userstatus");
  //    console.log(this.userStatus);
    this.value = 0;
    this.sub = this.route.params.subscribe(params => {
      this.serviceName = params['serviceName'];
      if (this.serviceName === 'menu') {
        this.arr = menuService.cartItems;
        this.service = menuService;
        this.continueShopping = '/menu';
      }else if (this.serviceName === 'history') {
        this.arr = historyService.cartItems;
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
        this.arr = bewellService.cartItems;
        this.service = bewellService;
        this.continueShopping = '/bewell';
      }
    });

  }
}

