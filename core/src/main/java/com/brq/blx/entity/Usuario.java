package com.brq.blx.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.google.gson.annotations.Expose;

import java.util.List;

@Entity
@Table(name = "BLX_USUARIO")
@NamedQuery(name = "Usuario.findAll", query = "SELECT b FROM Usuario b")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	
	/*
	 * SoluÃ§Ã£o do problema referente a sequÃªncia do Hibernate: Primeiramente
	 * vocÃª deve colocar a anotaÃ§Ã£o [ allocationSize = 1 ] dentro da
	 * anotaÃ§Ã£o @SequenceGenerator, caso isso nÃ£o resolva, troque manualmente o
	 * valor do incrementBy dentro do SQLDEVELOPER
	 */

	/*
	 * OBSERVE: ALGUMAS COLUNAS QUE DEVERIAM POSSUIR A ATRIBUIÃ‡ÃƒO "UNIQUE" NÃƒO
	 * POSSUEM A CARACTERÃ�STICA DE VALOR "ÃšNICO", POIS ESTAMOS EM FASE DE TESTE
	 * LOGO MAIS ADICIONAREMOS NAS ANOTAÃ‡Ã•ES @Column a anotaÃ§Ã£o: (unique = true)
	 */

	@Id
	@SequenceGenerator(name = "BLX_USUARIO_CODUSUARIO_GENERATOR", sequenceName = "BLXSEQ_ID_USUARIO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BLX_USUARIO_CODUSUARIO_GENERATOR")
	@Column(name = "COD_USUARIO")
	@Expose
	private long codUsuario;

	@Column(name = "NM_NOME")
	@Expose
	private String nmNome;

	@Column(name = "VL_EMAIL")
	@Expose
	private String vlEmail;

	@Column(name = "VL_LOGIN")
	@Expose
	private String vlLogin;
	
	@Column(name = "VL_SKYPE")
	@Expose
	private String vlSkype;

	@Column(name = "VL_CPF")
	@Expose
	private String vlCpf;

	@Column(name = "VL_SENHA")
	@Expose
	private String vlSenha;

	@Column(name = "VL_STATUS")
	@Expose
	private Integer vlStatus;

	/* RELACOES JOINCOLUMN */
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "TIPOUSUARIO_COD_TIPOUSUARIO")
	@Expose
	private TipoUsuario blxTipoUsuario;
	
	/*Relacao do matheus*/
	
	@OneToMany(mappedBy="blxUsuario", fetch=FetchType.EAGER)
	@Expose
	private List<Contato> blxContatos;

	@OneToMany(mappedBy="blxUsuario", fetch=FetchType.EAGER)
	@Expose
	private List<Anuncio> blxAnuncios;

	public Usuario() {}

	public Usuario(long codUsuario, String nmNome, String vlEmail, String vlLogin, String vlCpf, String vlSenha,
			Integer vlStatus, TipoUsuario blxTipoUsuario) {
		super();
		this.codUsuario = codUsuario;
		this.nmNome = nmNome;
		this.vlEmail = vlEmail;
		this.vlLogin = vlLogin;
		this.vlCpf = vlCpf;
		this.vlSenha = vlSenha;
		this.vlStatus = vlStatus;
		this.blxTipoUsuario = blxTipoUsuario;
	}

	public Usuario(long codUsuario, String nmNome, String vlEmail, String vlLogin, String vlCpf, String vlSenha,
			Integer vlStatus, List<Anuncio> blxAnuncios, List<Contato> blxContatos, TipoUsuario blxTipoUsuario) {
		super();
		this.codUsuario = codUsuario;
		this.nmNome = nmNome;
		this.vlEmail = vlEmail;
		this.vlLogin = vlLogin;
		this.vlCpf = vlCpf;
		this.vlSenha = vlSenha;
		this.vlStatus = vlStatus;
		this.blxTipoUsuario = blxTipoUsuario;
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

	public String getVlCpf() {
		return this.vlCpf;
	}

	public void setVlCpf(String vlCpf) {
		this.vlCpf = vlCpf;
	}

	public String getVlSenha() {
		return this.vlSenha;
	}

	public void setVlSenha(String vlSenha) {
		this.vlSenha = vlSenha;
	}

	public Integer getVlStatus() {
		return this.vlStatus;
	}

	public void setVlStatus(Integer vlStatus) {
		this.vlStatus = vlStatus;
	}
	
	public TipoUsuario getBlxTipoUsuario() {
		return blxTipoUsuario;
	}

	public void setBlxTipoUsuario(TipoUsuario blxTipoUsuario) {
		this.blxTipoUsuario = blxTipoUsuario;
	}

	public List<Contato> getBlxContatos() {
		return blxContatos;
	}

	public void setBlxContatos(List<Contato> blxContatos) {
		this.blxContatos = blxContatos;
	}

	public List<Anuncio> getBlxAnuncios() {
		return blxAnuncios;
	}

	public void setBlxAnuncios(List<Anuncio> blxAnuncios) {
		this.blxAnuncios = blxAnuncios;
	}

	public String getVlSkype() {
		return vlSkype;
	}

	public void setVlSkype(String vlSkype) {
		this.vlSkype = vlSkype;
	}

	@Override
	public String toString() {
		return "Usuario [codUsuario=" + codUsuario + ", nmNome=" + nmNome + ", vlEmail=" + vlEmail + ", vlLogin="
				+ vlLogin + ", vlRg=" + vlCpf + ", vlSenha=" + vlSenha + ", vlStatus=" + vlStatus + ", blxTipousuario="
				+ blxTipoUsuario + "]";
	}
}