var tempoInicial = $("#tempo").text();
var campo = $(".campo-digitacao");

$(() => {
    atualizaTamFrase();
    contaPalavras();
    inicializaCronometro();
    inicializaMarcadores();
  
    $("#botao-reiniciar").click(reiniciaJogo);

    atualizaPlacar();

    $("#usuarios").selectize({
        create: true,
        sortField: 'text'
    });

    $(".tooltip").tooltipster({
        trigger: "custom"
    });
});

function atualizaTamFrase(){

    var numPalavras = $(".frase").text().split(" ").length;
    var tamanhoFrase = $("#tamanho-frase");
    tamanhoFrase.text(numPalavras);
}

function contaPalavras(){
    
    campo.on("input", () => {
        
        var conteudo = campo.val();
        var qtdPalavras = conteudo.split(/\S+/).length -1;
        $("#contador-palavras").text(qtdPalavras);
    
        var qtdCaracteres = conteudo.length;
        $("#contador-caracteres").text(qtdCaracteres);
    });
}

function inicializaCronometro(){  

    campo.one("focus", () =>{
        
        var tempo = tempoInicial;
        var cronometroId = setInterval(() => {
            tempo --;
            $("#tempo").text(tempo);
            if(tempo < 1){   

                clearInterval(cronometroId);
                finalizaJogo();                
            }
        }, 1000)
    });
}


function inicializaMarcadores(){

    campo.on("input", () => {

        var digitado = campo.val();
        var frase = $(".frase").text();
               
        if(frase.startsWith(digitado)){
            campo.addClass("certo");
            campo.removeClass("errado");
        }else{
            campo.addClass("errado");
            campo.removeClass("certo");
        }
    })
}

function reiniciaJogo(){

    campo.attr("disabled", false);
    campo.val("");
    $("#contador-palavras").text("0");
    $("#contador-caracteres").text("0");
    $("#tempo").text(tempoInicial);
    
    inicializaCronometro();
    campo.removeClass("campo-desativado");
    campo.removeClass("errado");
    campo.removeClass("certo");
    $(".placar").stop().slideUp(600);
}

function finalizaJogo(){

    campo.attr("disabled", true);
    campo.toggleClass("campo-desativado");
    inserePlacar();
}