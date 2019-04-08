class NegociacaoController{

    constructor() {
        let $ = document.querySelector.bind(document);

        this._inputData = $('#data');
        this._inputQuantidade = $('#quantidade');
        this._inputValor = $('#valor');
        this._form = $('.form');
        
        this._listaNegociacoes = new Bind(
            new ListaNegociacoes(), 
            new NegociacoesView($('#negociacoesView')), 
            'adiciona', 'esvazia', 'ordena'
        );
        
        this._mensagem = new Bind(
            new Mensagem(), 
            new MensagemView($('#mensagemView')),
            'texto'
        );

        this._ordemAtual = '';
    }

    adiciona(event){    
        event.preventDefault();   
        this._listaNegociacoes.adiciona(this._criaNegociacao());        
        this._mensagem.texto = 'Negociação adicionada com sucesso!';        
        this._limpa();
    }
    
    apaga(){
        this._listaNegociacoes.esvazia();
        this._mensagem.texto = 'Negociações excluídas com sucesso!';
    }

    importaNegociacoes(){

        let service = new NegociacaoService();
        service.obterNegociacoes()
            .then(negociacoes => {
                negociacoes
                .forEach(negociacao => this._listaNegociacoes.adiciona(negociacao));
                this._mensagem.texto = 'Negociações importadas com sucesso';
            })
            .catch(erro => this._mensagem.texto = erro);
    }

    _limpa(){
        this._form.reset();
        this._inputData.focus();
    }

    _criaNegociacao(negociacao){
        return new Negociacao(
            DateHelper.textToDate(this._inputData.value),            
            this._inputQuantidade.value,
            this._inputValor.value
        );
    }

    ordena(coluna){

        if(this._ordemAtual == coluna){
            this._listaNegociacoes.ordena((a,b) => b[coluna] - a [coluna]);
        }else{
            this._listaNegociacoes.ordena((a,b) => a[coluna] - b [coluna]);
        }

        this._ordemAtual = coluna;
    }
}