import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { User } from 'src/app/models/user.model';
import { UserService } from 'src/app/user-auth/user.service';


@Component({
  selector: 'app-register',
  templateUrl: './new-user.component.html',
  styleUrls: ['./new-user.component.scss']
})
export class NewUserComponent implements OnInit {
  @ViewChild("f") registerForm : NgForm;
  res:string;

  

  //user:User=new User(this.registerForm.value.name,"leela@gmail.com",new Date("2022-06-04"),"123");

 
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
        "USER")
    )
    .subscribe((responseData: any) => {
      console.log(responseData);
      alert("User Added Successfully")
      this.res=responseData;
      this.route.navigate(["admin-dashboard","mng-users"])
    });

  }

 

}
  