package br.com.gsw.boot.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Bicicleta implements Serializable {

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

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "pt-BR", timezone = "Brazil/East")
	@Column(name = "data_compra")
	private Date dataCompra;
	private boolean contato;

	public Bicicleta(String nome, String email, String telefone, String modelo, String numeroSerial,
			BigDecimal valorCompra, Date dataCompra, boolean contato) {

		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.modelo = modelo;
		this.numeroSerial = numeroSerial;
		this.valorCompra = valorCompra;
		this.dataCompra = dataCompra;
		this.contato = contato;
	}

}
