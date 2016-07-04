package com.brq.blx.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the BLX_CATEGORIA database table.
 * 
 */
@Entity
@Table(name="BLX_CATEGORIA")
@NamedQuery(name="Categoria.findAll", query="SELECT b FROM Categoria b")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BLX_CATEGORIA_CODCATEGORIA_GENERATOR", sequenceName="SEQ_ID_CATEGORIA", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BLX_CATEGORIA_CODCATEGORIA_GENERATOR")
	@Column(name="COD_CATEGORIA")
	private long codCategoria;

	@Column(name="DS_DESCRICAO")
	private String dsDescricao;

	@Column(name="NM_NOME")
	private String nmNome;

	//bi-directional many-to-one association to BlxAnuncio
	@OneToMany(mappedBy="blxCategoria")
	private List<Anuncio> blxAnuncios;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="CATEGORIA_COD_CATEGORIA")
	private Categoria blxCategoria;

	//bi-directional many-to-one association to Categoria
	@OneToMany(mappedBy="blxCategoria")
	private List<Categoria> blxCategorias;

	public Categoria() {
	}

	public long getCodCategoria() {
		return this.codCategoria;
	}

	public void setCodCategoria(long codCategoria) {
		this.codCategoria = codCategoria;
	}

	public String getDsDescricao() {
		return this.dsDescricao;
	}

	public void setDsDescricao(String dsDescricao) {
		this.dsDescricao = dsDescricao;
	}

	public String getNmNome() {
		return this.nmNome;
	}

	public void setNmNome(String nmNome) {
		this.nmNome = nmNome;
	}

	public List<Anuncio> getBlxAnuncios() {
		return this.blxAnuncios;
	}

	public void setBlxAnuncios(List<Anuncio> blxAnuncios) {
		this.blxAnuncios = blxAnuncios;
	}

	public Anuncio addBlxAnuncio(Anuncio blxAnuncio) {
		getBlxAnuncios().add(blxAnuncio);
		blxAnuncio.setBlxCategoria(this);

		return blxAnuncio;
	}

	public Anuncio removeBlxAnuncio(Anuncio blxAnuncio) {
		getBlxAnuncios().remove(blxAnuncio);
		blxAnuncio.setBlxCategoria(null);

		return blxAnuncio;
	}

	public Categoria getBlxCategoria() {
		return this.blxCategoria;
	}

	public void setBlxCategoria(Categoria blxCategoria) {
		this.blxCategoria = blxCategoria;
	}

	public List<Categoria> getBlxCategorias() {
		return this.blxCategorias;
	}

	public void setBlxCategorias(List<Categoria> blxCategorias) {
		this.blxCategorias = blxCategorias;
	}

	public Categoria addBlxCategoria(Categoria blxCategoria) {
		getBlxCategorias().add(blxCategoria);
		blxCategoria.setBlxCategoria(this);

		return blxCategoria;
	}

	public Categoria removeBlxCategoria(Categoria blxCategoria) {
		getBlxCategorias().remove(blxCategoria);
		blxCategoria.setBlxCategoria(null);

		return blxCategoria;
	}

}