$("#botao-placar").click(() => {
    mostraPlacar();
    scrollPlacar();
});

$("#botao-sync").click(() => {
    mostraPlacar();
    sincronizaPlacar();
});

function inserePlacar(){
    
    var corpoTabela = $(".placar").find("tbody");
    var usuario = $("#usuarios").val();
    var numPalavras = $("#contador-palavras").text();
    
    var linha = novaLinha(usuario, numPalavras);
    linha.find(".botao-remover").click(removeLinha);
    
    corpoTabela.prepend(linha);
    
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

function sincronizaPlacar(){

    var placar = [];
    var linhas = $("tbody>tr");

    linhas.each(function() {
        var usuario = $(this).find("td:nth-child(1)").text();
        var acertos = $(this).find("td:nth-child(2)").text();
        
        var score = {
            usuario: usuario,
            pontos: acertos
        };
    
        placar.push(score);
    })

    dados = {
        placar: placar
    }

    $.post("http://localhost:3000/placar", dados, function() {
        console.log("Dados sincronizados com sucesso!");
        $(".tooltip").tooltipster("open");
    })
    .fail(() => {
        $(".tooltip").tooltipster("open").tooltipster("content", "Não foi possível sincronizar os dados!")
    })
    .always(() => {
        setInterval(() => {
            $(".tooltip").tooltipster("close");
        }, 1200);
    });
}

function atualizaPlacar(){

    $.get("http://localhost:3000/placar",data => {
        $(data).each(function(){
            var linha = novaLinha(this.usuario, this.pontos);

            linha.find(".botao-remover").click(removeLinha);

            $("tbody").append(linha);
        });
    });
}