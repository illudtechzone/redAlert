import { CurrentUserService } from './../../security/current-user.service';
import { element } from 'protractor';
import { UserOptionsPopoverComponent } from './../../components/user-options-popover/user-options-popover.component';
import { OAuthService } from 'angular-oauth2-oidc';
import { Component, OnInit } from '@angular/core';
import { PopoverController, AngularDelegate } from '@ionic/angular';
import { userInfo } from 'os';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.page.html',
  styleUrls: ['./navbar.page.scss'],
})
export class NavbarPage implements OnInit {

  user: any;
  profileName: String;
  constructor(private popoverController: PopoverController, private currentUser: CurrentUserService) { }

  async ngOnInit() {
    await this.currentUser.getCurrentUser(false).then( (user) => {
      this.user = user;
      this.profileName = this.user.given_name + ' ' + this.user.family_name;
    });
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
