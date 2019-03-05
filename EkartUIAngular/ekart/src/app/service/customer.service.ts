import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Customer } from '../domain/customer';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  url:string = "http://localhost:8080/api/customers";

  constructor(
    private httpClient:HttpClient
  ) { 
  }

  createCustomer(customer:Customer):Observable<Customer> {

    let header = new Headers({'Content-Type':'application/json'});
    let options = new HttpHeaders().append("XSRF-TOKEN" , "")
    return this.httpClient.post<Customer>(this.url,customer , {headers:options})
  }
}
