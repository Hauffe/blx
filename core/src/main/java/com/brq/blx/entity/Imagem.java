package com.brq.blx.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the BLX_IMAGEM database table.
 * 
 */
@Entity
@Table(name="BLX_IMAGEM")
@NamedQuery(name="Imagem.findAll", query="SELECT b FROM Imagem b")
public class Imagem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BLX_IMAGEM_CODIMAGEM_GENERATOR", sequenceName="SEQ_ID_IMAGEM", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BLX_IMAGEM_CODIMAGEM_GENERATOR")
	@Column(name="COD_IMAGEM")
	private long codImagem;

	@Column(name="NM_NOME")
	private String nmNome;

	@Column(name="VL_CAMINHO")
	private String vlCaminho;

	//bi-directional many-to-one association to BlxAnuncio
	@ManyToOne
	@JoinColumn(name="ANUNCIO_COD_ANUNCIO")
	private Anuncio blxAnuncio;

	public Imagem() {
	}

	public long getCodImagem() {
		return this.codImagem;
	}

	public void setCodImagem(long codImagem) {
		this.codImagem = codImagem;
	}

	public String getNmNome() {
		return this.nmNome;
	}

	public void setNmNome(String nmNome) {
		this.nmNome = nmNome;
	}

	public String getVlCaminho() {
		return this.vlCaminho;
	}

	public void setVlCaminho(String vlCaminho) {
		this.vlCaminho = vlCaminho;
	}

	public Anuncio getBlxAnuncio() {
		return this.blxAnuncio;
	}

	public void setBlxAnuncio(Anuncio blxAnuncio) {
		this.blxAnuncio = blxAnuncio;
	}

}