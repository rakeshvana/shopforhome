import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/models/user.model';
import { UserService } from 'src/app/user-auth/user.service';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.scss']
})
export class UpdateUserComponent implements OnInit {
  @ViewChild("f") registerForm : NgForm;
  res:any;
  id:any;
  user:User;
  constructor(private userService : UserService ,private router: Router,private route:ActivatedRoute) { }



  ngOnInit(): void {
    this.route.paramMap.subscribe(resp=>{
      this.id = resp.get('id');
     // alert('id is sent '+this.id)
      this.userService.getUserById(this.id).subscribe(response=>{
        this.user=response;
        console.log(this.user)
      })
    })


    

  }

  updateUser(){
    console.log(this.registerForm)
    this.userService.updateUser(
      new User(
        this.registerForm.value.name,
        this.registerForm.value.email,
        this.registerForm.value.address,
        this.registerForm.value.contactNumber,
        this.registerForm.value.password,
        "USER",),this.id
    )
    .subscribe((responseData: any) => {
      console.log(responseData);
      console.log(this.registerForm)
      this.res=responseData;
    });


}



}
