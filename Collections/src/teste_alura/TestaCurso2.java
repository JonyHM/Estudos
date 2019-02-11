package teste_alura;

import java.util.*;

public class TestaCurso2 {
	
	public static void main(String[] args) {
		Curso javaColecoes = new Curso("Dominando as coleções do Java", "Paulo Silveira");
		
		javaColecoes.adicionaAula(new Aula("Collections", 240));
		javaColecoes.adicionaAula(new Aula("Hibernate", 160));
		javaColecoes.adicionaAula(new Aula("Angular 2", 320));
		
		List<Aula> aulasImut = javaColecoes.getAulas();
		System.out.println(aulasImut);
		
		List<Aula> aulas = new ArrayList<>(aulasImut);		
		Collections.sort(aulas);
		System.out.println(aulas);		
		System.out.println(javaColecoes.getTempoTotal());
		System.out.println(javaColecoes);
		
		
	}
}
