package br.com.gsw.maven;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		Produto produto = new Produto("HaoJue Chopper Road", 7300.00);
		System.out.println("Daqui a pouco estarei com uma " + produto.getNome() + ", que custa " + produto.getPreco());
	}
}
