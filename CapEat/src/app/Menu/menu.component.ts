import { Component, OnInit } from '@angular/core';

import { MenuItem } from './menu-item';
import { MenuService } from './menu.service';


@Component({
    templateUrl: './menu.component.html',
    styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
    pageTitle: string = 'Indain  Menu';
    imageWidth: number = 50;
    imageMargin: number = 2;
    showImage: boolean = false;
    errorMessage: string;

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

    constructor(private menuService: MenuService) {

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
    addItemToCart(product:any){
        this.menuService.addToTheCart(product);
    }
}
