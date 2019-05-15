import { BicicletasService } from './../../service/bicicletas.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-view-registration',
  templateUrl: './view-registration.component.html',
  styleUrls: ['./view-registration.component.css']
})
export class ViewRegistrationComponent implements OnInit {

  public regBicicleta;

  constructor(
    private bicicletasService: BicicletasService,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    this.getRegBicicleta(this.route.snapshot.params.id);
  }

  getRegBicicleta(id: number) {
    this.bicicletasService.getBicicleta(id).subscribe(
      dados => this.regBicicleta = dados,
      erro => console.error(erro),
      () => console.log('Bicicletas carregadas com sucesso!')
    );
  }
}
