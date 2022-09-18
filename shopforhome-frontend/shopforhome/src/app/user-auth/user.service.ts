import { HttpClient, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { BehaviorSubject, Observable, Subject } from "rxjs";
import {User} from "../models/user.model"


@Injectable(
    
)
export class UserService{
    
    //isAuthenticated=false;
    isAuthenticated=new Subject<boolean>();
    CurrentUserId=new BehaviorSubject<number>(0);

    
    

    constructor(public http: HttpClient) {
        
    }


    public registerUser(user:User): Observable<string>{
        
        return this.http.post("http://localhost:8181/user/register", user, { responseType: 'text' });
    }
    
    public loginUser(email:string,password:string):Observable<any>{

        
        
        return this.http.post("http://localhost:8181/user/login",{email:email,password:password});
        //return this.currentUser;
        
    }

    public logout():Observable<any>{
 
        const params = new HttpParams().set('userId', String(localStorage.getItem('userId')))
        this.isAuthenticated.next(false)
        return this.http.get("http://localhost:8181/user/logout",{params})
    }
    public getLoggedInStatus():Observable<any>{
        return this.http.get("http://localhost:8181/user/getLoggedInStatus")
    
    }



    public getAllUsers():Observable<any>{
        return this.http.get("http://localhost:8181/user/getusers")
    }

    public deleteUser(userId:number){
        return this.http.delete("http://localhost:8181/user/delete/"+userId);
    }

    public updateUser(user:User,id:number){
        return this.http.put("http://localhost:8181/user/updateuser/"+id,user);

    }

    public getUserById(id:number):Observable<any>{
        return this.http.get("http://localhost:8181/user/getuserbyid/"+id)
    }





}


