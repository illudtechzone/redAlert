import { Component, OnInit, Input } from '@angular/core';
import { ModalController } from '@ionic/angular';
import { Geolocation } from '@ionic-native/geolocation/ngx';

@Component({
  selector: 'app-post-alert-modal',
  templateUrl: './post-alert-modal.component.html',
  styleUrls: ['./post-alert-modal.component.scss'],
})
export class PostAlertModalComponent implements OnInit {

  @Input() alert: String;
  lat: Number;
  lng: Number;
  zoom: Number = 15;
  color: String;
  constructor(private modalController: ModalController, private geolocation: Geolocation) { }

  ngOnInit() {
    this.color = (this.alert === 'Red') ? 'danger' : 'warning';
    this.getLocation();
  }

  getLocation() {
    this.geolocation.getCurrentPosition().then((response) => {
      this.lat = response.coords.latitude;
      this.lng = response.coords.longitude;
    }).catch((error) => {
      console.log('Error getting location');
    });
  }

  closeModal() {
    this.modalController.dismiss();
  }

}
