class NegociacaoService{

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
}