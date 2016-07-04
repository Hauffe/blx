package com.brq.blx.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the BLX_CONTATO database table.
 * 
 */
@Entity
@Table(name="BLX_CONTATO")
@NamedQuery(name="Contato.findAll", query="SELECT b FROM Contato b")
public class Contato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BLX_CONTATO_CODCONTATO_GENERATOR", sequenceName="SEQ_ID_CONTATO", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BLX_CONTATO_CODCONTATO_GENERATOR")
	@Column(name="COD_CONTATO")
	private long codContato;

	@Column(name="VL_TELEFONEFIXO")
	private String vlTelefonefixo;

	@Column(name="VL_TELEFONEMOVEL")
	private String vlTelefonemovel;

	//bi-directional many-to-one association to BlxAnuncio
	@OneToMany(mappedBy="blxContato")
	private List<Anuncio> blxAnuncios;

	//bi-directional many-to-one association to BlxUsuario
	@ManyToOne
	@JoinColumn(name="USUARIO_COD_USUARIO")
	private Usuario blxUsuario;

	//bi-directional many-to-one association to BlxEndereco
	@OneToMany(mappedBy="blxContato")
	private List<Endereco> blxEnderecos;

	public Contato() {
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

	public Anuncio addBlxAnuncio(Anuncio blxAnuncio) {
		getBlxAnuncios().add(blxAnuncio);
		blxAnuncio.setBlxContato(this);

		return blxAnuncio;
	}

	public Anuncio removeBlxAnuncio(Anuncio blxAnuncio) {
		getBlxAnuncios().remove(blxAnuncio);
		blxAnuncio.setBlxContato(null);

		return blxAnuncio;
	}

	public Usuario getBlxUsuario() {
		return this.blxUsuario;
	}

	public void setBlxUsuario(Usuario blxUsuario) {
		this.blxUsuario = blxUsuario;
	}

	public List<Endereco> getBlxEnderecos() {
		return this.blxEnderecos;
	}

	public void setBlxEnderecos(List<Endereco> blxEnderecos) {
		this.blxEnderecos = blxEnderecos;
	}

	public Endereco addBlxEndereco(Endereco blxEndereco) {
		getBlxEnderecos().add(blxEndereco);
		blxEndereco.setBlxContato(this);

		return blxEndereco;
	}

	public Endereco removeBlxEndereco(Endereco blxEndereco) {
		getBlxEnderecos().remove(blxEndereco);
		blxEndereco.setBlxContato(null);

		return blxEndereco;
	}

}