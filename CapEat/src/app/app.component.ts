import { Component,  OnInit } from '@angular/core';




@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  showDialog = true;
  constructor() {
    
  }
  

  ngOnInit()  {
    // called after the constructor and called  after the first ngOnChanges()
  }

  
}
