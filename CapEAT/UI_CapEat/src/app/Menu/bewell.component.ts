import { Component, OnInit } from '@angular/core';

import { MenuItem } from './menu-item';
import { BewellService } from '../Services/bewell.service';


@Component({
    templateUrl: './bewell.component.html',
    styleUrls: ['./bewell.component.css']
})
export class BewellComponent implements OnInit {
    pageTitle: string = 'BeWell  Menu';
    imageWidth: number = 100;
    imageMargin: number = 2;
    showImage: boolean = true;
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

    constructor(public bewellService: BewellService) {

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
        this.bewellService.getMenuItems()
                .subscribe(products => {
                    this.products = products;
                    this.filteredProducts = this.products;
                },
                    error => this.errorMessage = <any>error);
    }
    addItemToCart(product:any){
        this.bewellService.addToTheCart(product);
    }
}
