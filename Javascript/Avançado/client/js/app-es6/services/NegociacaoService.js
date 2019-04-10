import {HttpService} from './HttpService';
import {Negociacao} from '../models/Negociacao';
import {ConnectionFactory} from './ConnectionFactory';
import {NegociacaoDao} from '../daos/NegociacaoDao';

export class NegociacaoService{

    constructor(){
        this._http = new HttpService();
    }

    obterNecociacoesDaSemana(){

        return this._http
            .get('negociacoes/semana')
            .then(negociacoes => {
                console.log(negociacoes);
                return negociacoes.map(obj => new Negociacao(new Date(obj.data),obj.quantidade, obj.valor));
            })
            .catch(erro => {
                console.log(erro);
                throw new Error('Não foi possível obter as negociações da semana!');
            });
    }
    
    obterNecociacoesDaSemanaPassada(){
        
        return this._http
            .get('negociacoes/anterior')
            .then(negociacoes => {
                console.log(negociacoes);
                return negociacoes.map(obj => new Negociacao(new Date(obj.data),obj.quantidade, obj.valor));
            })
            .catch(erro => {
                console.log(erro);
                throw new Error('Não foi possível obter as negociações da semana passada!');
            });
    }
    
    obterNecociacoesDaSemanaRetrasada(cb){

        return this._http
            .get('negociacoes/retrasada')
            .then(negociacoes => {
                console.log(negociacoes);
                return negociacoes.map(obj => new Negociacao(new Date(obj.data),obj.quantidade, obj.valor));
            })
            .catch(erro => {
                console.log(erro);
                throw new Error('Não foi possível obter as negociações da semana retrasada!');
            });
    }
    
    obterNegociacoes(){
        return Promise.all([
            this.obterNecociacoesDaSemana(), 
            this.obterNecociacoesDaSemanaPassada(), 
            this.obterNecociacoesDaSemanaRetrasada()
        ]).then(periodos => {
            let negociacoes = periodos
            .reduce((flatArray, array) => flatArray.concat(array), []);

            return negociacoes;
        }).catch(erro => {
            throw new Error(erro)
        });
    }

    cadastra(negociacao){

        return ConnectionFactory
            .getConnection()
            .then(conexao => new NegociacaoDao(conexao))
            .then(dao => dao.adiciona(negociacao))
            .then(() => 'Negociação cadastrada com sucesso!')        
            .catch(erro => {
                console.log(erro);
                throw new Error('Não foi possível cadastrar estra negociação!');
            });
    }

    lista(){

        return ConnectionFactory
            .getConnection()
            .then(connection => new NegociacaoDao(connection))
            .then(dao => dao.listaTodos())
            .catch(erro => {
                console.log(erro);
                throw new Error('Não foi possível obter as negociações');
            });
    }

    apaga(){

        return ConnectionFactory
            .getConnection()
            .then(conexao => new NegociacaoDao(conexao))
            .then(dao => dao.apagaTodos())
            .then(() => 'Negociações apagadas com sucesso!')
            .catch(erro => {
                console.log(erro);
                throw new Error('Não foi possível apagar as negociações!')
            });
    }

    importa(listaAtual){

        return this.obterNegociacoes()
            .then(negociacoes => 
                negociacoes.filter(negociacao => 
                    !listaAtual.some(negociacaoExistente =>
                            negociacao.equals(negociacaoExistente)))
            ).catch(erro =>{
                console.log(erro);
                throw new Error('Não foi possível importar as negociações!');
            });
    }
}