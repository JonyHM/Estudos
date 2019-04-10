export class HttpService{

    _handleErrors(resposta){
        if(!resposta.ok)throw new Error(resposta.statusText);
        return resposta;
    }

    get(url){

        return fetch(url)
            .then(resposta => this._handleErrors(resposta))
            .then(resposta => resposta.json());
    }

    post(url, dado){

        return fetch(url), {
            headers: {"Content-Type" : "application/json"},
            method: 'post',
            body: JSON.stringify(dado)
        }
        .then(resposta => this._handleErrors(resposta))
        
        
        new Promise((resolve, reject) => {

            let xhr = new XMLHttpRequest();
            xhr.open('POST', url, true); 
            xhr.setRequestHeader();
            xhr.onreadystatechange = () => {
                if(xhr.readyState == 4){
                    if(xhr.status == 200){    
                        resolve(JSON.parse(xhr.responseText));    
                    }else{
                        console.log(xhr.responseText);
                        reject(xhr.responseText);
                    }
                }
            };
            xhr.send(JSON.stringify(dado));
        });
    }
}