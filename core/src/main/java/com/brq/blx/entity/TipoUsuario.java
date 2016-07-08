package com.brq.blx.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BLX_TIPOUSUARIO")
@NamedQuery(name="TipoUsuario.findAll", query="SELECT b FROM TipoUsuario b")
public class TipoUsuario implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BLX_TIPOUSUARIO_CODTIPOUSUARIO_GENERATOR", sequenceName="SEQ_ID_TIPOUSUARIO", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BLX_TIPOUSUARIO_CODTIPOUSUARIO_GENERATOR")
	@Column(name="COD_TIPOUSUARIO")
	private long codTipoUsuario;

	@Column(name="VL_TIPO")
	private String vlTipo;
	
	public TipoUsuario() {}

	public TipoUsuario(long codTipoUsuario, String vlTipo) {
		super();
		this.codTipoUsuario = codTipoUsuario;
		this.vlTipo = vlTipo;
	}

	public long getCodTipoUsuario() {
		return this.codTipoUsuario;
	}

	public void setCodTipoUsuario(long codTipousuario) {
		this.codTipoUsuario = codTipousuario;
	}

	public String getVlTipo() {
		return this.vlTipo;
	}

	public void setVlTipo(String vlTipo) {
		this.vlTipo = vlTipo;
	}

	@Override
	public String toString() {
		return "TipoUsuario [codTipoUsuario=" + codTipoUsuario + ", vlTipo=" + vlTipo + "]";
	}
}