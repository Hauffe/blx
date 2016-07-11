package com.brq.blx.entity;

import java.io.Serializable;
import javax.persistence.*;

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
	
	@Column(name = "VL_NUMERO")
	private Integer vlNumero;

	@Column(name = "VL_RUA")
	private String vlRua;

	@Column(name = "VL_UF")
	private String vlUf;
	
	/* RELAÇÕES JOINCOLUMN */

	@OneToOne(mappedBy="blxEndereco", fetch=FetchType.EAGER)
	private Contato blxContato;

	public Endereco() {}

	public Endereco(long codEndereco, String vlCep, String vlCidade, Integer vlNumero, String vlRua, String vlUf, Contato blxContato) {
		super();
		this.codEndereco = codEndereco;
		this.vlCep = vlCep;
		this.vlCidade = vlCidade;
		this.vlNumero = vlNumero;
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

	public Integer getVlNumero() {
		return vlNumero;
	}

	public void setVlNumero(Integer vlNumero) {
		this.vlNumero = vlNumero;
	}

	public Contato getBlxContato() {
		return blxContato;
	}

	public void setBlxContato(Contato blxContato) {
		this.blxContato = blxContato;
	}

	@Override
	public String toString() {
		return "Endereco [codEndereco=" + codEndereco + ", vlCep=" + vlCep + ", vlCidade=" + vlCidade + ", vlRua="
				+ vlRua + ", vlUf=" + vlUf + ", blxContato=" + blxContato + "]";
	}
}