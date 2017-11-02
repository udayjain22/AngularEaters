import { Routes } from '@angular/router';

import { MenuComponent } from './Menu/menu.component';
import { HomeComponent } from './Home/home.component';
import {AddCartComponent} from './Addcart/addcart.component'


export const appRoutes: Routes = [
  { path: 'menu', component: MenuComponent },
  { path: '', component: HomeComponent },
  {path:'addCart', component: AddCartComponent}
];
