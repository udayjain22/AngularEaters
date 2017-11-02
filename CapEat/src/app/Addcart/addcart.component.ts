import { Component,  OnInit } from '@angular/core';
import { MenuItem } from '../Menu/menu-item';
import { MenuService } from '../Menu/menu.service';

@Component({
  selector: 'app-addcart',
  templateUrl: './addcart.component.html',
  styleUrls: ['./addcart.component.css']
})
export class AddCartComponent {
  constructor(private menuService: MenuService){

  }
}
