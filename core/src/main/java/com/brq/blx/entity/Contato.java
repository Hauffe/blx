package com.brq.blx.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the BLX_CONTATO database table.
 * 
 */
@Entity
@Table(name = "BLX_CONTATO")
@NamedQuery(name = "Contato.findAll", query = "SELECT b FROM Contato b")
public class Contato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "BLX_CONTATO_CODCONTATO_GENERATOR", sequenceName = "SEQ_ID_CONTATO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BLX_CONTATO_CODCONTATO_GENERATOR")
	@Column(name = "COD_CONTATO")
	private long codContato;

	@Column(name = "VL_TELEFONEFIXO")
	private String vlTelefonefixo;

	@Column(name = "VL_TELEFONEMOVEL")
	private String vlTelefonemovel;

	// bi-directional many-to-one association to BlxAnuncio
	@OneToMany(mappedBy = "blxContato")
	private List<Anuncio> blxAnuncios;

	// bi-directional many-to-one association to BlxUsuario
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "USUARIO_COD_USUARIO") private Usuario blxUsuario;
	 */

	@Column(name = "USUARIO_COD_USUARIO")
	private long pk_usuario;

	// bi-directional many-to-one association to BlxEndereco
	@OneToMany(mappedBy = "blxContato")
	private List<Endereco> blxEnderecos;

	public Contato() {
	}

	public Contato(long codContato, String vlTelefonefixo, String vlTelefonemovel) {
		super();
		this.codContato = codContato;
		this.vlTelefonefixo = vlTelefonefixo;
		this.vlTelefonemovel = vlTelefonemovel;
	}

	public Contato(long codContato, String vlTelefonefixo, String vlTelefonemovel, List<Anuncio> blxAnuncios,
			long pk_usuario, List<Endereco> blxEnderecos) {
		super();
		this.codContato = codContato;
		this.vlTelefonefixo = vlTelefonefixo;
		this.vlTelefonemovel = vlTelefonemovel;
		this.blxAnuncios = blxAnuncios;
		this.pk_usuario = pk_usuario;
		this.blxEnderecos = blxEnderecos;
	}

	public long getCodContato() {
		return this.codContato;
	}

	public void setCodContato(long codContato) {
		this.codContato = codContato;
	}

	public String getVlTelefonefixo() {
		return this.vlTelefonefixo;
	}

	public void setVlTelefonefixo(String vlTelefonefixo) {
		this.vlTelefonefixo = vlTelefonefixo;
	}

	public String getVlTelefonemovel() {
		return this.vlTelefonemovel;
	}

	public void setVlTelefonemovel(String vlTelefonemovel) {
		this.vlTelefonemovel = vlTelefonemovel;
	}

	public List<Anuncio> getBlxAnuncios() {
		return this.blxAnuncios;
	}

	public void setBlxAnuncios(List<Anuncio> blxAnuncios) {
		this.blxAnuncios = blxAnuncios;
	}



	public long getPk_usuario() {
		return pk_usuario;
	}

	public void setPk_usuario(long pk_usuario) {
		this.pk_usuario = pk_usuario;
	}

	public List<Endereco> getBlxEnderecos() {
		return this.blxEnderecos;
	}

	public void setBlxEnderecos(List<Endereco> blxEnderecos) {
		this.blxEnderecos = blxEnderecos;
	}

}