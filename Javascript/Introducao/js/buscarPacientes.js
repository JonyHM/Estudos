var botaoAdicioar = document.querySelector("#buscar-paciente");

botaoAdicioar.addEventListener("click", function() {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "https://api-pacientes.herokuapp.com/pacientes1");

    var erroAjax = document.querySelector("#erro-ajax");

    xhr.addEventListener("load", function(){
        erroAjax.classList.add("invisivel");
        if(this.status == 200){
            var response = xhr.responseText;
            var pacientes = JSON.parse(response);
    
            pacientes.forEach(function(paciente){
                adicionaNaTabela(paciente);
            });
        }else{
            erroAjax.classList.remove("invisivel");

        }
    });

    xhr.send();
});