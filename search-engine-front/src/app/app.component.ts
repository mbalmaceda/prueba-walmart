import { Component } from '@angular/core';
import {FormControl, Validators} from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'search-engine-front';
  delayTime = 500;
  searches: string[] = [];

  emailFormControl = new FormControl('', [
    Validators.required
  ]);
  
  search($event: Event) {
    console.log($event);

    this.searches.push(
      /**
       * You need to explicitly tell TypeScript the type of the HTMLElement which is your target.
       * @see https://stackoverflow.com/a/42066698/6924437
       */
      ($event.target as HTMLInputElement).value
    );

  }
}
