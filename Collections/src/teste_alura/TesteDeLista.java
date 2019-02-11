package teste_alura;

import java.util.*;

public class TesteDeLista {
	
	public static void main(String[] args) {
		Aula a1 = new Aula("Colections", 180);
		Aula a2 = new Aula("Ferramentas de Build automatizado", 240);
		Aula a3 = new Aula("Hibernate", 120);
		Aula a4 = new Aula("Fundamentos Web", 60);
		
		ArrayList<Aula> cursos = new ArrayList<>();
		cursos.add(a1);
		cursos.add(a2);
		cursos.add(a3);
		cursos.add(a4);
		
		System.out.println(cursos);
		
		Collections.sort(cursos);
		System.out.println(cursos);
		
		//ordenando os itens utilizando o metodo Collections
		Collections.sort(cursos, Comparator.comparing(Aula::getTempo));
		System.out.println(cursos);
		
		//ordenando de forma mais facil (funciona a partir do java 8)
		cursos.sort(Comparator.comparing(Aula::getTempo));
		System.out.println(cursos);
	}
}
