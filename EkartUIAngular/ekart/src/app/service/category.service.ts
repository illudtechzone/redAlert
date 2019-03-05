import { Injectable, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Category } from '../domain/category';


@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  url:string = "http://localhost:8080/api/categories/name"

  constructor(
    private http:HttpClient
  ) { }

  getCategory():Observable<Category[]> {

      return this.http.get<Category[]>(this.url);
  }
}
