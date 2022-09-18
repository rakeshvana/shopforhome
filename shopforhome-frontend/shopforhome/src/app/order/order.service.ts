import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { RouterOutlet } from "@angular/router";
import { BehaviorSubject, ReplaySubject, Subject } from "rxjs";
import { CartItem } from "../models/CartItem.model";
import { Order } from "../models/Order.model";

@Injectable({
    providedIn: 'root'
})

export class OrderService{
    cartItems = new ReplaySubject<CartItem[]>(1);

     constructor(private http:HttpClient){
        console.log("in order service ",this.cartItems)
     }


     getCartItems(cartItems:CartItem[]){

        this.cartItems.next(cartItems);
        console.log("in order service ",this.cartItems)
        return cartItems;
     }


     addProductToOrder(orderItems:CartItem[]){
        return this.http.post("http://localhost:8181/order/"+localStorage.getItem('userId')+"/addorder",orderItems);

     }
}
