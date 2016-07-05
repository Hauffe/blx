package com.brq.blx.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the BLX_ENDERECO database table.
 * 
 */
@Entity
@Table(name = "BLX_ENDERECO")
@NamedQuery(name = "Endereco.findAll", query = "SELECT b FROM Endereco b")
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "BLX_ENDERECO_CODENDERECO_GENERATOR", sequenceName = "SEQ_ID_ENDERECO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BLX_ENDERECO_CODENDERECO_GENERATOR")
	@Column(name = "COD_ENDERECO")
	private long codEndereco;

	@Column(name = "VL_CEP")
	private String vlCep;

	@Column(name = "VL_CIDADE")
	private String vlCidade;

	@Column(name = "VL_RUA")
	private String vlRua;

	@Column(name = "VL_UF")
	private String vlUf;

	// bi-directional many-to-one association to BlxContato
	@ManyToOne
	@JoinColumn(name = "CONTATO_COD_CONTATO") private Contato blxContato;
	 

/*	@Column(name = "CONTATO_COD_CONTATO")
	private long pk_contato;*/

	public Endereco() {
	}



	public Endereco(long codEndereco, String vlCep, String vlCidade, String vlRua, String vlUf, Contato blxContato) {
		super();
		this.codEndereco = codEndereco;
		this.vlCep = vlCep;
		this.vlCidade = vlCidade;
		this.vlRua = vlRua;
		this.vlUf = vlUf;
		this.blxContato = blxContato;
	}



	public long getCodEndereco() {
		return this.codEndereco;
	}

	public void setCodEndereco(long codEndereco) {
		this.codEndereco = codEndereco;
	}

	public String getVlCep() {
		return this.vlCep;
	}

	public void setVlCep(String vlCep) {
		this.vlCep = vlCep;
	}

	public String getVlCidade() {
		return this.vlCidade;
	}

	public void setVlCidade(String vlCidade) {
		this.vlCidade = vlCidade;
	}

	public String getVlRua() {
		return this.vlRua;
	}

	public void setVlRua(String vlRua) {
		this.vlRua = vlRua;
	}

	public String getVlUf() {
		return this.vlUf;
	}

	public void setVlUf(String vlUf) {
		this.vlUf = vlUf;
	}


}