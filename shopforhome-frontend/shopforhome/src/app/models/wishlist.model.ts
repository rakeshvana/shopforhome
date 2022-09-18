import { Product } from "./product.model";
import { UserId } from "./UserId.model";

export class Wishlist{
    constructor(public id:number,
        public product : Product,
        public user : UserId){}
}