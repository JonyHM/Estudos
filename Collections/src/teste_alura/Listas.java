package teste_alura;

import java.util.ArrayList;
import java.util.Collections;

public class Listas {

	public static void main(String[] args) {
		String a1 = "Colections";
		String a2 = "Ferramentas de Build automatizado";
		String a3 = "Fundamentos Web";

		ArrayList<String> cursos = new ArrayList<>();
		cursos.add(a1);
		cursos.add(a2);
		cursos.add(a3);

		System.out.println(cursos);
		System.out.println("\nAulas a serem feitas: ");
		
		cursos.forEach(item -> {
			System.out.println("- " + item);
		});
		
		cursos.add("Angular 2");
		System.out.println(cursos);
		
		Collections.sort(cursos);		
		System.out.println(cursos);
	}
}