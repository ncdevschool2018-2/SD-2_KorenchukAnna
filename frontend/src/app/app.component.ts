import { Component } from '@angular/core';
import {AccountService} from "./service/account.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [AccountService]
})
export class AppComponent {
  title = 'frontend';


}
