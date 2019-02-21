package br.com.gsw.gerenciador.servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gsw.gerenciador.acoes.Acao;

//@WebFilter("/entrada")
public class ControladorFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String paramAcao = request.getParameter("acao");
		
		String nomeClasse = "br.com.gsw.gerenciador.acoes." + paramAcao;
		String nome;
		
		try {
			Class classe = Class.forName(nomeClasse); //Carrega a classe com o nome enviado
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
		String[] resp = nome.split(":");
		if(resp[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + resp[1]);
			rd.forward(request, response);
		}else {
			response.sendRedirect("entrada?acao=" + resp[1]);
		}
		
	}
}
