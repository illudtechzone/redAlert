import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-friends',
  templateUrl: './friends.page.html',
  styleUrls: ['./friends.page.scss'],
})
export class FriendsPage implements OnInit {
  public friends = [
    { username: 'Jane Marie' },
    { username: 'Jim Beglin' },
    { username: 'Trevor Philip' },
    { username: 'Ayushman Varma' }
  ];

  public others = [
    { username: 'Logan Ward' },
    { username: 'Walter White' },
    { username: 'Alexa Hoffman' },
    { username: 'Melissa Carpenter' }
  ];
  constructor() { }

  ngOnInit() {
  }

}
