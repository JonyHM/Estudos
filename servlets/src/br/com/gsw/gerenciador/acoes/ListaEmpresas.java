package br.com.gsw.gerenciador.acoes;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gsw.gerenciador.modelo.Banco;
import br.com.gsw.gerenciador.modelo.Empresa;

public class ListaEmpresas {
	
	public void executa (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Funcionou!");
		
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();
		request.setAttribute("empresas", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
		rd.forward(request, response);
	}
}
