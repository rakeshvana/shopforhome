import { Component, OnInit } from '@angular/core';
import { CartService } from '../cart/cart.service';
import { Wishlist } from '../models/wishlist.model';

@Component({
  selector: 'app-wishlist',
  templateUrl: './wishlist.component.html',
  styleUrls: ['./wishlist.component.scss']
})
export class WishlistComponent implements OnInit {


  wcount:number=Number(localStorage.getItem('wcount'))
  wishlistProducts : Wishlist []=[];
  constructor(private cartService: CartService) { }

  ngOnInit(): void {
    this.cartService.getWishlistCount().subscribe(
      (value)=>{
        this.wcount=value;
        this.cartService.cartCount.next(value);
        //localStorage.setItem('wcount',String(this.cartService.wishlistCount.value))
      }
      )
  
  

    this.cartService.wishlistCount.subscribe(
      (value)=>{this.wcount=value}
    )
    

    this.cartService.showWishlist().subscribe(
      (prods:Wishlist[])=> {
        this.wishlistProducts=prods
        console.log(this.wishlistProducts)
      }
    )

    
  }


  onShow(){
    this.cartService.showCart().subscribe(
      (prods:Wishlist[])=> {
        console.log(prods)
        this.wishlistProducts=prods
        
      }
    )
  }

  onRemove(prodId:number){
    this.cartService.deleteProductFromWishlist(prodId).subscribe(
      (resdata)=>{
        console.log(resdata)
        this.cartService.showWishlist().subscribe(
          (prods:Wishlist[])=> {
            this.wishlistProducts=prods
            console.log(this.wishlistProducts)
            
            this.cartService.wishlistCount.next(Number(resdata))
            console.log(resdata)
             localStorage.setItem('wcount',String(this.cartService.wishlistCount.value))
          }
        )
      }
    )

  }

  onAddToCart(prodId:number){
    this.cartService.addProductToCart(prodId).subscribe(
      (resdata:any)=>{
        console.log(resdata)
      }
    )
  }


}
