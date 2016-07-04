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
	private BigDecimal vlStatus;

	// bi-directional many-to-one association to BlxAlteracao
	@OneToMany(mappedBy = "blxAnuncio")
	private List<Alteracao> blxAlteracaos;

	// bi-directional many-to-one association to BlxCategoria
	/*
	 * @ManyToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "CATEGORIA_COD_CATEGORIA") private Categoria
	 * blxCategoria;
	 */

	@Column(name = "CATEGORIA_COD_CATEGORIA")
	private long pk_categoria;

	// bi-directional many-to-one association to BlxContato
	/*
	 * @ManyToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "CONTATO_COD_CONTATO") private Contato blxContato;
	 */

	@Column(name = "CONTATO_COD_CONTATO")
	private long pk_contato;

	// bi-directional many-to-one association to BlxUsuario
	/*
	 * @ManyToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "USUARIO_COD_USUARIO") private Usuario blxUsuario;
	 */

	@Column(name = "USUARIO_COD_USUARIO")
	private long pk_usuario;

	// bi-directional many-to-one association to BlxAvaliacao
	@OneToMany(mappedBy = "blxAnuncio")
	private List<Avaliacao> blxAvaliacaos;

	// bi-directional many-to-one association to BlxImagem
	@OneToMany(mappedBy = "blxAnuncio")
	private List<Imagem> blxImagems;

	public Anuncio() {
	}

	public Anuncio(long codAnuncio, String dsDescricao, Date dtAnuncio, String nmNome, double vlPreco,
			BigDecimal vlStatus) {
		super();
		this.codAnuncio = codAnuncio;
		this.dsDescricao = dsDescricao;
		this.dtAnuncio = dtAnuncio;
		this.nmNome = nmNome;
		this.vlPreco = vlPreco;
		this.vlStatus = vlStatus;
	}

	public Anuncio(String dsDescricao, Date dtAnuncio, String nmNome, double vlPreco, BigDecimal vlStatus,
			long pk_categoria, long pk_contato, long pk_usuario) {
		super();
		this.dsDescricao = dsDescricao;
		this.dtAnuncio = dtAnuncio;
		this.nmNome = nmNome;
		this.vlPreco = vlPreco;
		this.vlStatus = vlStatus;
		this.pk_categoria = pk_categoria;
		this.pk_contato = pk_contato;
		this.pk_usuario = pk_usuario;
	}

	public long getCodAnuncio() {
		return codAnuncio;
	}

	public void setCodAnuncio(long codAnuncio) {
		this.codAnuncio = codAnuncio;
	}

	public String getDsDescricao() {
		return dsDescricao;
	}

	public void setDsDescricao(String dsDescricao) {
		this.dsDescricao = dsDescricao;
	}

	public Date getDtAnuncio() {
		return dtAnuncio;
	}

	public void setDtAnuncio(Date dtAnuncio) {
		this.dtAnuncio = dtAnuncio;
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

	public BigDecimal getVlStatus() {
		return vlStatus;
	}

	public void setVlStatus(BigDecimal vlStatus) {
		this.vlStatus = vlStatus;
	}

	public List<Alteracao> getBlxAlteracaos() {
		return blxAlteracaos;
	}

	public void setBlxAlteracaos(List<Alteracao> blxAlteracaos) {
		this.blxAlteracaos = blxAlteracaos;
	}

	public long getPk_categoria() {
		return pk_categoria;
	}

	public void setPk_categoria(long pk_categoria) {
		this.pk_categoria = pk_categoria;
	}

	public long getPk_contato() {
		return pk_contato;
	}

	public void setPk_contato(long pk_contato) {
		this.pk_contato = pk_contato;
	}

	public long getPk_usuario() {
		return pk_usuario;
	}

	public void setPk_usuario(long pk_usuario) {
		this.pk_usuario = pk_usuario;
	}

	public List<Avaliacao> getBlxAvaliacaos() {
		return blxAvaliacaos;
	}

	public void setBlxAvaliacaos(List<Avaliacao> blxAvaliacaos) {
		this.blxAvaliacaos = blxAvaliacaos;
	}

	public List<Imagem> getBlxImagems() {
		return blxImagems;
	}

	public void setBlxImagems(List<Imagem> blxImagems) {
		this.blxImagems = blxImagems;
	}

	@Override
	public String toString() {
		return "Anuncio [codAnuncio=" + codAnuncio + ", dsDescricao=" + dsDescricao + ", dtAnuncio=" + dtAnuncio
				+ ", nmNome=" + nmNome + ", vlPreco=" + vlPreco + ", vlStatus=" + vlStatus + ", blxAlteracaos="
				+ blxAlteracaos + ", pk_categoria=" + pk_categoria + ", pk_contato=" + pk_contato + ", pk_usuario="
				+ pk_usuario + "]";
	}


}