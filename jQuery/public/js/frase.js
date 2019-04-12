$("#botao-frase").click(fraseAleatoria);

function fraseAleatoria(){

    $("#spinner").show();

    $.get("http://localhost:3000/frases", resposta => {        
        let random = Math.floor(Math.random() * resposta.length);
        $(".frase").text(resposta[random].texto); 

        atualizaTamFrase();
        $("#tempo").text(resposta[random].tempo);
    })
    .fail(() => {
        $("#erro").toggle();
        setTimeout(() => $("#erro").toggle(), 2000);
    })
    .always(() => $("#spinner").toggle());
}

$("#botao-frase-id").click(buscaFrase);

function buscaFrase(){

    $("#spinner").show();    
    let fraseId = $("#frase-id").val();
    let dados = {
        id: fraseId
    };

    $.get("http://localhost:3000/frases", dados, resp => {
        $(".frase").text(resp.texto);
        atualizaTamFrase();
        $("#tempo").text(resp.tempo);
    })
    .fail(() => {
        $("#erro").toggle();
        setTimeout(() => $("#erro").toggle(), 2000);
    })
    .always(() => $("#spinner").toggle());
}