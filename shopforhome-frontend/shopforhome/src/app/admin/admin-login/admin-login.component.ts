import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../../user-auth/user.service';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.scss']
})
export class AdminLoginComponent implements OnInit {

  @ViewChild("f") loginForm : NgForm;
  res:string

  isLoading:boolean=false;

  constructor(private userService : UserService,private route:Router) { }

  ngOnInit(): void {
  }

  onLogin(){
    console.log(this.loginForm.value)
    this.isLoading=true;
    this.userService.loginUser(this.loginForm.value.email,this.loginForm.value.password).
    subscribe(responseData => {
      this.res=responseData;
      console.log(responseData)
      this.isLoading=false;
      if(responseData!=null && responseData.role=="ADMIN"){
        this.userService.isAuthenticated.next(true);
        this.gotoLoginPage();
        localStorage.setItem('adminId',String(responseData));
        localStorage.setItem('isAdminLoggedIn','true')

      }
    })
  }

  gotoLoginPage(){
    alert("Logged In Successfully")
    this.route.navigate(['/admin-dashboard'])
  }

}
