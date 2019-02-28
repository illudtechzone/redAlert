import { EditContactModalPage } from './edit-contact-modal/edit-contact-modal.page';
import { Component } from '@angular/core';
import { ModalController, AlertController } from '@ionic/angular';

@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss']
})
export class Tab1Page {
  constructor(private modalController: ModalController, private alertController: AlertController) {}

  async openModal() {
    const modal = await this.modalController.create({
      component: EditContactModalPage,
      backdropDismiss: true,
      showBackdrop: true
    });
    return await modal.present();
  }

  async alertDelete() {
    const alert = await this.alertController.create({
      header: 'Are you sure?',
      message: 'This contact will  be deleted!, <strong>Continue?</strong>',
      buttons: [
        {
          text: 'Cancel',
          role: 'cancel',
          cssClass: 'secondary',
          handler: (blah) => {
            console.log('Confirm Cancel: blah');
          }
        }, {
          text: 'Okay',
          handler: () => {
            console.log('Confirm Okay');
          }
        }
      ],
      translucent: true
    });

    await alert.present();
  }
}
