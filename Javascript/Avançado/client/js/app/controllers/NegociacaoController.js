class NegociacaoController{
    constructor() {
        let $ = document.querySelector.bind(document);
        this._inputData = $('#data');
        this._inputQuantidade = $('#quantidade');
        this._inputValor = $('#valor');
        this._form = $('.form');
        this._listaNegociacoes = new ListaNegociacoes();
    }

    adiciona(event){
        
        event.preventDefault();
        
        this._listaNegociacoes.adiciona(this._criaNegociacao());
        this._limpa();
        
        console.log(this._listaNegociacoes.negociacoes);
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