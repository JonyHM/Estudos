var btnAdicionar = document.querySelector("#adicionar-paciente");

btnAdicionar.addEventListener("click", function(event){    
    event.preventDefault(); // Previne o funcionamento padrão do botão    
    var form = document.querySelector("#form-adiciona");

    var paciente = pegaDadosDoForm(form);
    var trPaciente = montaTr(paciente);

    var erros = validaDados(paciente);
    
    if(erros.length > 0){
        exibeErros(erros);
        return;
    }

    var tabela = document.querySelector("#tabela-pacientes");
    tabela.appendChild(trPaciente);
    form.reset();    

    var ul = document.querySelector("#erros");
    ul.innerHTML = "";
});

function pegaDadosDoForm(form){
    var paciente = {
        nome: form.nome.value,
        peso: form.peso.value,
        altura: form.altura.value,
        gordura: form.gordura.value,
        imc: calculaIMC(form.peso.value, form.altura.value)
    }

    return paciente;
}

function montaTr(paciente){    
    var trPaciente = document.createElement("tr");
    trPaciente.classList.add("paciente");
    
    var tdNome = montaTd(paciente.nome, "info-nome");    
    var tdPeso = montaTd(paciente.peso, "info-peso");
    var tdAltura = montaTd(paciente.altura, "info-altura");    
    var tdGordura = montaTd(paciente.gordura, "info-gordura");    
    var tdImc = montaTd(paciente.imc, "info-imc");

    trPaciente.appendChild(tdNome);
    trPaciente.appendChild(tdPeso);
    trPaciente.appendChild(tdAltura);
    trPaciente.appendChild(tdGordura);
    trPaciente.appendChild(tdImc);

    return trPaciente;
}

function montaTd(dado, classe){
    var td = document.createElement("td");
    td.textContent = dado;
    td.classList.add(classe);

    return td;
}

function validaDados(paciente){
    var erros = [];

    if(!validaPeso(paciente.peso)) erros.push("O peso inserido é inválido");
    if(!validaAltura(paciente.altura)) erros.push("A altura inserida é inválida");
    if(paciente.nome.length == 0) erros.push("O nome não deve ser vazio!");
    if(paciente.gordura.length == 0) erros.push("A gordura não deve ser vazia!");

    return erros;
}

function exibeErros(erros){
    var ul = document.querySelector("#erros");
    ul.innerHTML = "";

    erros.forEach(function(erro){
        var li = document.createElement("li");
        li.textContent = erro;
        ul.appendChild(li);
    });
}