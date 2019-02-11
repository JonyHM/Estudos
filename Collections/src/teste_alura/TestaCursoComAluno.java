package teste_alura;

public class TestaCursoComAluno {

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
		
		/*For Each (método que reduz o código do for que o eclipse cria) com "expressão 
		 * lambda" (aluno -> {ação a ser realizada})
		 */
		preparoEstagio.getAlunos().forEach(aluno -> {
			System.out.println(aluno);
		});
		
		System.out.println(preparoEstagio.estaMatriculado(a1));	
	}
}
