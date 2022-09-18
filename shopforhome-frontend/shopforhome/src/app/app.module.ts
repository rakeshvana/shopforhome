import { HttpClientModule } from '@angular/common/http';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { LoadingSpinnerComponent } from './shared/loading-spinner.component';
import { LoginComponent } from './user-auth/login/login.component';
import { RegisterComponent } from './user-auth/register/register.component';
import { UserService } from './user-auth/user.service';
import { AdminLoginComponent } from './admin/admin-login/admin-login.component';
import { AdminRegisterComponent } from './admin/admin-register/admin-register.component';
import { CartComponent } from './cart/cart.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FilterPipe } from './shared/filter.pipe';
import { SortPipe } from './shared/sort.pipe';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import {MatCardModule} from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button'
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatTabsModule} from '@angular/material/tabs';
import {MatFormFieldModule} from '@angular/material/form-field';

import { WishlistComponent } from './wishlist/wishlist.component';
import { AdminDashboardComponent } from './admin/admin-dashboard/admin-dashboard.component';
import { ManageUsersComponent } from './admin/manage-users/manage-users.component';
import { ManageProductsComponent} from './admin/manage-products/manage-products.component';
import { OrderComponent } from './order/order.component';
import { FooterComponent } from './footer/footer.component'
import { UpdateproductComponent } from './admin/updateproduct/updateproduct.component';
import { AddproductsComponent } from './admin/addproducts/addproducts.component';

import { NewUserComponent } from './admin/new-user/new-user.component';
import { CouponComponent } from './admin/coupon/coupon.component';
import { UpdateUserComponent } from './admin/update-user/update-user.component';




const appRoutes : Routes=[

  {path:'login',component:LoginComponent},
  {path:'register',component:RegisterComponent},
  {path:'admin/login',component:AdminLoginComponent},
  {path:'admin/register',component:AdminRegisterComponent},

  {path:'',component:DashboardComponent},
  {path:'cart',component:CartComponent},
  {path:'wishlist',component:WishlistComponent},
  {path:'admin-dashboard',component:AdminDashboardComponent},
  {path:'admin-dashboard/mng-users',component:ManageUsersComponent},
  {path:'admin-dashboard/mng-products',component:ManageProductsComponent},
  {path:'cart/order',component:OrderComponent},
  {path:'admin-dashboard/mng-products/addproduct',component:AddproductsComponent},
  { path:"updateproducts/:pid",component:UpdateproductComponent},
  {path:'admin-dashboard/mng-products/newuser',component:NewUserComponent},
  {path:"admin-dashboard/mng-users/updateuser/:id",component:UpdateUserComponent}
 
 
  
]

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent,
    RegisterComponent,
    LoadingSpinnerComponent,
    AdminLoginComponent,
    AdminRegisterComponent,
    CartComponent,
    DashboardComponent,
    FilterPipe,
    SortPipe,
    WishlistComponent,
    AdminDashboardComponent,
    ManageUsersComponent,
    ManageProductsComponent,
    OrderComponent,
    FooterComponent,
    UpdateproductComponent,
    AddproductsComponent,
    NewUserComponent,
    CouponComponent,
    UpdateUserComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(appRoutes),
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatButtonModule,
    MatIconModule,
    MatToolbarModule,
    MatTabsModule,
    MatFormFieldModule
    
  ],
  providers: [UserService],
  bootstrap: [AppComponent],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ]
})
export class AppModule { }
