package br.com.gsw.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> listaEmpresas = new ArrayList<>();
	private static List<Usuarios> listaUsuarios = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	static {
		Empresa emp1 = new Empresa();
		emp1.setId(chaveSequencial++);
		emp1.setNome("GSW");
		Empresa emp2 = new Empresa();
		emp2.setId(chaveSequencial++);
		emp2.setNome("Embraer");
		Banco.listaEmpresas.add(emp1);
		Banco.listaEmpresas.add(emp2);
		
		Usuarios u1 = new Usuarios();
		u1.setLogin("jhmorae");
		u1.setSenha("26845");
		Usuarios u2 = new Usuarios();
		u2.setLogin("teste");
		u2.setSenha("12345");
		
		listaUsuarios.add(u1);
		listaUsuarios.add(u2);
	}
	
	public void adiciona(Empresa empresa) {
		empresa.setId(chaveSequencial++);
		Banco.listaEmpresas.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.listaEmpresas;
	}

	public void removerEmpresa(Integer id) {
		
		Iterator<Empresa> iter = listaEmpresas.iterator();

		while(iter.hasNext()) {
			Empresa emp = iter.next();
			if(emp.getId() == id) {
				iter.remove();
			}
		}
	}

	public Empresa buscaEmpresaPeloId(Integer id) {
		for (Empresa empresa : listaEmpresas) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

	public Usuarios usuarioExiste(String login, String senha) {
		
		for (Usuarios usuario : listaUsuarios) {
			if(usuario.podeAcessar(login, senha)) {
				return usuario;
			}			
		}
		return null;
	}
	
}
