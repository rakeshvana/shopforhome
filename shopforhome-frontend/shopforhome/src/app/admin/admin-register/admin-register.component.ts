import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../../models/user.model';
import { UserService } from '../../user-auth/user.service';

@Component({
  selector: 'app-admin-register',
  templateUrl: './admin-register.component.html',
  styleUrls: ['./admin-register.component.scss']
})
export class AdminRegisterComponent implements OnInit {
  @ViewChild("f") registerForm : NgForm;
  res:string;
  

  

  //user:User=new User(this.registerForm.value.name,"leela@gmail.com",new Date("2022-06-04"),"123");

  savecred(){
    this.registerForm.setValue (
      {
        name:"test",
        email:"test@gmail.com",
        address:"testadress",
        contactNumber:1234567894,
        password:"123",
        
      },
    )
  }
  constructor(private userService : UserService ,private route: Router) { }

  
  
  ngOnInit(): void {
  }

  registerUser(){
    console.log(this.registerForm)
    this.userService.registerUser(
      new User(
        this.registerForm.value.name,
        this.registerForm.value.email,
        this.registerForm.value.address,
        this.registerForm.value.contactNumber,
        this.registerForm.value.password,
        "ADMIN")
    )
    .subscribe((responseData: any) => {
      console.log(responseData);
      this.res=responseData;
      this.gotoLoginPage();
    });

  }

  gotoLoginPage(){
    alert(this.res);
    if(this.res==="Registered Successfully")
      this.route.navigate(['admin/login'])
  }
  
}
