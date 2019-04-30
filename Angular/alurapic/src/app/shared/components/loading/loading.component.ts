import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';

import { LoadingService } from './loading.service';

@Component({
  selector: 'ap-loading',
  templateUrl: './loading.component.html',
  styleUrls: ['loading.component.css']
})
export class LoadingComponent implements OnInit{

  loading$: Observable<string>;

  constructor(private loadingService: LoadingService) {

  }
  ngOnInit(): void {
    this.loading$ = this.loadingService
      .loading
      .pipe(map(type => type.valueOf()))

  }
}
