import { PostAlertModalPageModule } from './post-alert-modal/post-alert-modal.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { IonicModule } from '@ionic/angular';
import { RouterModule } from '@angular/router';

import { HomePage } from './home.page';
import { NavbarPageModule } from '../navbar/navbar.module';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    PostAlertModalPageModule,
    NavbarPageModule,
    RouterModule.forChild([
      {
        path: '',
        component: HomePage
      }
    ])
  ],
  declarations: [HomePage]
})
export class HomePageModule {}
