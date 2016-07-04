package com.brq.blx.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the BLX_ALTERACAO database table.
 * 
 */
@Entity
@Table(name="BLX_ALTERACAO")
@NamedQuery(name="Alteracao.findAll", query="SELECT b FROM Alteracao b")
public class Alteracao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BLX_ALTERACAO_CODALTERACAO_GENERATOR", sequenceName="SEQ_ID_ALTERACAO", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BLX_ALTERACAO_CODALTERACAO_GENERATOR")
	@Column(name="COD_ALTERACAO")
	private long codAlteracao;

	@Column(name="DS_DESCRICAO")
	private String dsDescricao;

	@Temporal(TemporalType.DATE)
	@Column(name="VL_ALTERACAO")
	private Date vlAlteracao;

	//bi-directional many-to-one association to BlxAnuncio
	@ManyToOne
	@JoinColumn(name="ANUNCIO_COD_ANUNCIO")
	private Anuncio blxAnuncio;

	public Alteracao() {
	}

	public long getCodAlteracao() {
		return this.codAlteracao;
	}

	public void setCodAlteracao(long codAlteracao) {
		this.codAlteracao = codAlteracao;
	}

	public String getDsDescricao() {
		return this.dsDescricao;
	}

	public void setDsDescricao(String dsDescricao) {
		this.dsDescricao = dsDescricao;
	}

	public Date getVlAlteracao() {
		return this.vlAlteracao;
	}

	public void setVlAlteracao(Date vlAlteracao) {
		this.vlAlteracao = vlAlteracao;
	}

	public Anuncio getBlxAnuncio() {
		return this.blxAnuncio;
	}

	public void setBlxAnuncio(Anuncio blxAnuncio) {
		this.blxAnuncio = blxAnuncio;
	}

}