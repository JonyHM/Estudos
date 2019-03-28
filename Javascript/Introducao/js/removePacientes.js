var tabela = document.querySelector("#tabela-pacientes");

tabela.addEventListener("dblclick", function(event){
    var alvo = event.target;
    var pai = alvo.parentNode;

    pai.classList.add("fadeOut");
    setTimeout(function(){
        pai.remove();
    }, 500);
});