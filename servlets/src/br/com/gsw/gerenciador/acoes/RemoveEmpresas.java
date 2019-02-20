package br.com.gsw.gerenciador.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gsw.gerenciador.modelo.Banco;

public class RemoveEmpresas implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramId = request.getParameter("id");
		
		Integer id = Integer.valueOf(paramId);		
		
		Banco banco = new Banco(); //Query BD
		banco.removerEmpresa(id);
		
		return "redirect:ListaEmpresas";
	}
}
