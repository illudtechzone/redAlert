import { element } from 'protractor';
import { UserOptionsPopoverComponent } from './../../components/user-options-popover/user-options-popover.component';
import { OAuthService } from 'angular-oauth2-oidc';
import { Component, OnInit } from '@angular/core';
import { PopoverController, AngularDelegate } from '@ionic/angular';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.page.html',
  styleUrls: ['./navbar.page.scss'],
})
export class NavbarPage implements OnInit {

  constructor(private popoverController: PopoverController) { }

  ngOnInit() {
  }

  async presentPopover(ev: any) {
    const popover = await this.popoverController.create({
      component: UserOptionsPopoverComponent,
      event: ev,
      translucent: true,
      backdropDismiss: true
    });
    return await popover.present();
  }

}
