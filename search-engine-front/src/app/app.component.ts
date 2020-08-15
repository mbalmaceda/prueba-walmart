import { Component } from '@angular/core';
import {FormControl, Validators} from '@angular/forms';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'search-engine-front';
  delayTime = 500;
  searches: string[] = [];
  
  search: any = { search : ''};

  searchFormControl = new FormControl('', [
    Validators.required
  ]);
  
  searchEngine($event: Event) {
    console.log(($event.target as HTMLInputElement).value);
    this.search = { search : ($event.target as HTMLInputElement).value};
  }
}
