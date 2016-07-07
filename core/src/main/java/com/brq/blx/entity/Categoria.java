package com.brq.blx.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "BLX_CATEGORIA")
@NamedQuery(name = "Categoria.findAll", query = "SELECT b FROM Categoria b")
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "BLX_CATEGORIA_CODCATEGORIA_GENERATOR", sequenceName = "SEQ_ID_CATEGORIA", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BLX_CATEGORIA_CODCATEGORIA_GENERATOR")
	@Column(name = "COD_CATEGORIA")
	private Long codCategoria;

	@Column(name = "DS_DESCRICAO")
	private String dsDescricao;

	@Column(name = "NM_NOME")
	private String nmNome;
	
	/* RELAÇÕES */

	@OneToMany(mappedBy = "blxCategoria", fetch = FetchType.EAGER)
	private List<Anuncio> blxAnuncios;

	/* RELAÇÕES JOINCOLUMN */
	
	@ManyToOne(targetEntity=Categoria.class)
	@JoinColumn(name = "CATEGORIA_COD_CATEGORIA") 
	private Categoria blxCategoriaPai;

	public Categoria() {}

	public Categoria(Long codCategoria, String dsDescricao, String nmNome, Categoria blxCategoriaPai) {
		super();
		this.codCategoria = codCategoria;
		this.dsDescricao = dsDescricao;
		this.nmNome = nmNome;
		this.blxCategoriaPai = blxCategoriaPai;
	}

	public Categoria(Long codCategoria, String dsDescricao, String nmNome, List<Anuncio> blxAnuncios,
			Categoria blxCategoriaPai) {
		super();
		this.codCategoria = codCategoria;
		this.dsDescricao = dsDescricao;
		this.nmNome = nmNome;
		this.blxAnuncios = blxAnuncios;
		this.blxCategoriaPai = blxCategoriaPai;
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

	@Override
	public String toString() {
		return "Categoria [codCategoria=" + codCategoria + ", dsDescricao=" + dsDescricao + ", nmNome=" + nmNome
				+ ", blxCategoriaPai=" + blxCategoriaPai + "]";
	}
}