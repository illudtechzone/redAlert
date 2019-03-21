import { OAuthService } from 'angular-oauth2-oidc';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.page.html',
  styleUrls: ['./navbar.page.scss'],
})
export class NavbarPage implements OnInit {

  constructor(private oauthService: OAuthService) { }

  ngOnInit() {
  }

  logout() {
    this.oauthService.logOut();
  }
}
