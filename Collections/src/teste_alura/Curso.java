package teste_alura;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Curso {

	private String nome;
	private String instrutor;
	private List<Aula> aulas = new LinkedList<Aula>();
	private Set<Aluno> alunos = new HashSet<>();
	private Map<Integer, Aluno> matriculaToAluno = new HashMap<>();
		
	public Curso(String nome, String instrutor) {
		this.nome = nome;
		this.instrutor = instrutor;
	}

	public String getNome() {
		return nome;
	}
	
	public String getInstrutor() {
		return instrutor;
	}
	
	public List<Aula> getAulas(){
		/* retorna uma lista imutável, que obriga a criar um método para 
		 * adicionar aulas à lista (encapsulamento)
		 */
		
		return Collections.unmodifiableList(aulas);
	}
	
	public void adicionaAula(Aula aula) {
		this.aulas.add(aula);
	}	
	
	public int getTempoTotal() {
		/*int tempoTotal = 0;
		for (Aula aula : aulas) {
			tempoTotal += aula.getTempo();
		}
		
		return tempoTotal;
		*/
		
		// Solução mais enxuta
		return this.aulas.stream().mapToInt(Aula::getTempo).sum();
	}
	
	@Override
	public String toString() {
			return "[Exercício de teste: " + nome + ", tempo total: " + this.getTempoTotal() + ", aulas:" + this.aulas + "]";
	}
	
	public void matricula(Aluno aluno) {
		this.alunos.add(aluno);
		this.matriculaToAluno.put(aluno.getNumeroMatricula(), aluno);
	}
	
	public Set<Aluno> getAlunos() {
		return Collections.unmodifiableSet(alunos);
	}

	public boolean estaMatriculado(Aluno aluno) {
		return this.alunos.contains(aluno);
	}
	
	public Aluno buscar(int matricula) {
		return matriculaToAluno.get(matricula);
	}
}
