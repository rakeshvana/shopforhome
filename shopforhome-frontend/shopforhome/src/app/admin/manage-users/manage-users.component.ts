import { TitleCasePipe } from '@angular/common';
import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Coupon } from 'src/app/models/coupon.model';
import { UserId } from 'src/app/models/UserId.model';
import { UserService } from 'src/app/user-auth/user.service';
import { CouponService } from '../coupon.service';
import { CouponComponent } from '../coupon/coupon.component';

@Component({
  selector: 'app-manage-users',
  templateUrl: './manage-users.component.html',
  styleUrls: ['./manage-users.component.scss']
})
export class ManageUsersComponent implements OnInit {
  res:any
  users : UserId[]=[]
  coupons:Coupon[]=[]
  @ViewChild("f") couponForm : NgForm;

  constructor(private userService : UserService,private couponService :CouponService,private router:Router) { }

  ngOnInit(): void {
    this.userService.getAllUsers().subscribe(
      (responseData)=>{
        console.log(responseData)
        this.users=responseData
      }
    )

  


    this.couponService.getCoupons().subscribe(
      (responseData)=>{
        this.coupons=responseData;
        console.log(responseData)
      }
    )



  }


  onDelete(userId:number){
    this.userService.deleteUser(userId).subscribe(
      (responseData)=>{
        console.log(responseData)
      }
    )
  }

onUpdateUser(id:number){

  this.router.navigate([('/admin-dashboard/mng-users/updateuser/'+id)])
  
}

onAddCoupon(userId:number){
  console.log(this.couponForm.value)

  this.couponService.addCoupon(new Coupon(this.couponForm.value.name,this.couponForm.value.percentage,userId)).subscribe(
    (responseData)=>{
      this.res=responseData;
      console.log(responseData)

    }
  )
}



onDeleteCoupon(userId:number){
  this.couponService.deleteCoupon(userId).subscribe(
    (responseData)=>{console.log(responseData)}
  )
}






}



