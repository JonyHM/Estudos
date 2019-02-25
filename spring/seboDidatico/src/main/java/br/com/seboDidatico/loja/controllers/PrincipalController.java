package br.com.seboDidatico.loja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PrincipalController {
	
	@RequestMapping("/")
	public String index() {
		
		System.out.println("Entrando na página");
		return "inicio";
	}
}
