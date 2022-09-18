import { Product } from "./product.model";
import { User } from "./user.model";

export class CartItem{

    

    constructor(
        public cart_Id:number,
        public product:Product,
        public user:User,
        public quantity:number
    ){}
}