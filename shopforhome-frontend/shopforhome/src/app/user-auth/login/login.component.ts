import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  @ViewChild("f") loginForm : NgForm;
  isLoading:boolean=false;
  res:any=0

  constructor(private userService : UserService,private route:Router) { }

  ngOnInit(): void {
    

  }

  onLogin(){
    console.log(this.loginForm.value)
    this.isLoading=true;
    this.userService.loginUser(this.loginForm.value.email,this.loginForm.value.password).
    subscribe(responseData => {
      this.isLoading=false;
      this.res=responseData
      if(responseData!=null){
      console.log(responseData);
      localStorage.setItem('userId',String(responseData.userId));
      localStorage.setItem('isLoggedIn','true')
      this.userService.isAuthenticated.next(true)
      
       console.log(localStorage.getItem('userId'))
        
        this.gotoLoginPage();


      }
    })

  }

  gotoLoginPage(){
    //alert("Logged In Successfully")
    this.route.navigate(['/'])


  
    
    

    

  }
}
