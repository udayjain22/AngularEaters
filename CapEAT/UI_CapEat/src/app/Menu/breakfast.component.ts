import { Component, OnInit } from '@angular/core';

import { MenuItem } from './menu-item';
import { BreakfastService } from '../Services/breakfast.service';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';




@Component({
    templateUrl: './breakfast.component.html',
    styleUrls: ['./breakfast.component.css']
})
export class BreakfastComponent implements OnInit {
    pageTitle: string = 'Breakfast  Menu (Each option feeds 15 people.)';
    imageWidth: number = 100;
    imageMargin: number = 2;
    showImage: boolean = true;
    errorMessage: string;
    public router;
    
    _listFilter: string;
    get listFilter(): string {
        return this._listFilter;
    }
    set listFilter(value: string) {
        this._listFilter = value;
        this.filteredProducts = this.listFilter ? this.performFilter(this.listFilter) : this.products;
    }

    filteredProducts: MenuItem[];
    products: MenuItem[] = [];

    constructor(public menuService: BreakfastService, public routes: Router) {
        this.router = routes;
    }
    paynow(index: number){
        localStorage.setItem("amount",JSON.stringify(this.filteredProducts[index].price));        
        localStorage.setItem("lunchchef", JSON.stringify(this.filteredProducts[index]));
        this.router.navigateByUrl('/payment');            
    }
    
    performFilter(filterBy: string): MenuItem[] {
        filterBy = filterBy.toLocaleLowerCase();
        return this.products.filter((product: MenuItem) =>
              product.productName.toLocaleLowerCase().indexOf(filterBy) !== -1);
    }

    toggleImage(): void {
        this.showImage = !this.showImage;
    }

    ngOnInit(): void {
        this.menuService.getMenuItems()
                .subscribe(products => {
                    this.products = products;
                    this.filteredProducts = this.products;
                },
                    error => this.errorMessage = <any>error);
    }
    
}
