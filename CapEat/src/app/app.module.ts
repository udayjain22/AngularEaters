import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { UIRouterModule } from '@uirouter/angular';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';


import {AppComponent} from './app.component';
import {NavComponent} from './nav/nav.component';

import { appRoutes } from './routes';
import {HomeComponent} from './Home/home.component';
import {SigninComponent} from './Signin/sign.component';
import {DialogComponent} from './Dialogue/dialogue.component';
import { CreditCardDirectivesModule } from 'ng2-cc-library'

import { FooterComponent } from './footer/footer.component';

import { MenuComponent } from './Menu/menu.component';
import { MenuService } from './Menu/menu.service';
import { StarComponent } from './shared/star.component';
import {AddCartComponent} from './Addcart/addcart.component'



@NgModule({
  imports: [
    BrowserModule,
    HttpModule,
    NgbModule.forRoot(),
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    FormsModule,
    CreditCardDirectivesModule,
   
  ],
  declarations: [
    AppComponent,
    NavComponent,
    HomeComponent,
// <<<<<<< signin
    DialogComponent,
   ],

    NavComponent,
    FooterComponent,
    MenuComponent,
    StarComponent,
    AddCartComponent,
  ],

  providers: [
    MenuService
   ],
  bootstrap: [AppComponent]
})
export class AppModule { }
