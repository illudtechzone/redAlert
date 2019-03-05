import { Component, OnInit , Output , EventEmitter, Input} from '@angular/core';
import { CategoryService } from 'src/app/service/category.service';
import { Category } from 'src/app/domain/category';
import { Product } from 'src/app/domain/product';
import { ProductCategoryService } from 'src/app/service/product-category.service';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent implements OnInit {

  category: Category[];
  products:Product[];
  @Output() valueUpdate = new EventEmitter();  

  constructor(
    private categoryService:CategoryService,
    private productCategoryService:ProductCategoryService,
    private productService:ProductService
  ) { }

  ngOnInit() {
    this.getCategory();
  }

  getCategory():void {

    this.categoryService.getCategory()
    .subscribe(category=>this.category = category);
  }

  updateProducts(id:Number) {
    if(id == 0) {

      this.productService.getProducts()
        .subscribe(products=>{
        this.products = products;
        this.valueUpdate.emit(this.products)
      });
       
    } else {

      this.productCategoryService.getCategoryById(id)
      .subscribe(category=>{
        this.products = category.products;
        this.valueUpdate.emit(this.products)
  
      })
  
    }
  }



}
