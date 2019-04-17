import { NegociacaoService } from './../services/index';
import { NegociacoesView, MensagemView } from '../views/index';
import { Negociacoes, Negociacao} from '../models/index';
import { domInject, throttle } from '../helpers/decorators/index'
import { imprime } from '../helpers/index'

export class NegociacaoController {

    @domInject('#data')
    private _inputData: JQuery;
    
    @domInject('#quantidade')
    private _inputQuantidade: JQuery;

    @domInject('#valor')
    private _inputValor: JQuery;

    private _negociacoes = new Negociacoes();
    private _negociacoesView = new NegociacoesView('#negociacoesView');
    private _mensagemView = new MensagemView('#mensagemView');
    private _service = new NegociacaoService();

    constructor() {
        this._negociacoesView.update(this._negociacoes);
    }

    @throttle()
    adiciona() {

        let dia = new Date(this._inputData.val().replace(/-/g, ','));

        if(!this._ehDiaUtil(dia)) {
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

        imprime(negociacao, this._negociacoes);
        
        this._negociacoesView.update(this._negociacoes);
        this._mensagemView.update('Negociação adicionada com sucesso!');
    }

    private _ehDiaUtil(dia: Date) {

        return dia.getDay() != DiaDaSemana.Domingo && dia.getDay() != DiaDaSemana.Sabado;
    }

    @throttle()
    async importaDados() {

        try{

            const negociacoesParaImportar = await this._service
                .obterNegociacoes(res => {
                    if(res.ok){
                        return res;
                    } else {
                        throw new Error(res.statusText);
                    }
                })
    
    
                const negociacoesJaImportadas = this._negociacoes.paraArray();
    
                negociacoesParaImportar
                    .filter(negociacao => 
                        !negociacoesJaImportadas.some(jaImportada => 
                            negociacao.ehIgual(jaImportada)))
                .forEach(negociacao =>
                    this._negociacoes.adiciona(negociacao))
                
                    this._negociacoesView.update(this._negociacoes);
        } catch(error){
            this._mensagemView.update(error);
        }
    }
}

enum DiaDaSemana {
    Domingo,
    Segunda,
    Terca,
    Quarta,
    Quinta, 
    Sexta, 
    Sabado
}