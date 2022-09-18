import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BehaviorSubject } from 'rxjs/internal/BehaviorSubject';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http:HttpClient) { }

  public search = new BehaviorSubject<string>("");

  getProducts(){
    return this.http.get("http://localhost:8181/getproduct");
  }

  addProduct(values:any){
    return this.http.post("http://localhost:8181/addproduct",values)
  }

  getProductById(id:any){
    return this.http.get("http://localhost:8181/getproductbyId/"+id);
  }

  updateProduct(id:any,values:any){
   return this.http.put("http://localhost:8181/updateproduct/"+id,values)
  }

  deleteProduct(id:number){
    return this.http.delete("http://localhost:8181/deleteproduct/"+id)
  }

  uploadfile(form:any){
    return this.http.post("http://localhost:8181/upload",form)
  }

  getReport():Observable<any>{
    return this.http.get("http://localhost:8282/report")
  }

  getReportByDate(from:string,to:string):Observable<any>{
    
    return this.http.get("http://localhost:8282/report/"+from+"/"+to);
  }

  sendEmail(id:any){
    alert("Mail Sent successfully");
    return this.http.get("http://localhost:8181/sendemail/"+id);
  }

  
}
