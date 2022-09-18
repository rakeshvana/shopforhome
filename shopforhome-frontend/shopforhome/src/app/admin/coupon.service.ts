import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Coupon } from "../models/coupon.model";

@Injectable(
    {
        providedIn:"root"
    }
)
export class CouponService{

    constructor(private http:HttpClient){}

    addCoupon(coupon:Coupon){
        
        return this.http.post("http://localhost:8383/addcoupon",coupon)

    }


    getCoupons():Observable<any>{
        return this.http.get("http://localhost:8383/getcoupon")
    }

    deleteCoupon(id:number):Observable<any>{
        return this.http.delete("http://localhost:8383/deletecoupon/"+id);
    }

    getCouponByuser(userId:number):Observable<any>{
        return this.http.get("http://localhost:8383/getcouponbyuser/"+userId);
    }
}