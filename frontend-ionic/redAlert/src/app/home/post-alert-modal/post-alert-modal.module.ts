import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';

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
    RouterModule.forChild(routes)
  ],
  declarations: [PostAlertModalPage]
})
export class PostAlertModalPageModule {}
