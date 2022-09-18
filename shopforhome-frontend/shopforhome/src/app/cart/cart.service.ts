import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { BehaviorSubject, Observable, ReplaySubject, Subject } from "rxjs";
import { CartItem } from "../models/CartItem.model";
import { ProductToCart } from "../models/ProductToCart.model";
import { LoginComponent } from "../user-auth/login/login.component";
import { UserService } from "../user-auth/user.service";

@Injectable({
    providedIn: 'root'
})
export class CartService{
    
    cartCount = new BehaviorSubject<number>(Number(localStorage.getItem('count')));
    wishlistCount = new BehaviorSubject<number>(Number(localStorage.getItem('wcount')));


    constructor(
        private http:HttpClient,
        private userService: UserService
        ){}

    ngOnInit(): void {

        
    }

    addProductToCart(productId:number){
        console.log("in cart service"+productId)
        return this.http.post("http://localhost:8181/"+localStorage.getItem("userId")+"/cart/add/",
        new ProductToCart(1,productId))
    }


    showCart():Observable<any>{
        return this.http.get("http://localhost:8181/"+localStorage.getItem("userId")+"/cart")
    }

    deleteProductFromCart(productId:number){

        console.log("in service cart")
         return this.http.delete("http://localhost:8181/"+localStorage.getItem("userId")+"/cart/delete/"+productId)
    }





    addProductToWishlist(productId : number){
        return this.http.post("http://localhost:8181/"+localStorage.getItem("userId")+"/wishlist/add/",
        {productId:productId})

    }

    
    showWishlist():Observable<any>{
        console.log("in wishlist")
        return this.http.get("http://localhost:8181/"+localStorage.getItem("userId")+"/wishlist")
    }

    deleteProductFromWishlist(productId:number){

        console.log("in wishlist")
         return this.http.delete("http://localhost:8181/"+localStorage.getItem("userId")+"/wishlist/delete/"+productId)
    }

    getCartCount():Observable<any>{
        return this.http.get("http://localhost:8181/"+localStorage.getItem("userId")+"/cart/cartcount")
    }

    getWishlistCount():Observable<any>{
        return this.http.get("http://localhost:8181/"+localStorage.getItem("userId")+"/wishlist/wishlistcount")
    }



}