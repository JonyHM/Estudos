package teste_alura;

public class Aula implements Comparable<Aula>{
	
	private String nome;
	private int tempo;
	
	public Aula(String nome, int tempo) {
		this.nome = nome;
		this.tempo = tempo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getTempo() {
		return tempo;
	}
	
	@Override
	public String toString() {
		return "[Curso:" + this.nome + ", " + this.tempo + " minutos]";
	}

	// Permite a classificação de itens da lista pelo nome, através do Comparable 
	@Override
	public int compareTo(Aula outroCurso) {
		return this.nome.compareTo(outroCurso.nome);
	}
}
