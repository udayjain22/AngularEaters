import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import { Http } from '@angular/http';
import { Inject } from '@angular/core';
@Injectable()
export class PaymentService {
    public sendorderobj : Object;
    
    constructor(@Inject(Http) private http: Http) {
    }
    paynow(sendorderobj): Observable<any> {
    //    console.log(sendorderobj);
        return this.http.post('/CapEAT/makepayment', sendorderobj) ;
    }
}