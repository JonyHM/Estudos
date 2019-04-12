$("#botao-frase").click(fraseAleatoria);

function fraseAleatoria(){
    $.get("http://localhost:3000/frases", resposta => {
        
        let random = Math.floor(Math.random() * resposta.length);
        $(".frase").text(resposta[random].texto);
        
        atualizaTamFrase();
        $("#tempo").text(resposta[random].tempo);
    });
}