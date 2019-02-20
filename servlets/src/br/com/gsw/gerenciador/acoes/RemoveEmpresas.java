package br.com.gsw.gerenciador.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gsw.gerenciador.modelo.Banco;

public class RemoveEmpresas {

	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Removendo...");
		String paramId = request.getParameter("id");
		
		Integer id = Integer.valueOf(paramId);		
		System.out.println(id);
		
		Banco banco = new Banco(); //Query BD
		banco.removerEmpresa(id);
		
		response.sendRedirect("entrada?acao=ListaEmpresas");
	}
}
