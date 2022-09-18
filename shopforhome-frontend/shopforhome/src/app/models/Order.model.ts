import { Product } from "./product.model";
import { User } from "./user.model";

export class Order{
    constructor(
        public product:Product,
        public user : User,
        public quantity:number,
        public price:number,
        public orderDate : Date
    ){}
}