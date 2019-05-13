package br.com.gsw.boot.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@SuppressWarnings("unused")
public class Bicicleta implements Serializable{

	private static final long serialVersionUID = -1197208050933831323L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	private String email;
	private String telefone;
	private String modelo;
	
	@Column(name = "numero_serial")
	private String numeroSerial;
	
	@Column(name = "valor_compra")
	private BigDecimal valorCompra;
	
	@Column(name = "data_compra")
	private Date dataCompra;
	private boolean contato;

}
