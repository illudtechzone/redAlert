import { BrowserModule} from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductListComponent } from './component/product-list/product-list.component';
import { CategoryListComponent } from './component/category-list/category-list.component';
import { HttpClient, HttpClientModule, HttpClientXsrfModule } from '@angular/common/http';
import { NgxLoadingModule } from 'ngx-loading';
import { ProductDetailComponent } from './component/product-detail/product-detail.component';
import { CustomerComponent } from './component/customer/customer.component';
import { FormsModule } from '@angular/forms';
import { XSRF_HEADER_NAME } from '@angular/common/http/src/xsrf';


@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    CategoryListComponent,
    ProductDetailComponent,
    CustomerComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    NgxLoadingModule,
    FormsModule,
    HttpClientXsrfModule.withOptions({
      cookieName:'XSRF-TOKEN',
      headerName:'X-XSRF-TOKEN'
    })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { 
}
