package com.brq.blx.entity;
import java.io.Serializable;
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

import com.google.gson.annotations.Expose;


/**
 * The persistent class for the BLX_USUARIO database table.
 * 
 */
@Entity
@Table(name="BLX_USUARIO")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BLX_USUARIO_CODUSUARIO_GENERATOR", sequenceName="SEQ_ID_USUARIO", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BLX_USUARIO_CODUSUARIO_GENERATOR")
	@Column(name="COD_USUARIO")
	@Expose
	private long codUsuario;

	@Column(name="NM_NOME")
	@Expose
	private String nmNome;

	@Column(name="VL_CPF")
	@Expose
	private String vlCpf;

	@Column(name="VL_EMAIL")
	@Expose
	private String vlEmail;

	@Column(name="VL_LOGIN")
	@Expose
	private String vlLogin;

	@Column(name="VL_SENHA")
	@Expose
	private String vlSenha;

	@Column(name="VL_SKYPE")
	@Expose
	private String vlSkype;

	@Column(name="VL_STATUS")
	@Expose
	private Integer vlStatus;

	//bi-directional many-to-one association to Anuncio
	@OneToMany(mappedBy="blxUsuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Expose
	private List<Anuncio> blxAnuncios;

	//bi-directional many-to-one association to Notificacao
	@OneToMany(mappedBy="blxUsuario1")
	private List<Notificacao> blxNotificacaos1;

	//bi-directional many-to-one association to Notificacao
	@OneToMany(mappedBy="blxUsuario2")
	private List<Notificacao> blxNotificacaos2;

	//bi-directional many-to-one association to Contato
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="CONTATO_COD_CONTATO")
	@Expose
	private Contato blxContato;

	//bi-directional many-to-one association to TipoUsuario
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="TIPOUSUARIO_COD_TIPOUSUARIO")
	@Expose
	private TipoUsuario blxTipoUsuario;

	public Usuario() {
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

	public String getVlCpf() {
		return this.vlCpf;
	}

	public void setVlCpf(String vlCpf) {
		this.vlCpf = vlCpf;
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

	public String getVlSenha() {
		return this.vlSenha;
	}

	public void setVlSenha(String vlSenha) {
		this.vlSenha = vlSenha;
	}

	public String getVlSkype() {
		return this.vlSkype;
	}

	public void setVlSkype(String vlSkype) {
		this.vlSkype = vlSkype;
	}

	public Integer getVlStatus() {
		return this.vlStatus;
	}

	public void setVlStatus(Integer vlStatus) {
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

	public List<Notificacao> getBlxNotificacaos1() {
		return this.blxNotificacaos1;
	}

	public void setBlxNotificacaos1(List<Notificacao> blxNotificacaos1) {
		this.blxNotificacaos1 = blxNotificacaos1;
	}

	public Notificacao addBlxNotificacaos1(Notificacao blxNotificacaos1) {
		getBlxNotificacaos1().add(blxNotificacaos1);
		blxNotificacaos1.setBlxUsuario1(this);

		return blxNotificacaos1;
	}

	public Notificacao removeBlxNotificacaos1(Notificacao blxNotificacaos1) {
		getBlxNotificacaos1().remove(blxNotificacaos1);
		blxNotificacaos1.setBlxUsuario1(null);

		return blxNotificacaos1;
	}

	public List<Notificacao> getBlxNotificacaos2() {
		return this.blxNotificacaos2;
	}

	public void setBlxNotificacaos2(List<Notificacao> blxNotificacaos2) {
		this.blxNotificacaos2 = blxNotificacaos2;
	}

	public Notificacao addBlxNotificacaos2(Notificacao blxNotificacaos2) {
		getBlxNotificacaos2().add(blxNotificacaos2);
		blxNotificacaos2.setBlxUsuario2(this);

		return blxNotificacaos2;
	}

	public Notificacao removeBlxNotificacaos2(Notificacao blxNotificacaos2) {
		getBlxNotificacaos2().remove(blxNotificacaos2);
		blxNotificacaos2.setBlxUsuario2(null);

		return blxNotificacaos2;
	}

	public Contato getBlxContato() {
		return this.blxContato;
	}

	public void setBlxContato(Contato blxContato) {
		this.blxContato = blxContato;
	}

	public TipoUsuario getBlxTipoUsuario() {
		return blxTipoUsuario;
	}

	public void setBlxTipoUsuario(TipoUsuario blxTipoUsuario) {
		this.blxTipoUsuario = blxTipoUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [codUsuario=" + codUsuario + ", nmNome=" + nmNome + ", vlCpf=" + vlCpf + ", vlEmail=" + vlEmail
				+ ", vlLogin=" + vlLogin + ", vlSenha=" + vlSenha + ", vlSkype=" + vlSkype + ", vlStatus=" + vlStatus
				+ ", blxAnuncios=" + blxAnuncios + ", blxContato=" + blxContato + ", blxTipoUsuario=" + blxTipoUsuario
				+ "]";
	}
	
	


	
	

}