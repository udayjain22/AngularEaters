import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Http } from '@angular/http';
import { Inject } from '@angular/core';
import { HistoryItem } from '../history/history-item';


@Injectable()
export class HistoryService {
    public cartItems: HistoryItem[] = [];
    constructor( @Inject(Http) private http: Http) {
    }
    getHistory(): Observable<any> {
        return this.http.post('/CapEAT/history', '3');
    }
    addToTheCart(historyItem: HistoryItem) {
        let item = this.cartItems.find((item) => item.orderId === historyItem.orderId);
        if (!item) {
            item = historyItem;
            this.cartItems.push(item);
            item.orderQuantity = 0;
        }
        item.orderQuantity += 1;
    }
    getTotalCartItems() {
        let cnt = 0;
        this.cartItems.forEach((item) => cnt += item.orderQuantity);
        return cnt;
    }
}