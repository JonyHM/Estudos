package br.com.seboDidatico.loja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.seboDidatico.loja.daos.ProdutoDAO;
import br.com.seboDidatico.loja.models.Produto;

@Controller
public class HomeController {

	@Autowired
	private ProdutoDAO produtoDAO;
	
	@RequestMapping("/")
	@Cacheable("produtosHome")
	public ModelAndView index() {		
		ModelAndView modelAndView = new ModelAndView("home");
		List<Produto> produtos = produtoDAO.listar();
		modelAndView.addObject("produtos", produtos);
		
		return modelAndView;
	}
}
