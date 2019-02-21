//package br.com.gsw.gerenciador.servlets;
//
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import br.com.gsw.gerenciador.acoes.Acao;
//
////@WebServlet(urlPatterns="/entrada")
//public class MainServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		String paramAcao = request.getParameter("acao");
//		
//		String nomeClasse = "br.com.gsw.gerenciador.acoes." + paramAcao;
//		String nome;
//		
//		try {
//			Class classe = Class.forName(nomeClasse); //Carrega a classe com o nome enviado
//			Acao acao = (Acao) classe.newInstance();
//			nome = acao.executa(request, response);
//		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
//			throw new ServletException(e);
//		}
//		
//		String[] resp = nome.split(":");
//		if(resp[0].equals("forward")) {
//			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + resp[1]);
//			rd.forward(request, response);
//		}else {
//			response.sendRedirect("entrada?acao=" + resp[1]);
//		}
//	}
//}
