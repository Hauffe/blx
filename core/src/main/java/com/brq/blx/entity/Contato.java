package com.brq.blx.entity;

import java.io.Serializable;
import javax.persistence.*;
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
	private long codContato;

	@Column(name = "VL_TELEFONEFIXO")
	private String vlTelefonefixo;

	@Column(name = "VL_TELEFONEMOVEL")
	private String vlTelefonemovel;
	
	/* RELAÇÕES */

	@OneToMany(mappedBy = "blxContato")
	private List<Anuncio> blxAnuncios;
	
	@OneToMany(mappedBy = "blxContato")
	private List<Endereco> blxEnderecos;

	/* RELAÇÕES JOINCOLUMN */
	
	@ManyToOne
	@JoinColumn(name = "USUARIO_COD_USUARIO") 
	private Usuario blxUsuario;

	public Contato() {}

	public Contato(long codContato, String vlTelefonefixo, String vlTelefonemovel) {
		super();
		this.codContato = codContato;
		this.vlTelefonefixo = vlTelefonefixo;
		this.vlTelefonemovel = vlTelefonemovel;
	}
	
	public Contato(long codContato, String vlTelefonefixo, String vlTelefonemovel, Usuario blxUsuario) {
		super();
		this.codContato = codContato;
		this.vlTelefonefixo = vlTelefonefixo;
		this.vlTelefonemovel = vlTelefonemovel;
		this.blxUsuario = blxUsuario;
	}

	public Contato(long codContato, String vlTelefonefixo, String vlTelefonemovel, List<Anuncio> blxAnuncios,
			Usuario blxUsuario, List<Endereco> blxEnderecos) {
		super();
		this.codContato = codContato;
		this.vlTelefonefixo = vlTelefonefixo;
		this.vlTelefonemovel = vlTelefonemovel;
		this.blxAnuncios = blxAnuncios;
		this.blxUsuario = blxUsuario;
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

	public List<Endereco> getBlxEnderecos() {
		return this.blxEnderecos;
	}

	public void setBlxEnderecos(List<Endereco> blxEnderecos) {
		this.blxEnderecos = blxEnderecos;
	}

	@Override
	public String toString() {
		return "Contato [codContato=" + codContato + ", vlTelefonefixo=" + vlTelefonefixo + ", vlTelefonemovel="
				+ vlTelefonemovel + ", blxUsuario=" + blxUsuario + "]";
	}
}