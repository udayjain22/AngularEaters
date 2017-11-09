import { Component, OnInit } from '@angular/core';
import { MenuItem } from '../Menu/menu-item';
import { MenuService } from '../Menu/menu.service';
import { BewellService } from '../Menu/bewell.service';
import { ActivatedRoute } from "@angular/router";

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



  constructor(public menuService: MenuService, public bewellService: BewellService, public route: ActivatedRoute ) {
    this.arr = menuService.cartItems;
    this.value = 0;
    this.sub = this.route.params.subscribe(params => {
      this.serviceName = params['serviceName'];
      if (this.serviceName === 'menu') {
        this.service = menuService;
        this.continueShopping = '/menu';
      } else {
        this.service = bewellService;
        this.continueShopping = '/bewell';
      }
    });

  }
}
