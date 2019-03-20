package br.com.caelum.leilao.dominio;

public class AnoBissexto {

	public Boolean ehBissexto(Integer ano) {
		
		if(multiploDe4(ano)){
			if(!multiploDe100(ano)) 
				return true;
			return multiploDe400(ano);
		}
		else return false;
	}

	private Boolean multiploDe100(Integer ano) {
		return ano % 100 == 0;
	}

	private Boolean multiploDe4(Integer ano) {
		return ano % 4 == 0;
	}

	private Boolean multiploDe400(Integer ano) {
		return ano % 400 == 0;
	}
}
