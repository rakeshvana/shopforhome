export class Product{
    constructor(
        public pid : number,
        public productName:string,
        public productCategory:string,
        public productDescription:string,
        public productStock:string,
        public productPrice:number,
        public productImage:string
    ){}
}