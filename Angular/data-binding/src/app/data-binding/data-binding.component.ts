import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-data-binding',
  templateUrl: './data-binding.component.html',
  styleUrls: ['./data-binding.component.css']
})
export class DataBindingComponent implements OnInit {

  url: string = "alura.com.br/promocao/nerd";
  imagem: string = "http://lorempixel.com/400/200/sports/Dummy-Text/";
  atual: string = "";
  valorSalvo: string = "";

  isMouseOver: boolean = false;

  nome: string = "Seu Nome";
  nomeDoCurso: string = "Angular";

  valorInicial: number = 50;

  clique(){
    alert("Clicou");
  }

  onKeyUp(event: KeyboardEvent){

    this.atual = (<HTMLInputElement>event.target).value;
  }

  salvar(valor){
    this.valorSalvo = valor;
  }
  
  toggleMouse(){
    this.isMouseOver = !this.isMouseOver;
  }

  onMudouValor(evento){
    console.log(evento.mudouValor);
  }

  constructor() { }
  
  ngOnInit() {}

}
