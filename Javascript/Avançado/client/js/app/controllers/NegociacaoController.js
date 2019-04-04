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
            'adiciona', 'esvazia'
        );
        
        this._mensagem = new Bind(
            new Mensagem(), 
            new MensagemView($('#mensagemView')),
            'texto'
        );
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
        service.obterNecociacoesDaSemana((erro, negociacoes) => {
            if(erro){
                this._mensagem.texto = erro;
                return;
            }
            
            negociacoes.forEach(negociacao => this._listaNegociacoes.adiciona(negociacao));
            this._mensagem.texto = 'Nregociações imporetadas com sucesso';
        });
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
}