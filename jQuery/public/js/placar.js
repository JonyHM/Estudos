$("#botao-placar").click(() => {
    mostraPlacar();
    scrollPlacar();
});

function inserePlacar(){
    
    var corpoTabela = $(".placar").find("tbody");
    var usuario = "Jonathas";
    var numPalavras = $("#contador-palavras").text();
    
    var linha = novaLinha(usuario, numPalavras);
    linha.find(".botao-remover").click(removeLinha);
    
    corpoTabela.append(linha);
    
    $(".placar").slideDown(600);
    scrollPlacar();
}

function novaLinha(usuario, numPalavras){
    
    var linha = $("<tr>");
    var colunaUsuario = $("<td>").text(usuario);
    var colunaPalavras = $("<td>").text(numPalavras);
    var colunaRemover = $("<td>");
    
    var link = $("<a>").attr("href", "#").addClass("botao-remover");
    var icone = $("<i>").addClass("small").addClass("material-icons").text("delete");
    
    link.append(icone);
    colunaRemover.append(link);
    
    linha.append(colunaUsuario);
    linha.append(colunaPalavras);
    linha.append(colunaRemover);
    
    return linha;
}

function removeLinha(event){
    
    event.preventDefault();
    let linha = $(this).parent().parent();
    
    linha.fadeOut(() => linha.remove());
}

function mostraPlacar(){
    $(".placar").stop().slideToggle(600);
}

function scrollPlacar(){
    let posicaoPlacar = $(".placar").offset().top;

    $("html").animate({
        scrollTop: `${posicaoPlacar}px`
    }, 1000);
}