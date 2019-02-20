package br.com.gsw.gerenciador.acoes;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gsw.gerenciador.modelo.Banco;
import br.com.gsw.gerenciador.modelo.Empresa;

public class AlteraEmpresas {
	
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
					
		String nomeEmpresa = request.getParameter("nome");
		String paramDataEmpresa = request.getParameter("data");
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramDataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		System.out.println("Alterando Empresa..." + id);
		
		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaPeloId(id); //Query BD
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		response.sendRedirect("entrada?acao=ListaEmpresas");
	}
}
