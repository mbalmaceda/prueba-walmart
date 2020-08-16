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
  search: any = { search : ''};

  searchFormControl = new FormControl('', [
    Validators.required,
    Validators.minLength(3)
  ]);
  
  searchEngine($event: Event) {
    this.search = { search : ($event.target as HTMLInputElement).value};
  }
}
