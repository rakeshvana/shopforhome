import { Component, OnInit } from '@angular/core';
import { Subject } from 'rxjs';
import { CouponService } from '../admin/coupon.service';
import { CartItem } from '../models/CartItem.model';
import { Coupon } from '../models/coupon.model';
import { Order } from '../models/Order.model';
import { OrderService } from './order.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.scss']
})
export class OrderComponent implements OnInit {
  userId=Number(localStorage.getItem('userId'))
  orderProduct: CartItem []=[];
  total=0
  discountTotal:number=0
  updatedTotalSum=new Subject<number>()
  discountCode:string
  coupon:Coupon
  discountApplied:boolean=false;

  constructor(private orderService : OrderService, private couponService : CouponService) { }

  ngOnInit(): void {
    this.orderService.cartItems.subscribe(
      (res)=>{
        this.orderProduct=res;
      }
    )
    this.getTotalSum()
    console.log(this.orderProduct)

    this.updatedTotalSum.subscribe(
      (val)=>{this.discountTotal=val}
    )

    this.couponService.getCouponByuser(this.userId).subscribe(
      (res)=>{
        this.coupon=res;
        console.log("coupon ",res)
      }
    )


  }

  getTotalSum(){
    for(let i of this.orderProduct){
      this.total+=i.product.productPrice*i.quantity+10;
    }
  }

  onPlaceOrder(){
    alert("order placed");
    this.orderService.addProductToOrder(this.orderProduct).subscribe(
      (responseData)=>{
        console.log(responseData)
      }
    );
  }

 
  onApplyDiscount(){
    
   
    this.updatedTotalSum.next((this.total)-((this.total*this.coupon.percentage)/100)-10)
      
    this.discountApplied=true

    
  }


}
