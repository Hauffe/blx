package com.brq.blx.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the BLX_CATEGORIA database table.
 * 
 */
@Entity
@Table(name = "BLX_CATEGORIA")
@NamedQuery(name = "Categoria.findAll", query = "SELECT b FROM Categoria b")
public class Categoria implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "BLX_CATEGORIA_CODCATEGORIA_GENERATOR", sequenceName = "SEQ_ID_CATEGORIA", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BLX_CATEGORIA_CODCATEGORIA_GENERATOR")
	@Column(name = "COD_CATEGORIA")
	private Long codCategoria;

	@Column(name = "DS_DESCRICAO")
	private String dsDescricao;

	@Column(name = "NM_NOME")
	private String nmNome;

	// bi-directional many-to-one association to BlxAnuncio
	@OneToMany(mappedBy = "blxCategoria")
	private List<Anuncio> blxAnuncios;

	// bi-directional many-to-one association to Categoria
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "CATEGORIA_COD_CATEGORIA") private Categoria
	 * blxCategoria;
	 */

	@Column(name = "CATEGORIA_COD_CATEGORIA")
	private Long pk_categoria;

	/*
	 * //bi-directional many-to-one association to Categoria
	 * 
	 * @OneToMany(mappedBy="blxCategoria") private List<Categoria>
	 * blxCategorias;
	 */

	public Categoria() {
	}

	public Categoria(Long codCategoria, String dsDescricao, String nmNome, List<Anuncio> blxAnuncios,
			Long pk_categoria) {
		super();
		this.codCategoria = codCategoria;
		this.dsDescricao = dsDescricao;
		this.nmNome = nmNome;
		this.blxAnuncios = blxAnuncios;
		this.pk_categoria = pk_categoria;
	}

	public Long getCodCategoria() {
		return this.codCategoria;
	}

	public void setCodCategoria(Long codCategoria) {
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

	public Long getPk_categoria() {
		return pk_categoria;
	}

	public void setPk_categoria(Long pk_categoria) {
		this.pk_categoria = pk_categoria;
	}

}