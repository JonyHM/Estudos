import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import { BicicletasService } from './../../service/bicicletas.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  modelos: string[] = [
    'Globo MTB 29 Full Suspension',
    'Globo Carbon Fiber Race Series',
    'Globo Time Trial Blade'
  ];

  formulario: FormGroup;
  mensagemValida: string = '';
  erro: boolean;

  constructor(private bicicletasService: BicicletasService) { }

  ngOnInit() {
    this.formulario = new FormGroup({
      nome: new FormControl('', Validators.required),
      email: new FormControl('', Validators.required),
      telefone: new FormControl('', Validators.required),
      modelo: new FormControl('', Validators.required),
      numeroSerial: new FormControl('', Validators.required),
      valorCompra: new FormControl('', Validators.required),
      dataCompra: new FormControl('', Validators.required),
      contato: new FormControl()
    });
  }

  registrarBicicleta() {

    this.bicicletasService.criarRegistroDeBicicletas(this.formulario.value)
    .subscribe(
      dados => {
        this.mensagemValida = 'Registro enviado com sucesso. Obrigado!';
        this.formulario.reset();
        this.erro = false;
        return true;
      },
      err => {
        this.erro = true;
        console.log(err);
        this.mensagemValida = 'Ocorreu um erro Inesperado!\nPor favor, tente novamente';
      }
    );
  }
}
