package com.brq.blx.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;


/**
 * The persistent class for the BLX_NOTIFICACAO database table.
 * 
 */
@Entity
@Table(name="BLX_NOTIFICACAO")
@NamedQuery(name="Notificacao.findAll", query="SELECT n FROM Notificacao n")
public class Notificacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BLX_NOTIFICACAO_CODNOTIFICACAO_GENERATOR", sequenceName="SEQ_ID_NOTIFICACAO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BLX_NOTIFICACAO_CODNOTIFICACAO_GENERATOR")
	@Column(name="COD_NOTIFICACAO")
	@Expose
	private long codNotificacao;

	@Expose
	@Column
	private String idsala;

	//bi-directional many-to-one association to Anuncio
	@ManyToOne
	@JoinColumn(name="ANUNCIO_COD_ANUNCIO")
	@Expose
	private Anuncio blxAnuncio;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="COD_USUARIO_NOTIFICADO")
	@Expose
	private Usuario blxUsuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="USUARIO_COD_USUARIO")
	@Expose
	private Usuario blxUsuario2;

	public Notificacao() {
	}

	public long getCodNotificacao() {
		return this.codNotificacao;
	}

	public void setCodNotificacao(long codNotificacao) {
		this.codNotificacao = codNotificacao;
	}

	public String getIdsala() {
		return idsala;
	}

	public void setIdsala(String idsala) {
		this.idsala = idsala;
	}

	public Anuncio getBlxAnuncio() {
		return this.blxAnuncio;
	}

	public void setBlxAnuncio(Anuncio blxAnuncio) {
		this.blxAnuncio = blxAnuncio;
	}

	public Usuario getBlxUsuario1() {
		return this.blxUsuario1;
	}

	public void setBlxUsuario1(Usuario blxUsuario1) {
		this.blxUsuario1 = blxUsuario1;
	}

	public Usuario getBlxUsuario2() {
		return this.blxUsuario2;
	}

	public void setBlxUsuario2(Usuario blxUsuario2) {
		this.blxUsuario2 = blxUsuario2;
	}

}