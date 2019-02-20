package br.com.gsw.gerenciador.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.gsw.gerenciador.modelo.Banco;
import br.com.gsw.gerenciador.modelo.Usuarios;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
					
		Banco banco = new Banco();
		Usuarios usuario = banco.usuarioExiste(login, senha);
		
		
		
		if(usuario != null) {
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", usuario);
			
			return "redirect:ListaEmpresas";
		}else {
			return "redirect:LoginForm";
		}
	}

}