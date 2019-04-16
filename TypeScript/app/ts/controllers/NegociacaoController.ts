import { NegociacoesView, MensagemView } from '../views/index';
import { Negociacoes, Negociacao} from '../models/index';

export class NegociacaoController{

    private _inputData: JQuery;
    private _inputQuantidade: JQuery;
    private _inputValor: JQuery;
    private _negociacoes = new Negociacoes();
    private _negociacoesView = new NegociacoesView('#negociacoesView');
    private _mensagemView = new MensagemView('#mensagemView');

    constructor() {
        
        this._inputData = $('#data');
        this._inputQuantidade = $('#quantidade');
        this._inputValor = $('#valor');
        this._negociacoesView.update(this._negociacoes);
    }

    adiciona(event: Event){

        event.preventDefault();

        let dia = new Date(this._inputData.val().replace(/-/g, ','));

        if(!this._ehDiaUtil(dia)){
            this._mensagemView.update('Não é possível realizar uma Negociação em Fim de Semana!\t'
            + 'Por favor, tente novamente em um dia útil');
            return;
        }

        const negociacao = new Negociacao(
            dia,
            parseInt(this._inputQuantidade.val()),
            parseFloat(this._inputValor.val())
        )

        this._negociacoes.adiciona(negociacao);

        this._negociacoesView.update(this._negociacoes);

        this._mensagemView.update('Negociação adicionada com sucesso!');
    }

    private _ehDiaUtil(dia: Date){

        return dia.getDay() != DiaDaSemana.Domingo && dia.getDay() != DiaDaSemana.Sabado;
    }
}

enum DiaDaSemana{
    Domingo,
    Segunda,
    Terca,
    Quarta,
    Quinta, 
    Sexta, 
    Sabado
}