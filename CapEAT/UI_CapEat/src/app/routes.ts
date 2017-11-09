import { Routes } from '@angular/router';

import { MenuComponent } from './Menu/menu.component';
import { BewellComponent } from './Menu/bewell.component';
import { HomeComponent } from './Home/home.component';
import { PaymentComponent } from './payment/payment.component';
import { AddCartComponent} from './Addcart/addcart.component';
import { DialogComponent } from './Dialogue/dialogue.component';
import { MapComponent} from './map/map.component';
import { HistoryComponent } from './history/history.component';
import { CateringComponent } from './catering/catering.component';
import { SpecialComponent } from './special/special.component';
import { SpiceLevelComponent } from './spice-level/spice-level.component';



export const appRoutes: Routes = [
  { path: 'menu', component: MenuComponent },
  { path: 'bewell', component: BewellComponent },
  { path: '', component: HomeComponent },
  { path: 'dialog', component: DialogComponent },
  {path: 'addCart/:serviceName', component: AddCartComponent},
  {path: 'payment', component: PaymentComponent},
  {path: 'history', component: HistoryComponent},
  {path: 'maps', component: MapComponent },
  {path: 'catering', component: CateringComponent },
  {path: 'special', component: SpecialComponent },
  {path: 'spicelevel', component: SpiceLevelComponent }
];
