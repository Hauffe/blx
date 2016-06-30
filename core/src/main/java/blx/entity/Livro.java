package blx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*
 * No banco 
 * create sequence seqlivro;
 * 
 * create table tblivro(
 *    idlivro integer primary key,
 *    titulo varchar(30),
 *    isbn varchar(255) unique,
 *    categoria varchar(255),
 *    resumo varchar(255) 
 * );
 * 
 * insert into values(seqlivro.nextval)
 */
//Classe Livro � uma entidade no banco de dados
@Entity
//Que no banco o nome da tabela � tblivro
@Table(name="tblivro")
//Criar a sequencia seqlivro
@SequenceGenerator(name="seqlivro", sequenceName="seqlivro")
public class Livro {
	
	//Chave prim�ria do banco de dados
	@Id
	//Utilizar Sequence no banco (seqlivro)
	@GeneratedValue(generator="seqlivro")
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer idLivro;
	@Column(length=30)
	private String titulo;
	@Column(unique=true)
	private String isbn;
	@Column
	private String categoria;
	@Column
	private String resumo;
	
	public Livro(Integer idLivro, String titulo, String isbn, String categoria,
			String resumo) {
		super();
		this.idLivro = idLivro;
		this.titulo = titulo;
		this.isbn = isbn;
		this.categoria = categoria;
		this.resumo = resumo;
	}
	public Livro() {
		super();
	}
	public Integer getIdLivro() {
		return idLivro;
	}
	public void setIdLivro(Integer idLivro) {
		this.idLivro = idLivro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	@Override
	public String toString() {
		return "Livro [idLivro=" + idLivro + ", titulo=" + titulo + ", isbn="
				+ isbn + ", categoria=" + categoria + ", resumo=" + resumo
				+ "]";
	}
}
