import { Component, OnInit, Input, Output , EventEmitter } from '@angular/core';
import { Product } from 'src/app/domain/product';
import { ProductService } from 'src/app/service/product.service';
import {
  trigger,
  state,
  style,
  animate,
  transition
} from '@angular/animations';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css'] ,
  animations: [
    trigger("openClose" , [

        state("open" , style(
          {
            opacity:1
          }   
        )),
        state("close" , style(
          {
            opacity:0
          }
        )),
        transition('close => open', [animate('0.5s')])
    ])
  ]

})
export class ProductDetailComponent implements OnInit {

  @Input() product:Product;

  @Input() isHidden:boolean;

  @Output() eventEmitter:EventEmitter<boolean> = new EventEmitter();

  constructor(
  ) { }

  ngOnInit() {}

  sendCloseEvent() {
    this.eventEmitter.emit(this.isHidden)
  }
}
