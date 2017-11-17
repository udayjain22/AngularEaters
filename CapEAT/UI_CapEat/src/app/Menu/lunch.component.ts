import { Component, OnInit } from '@angular/core';
import { MenuItem } from './menu-item';
import { LunchService } from '../Services/lunch.service';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';

@Component({
    templateUrl: './lunch.component.html',
    styleUrls: ['./lunch.component.css']
})
export class LunchComponent implements OnInit {
    pageTitle: string = 'Lunch  Menu (Each option feeds 15 people.)';
    imageWidth: number = 100;
    imageMargin: number = 2;
    showImage: boolean = true;
    errorMessage: string;
    public router;
    public try: any[] = [];
    

    _listFilter: string;
    get listFilter(): string {
        return this._listFilter;
    }
    set listFilter(value: string) {
        this._listFilter = value;
        this.filteredProducts = this.listFilter ? this.performFilter(this.listFilter) : this.products;
    }

    paynow(index: number){
        localStorage.setItem("amount",JSON.stringify(this.filteredProducts[index].price));                
        localStorage.setItem("lunchchef", JSON.stringify(this.filteredProducts[index]));
        this.router.navigateByUrl('/payment');            
    }

    filteredProducts: MenuItem[];
    products: MenuItem[] = [];

    constructor(public menuService: LunchService, public routes: Router) {
        this.router = routes;
    }

    onRatingClicked(message: string): void {
        this.pageTitle = 'Product List: ' + message;
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

