import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductService } from 'src/app/product.service';

@Component({
  selector: 'app-manage-products',
  templateUrl: './manage-products.component.html',
  styleUrls: ['./manage-products.component.scss']
})
export class ManageProductsComponent implements OnInit {

  products:any;
  file:any;
  constructor(private service:ProductService,private router:Router) { }

  ngOnInit(): void {
    this.service.getProducts().subscribe(response=>{
      this.products=response;
    })
  }

  selectFile(event:any){
    this.file=event.target.files[0]
  }

  uploadFile(){
    let formData = new FormData()
    formData.append('file',this.file)
    this.service.uploadfile(formData).subscribe(resp=>{
      if(resp){
        alert("Uploaded Successfully")
        this.ngOnInit();
      }
    })
  }

  updateProduct(pid:any){
    this.router.navigate([('/updateproducts/'+pid)])
  }

  deleteProduct(pid:number){
    this.service.deleteProduct(pid).subscribe(Response=>{
      if(Response){
        this.ngOnInit()
      }
    })
  }

  sendEmail(pid:any){
    console.log(pid);
    this.service.sendEmail(pid).subscribe();
  }

}
