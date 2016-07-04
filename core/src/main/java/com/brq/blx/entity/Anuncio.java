package com.brq.blx.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the BLX_ANUNCIO database table.
 * 
 */
@Entity
@Table(name="BLX_ANUNCIO")
@NamedQuery(name="Anuncio.findAll", query="SELECT b FROM Anuncio b")
public class Anuncio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BLX_ANUNCIO_CODANUNCIO_GENERATOR", sequenceName="SEQ_ID_ANUNCIO", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BLX_ANUNCIO_CODANUNCIO_GENERATOR")
	@Column(name="COD_ANUNCIO")
	private long codAnuncio;

	@Column(name="DS_DESCRICAO")
	private String dsDescricao;

	@Temporal(TemporalType.DATE)
	@Column(name="DT_ANUNCIO")
	private Date dtAnuncio;

	@Column(name="NM_NOME")
	private String nmNome;

	@Column(name="VL_PRECO")
	private double vlPreco;

	@Column(name="VL_STATUS")
	private BigDecimal vlStatus;

	//bi-directional many-to-one association to BlxAlteracao
	@OneToMany(mappedBy="blxAnuncio")
	private List<Alteracao> blxAlteracaos;

	//bi-directional many-to-one association to BlxCategoria
	@ManyToOne
	@JoinColumn(name="CATEGORIA_COD_CATEGORIA")
	private Categoria blxCategoria;

	//bi-directional many-to-one association to BlxContato
	@ManyToOne
	@JoinColumn(name="CONTATO_COD_CONTATO")
	private Contato blxContato;

	//bi-directional many-to-one association to BlxUsuario
	@ManyToOne
	@JoinColumn(name="USUARIO_COD_USUARIO")
	private Usuario blxUsuario;

	//bi-directional many-to-one association to BlxAvaliacao
	@OneToMany(mappedBy="blxAnuncio")
	private List<Avaliacao> blxAvaliacaos;

	//bi-directional many-to-one association to BlxImagem
	@OneToMany(mappedBy="blxAnuncio")
	private List<Imagem> blxImagems;

	public Anuncio() {
	}

	public long getCodAnuncio() {
		return this.codAnuncio;
	}

	public void setCodAnuncio(long codAnuncio) {
		this.codAnuncio = codAnuncio;
	}

	public String getDsDescricao() {
		return this.dsDescricao;
	}

	public void setDsDescricao(String dsDescricao) {
		this.dsDescricao = dsDescricao;
	}

	public Date getDtAnuncio() {
		return this.dtAnuncio;
	}

	public void setDtAnuncio(Date dtAnuncio) {
		this.dtAnuncio = dtAnuncio;
	}

	public String getNmNome() {
		return this.nmNome;
	}

	public void setNmNome(String nmNome) {
		this.nmNome = nmNome;
	}

	public double getVlPreco() {
		return this.vlPreco;
	}

	public void setVlPreco(double vlPreco) {
		this.vlPreco = vlPreco;
	}

	public BigDecimal getVlStatus() {
		return this.vlStatus;
	}

	public void setVlStatus(BigDecimal vlStatus) {
		this.vlStatus = vlStatus;
	}

	public List<Alteracao> getBlxAlteracaos() {
		return this.blxAlteracaos;
	}

	public void setBlxAlteracaos(List<Alteracao> blxAlteracaos) {
		this.blxAlteracaos = blxAlteracaos;
	}

	public Alteracao addBlxAlteracao(Alteracao blxAlteracao) {
		getBlxAlteracaos().add(blxAlteracao);
		blxAlteracao.setBlxAnuncio(this);

		return blxAlteracao;
	}

	public Alteracao removeBlxAlteracao(Alteracao blxAlteracao) {
		getBlxAlteracaos().remove(blxAlteracao);
		blxAlteracao.setBlxAnuncio(null);

		return blxAlteracao;
	}

	public Categoria getBlxCategoria() {
		return this.blxCategoria;
	}

	public void setBlxCategoria(Categoria blxCategoria) {
		this.blxCategoria = blxCategoria;
	}

	public Contato getBlxContato() {
		return this.blxContato;
	}

	public void setBlxContato(Contato blxContato) {
		this.blxContato = blxContato;
	}

	public Usuario getBlxUsuario() {
		return this.blxUsuario;
	}

	public void setBlxUsuario(Usuario blxUsuario) {
		this.blxUsuario = blxUsuario;
	}

	public List<Avaliacao> getBlxAvaliacaos() {
		return this.blxAvaliacaos;
	}

	public void setBlxAvaliacaos(List<Avaliacao> blxAvaliacaos) {
		this.blxAvaliacaos = blxAvaliacaos;
	}

	public Avaliacao addBlxAvaliacao(Avaliacao blxAvaliacao) {
		getBlxAvaliacaos().add(blxAvaliacao);
		blxAvaliacao.setBlxAnuncio(this);

		return blxAvaliacao;
	}

	public Avaliacao removeBlxAvaliacao(Avaliacao blxAvaliacao) {
		getBlxAvaliacaos().remove(blxAvaliacao);
		blxAvaliacao.setBlxAnuncio(null);

		return blxAvaliacao;
	}

	public List<Imagem> getBlxImagems() {
		return this.blxImagems;
	}

	public void setBlxImagems(List<Imagem> blxImagems) {
		this.blxImagems = blxImagems;
	}

	public Imagem addBlxImagem(Imagem blxImagem) {
		getBlxImagems().add(blxImagem);
		blxImagem.setBlxAnuncio(this);

		return blxImagem;
	}

	public Imagem removeBlxImagem(Imagem blxImagem) {
		getBlxImagems().remove(blxImagem);
		blxImagem.setBlxAnuncio(null);

		return blxImagem;
	}

}