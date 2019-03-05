import { Component, OnInit, Input, AfterViewInit, ViewChild } from '@angular/core';
import { ProductService } from 'src/app/service/product.service';
import { ProductCategoryService } from 'src/app/service/product-category.service';
import { Product } from 'src/app/domain/product';
import { Category } from 'src/app/domain/category';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit{

  products:Product[];

  product:Product;
  
  @Input() isHiddenProductDetail:boolean = true;

  id:Number = 1;

  constructor(
    private productService:ProductService,
    private productCategoryService:ProductCategoryService
  ) { }

  ngOnInit() {
    this.getAllProducts();
  }

  getAllProducts() {
    this.productService.getProducts()
    .subscribe(products=>this.products = products);
  }

  getProductById() {
    this.productService.getProductById(this.id)
    .subscribe(product=>this.product=product);
  }

  getUpdatedProduct(id:Number) {
    this.id = id;
    this.isHiddenProductDetail = !this.isHiddenProductDetail;
    console.log(this.isHiddenProductDetail)
    this.getProductById();
  }

  getUpdatedProducts($event) {
    this.products = $event;
  }

  recieveProductDetailClose($event) {

    this.isHiddenProductDetail = !$event;
  }
}
