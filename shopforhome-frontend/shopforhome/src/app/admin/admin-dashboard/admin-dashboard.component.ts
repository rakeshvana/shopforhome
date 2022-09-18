import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Subject } from 'rxjs';
import { Report } from 'src/app/models/report.model';
import { ProductService } from 'src/app/product.service';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.scss']
})
export class AdminDashboardComponent implements OnInit {

  report:Report[]=[]
  private updateReport = new Subject<Report[]>();

  @ViewChild("f") fromAndTo : NgForm;

  from : string;
  to : string;

  constructor(private productService :ProductService) { }

  ngOnInit(): void {

    this.productService.getReport().subscribe(
    (responseData)=>{
      this.report=responseData;
      console.log(this.from)
    }
    )

    this.updateReport.subscribe(
      (value)=>{
        this.report=value
      }
    )

  }

  onClick(){
    this.productService.getReport().subscribe(
      (responseData)=>{
        this.report=responseData;
        console.log(this.from)
      }
      )
  }

  onSubmit(){
    
    this.productService.getReportByDate(this.fromAndTo.value.from,this.fromAndTo.value.to).subscribe(
      (responseData)=>{
        this.updateReport.next(responseData);
      }
    )
  }

}
