import { Component,  OnInit } from '@angular/core';
import { MenuItem } from '../Menu/menu-item';
import { MenuService } from '../Menu/menu.service';
import { BewellService } from '../Menu/bewell.service';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-addcart',
  templateUrl: './addcart.component.html',
  styleUrls: ['./addcart.component.css']
})


export class AddCartComponent {
  serviceName:string;
  public sub:any;
  public service:any;
  public continueShopping:string;

  constructor(public menuService: MenuService, private bewellService: BewellService, private route: ActivatedRoute ){
      this.sub = this.route.params.subscribe(params => {
      this.serviceName = params['serviceName'];
      if(this.serviceName === 'menu') {
          this.service = menuService;
          this.continueShopping = '/menu';
      } else {
        this.service = bewellService;
        this.continueShopping = '/bewell';
      }
      })

  }
}
