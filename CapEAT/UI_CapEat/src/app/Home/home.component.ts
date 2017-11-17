import { Component, OnInit, Input } from '@angular/core';
import { LoginService } from '../Services/login.service';
import { Http, RequestOptions, URLSearchParams } from '@angular/http';
import { Injectable, Inject } from '@angular/core';
import { FormBuilder, Validators} from "@angular/forms";

//import { HttpParams, HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',//
  styleUrls: ['./home.component.css']
})


export class HomeComponent implements OnInit {
  title = 'home';
  public eid;
  public password;
  public myParams: Object;
  public userstatus = 'first';
  public sid;

  showDialog;
  constructor(public loginservice: LoginService) {
    if(sessionStorage["PopupShown"] != 'yes'){ 
      this.showDialog = true;
      sessionStorage["PopupShown"] = 'yes';
      }
      }


  ngOnInit() {

  }
  verifyUser() {
    this.myParams = {
      "eid": this.eid,
      "password": this.password
    };

    this.loginservice.getConnection(this.myParams).subscribe((resp) => {
      this.userstatus = resp.json().status;
      this.sid = resp.json().sid;
      localStorage.setItem("existingcard", resp.json().cardNum);
      localStorage.setItem("sid", this.sid);
  //    console.log(localStorage.getItem("sid"));
  //    console.log(resp.json());
      if (this.userstatus === 'HasData'||this.userstatus === 'NoData') {
        localStorage.setItem("userstatus", this.userstatus);        
        this.showDialog = false;
      }
    });
    this.userstatus = 'none';
  }
}