export class Report{
    constructor(
        public  productId :number,
        public  productName:string,
        public  productCategory:string,
        public  price:number,
        public  currentStock:number,
        public  orderedAmount:number,
        public  profit:number,
        public productImage:string
    ){}
}