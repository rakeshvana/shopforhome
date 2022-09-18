import { TemplateBindingParseResult } from '@angular/compiler';
import { Component, OnInit  } from '@angular/core';
import { Router } from '@angular/router';
import { CartService } from '../cart/cart.service';
import { Product } from '../models/product.model';
import { ProductService } from '../product.service';
import { UserService } from '../user-auth/user.service';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit{

  isAuthenticated:boolean=(localStorage.getItem('isLoggedIn')=="true"?true:false)
  isAdminAuthenticated : boolean = (localStorage.getItem('isAdminLoggedIn')=="true"?true:false)
  products:Product[]=[]
  filterCategory : Product[]=[]
  searchTerm !: string;
  searchKey:string ="";
  params:string=""

  constructor(
    private userService:UserService,
     private route:Router,
     private cartService : CartService,
     private productService : ProductService) { 
  
  }

  ngOnInit(): void {

    this.userService.getLoggedInStatus().subscribe(
      (responseData :boolean)=> {
        this.isAuthenticated=responseData;
        localStorage.setItem('isLoggedIn',String(responseData))
        console.log("getLooged in : "+responseData)
      }

      
    )
   

    this.userService.isAuthenticated.subscribe(
      (      value: boolean) => {
        this.isAuthenticated=value
      }
    )
    console.log(this.isAuthenticated)
  }

  onLogout(){
    this.route.navigate(['/login'])
    this.userService.logout().subscribe(
      responseData=>{
        console.log(responseData);

        
      }
      );
    localStorage.removeItem("userId")
    localStorage.setItem("isLoggedIn","false")
    localStorage.setItem("isAdminLoggedIn","false")
    this.userService.isAuthenticated.next(false);

  }

  filter(category:string){
    
  }


  onOpenCart(){
      if(this.isAuthenticated==false){
      this.route.navigate(['/login']);
      }
      else{
        this.route.navigate(['/cart']);
      }
   
  }

}
