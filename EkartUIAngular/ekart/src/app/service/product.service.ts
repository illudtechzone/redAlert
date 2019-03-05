import { Injectable, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Product } from '../domain/product';


@Injectable({
  providedIn: 'root'
})
export class ProductService {

  url:string = "http://localhost:8080/api/products";
  
  constructor(
    private http:HttpClient
  ) { }

  getProducts():Observable<Product[]> {

    return this.http.get<Product[]>(this.url)
  }

  getProductById(id:Number):Observable<Product> {

    return this.http.get<Product>(this.url + "/" + id);

  }
}
