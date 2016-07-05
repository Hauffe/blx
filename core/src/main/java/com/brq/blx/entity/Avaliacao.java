package com.brq.blx.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the BLX_AVALIACAO database table.
 * 
 */
@Entity
@Table(name = "BLX_AVALIACAO")
@NamedQuery(name = "Avaliacao.findAll", query = "SELECT b FROM Avaliacao b")
public class Avaliacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "BLX_AVALIACAO_CODAVALIACAO_GENERATOR", sequenceName = "SEQ_ID_AVALIACAO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BLX_AVALIACAO_CODAVALIACAO_GENERATOR")
	@Column(name = "COD_AVALIACAO")
	private long codAvaliacao;

	@Temporal(TemporalType.DATE)
	@Column(name = "DT_AVALIACAO")
	private Date dtAvaliacao;

	@Column(name = "VL_NOTA")
	private String vlNota;

	// bi-directional many-to-one association to BlxAnuncio
	 @ManyToOne
	 @JoinColumn(name="ANUNCIO_COD_ANUNCIO")
	 private Anuncio blxAnuncio;
	 

	/*@Column(name = "ANUNCIO_COD_ANUNCIO")
	private long pk_anuncio;*/

	public Avaliacao() {
	}

	

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

}