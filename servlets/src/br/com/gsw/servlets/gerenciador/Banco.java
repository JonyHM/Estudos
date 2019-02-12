package br.com.gsw.servlets.gerenciador;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private static List<Empresa> listaEmpresas = new ArrayList<>();
	
	static {
		Empresa emp1 = new Empresa();
		emp1.setNome("GSW");
		Empresa emp2 = new Empresa();
		emp2.setNome("Embraer");
		Banco.listaEmpresas.add(emp1);
		Banco.listaEmpresas.add(emp2);
	}
	
	public void adiciona(Empresa empresa) {		
		Banco.listaEmpresas.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.listaEmpresas;
	}
	
}
