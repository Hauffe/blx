package com.brq.blx.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.google.gson.annotations.Expose;

import java.util.List;

@Entity
@Table(name = "BLX_CONTATO")
@NamedQuery(name = "Contato.findAll", query = "SELECT b FROM Contato b")
public class Contato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "BLX_CONTATO_CODCONTATO_GENERATOR", sequenceName = "SEQ_ID_CONTATO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BLX_CONTATO_CODCONTATO_GENERATOR")
	@Column(name = "COD_CONTATO")
	@Expose
	private long codContato;

	@Column(name = "VL_TELEFONEFIXO")
	@Expose
	private String vlTelefoneFixo;

	@Column(name = "VL_TELEFONEMOVEL")
	@Expose
	private String vlTelefoneMovel;
	

	/* RELAÇÕES JOINCOLUMN */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ENDERECO_COD_ENDERECO")
	@Expose
	private Endereco blxEndereco;
	
	@ManyToOne
	@JoinColumn(name = "USUARIO_COD_USUARIO") 
	private Usuario blxUsuario;
	
	/*Relacoes*/
	
	@OneToMany(mappedBy="blxContato", fetch=FetchType.EAGER)
	private List<Anuncio> blxAnuncios;

	public Contato() {}

	public Contato(long codContato, String vlTelefonefixo, String vlTelefonemovel) {
		super();
		this.codContato = codContato;
		this.vlTelefoneFixo = vlTelefonefixo;
		this.vlTelefoneMovel = vlTelefonemovel;
	}
	
	public Contato(long codContato, String vlTelefoneFixo, String vlTelefoneMovel, Usuario blxUsuario) {
		super();
		this.codContato = codContato;
		this.vlTelefoneFixo = vlTelefoneFixo;
		this.vlTelefoneMovel = vlTelefoneMovel;
		this.blxUsuario = blxUsuario;
	}

	public Contato(long codContato, String vlTelefoneFixo, String vlTelefoneMovel, List<Anuncio> blxAnuncios,
			Usuario blxUsuario, List<Endereco> blxEnderecos) {
		super();
		this.codContato = codContato;
		this.vlTelefoneFixo = vlTelefoneFixo;
		this.vlTelefoneMovel = vlTelefoneMovel;
		this.blxUsuario = blxUsuario;
		
	}

	public Endereco getBlxEndereco() {
		return blxEndereco;
	}

	public void setBlxEndereco(Endereco blxEndereco) {
		this.blxEndereco = blxEndereco;
	}

	public Usuario getBlxUsuario() {
		return blxUsuario;
	}

	public void setBlxUsuario(Usuario blxUsuario) {
		this.blxUsuario = blxUsuario;
	}

	public long getCodContato() {
		return this.codContato;
	}

	public void setCodContato(long codContato) {
		this.codContato = codContato;
	}

	public String getVlTelefoneFixo() {
		return this.vlTelefoneFixo;
	}

	public void setVlTelefoneFixo(String vlTelefonefixo) {
		this.vlTelefoneFixo = vlTelefonefixo;
	}

	public String getVlTelefoneMovel() {
		return this.vlTelefoneMovel;
	}

	public void setVlTelefoneMovel(String vlTelefonemovel) {
		this.vlTelefoneMovel = vlTelefonemovel;
	}

	@Override
	public String toString() {
		return "Contato [codContato=" + codContato + ", vlTelefonefixo=" + vlTelefoneFixo + ", vlTelefonemovel="
				+ vlTelefoneMovel + ", blxUsuario=" + blxUsuario + "]";
	}
}