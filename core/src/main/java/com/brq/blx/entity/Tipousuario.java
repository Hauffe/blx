package com.brq.blx.entity;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the BLX_TIPOUSUARIO database table.
 * 
 */
@Entity
@Table(name="BLX_TIPOUSUARIO")
@NamedQuery(name="Tipousuario.findAll", query="SELECT b FROM Tipousuario b")
public class Tipousuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BLX_TIPOUSUARIO_CODTIPOUSUARIO_GENERATOR", sequenceName="SEQ_ID_TIPOUSUARIO", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BLX_TIPOUSUARIO_CODTIPOUSUARIO_GENERATOR")
	@Column(name="COD_TIPOUSUARIO")
	private long codTipousuario;

	@Column(name="VL_TIPO")
	private String vlTipo;

	//bi-directional many-to-one association to BlxUsuario
/*	@OneToMany(mappedBy="blxTipousuario")
	private List<Usuario> blxUsuarios;*/
	

	public Tipousuario() {
	}

	public Tipousuario(long codTipousuario, String vlTipo) {
		super();
		this.codTipousuario = codTipousuario;
		this.vlTipo = vlTipo;
	}

	
	public long getCodTipousuario() {
		return this.codTipousuario;
	}

	public void setCodTipousuario(long codTipousuario) {
		this.codTipousuario = codTipousuario;
	}

	public String getVlTipo() {
		return this.vlTipo;
	}

	public void setVlTipo(String vlTipo) {
		this.vlTipo = vlTipo;
	}

}