package com.brq.blx.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the BLX_USUARIO database table.
 * 
 */
@Entity
@Table(name="BLX_USUARIO")
@NamedQuery(name="Usuario.findAll", query="SELECT b FROM Usuario b")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	/* Solução do problema referente a sequência do Hibernate: Primeiramente você deve colocar a anotação [ allocationSize = 1 ] dentro da anotação @SequenceGenerator,
	 caso isso não resolva, troque manualmente o valor do incrementBy dentro do SQLDEVELOPER*/

	@Id
	@SequenceGenerator(name="BLX_USUARIO_CODUSUARIO_GENERATOR", sequenceName="BLXSEQ_ID_USUARIO", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BLX_USUARIO_CODUSUARIO_GENERATOR")
	/*@GeneratedValue(generator="BLX_USUARIO_CODUSUARIO_GENERATOR")*/
	@Column(name="COD_USUARIO")
	private long codUsuario;

	@Column(name="NM_NOME")
	private String nmNome;

	@Column(name="VL_EMAIL")
	private String vlEmail;

	@Column(name="VL_LOGIN")
	private String vlLogin;

	@Column(name="VL_RG")
	private String vlRg;

	@Column(name="VL_SENHA")
	private String vlSenha;

	@Column(name="VL_STATUS")
	private BigDecimal vlStatus;

	//bi-directional many-to-one association to BlxAnuncio
	@OneToMany(mappedBy="blxUsuario")
	private List<Anuncio> blxAnuncios;

	//bi-directional many-to-one association to BlxContato
	@OneToMany(mappedBy="blxUsuario")
	private List<Contato> blxContatos;

	//bi-directional many-to-one association to BlxTipousuario
/*	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="TIPOUSUARIO_COD_TIPOUSUARIO")
	private Tipousuario blxTipousuario;*/
	
	@Column(name="TIPOUSUARIO_COD_TIPOUSUARIO")
	private long pk_tipousuario;

	public Usuario() {
	}
	
	
	
	public Usuario(long codUsuario, String nmNome, String vlEmail, String vlLogin, String vlRg, String vlSenha,
			BigDecimal vlStatus, long pk_tipousuario) {
		super();
		this.codUsuario = codUsuario;
		this.nmNome = nmNome;
		this.vlEmail = vlEmail;
		this.vlLogin = vlLogin;
		this.vlRg = vlRg;
		this.vlSenha = vlSenha;
		this.vlStatus = vlStatus;
		this.pk_tipousuario = pk_tipousuario;
	}



	public Usuario(long codUsuario, String nmNome, String vlEmail, String vlLogin, String vlRg, String vlSenha,
			BigDecimal vlStatus, List<Anuncio> blxAnuncios, List<Contato> blxContatos, long pk_tipousuario) {
		super();
		this.codUsuario = codUsuario;
		this.nmNome = nmNome;
		this.vlEmail = vlEmail;
		this.vlLogin = vlLogin;
		this.vlRg = vlRg;
		this.vlSenha = vlSenha;
		this.vlStatus = vlStatus;
		this.blxAnuncios = blxAnuncios;
		this.blxContatos = blxContatos;
		this.pk_tipousuario = pk_tipousuario;
	}
	
	

	public Usuario(String nmNome, String vlEmail, String vlLogin, String vlRg, String vlSenha, BigDecimal vlStatus,
			long pk_tipousuario) {
		super();
		this.nmNome = nmNome;
		this.vlEmail = vlEmail;
		this.vlLogin = vlLogin;
		this.vlRg = vlRg;
		this.vlSenha = vlSenha;
		this.vlStatus = vlStatus;
		this.pk_tipousuario = pk_tipousuario;
	}



	public long getCodUsuario() {
		return this.codUsuario;
	}

	public void setCodUsuario(long codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getNmNome() {
		return this.nmNome;
	}

	public void setNmNome(String nmNome) {
		this.nmNome = nmNome;
	}

	public String getVlEmail() {
		return this.vlEmail;
	}

	public void setVlEmail(String vlEmail) {
		this.vlEmail = vlEmail;
	}

	public String getVlLogin() {
		return this.vlLogin;
	}

	public void setVlLogin(String vlLogin) {
		this.vlLogin = vlLogin;
	}

	public String getVlRg() {
		return this.vlRg;
	}

	public void setVlRg(String vlRg) {
		this.vlRg = vlRg;
	}

	public String getVlSenha() {
		return this.vlSenha;
	}

	public void setVlSenha(String vlSenha) {
		this.vlSenha = vlSenha;
	}

	public BigDecimal getVlStatus() {
		return this.vlStatus;
	}

	public void setVlStatus(BigDecimal vlStatus) {
		this.vlStatus = vlStatus;
	}

	public List<Anuncio> getBlxAnuncios() {
		return this.blxAnuncios;
	}

	public void setBlxAnuncios(List<Anuncio> blxAnuncios) {
		this.blxAnuncios = blxAnuncios;
	}

	public Anuncio addBlxAnuncio(Anuncio blxAnuncio) {
		getBlxAnuncios().add(blxAnuncio);
		blxAnuncio.setBlxUsuario(this);

		return blxAnuncio;
	}

	public Anuncio removeBlxAnuncio(Anuncio blxAnuncio) {
		getBlxAnuncios().remove(blxAnuncio);
		blxAnuncio.setBlxUsuario(null);

		return blxAnuncio;
	}

	public List<Contato> getBlxContatos() {
		return this.blxContatos;
	}

	public void setBlxContatos(List<Contato> blxContatos) {
		this.blxContatos = blxContatos;
	}

	public Contato addBlxContato(Contato blxContato) {
		getBlxContatos().add(blxContato);
		blxContato.setBlxUsuario(this);

		return blxContato;
	}

	public Contato removeBlxContato(Contato blxContato) {
		getBlxContatos().remove(blxContato);
		blxContato.setBlxUsuario(null);

		return blxContato;
	}

	public long getPk_tipousuario() {
		return pk_tipousuario;
	}

	public void setPk_tipousuario(long pk_tipousuario) {
		this.pk_tipousuario = pk_tipousuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "Usuario [codUsuario=" + codUsuario + ", nmNome=" + nmNome + ", vlEmail=" + vlEmail + ", vlLogin="
				+ vlLogin + ", vlRg=" + vlRg + ", vlSenha=" + vlSenha + ", vlStatus=" + vlStatus + ", pk_tipousuario="
				+ pk_tipousuario + "]";
	}
	
	

}