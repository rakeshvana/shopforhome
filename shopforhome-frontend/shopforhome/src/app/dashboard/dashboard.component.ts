import { Component, OnInit } from '@angular/core';
import { CartService } from '../cart/cart.service';
import { ProductService } from '../product.service';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  products:any
  filterCategory : any
  searchTerm !: string;
  searchKey:string ="";
  params:string=""
  constructor(private productService : ProductService,private cartService :CartService) { }

  ngOnInit(): void {
    this.productService.getProducts().subscribe(response=>{
      this.products=response;
      this.filterCategory=response;
    })
    this.productService.search.subscribe((val:any)=>{
      this.searchKey = val;
    })
  }

  filter(category:string){
    this.filterCategory = this.products
    .filter((a:any)=>{
      console.log(a.productCategory)
      if(a.productCategory == category || category==''){
        return a;
      }
    })
  }

  search(event:any){
    this.searchTerm = (event.target as HTMLInputElement).value;
    this.productService.search.next(this.searchTerm);
  }

  sort(value:any){
    this.params=value;
  }

  onAddToCart(prodId:number){
    
     this.cartService.addProductToCart(prodId).subscribe(
      (resdata)=>{
        console.log(resdata)
        localStorage.setItem('count',String(resdata));
        console.log("value"+this.cartService.cartCount.value)
        this.cartService.cartCount.next(Number(resdata));
      }
    )
  }

  onAddToWishlist(prodId:number){
    this.cartService.addProductToWishlist(prodId).subscribe(
      (resdata)=>{
        console.log(resdata)
        localStorage.setItem('wcount',String(resdata));
        console.log("value"+this.cartService.wishlistCount.value)
        this.cartService.wishlistCount.next(Number(resdata));
        
      }
    )
  }

}
