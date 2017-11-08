import { Routes } from '@angular/router';

import { MenuComponent } from './Menu/menu.component';
import { BewellComponent } from './Menu/bewell.component';
import { HomeComponent } from './Home/home.component';
import { PaymentComponent } from './payment/payment.component';
import {AddCartComponent} from './Addcart/addcart.component';
import {MapComponent} from './map/map.component'


export const appRoutes: Routes = [
  { path: 'menu', component: MenuComponent },
  { path: 'bewell', component: BewellComponent },
  { path: '', component: HomeComponent },
  {path: 'addCart/:serviceName', component: AddCartComponent},
  {path: 'payment', component: PaymentComponent},
  {path: 'maps', component: MapComponent }
];
