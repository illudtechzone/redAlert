import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';
import { AgmCoreModule } from '@agm/core';

import { IonicModule } from '@ionic/angular';

import { PostAlertModalPage } from './post-alert-modal.page';

const routes: Routes = [
  {
    path: '/postAlert',
    component: PostAlertModalPage
  }
];

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    RouterModule.forChild(routes),
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyDNvROGIUEfGUi_YHSWWbBVTJpqZuZCjvY'
    })
  ],
  declarations: [PostAlertModalPage],
  exports: [PostAlertModalPage]
})
export class PostAlertModalPageModule {}
