package br.com.gsw.servlets.gerenciador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/removerEmpresas")
public class RemoverEmpresasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramId = request.getParameter("id");
		
		Integer id = Integer.valueOf(paramId);		
		System.out.println(id);
		
		Banco banco = new Banco();
		banco.removerEmpresa(id);
		
		response.sendRedirect("listaEmpresas");
	}

}
