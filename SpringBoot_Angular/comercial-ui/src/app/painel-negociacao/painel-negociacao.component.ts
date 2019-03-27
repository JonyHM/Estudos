import { Component, OnInit } from '@angular/core';
import { OportunidadeService } from '../oportunidade.service';

import { MessageService } from 'primeng/api';

@Component({
  selector: 'app-painel-negociacao',
  templateUrl: './painel-negociacao.component.html',
  styleUrls: ['./painel-negociacao.component.css']
})
export class PainelNegociacaoComponent implements OnInit {

  oportunidade = {};
  oportunidades = [];
  selec = {};

  constructor(
    private oportunidadeService: OportunidadeService,
    private messageService: MessageService
  ) { }

  ngOnInit() {
    this.consultar();
  }

  consultar(){
    this.oportunidadeService.listar()
      .subscribe(resposta => this.oportunidades = <any> resposta);
  }

  adicionar(){
    this.oportunidadeService.adicionar(this.oportunidade)
      .subscribe(() => {
        this.oportunidade = {};
        this.consultar();

        this.messageService.add({
          severity: 'success',
          summary: 'Oportunidade adicionada com sucesso'
        });
    },    
    resposta =>{
      let msg = 'Ocorreu um erro inesperado! Tente novamente';

      if(resposta.error.message){
        msg = resposta.error.message
      }

      this.messageService.add({
        severity: 'error',
        summary: msg
      });
    });
  }

  //Id continua sendo cotado... precisa zerar qnd zera td
  remover(id: any){        
    this.oportunidadeService.remover(id).subscribe(() => {
      this.consultar();

      this.messageService.add({
        severity: 'success',
        summary: 'Oportunidade excluída com sucesso'
      });
    });    
  }

  //precisa de um popup ou algo assim.... com o form atual não da ainda
  atualizar(id: any){
    this.oportunidadeService.selecionar(id).subscribe(
      resposta => {
        this.selec = <any> resposta
        this.oportunidadeService.atualizar(this.selec)

        this.messageService.add({
          severity: 'success',
          summary: 'Oportunidade adicionada com sucesso'
        });

        this.selec = {};
      })
  }
}
