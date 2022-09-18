import { User } from "./user.model";

export class Coupon{
    constructor(
        public couponName:string,
        public percentage:number,
        public userId : number
    ){}
}