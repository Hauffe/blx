package com.brq.blx.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.google.gson.annotations.Expose;

import java.util.Date;

@Entity
@Table(name = "BLX_ALTERACAO")
@NamedQuery(name = "Alteracao.findAll", query = "SELECT b FROM Alteracao b")
public class Alteracao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "BLX_ALTERACAO_CODALTERACAO_GENERATOR", sequenceName = "SEQ_ID_ALTERACAO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BLX_ALTERACAO_CODALTERACAO_GENERATOR")
	@Expose
	@Column(name = "COD_ALTERACAO")
	private long codAlteracao;

	@Expose
	@Column(name = "DS_DESCRICAO")
	private String dsDescricao;

	@Expose
	@Temporal(TemporalType.DATE)
	@Column(name = "DT_ALTERACAO")
	private Date dtAlteracao;
	
	/* RELAÇÕES JOINCOLUMN */

	@ManyToOne
	@JoinColumn(name = "ANUNCIO_COD_ANUNCIO")
	private Anuncio blxAnuncio;

	public Alteracao() {}

	public Alteracao(long codAlteracao, String dsDescricao, Date dtAlteracao) {
		super();
		this.codAlteracao = codAlteracao;
		this.dsDescricao = dsDescricao;
		this.dtAlteracao = dtAlteracao;
	}

	public long getCodAlteracao() {
		return codAlteracao;
	}

	public void setCodAlteracao(long codAlteracao) {
		this.codAlteracao = codAlteracao;
	}

	public String getDsDescricao() {
		return dsDescricao;
	}

	public void setDsDescricao(String dsDescricao) {
		this.dsDescricao = dsDescricao;
	}

	public Date getDtAlteracao() {
		return dtAlteracao;
	}

	public void setDtAlteracao(Date dtAlteracao) {
		this.dtAlteracao = dtAlteracao;
	}

	public Anuncio getBlxAnuncio() {
		return blxAnuncio;
	}

	public void setBlxAnuncio(Anuncio blxAnuncio) {
		this.blxAnuncio = blxAnuncio;
	}
}