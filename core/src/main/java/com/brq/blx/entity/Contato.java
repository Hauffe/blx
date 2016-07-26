package com.brq.blx.entity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * The persistent class for the BLX_CONTATO database table.
 * 
 */
@Entity
@Table(name="BLX_CONTATO")
@NamedQuery(name="Contato.findAll", query="SELECT c FROM Contato c")
public class Contato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BLX_CONTATO_CODCONTATO_GENERATOR", sequenceName="SEQ_ID_CONTATO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BLX_CONTATO_CODCONTATO_GENERATOR")
	@Column(name="COD_CONTATO")
	@Expose
	private long codContato;

	@Column(name="VL_TELEFONEFIXO")
	@Expose
	private String vlTelefoneFixo;

	@Column(name="VL_TELEFONEMOVEL")
	@Expose
	private String vlTelefoneMovel;

	//bi-directional many-to-one association to Anuncio
	@OneToMany(mappedBy="blxContato")
	private List<Anuncio> blxAnuncios;

	//bi-directional many-to-one association to Endereco
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ENDERECO_COD_ENDERECO")
	@Expose
	private Endereco blxEndereco;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="blxContato")
	private List<Usuario> blxUsuarios;

	public Contato() {
	}

	public long getCodContato() {
		return this.codContato;
	}

	public void setCodContato(long codContato) {
		this.codContato = codContato;
	}

	public String getVlTelefoneFixo() {
		return vlTelefoneFixo;
	}

	public void setVlTelefoneFixo(String vlTelefoneFixo) {
		this.vlTelefoneFixo = vlTelefoneFixo;
	}

	public String getVlTelefoneMovel() {
		return vlTelefoneMovel;
	}

	public void setVlTelefoneMovel(String vlTelefoneMovel) {
		this.vlTelefoneMovel = vlTelefoneMovel;
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

	public Endereco getBlxEndereco() {
		return this.blxEndereco;
	}

	public void setBlxEndereco(Endereco blxEndereco) {
		this.blxEndereco = blxEndereco;
	}

	public List<Usuario> getBlxUsuarios() {
		return this.blxUsuarios;
	}

	public void setBlxUsuarios(List<Usuario> blxUsuarios) {
		this.blxUsuarios = blxUsuarios;
	}

	public Usuario addBlxUsuario(Usuario blxUsuario) {
		getBlxUsuarios().add(blxUsuario);
		blxUsuario.setBlxContato(this);

		return blxUsuario;
	}

	public Usuario removeBlxUsuario(Usuario blxUsuario) {
		getBlxUsuarios().remove(blxUsuario);
		blxUsuario.setBlxContato(null);

		return blxUsuario;
	}

	@Override
	public String toString() {
		return "Contato [codContato=" + codContato + ", vlTelefoneFixo=" + vlTelefoneFixo + ", vlTelefoneMovel="
				+ vlTelefoneMovel + ", blxAnuncios=" + blxAnuncios + ", blxEndereco=" + blxEndereco + ", blxUsuarios="
				+ blxUsuarios + "]";
	}
	
	

}