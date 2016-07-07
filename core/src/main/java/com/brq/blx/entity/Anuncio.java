package com.brq.blx.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "BLX_ANUNCIO")
@NamedQuery(name = "Anuncio.findAll", query = "SELECT b FROM Anuncio b")
public class Anuncio implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "BLX_ANUNCIO_CODANUNCIO_GENERATOR", sequenceName = "SEQ_ID_ANUNCIO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BLX_ANUNCIO_CODANUNCIO_GENERATOR")
	@Column(name = "COD_ANUNCIO")
	private long codAnuncio;

	@Column(name = "DS_DESCRICAO")
	private String dsDescricao;

	@Temporal(TemporalType.DATE)
	@Column(name = "DT_ANUNCIO")
	private Date dtAnuncio;

	@Column(name = "NM_NOME")
	private String nmNome;

	@Column(name = "VL_PRECO")
	private double vlPreco;

	@Column(name = "VL_STATUS")
	private Integer vlStatus;
	
	/* RELAÇÔES */

	@JsonManagedReference
	@OneToMany(mappedBy = "blxAnuncio")
	private List<Avaliacao> blxAvaliacoes;

	@JsonManagedReference
	@OneToMany(mappedBy = "blxAnuncio")
	private List<Imagem> blxImagems;

	@JsonManagedReference
	@OneToMany(mappedBy = "blxAnuncio")
	private List<Alteracao> blxAlteracoes;
	
	/* RELAÇÕES JOINCOLUMN */
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CATEGORIA_COD_CATEGORIA")
	private Categoria blxCategoria;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CONTATO_COD_CONTATO")
	private Contato blxContato;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USUARIO_COD_USUARIO")
	private Usuario blxUsuario;

	public Anuncio() {
		blxAlteracoes = new ArrayList<Alteracao>();
		blxImagems = new ArrayList<Imagem>();
		blxAvaliacoes = new ArrayList<Avaliacao>();
	}

	public Anuncio(long codAnuncio, String dsDescricao, Date dtAnuncio, String nmNome, double vlPreco,
			Integer vlStatus, Categoria blxCategoria, Contato blxContato, Usuario blxUsuario) {
		this();
		this.codAnuncio = codAnuncio;
		this.dsDescricao = dsDescricao;
		this.dtAnuncio = dtAnuncio;
		this.nmNome = nmNome;
		this.vlPreco = vlPreco;
		this.vlStatus = vlStatus;
		this.blxCategoria = blxCategoria;
		this.blxContato = blxContato;
		this.blxUsuario = blxUsuario;
	}

	public long getCodAnuncio() {
		return codAnuncio;
	}

	public String getDsDescricao() {
		return dsDescricao;
	}

	public void setDsDescricao(String dsDescricao) {
		this.dsDescricao = dsDescricao;
	}

	public String getNmNome() {
		return nmNome;
	}

	public void setNmNome(String nmNome) {
		this.nmNome = nmNome;
	}

	public double getVlPreco() {
		return vlPreco;
	}

	public void setVlPreco(double vlPreco) {
		this.vlPreco = vlPreco;
	}

	public Integer getVlStatus() {
		return vlStatus;
	}

	public void setVlStatus(Integer vlStatus) {
		this.vlStatus = vlStatus;
	}



	public void setBlxCategoria(Categoria blxCategoria) {
		this.blxCategoria = blxCategoria;
	}

	public Contato getBlxContato() {
		return blxContato;
	}

	public void setBlxContato(Contato blxContato) {
		this.blxContato = blxContato;
	}

	public Usuario getBlxUsuario() {
		return blxUsuario;
	}

	public void setBlxUsuario(Usuario blxUsuario) {
		this.blxUsuario = blxUsuario;
	}

	public void setCodAnuncio(long codAnuncio) {
		this.codAnuncio = codAnuncio;
	}

	@Override
	public String toString() {
		return "Anuncio [codAnuncio=" + codAnuncio + ", dsDescricao=" + dsDescricao + ", dtAnuncio=" + dtAnuncio
				+ ", nmNome=" + nmNome + ", vlPreco=" + vlPreco + ", vlStatus=" + vlStatus + ", blxCategoria="
				+ blxCategoria + ", blxContato=" + blxContato + ", blxUsuario=" + blxUsuario + "]";
	}
}