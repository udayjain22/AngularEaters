import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/map';

import { MenuItem } from '../Menu/menu-item';

@Injectable()
export class BewellService {
    private _menuUrl = './api/menu-items/bewell_menu.json';
    public cartItems:Array<MenuItem>= [];
 constructor(private _http: HttpClient) { }

    getMenuItems(): Observable<MenuItem[]> {
        return this._http.get<MenuItem[]>(this._menuUrl)
            .do(data => console.log('All: ' + JSON.stringify(data)))
            .catch(this.handleError);
    }

    getMenuItem(id: number): Observable<MenuItem> {
        return this.getMenuItems()
            .map((menus: MenuItem[]) => menus.find(p => p.productId === id));
    }

    private handleError(err: HttpErrorResponse) {
        // in a real world app, we may send the server to some remote logging infrastructure
        // instead of just logging it to the console
        let errorMessage = '';
        if (err.error instanceof Error) {
            // A client-side or network error occurred. Handle it accordingly.
            errorMessage = `An error occurred: ${err.error.message}`;
        } else {
            // The backend returned an unsuccessful response code.
            // The response body may contain clues as to what went wrong,
            errorMessage = `Server returned code: ${err.status}, error message is: ${err.message}`;
        }
        console.error(errorMessage);
        return Observable.throw(errorMessage);
    }

    addToTheCart(menuItem:MenuItem){
        let item = this.cartItems.find((item) => item.productId === menuItem.productId);
        if (!item) {
            item = menuItem;
            this.cartItems.push(item);
            item.orderCount = 0;
        }
        item.orderCount += 1;
    }

    getTotalCartItems() {
        let cnt = 0;
        this.cartItems.forEach((item) => cnt += item.orderCount);
        return cnt;
    }
}
