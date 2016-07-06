package com.brq.blx.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
	
	/* RELAÇÔES */

	@OneToMany(mappedBy = "blxAnuncio")
	private List<Avaliacao> blxAvaliacaos;

	@OneToMany(mappedBy = "blxAnuncio")
	private List<Imagem> blxImagems;

	@OneToMany(mappedBy = "blxAnuncio")
	private List<Alteracao> blxAlteracaos;
	
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

	public Anuncio() {}

	public Anuncio(long codAnuncio, String dsDescricao, Date dtAnuncio, String nmNome, double vlPreco,
			BigDecimal vlStatus, Categoria blxCategoria, Contato blxContato, Usuario blxUsuario) {
		super();
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
				+ blxAlteracaos + "]";
	}
}