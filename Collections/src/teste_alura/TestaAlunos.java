package teste_alura;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class TestaAlunos {
	
	public static void main(String[] args) {
		// Encapsulando mais ainda o hashset, dando o Collection (mãe) como referência
		Collection<String> alunos = new HashSet<>();
		
		alunos.add("Primeiro nome");
		alunos.add("Segundo nome");
		alunos.add("Terceiro nome");
		alunos.add("Quarto nome");
		alunos.add("Quinto nome");
		alunos.add("Sexto nome");
		System.out.println(alunos);
		
		for (String aluno : alunos) {
			System.out.println(aluno);
		}		
		
		boolean search = alunos.contains("Primeiro");		
		System.out.println(search);
		
		/* Com o nível atial de encapsulamento, fica impossível acessar o método
		get. Sendo assim, foi criada uma nova lista e adicionado como referência
		o hash "alunos"
		*/ 
		List<String> alunosLista = new ArrayList<>(alunos);
		System.out.println(alunosLista.get(1));
	}
}
