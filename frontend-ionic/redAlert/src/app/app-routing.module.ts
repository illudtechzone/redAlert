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
    loadChildren: './home/home.module#HomePageModule'
  },
  {
    path: 'history',
    loadChildren: './history/history.module#HistoryPageModule'
  },
  {
    path: 'news',
    loadChildren: './news/news.module#NewsPageModule' 
  },
  {
    path: 'friends',
    loadChildren: './friends/friends.module#FriendsPageModule'
  },
  {
    path: 'post',
    loadChildren: './post/post.module#PostPageModule'
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
