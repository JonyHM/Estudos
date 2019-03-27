
var pacientes = document.querySelectorAll(".paciente");

for (let i = 0; i < pacientes.length; i++) {       

    var dados = {
        peso: pacientes[i].querySelector(".info-peso").textContent,
        altura: pacientes[i].querySelector(".info-altura").textContent,
        imc: pacientes[i].querySelector(".info-imc")
    } 

    var alturaValida = validaAltura(dados.altura);
    var pesoValido = validaPeso(dados.peso)

    if(!validaPeso(dados.peso)){
        dados.imc.textContent = "Peso Inválido";
        pesoValido = false;
        pacientes[i].classList.add("paciente-invalido");
    }
    if(!validaAltura(dados.altura)){
        dados.imc.textContent = "Altura inválida";
        alturaValida = false;
        pacientes[i].classList.add("paciente-invalido");
    }
    
    if(alturaValida && pesoValido){
        var imc = calculaIMC(dados.peso, dados.altura);
        dados.imc.textContent = imc;
    }
}

function calculaIMC(peso, altura){
    var imc = 0;
    imc = (peso / (altura*altura))
    return imc.toFixed(2);
}

function validaPeso(peso){
    if(peso > 0 && peso <= 500){
        return true;
    }else{
        return false;
    }
}

function validaAltura(altura){
    if(altura > 0 && altura <= 3.00){
        return true;
    }else{
        return false;
    }
}