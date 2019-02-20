package br.com.gsw.gerenciador.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gsw.gerenciador.modelo.Banco;
import br.com.gsw.gerenciador.modelo.Empresa;

/**
 * O MainServlet precisa, além de receber a acao "MostraEmpresas", receber o ID
 * da empresa a ser exibida. Caso contrário, a página retornará erro
 * 
 * http://localhost/servlets/entrada?acao=MostraEmpresas&id=<ID>
 */
public class MostraEmpresas implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);

		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaPeloId(id);
		request.setAttribute("empresa", empresa);

		return "forward:alteraEmpresaForm.jsp";
	}
}
