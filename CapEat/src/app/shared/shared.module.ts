import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StarComponent } from './star.component';
import { FormsModule } from '@angular/forms';
import { CounterComponent } from './counter.component';
 
@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [
    StarComponent,
    CounterComponent
  ],
  exports: [
    StarComponent,
    CommonModule,
    FormsModule,
    CounterComponent
  ]
})
export class SharedModule { }
