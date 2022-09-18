import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Product1 } from 'src/app/models/Product1';
import { ProductService } from 'src/app/product.service';


@Component({
  selector: 'app-addproducts',
  templateUrl: './addproducts.component.html',
  styleUrls: ['./addproducts.component.scss']
})
export class AddproductsComponent implements OnInit {

  constructor(private service:ProductService,private router:Router) { }

  ngOnInit(): void {
  }

  addProduct(values:any){
    var obj=new Product1()
    obj.pid=values.pid;
    obj.productName=values.productName;
    obj.productCategory=values.productCategory;
    obj.productDescription=values.productDescription;
    obj.productStock=values.productStock;
    obj.productPrice=values.productPrice;
    var img = values.productImage;
    obj.productImage=img.replace('C:\\fakepath\\', '');

    this.service.addProduct(obj).subscribe(Response=>{
      console.log(obj)
      if(Response){
        alert("Added successfully")
        this.router.navigate([('/product')])
      }
    })
   }

}
