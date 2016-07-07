package com.brq.blx.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "BLX_USUARIO")
@NamedQuery(name = "Usuario.findAll", query = "SELECT b FROM Usuario b")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	
	/*
	 * Solução do problema referente a sequência do Hibernate: Primeiramente
	 * você deve colocar a anotação [ allocationSize = 1 ] dentro da
	 * anotação @SequenceGenerator, caso isso não resolva, troque manualmente o
	 * valor do incrementBy dentro do SQLDEVELOPER
	 */

	/*
	 * OBSERVE: ALGUMAS COLUNAS QUE DEVERIAM POSSUIR A ATRIBUIÇÃO "UNIQUE" NÃO
	 * POSSUEM A CARACTERÍSTICA DE VALOR "ÚNICO", POIS ESTAMOS EM FASE DE TESTE
	 * LOGO MAIS ADICIONAREMOS NAS ANOTAÇÕES @Column a anotação: (unique = true)
	 */

	@Id
	@SequenceGenerator(name = "BLX_USUARIO_CODUSUARIO_GENERATOR", sequenceName = "BLXSEQ_ID_USUARIO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BLX_USUARIO_CODUSUARIO_GENERATOR")
	@Column(name = "COD_USUARIO")
	private long codUsuario;

	@Column(name = "NM_NOME")
	private String nmNome;

	@Column(name = "VL_EMAIL")
	private String vlEmail;

	@Column(name = "VL_LOGIN")
	private String vlLogin;

	@Column(name = "VL_RG")
	private String vlRg;

	@Column(name = "VL_SENHA")
	private String vlSenha;

	@Column(name = "VL_STATUS")
	private Integer vlStatus;

	/* RELAÇÕES JOINCOLUMN */
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "TIPOUSUARIO_COD_TIPOUSUARIO")
	private TipoUsuario blxTipousuario;

	public Usuario() {}

	public Usuario(long codUsuario, String nmNome, String vlEmail, String vlLogin, String vlRg, String vlSenha,
			Integer vlStatus, TipoUsuario blxTipousuario) {
		super();
		this.codUsuario = codUsuario;
		this.nmNome = nmNome;
		this.vlEmail = vlEmail;
		this.vlLogin = vlLogin;
		this.vlRg = vlRg;
		this.vlSenha = vlSenha;
		this.vlStatus = vlStatus;
		this.blxTipousuario = blxTipousuario;
	}

	public Usuario(long codUsuario, String nmNome, String vlEmail, String vlLogin, String vlRg, String vlSenha,
			Integer vlStatus, List<Anuncio> blxAnuncios, List<Contato> blxContatos, TipoUsuario blxTipousuario) {
		super();
		this.codUsuario = codUsuario;
		this.nmNome = nmNome;
		this.vlEmail = vlEmail;
		this.vlLogin = vlLogin;
		this.vlRg = vlRg;
		this.vlSenha = vlSenha;
		this.vlStatus = vlStatus;
		this.blxTipousuario = blxTipousuario;
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

	public Integer getVlStatus() {
		return this.vlStatus;
	}

	public void setVlStatus(Integer vlStatus) {
		this.vlStatus = vlStatus;
	}

	public TipoUsuario getBlxTipousuario() {
		return blxTipousuario;
	}

	public void setBlxTipousuario(TipoUsuario blxTipousuario) {
		this.blxTipousuario = blxTipousuario;
	}

	@Override
	public String toString() {
		return "Usuario [codUsuario=" + codUsuario + ", nmNome=" + nmNome + ", vlEmail=" + vlEmail + ", vlLogin="
				+ vlLogin + ", vlRg=" + vlRg + ", vlSenha=" + vlSenha + ", vlStatus=" + vlStatus + ", blxTipousuario="
				+ blxTipousuario + "]";
	}
}