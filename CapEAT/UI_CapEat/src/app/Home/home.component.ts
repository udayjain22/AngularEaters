import { Component, OnInit, Input } from '@angular/core';
import { LoginService } from '../Services/login.service';
import { Http, RequestOptions, URLSearchParams } from '@angular/http';
import { Injectable, Inject } from '@angular/core';
//import { HttpParams, HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})


export class HomeComponent implements OnInit {

  title = 'home';
  public eid;
  public password;
  public myParams : Object;
  showDialog;

  constructor(public loginservice: LoginService) {
    this.showDialog = true;
  }

  ngOnInit() {

  }
  verifyUser() {
    this.myParams={
      "eid" :this.eid,
      "password":this.password
    };
    this.loginservice.getConnection(this.myParams).subscribe((resp) => {
      console.log(resp.json());
    });

  }

}
