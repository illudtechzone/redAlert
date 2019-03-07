import { ModalController } from '@ionic/angular';
import { Component } from '@angular/core';
import { PostAlertModalPage } from '../post-alert-modal/post-alert-modal.page';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  constructor(private modalController: ModalController) {}

  async openModal(alert: String) {
    const modal = await this.modalController.create({
      component: PostAlertModalPage,
      componentProps: {alert: alert},
      backdropDismiss: true,
      showBackdrop: true
    });
    return await modal.present();
  }
}
