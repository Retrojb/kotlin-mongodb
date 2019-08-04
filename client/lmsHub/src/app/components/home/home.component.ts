import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  popup() {
    const welcomeMessage = "You have made it to the home page"
    const alarm = alert(welcomeMessage);
    console.log(welcomeMessage);
    return alarm;
  }
}
