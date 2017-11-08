import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { UIRouterModule } from '@uirouter/angular';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { NavComponent } from './nav/nav.component';

import { appRoutes } from './routes';
import { HomeComponent } from './Home/home.component';

import { FooterComponent } from './footer/footer.component';

import { MenuComponent } from './Menu/menu.component';
import { BewellComponent } from './Menu/bewell.component';
import { MenuService } from './Menu/menu.service';
import { BewellService } from './Menu/bewell.service';
import { AddCartComponent } from './Addcart/addcart.component';
import { DialogComponent } from './Dialogue/dialogue.component';
import { MapComponent } from './map/map.component';
import { PaymentComponent } from './payment/payment.component';
import { HistoryComponent } from './history/history.component';



@NgModule({
  imports: [
    BrowserModule,
    HttpModule,
    NgbModule.forRoot(),
    HttpClientModule,
    RouterModule.forRoot(appRoutes, {useHash: true }),
    FormsModule
  ],
  declarations: [
    AppComponent,
    NavComponent,
    HomeComponent,
    NavComponent,
    FooterComponent,
    MenuComponent,
    BewellComponent,
    AddCartComponent,
    DialogComponent,
    MapComponent,
    PaymentComponent,
    HistoryComponent,
  ],
  providers: [
    MenuService,
    BewellService
   ],
  bootstrap: [AppComponent]
})
export class AppModule { }
