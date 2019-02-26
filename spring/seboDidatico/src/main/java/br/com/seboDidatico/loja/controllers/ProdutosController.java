package br.com.seboDidatico.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.seboDidatico.loja.daos.ProdutoDAO;
import br.com.seboDidatico.loja.models.Produto;
import br.com.seboDidatico.loja.models.TipoPreco;

@Controller
public class ProdutosController {
	
	@Autowired
	private ProdutoDAO produtoDAO;
	
	@RequestMapping("/produtos/form")
	public ModelAndView form() {
		
		ModelAndView modelAndView = new ModelAndView("produtos/form");
		modelAndView.addObject("tipos", TipoPreco.values());
		
		return modelAndView;
	}
	
	@RequestMapping("/produtos")
	public String gravar(Produto produto) {
		produtoDAO.gravar(produto);
		return "produtos/sucesso";
	}
}
