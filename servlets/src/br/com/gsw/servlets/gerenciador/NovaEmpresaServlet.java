package br.com.gsw.servlets.gerenciador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewCompanyServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Faz apenas a requisição POST ser aceito pela página
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Confirma a chamada do Servlet
		System.out.println("Novo cadastro de Empresa");
		
		//Cria uma variavel do tipo String para receber o nome da empresa inserido e o designa a um atributo de um novo objeto
		String nomeEmpresa = request.getParameter("nome");
		String paramDataEmpresa = request.getParameter("data");
				
		//realizando parsing para formatar a data recebida como string (catch and rethrow)
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramDataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		//cria um novo banco de dados e envia o nome da empresa nele
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		//envia para o jsp o nome da empresa através do atributo empresa 
		request.setAttribute("empresa", empresa.getNome());
		response.sendRedirect("listaEmpresas"); //redireciona para outro servlet
		
//		//Chamar o JSP para exibir o arquivo criado
//		RequestDispatcher rd = request.getRequestDispatcher("/cadastroRealizado.jsp");
//		request.setAttribute("empresa", empresa.getNome());
//		rd.forward(request, response);
	}

}
