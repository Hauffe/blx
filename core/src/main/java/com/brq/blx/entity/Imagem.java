package com.brq.blx.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.google.gson.annotations.Expose;

@Entity
@Table(name="BLX_IMAGEM")
@NamedQuery(name="Imagem.findAll", query="SELECT b FROM Imagem b")
public class Imagem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BLX_IMAGEM_CODIMAGEM_GENERATOR", sequenceName="SEQ_ID_IMAGEM", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BLX_IMAGEM_CODIMAGEM_GENERATOR")
	@Column(name="COD_IMAGEM")
	@Expose
	private long codImagem;

	@Expose
	@Column(name="NM_NOME")
	private String nmNome;

	@Expose
	@Column(name="VL_CAMINHO")
	private String vlCaminho;
	
	/* RELAÇÕES JOINCOLUMN */

	@ManyToOne
	@JoinColumn(name="ANUNCIO_COD_ANUNCIO")
	private Anuncio blxAnuncio;

	public Imagem() {}

	public Imagem(long codImagem, Anuncio blxAnuncio) {
		super();
		this.codImagem = codImagem;
		this.blxAnuncio = blxAnuncio;
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
		return blxAnuncio;
	}

	public void setBlxAnuncio(Anuncio blxAnuncio) {
		this.blxAnuncio = blxAnuncio;
	}

	@Override
	public String toString() {
		return "Imagem [codImagem=" + codImagem + ", nmNome=" + nmNome + ", vlCaminho=" + vlCaminho + ", blxAnuncio="
				+ blxAnuncio + "]";
	}
}