package teste_alura;

public class TestaCurso {
	
	public static void main(String[] args) {
		Curso javaColecoes = new Curso("Dominando as coleções do Java", "Paulo Silveira");
		
		javaColecoes.adicionaAula(new Aula("Collections", 240));
		javaColecoes.adicionaAula(new Aula("Hibernate", 160));
		javaColecoes.adicionaAula(new Aula("Angular 2", 320));
		
		System.out.println(javaColecoes.getAulas());
		
		System.out.println(javaColecoes.getTempoTotal());
	}
}
