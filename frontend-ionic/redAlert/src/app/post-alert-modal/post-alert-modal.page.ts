import { Component, OnInit, Input } from '@angular/core';
import { ModalController } from '@ionic/angular';


@Component({
  selector: 'app-post-alert-modal',
  templateUrl: './post-alert-modal.page.html',
  styleUrls: ['./post-alert-modal.page.scss'],
})
export class PostAlertModalPage implements OnInit{
  @Input() alert: String;
  color: String;
  constructor(private modalController: ModalController) { }

  ngOnInit() {
    this.color = (this.alert === 'Red') ? 'danger' : 'warning';
  }

  closeModal() {
    this.modalController.dismiss();
  }
}
