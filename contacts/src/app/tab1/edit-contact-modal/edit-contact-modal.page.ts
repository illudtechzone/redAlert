import { ModalController } from '@ionic/angular';
import { Component } from '@angular/core';

@Component({
  selector: 'app-edit-contact-modal',
  templateUrl: './edit-contact-modal.page.html',
  styleUrls: ['./edit-contact-modal.page.scss'],
})
export class EditContactModalPage {

  constructor(private modalController: ModalController) { }

  closeModal() {
    this.modalController.dismiss();
  }
}
