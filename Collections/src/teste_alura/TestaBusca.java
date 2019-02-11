package teste_alura;

public class TestaBusca {

	public static void main(String[] args) {
		
		Curso preparoEstagio = new Curso("Curso de Java Collections", "Alura");

		preparoEstagio.adicionaAula(new Aula("ArrayList", 240));
		preparoEstagio.adicionaAula(new Aula("List", 160));
		preparoEstagio.adicionaAula(new Aula("HashSet", 320));

		Aluno a1 = new Aluno("Jonathas Moraes", 356737);
		Aluno a2 = new Aluno("Luiz Souza", 268451);
		Aluno a3 = new Aluno("Felipe Silva", 264815);

		preparoEstagio.matricula(a1);
		preparoEstagio.matricula(a2);
		preparoEstagio.matricula(a3);
		
		System.out.println("Que aluno está matriculado com o registro 268451?");
		Aluno aluno = preparoEstagio.buscar(268451);
		System.out.println(aluno);
	}
}
