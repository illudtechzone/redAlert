import { AppAuthGuard } from './app-auth-guard';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'landing',
    pathMatch: 'full'
  },
  {
    path: 'home',
    loadChildren: './home/home.module#HomePageModule',
    canActivate: [AppAuthGuard]
  },
  {
    path: 'history',
    loadChildren: './history/history.module#HistoryPageModule',
    canActivate: [AppAuthGuard]
  },
  {
    path: 'news',
    loadChildren: './news/news.module#NewsPageModule',
    canActivate: [AppAuthGuard]
  },
  {
    path: 'friends',
    loadChildren: './friends/friends.module#FriendsPageModule',
    canActivate: [AppAuthGuard]
  },
  {
    path: 'post',
    loadChildren: './post/post.module#PostPageModule',
    canActivate: [AppAuthGuard]
  },
  {
    path: 'landing',
    loadChildren: './landing/landing.module#LandingPageModule'
  }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
