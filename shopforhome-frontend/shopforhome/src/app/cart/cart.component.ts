import { Component, OnInit, ViewChild } from '@angular/core';
import { Subject } from 'rxjs';
import { CouponService } from '../admin/coupon.service';
import { CartItem } from '../models/CartItem.model';
import { Coupon } from '../models/coupon.model';
import { Product } from '../models/product.model';
import { OrderService } from '../order/order.service';
import { CartService } from './cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {
  count:number=Number(localStorage.getItem('count'))
  cartProducts : CartItem []=[];
  private updateCartProducts = new Subject<CartItem>();
  updateTotalAmount = new Subject<number>();
  totalAmount:number


  userId=Number(localStorage.getItem('userId'))
  coupon: Coupon;

  

  constructor(private cartService: CartService,private orderService :OrderService,private couponService :CouponService){}

  

  ngOnInit(): void {

    this.cartService.getCartCount().subscribe(
      (value)=>{
        this.count=value;
        this.cartService.cartCount.next(value);
      }
      )

    this.cartService.cartCount.subscribe(
      (value)=>{this.count=value}
    )

    this.cartService.showCart().subscribe(
      (prods:CartItem[])=> {
        this.cartProducts=prods
        console.log(this.cartProducts)
      }
    )

    for(var val of this.cartProducts){
      this.totalAmount=val.quantity*val.product.productPrice
      console.log(val)
    }
    
    this.updateTotalAmount.subscribe(
      (res)=>{this.totalAmount+=res; console.log(this.totalAmount)}
    )

    this.couponService.getCouponByuser(this.userId).subscribe(
      (res)=>{
        this.coupon=res;
        console.log(res)
        console.log("coupon ",res)
      }
    )
   
  }

  decreaseNumber(product:CartItem){
    if(product.quantity>0){
    product.quantity--;
    this.updateCartProducts.next(product)
    this.updateTotalAmount.next(product.quantity*product.product.productPrice)
    //console.log(this.totalAmount)
    for(var val of this.cartProducts){
      this.totalAmount=val.quantity*val.product.productPrice
      console.log(val)
    }
    
  }
    


  }

  increaseNumber(product:CartItem){
    if(product.quantity<=+product.product.productStock){
    product.quantity++;
    this.updateCartProducts.next(product)
    
    }
  }

  onShowCart(){
    this.cartService.showCart().subscribe(
      (prods:CartItem[])=> {
        console.log(prods)
        this.cartProducts=prods
        console.log(this.cartProducts)
        
       
      }
    )
  }

  onRemove(prodId:number){
    this.cartService.deleteProductFromCart(prodId).subscribe(
      (resdata)=>{
        console.log(resdata)
        this.cartService.showCart().subscribe(
          (prods:CartItem[])=> {
            this.cartProducts=prods
            console.log(this.cartProducts)
            console.log(resdata)

            this.cartService.cartCount.next(Number(resdata));
            localStorage.setItem('count',String(this.cartService.cartCount.value))

          }
        )
      }
    )
  }

  onCheckOut(){
    console.log(this.cartProducts);
    this.orderService.getCartItems(this.cartProducts)

  }


  

}

