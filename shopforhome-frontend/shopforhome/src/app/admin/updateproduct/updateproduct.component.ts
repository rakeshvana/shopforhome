import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product1 } from 'src/app/models/Product1';

import { ProductService } from 'src/app/product.service';



@Component({
  selector: 'app-updateproduct',
  templateUrl: './updateproduct.component.html',
  styleUrls: ['./updateproduct.component.scss']
})
export class UpdateproductComponent implements OnInit {

  product:any;
  id:any;
  url:any;
  constructor(private service:ProductService,private route:ActivatedRoute,private router:Router) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(resp=>{
      this.id = resp.get('pid');
      // alert('id is sent '+id)
      this.service.getProductById(this.id).subscribe(response=>{
        this.product=response;
        this.url="assets/images/"+this.product.productImage
        console.log(this.product.productImage)
      })
    })
  }

  

  updateProduct(values:any){
    var obj=new Product1()
    obj.productName=values.productName;
    obj.productCategory=values.productCategory;
    obj.productDescription=values.productDescription;
    obj.productStock=values.productStock;
    obj.productPrice=values.productPrice;
    if(values.productImage!=""){
      var img = values.productImage;
      obj.productImage=img.replace('C:\\fakepath\\', '');
    }else{
      obj.productImage=values.productImages;
    }

    this.service.updateProduct(this.id,obj).subscribe(Response=>{
      console.log(obj)
      if(Response){
        alert("Updated successfully")
        this.router.navigate([('/product')])
      }
    })
   }

   onselected(event:any){
    if(event.target.files){
      var reader = new FileReader();
      reader.readAsDataURL(event.target.files[0]);
      reader.onload=(event:any)=>{
        this.url=event.target.result;
      }
    }
   }

}
