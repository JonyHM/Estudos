import { BicicletasService } from './../../service/bicicletas.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  public bikes;

  constructor(private bicicletasService: BicicletasService) { }

  ngOnInit() {
    this.getBicicletas();
  }

  getBicicletas() {
    return this.bicicletasService
      .bicicletas
      .subscribe(
        dados => {
          this.bikes = dados;
        },
        err => console.log(err),
        () => console.log('Bicicletas carregadas')
      );
  }
}
