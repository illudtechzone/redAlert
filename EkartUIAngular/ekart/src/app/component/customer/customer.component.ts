import { Component, OnInit, AfterViewInit, ElementRef, ViewChild } from '@angular/core';
import { Customer } from 'src/app/domain/customer';
import { CustomerService } from 'src/app/service/customer.service';
import * as _ from "lodash";

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit , AfterViewInit {

  customer:Customer = new Customer();

  @ViewChild('signinBtn') signInBtn : ElementRef;
  @ViewChild('signupBtn') signUpBtn : ElementRef;
  @ViewChild('signinTab') signInTab : ElementRef;
  @ViewChild('signupTab') signUpTab : ElementRef;

  signinTabShowValue:boolean = false;
  signupTabShowValue:boolean = false;

  isLogged:boolean = false;

  constructor(
    private customerService:CustomerService
  ) { }

  onSubmit(){  

    let customerRegistered:Customer;
    this.customerService.createCustomer(this.customer)
    .subscribe(customer=>customerRegistered = customer);

    if(_.isEqual(this.customer , customerRegistered)) {
      this.isLogged = true;
    }

    console.log(this.customer)
  }

  ngOnInit() {

  }

  ngAfterViewInit() {

    this.signInBtn.nativeElement.addEventListener('click' , this.showSignInTab.bind(this));
    this.signUpBtn.nativeElement.addEventListener('click' , this.showSignUpTab.bind(this));
  }

  showSignInTab() {
    
    if(this.signupTabShowValue)
    {
      this.signUpTab.nativeElement.style.display = 'none';
      this.signupTabShowValue = !this.signupTabShowValue;
    }

    if(!this.signinTabShowValue) {
      this.signInTab.nativeElement.style.display = 'block';
      this.signinTabShowValue = !this.signinTabShowValue;
    }
    else {
      this.signInTab.nativeElement.style.display = 'none';
      this.signinTabShowValue = !this.signinTabShowValue;
    }
  }

  showSignUpTab() {
    
    if(this.signinTabShowValue)
    {
      this.signInTab.nativeElement.style.display = 'none';
      this.signinTabShowValue = !this.signinTabShowValue;
    }


    if(!this.signupTabShowValue) {
      this.signUpTab.nativeElement.style.display = 'block';
      this.signupTabShowValue = !this.signupTabShowValue;
    }
    else {
      this.signUpTab.nativeElement.style.display = 'none';
      this.signupTabShowValue = !this.signupTabShowValue;
    }
  }

}
