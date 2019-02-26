package br.com.seboDidatico.loja.models;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ElementCollection
	private List<Preco> preco;
	
	private String titulo;
	private String descricao;
	private int paginas;

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Preco> getPreco() {
		return preco;
	}
	public void setPreco(List<Preco> preco) {
		this.preco = preco;
	}
			
	@Override
	public String toString() {
		return "Produto [Título=" + titulo + ", Descrição=" + descricao + ", Páginas=" + paginas + "]";
	}
}
