import { AuthGuardService } from './security/auth-guard.service';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { OAuthModule } from 'angular-oauth2-oidc';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'home',
    loadChildren: './home/home.module#HomePageModule',
    canActivate: [AuthGuardService]
  },
  {
    path: 'history',
    loadChildren: './history/history.module#HistoryPageModule',
    canActivate: [AuthGuardService]
  },
  {
    path: 'news',
    loadChildren: './news/news.module#NewsPageModule',
    canActivate: [AuthGuardService]
  },
  {
    path: 'friends',
    loadChildren: './friends/friends.module#FriendsPageModule',
    canActivate: [AuthGuardService]
  },
  {
    path: 'post',
    loadChildren: './post/post.module#PostPageModule',
    canActivate: [AuthGuardService]
  },
  {
    path: 'landing',
    loadChildren: './landing/landing.module#LandingPageModule',
  },
  {
    path: 'login',
    loadChildren: './login/login.module#LoginPageModule'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes), OAuthModule.forRoot()],
  exports: [RouterModule]
})
export class AppRoutingModule {}
