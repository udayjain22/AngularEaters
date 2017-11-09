import { Injectable, Inject } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { HomeComponent } from '../Home/home.component';

@Injectable()
export class LoginService {

  public user : Object;
  public msg;

  constructor(@Inject(Http) public http: Http,private router: Router) {
    
  }

  getConnection(user): Observable<any> {
    console.log(user);
    return this.http.post('/CapEAT/signin', user);
  }

  
}