package com.brq.blx.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.google.gson.annotations.Expose;

import java.util.Date;

@Entity
@Table(name = "BLX_AVALIACAO")
@NamedQuery(name = "Avaliacao.findAll", query = "SELECT b FROM Avaliacao b")
public class Avaliacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "BLX_AVALIACAO_CODAVALIACAO_GENERATOR", sequenceName = "SEQ_ID_AVALIACAO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BLX_AVALIACAO_CODAVALIACAO_GENERATOR")
	@Column(name = "COD_AVALIACAO")
	@Expose
	private long codAvaliacao;

	@Expose
	@Temporal(TemporalType.DATE)
	@Column(name = "DT_AVALIACAO")
	private Date dtAvaliacao;

	@Expose
	@Column(name = "VL_NOTA")
	private String vlNota;
	
	/* Relações JOINCOLUMN */

	@ManyToOne
	@JoinColumn(name="ANUNCIO_COD_ANUNCIO")
	private Anuncio blxAnuncio;

	public Avaliacao() {}

	public Avaliacao(long codAvaliacao, Date dtAvaliacao, String vlNota, Anuncio blxAnuncio) {
		super();
		this.codAvaliacao = codAvaliacao;
		this.dtAvaliacao = dtAvaliacao;
		this.vlNota = vlNota;
		this.blxAnuncio = blxAnuncio;
	}

	public long getCodAvaliacao() {
		return this.codAvaliacao;
	}

	public void setCodAvaliacao(long codAvaliacao) {
		this.codAvaliacao = codAvaliacao;
	}

	public Date getDtAvaliacao() {
		return this.dtAvaliacao;
	}

	public void setDtAvaliacao(Date dtAvaliacao) {
		this.dtAvaliacao = dtAvaliacao;
	}

	public String getVlNota() {
		return this.vlNota;
	}

	public void setVlNota(String vlNota) {
		this.vlNota = vlNota;
	}
	
	

	public Anuncio getBlxAnuncio() {
		return blxAnuncio;
	}

	public void setBlxAnuncio(Anuncio blxAnuncio) {
		this.blxAnuncio = blxAnuncio;
	}

	@Override
	public String toString() {
		return "Avaliacao [codAvaliacao=" + codAvaliacao + ", dtAvaliacao=" + dtAvaliacao + ", vlNota=" + vlNota
				+ ", blxAnuncio=" + blxAnuncio + "]";
	}
}