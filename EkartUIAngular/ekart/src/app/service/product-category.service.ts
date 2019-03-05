import { Injectable, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Product } from '../domain/product';
import { Category } from '../domain/category';

@Injectable({
  providedIn: 'root'
})
export class ProductCategoryService {
  
  url:string = "http://localhost:8080/api/categories"

  constructor(
    private http:HttpClient
  ) { }

  getCategoryById(id:Number):Observable<Category> {

    return this.http.get<Category>(this.url + "/" + id);

  }
}
