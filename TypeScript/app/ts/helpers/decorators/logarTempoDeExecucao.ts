export function logarTempoDeExecucao(emSegundos: boolean = false) {
    
    return function(target: any, propertyKey: string, descriptor: PropertyDescriptor) {

        const metodoOriginal = descriptor.value;

        descriptor.value = function(...args: any[]){

            let unidade = 'ms';
            let divisor = 1;

            if(emSegundos){
                unidade = 's';
                divisor = 1000;
            }

            console.log('-------------------------');
            console.log(`Parâmetros passados para o método ${propertyKey}: ${JSON.stringify(args)}`);
            const inicio = performance.now();
            const retorno = metodoOriginal.apply(this, args);
            const final = performance.now();
            console.log(`O retorno do método ${propertyKey} é ${retorno}`);
            console.log(`O método ${propertyKey} demorou ${(final - inicio)/divisor}${unidade} em sua execução`);
            
            return retorno;
        }

        return descriptor;
    }
}