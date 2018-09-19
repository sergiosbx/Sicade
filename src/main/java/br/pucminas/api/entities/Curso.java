package br.pucminas.api.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "curso")
public class Curso implements Serializable {

	private static final long serialVersionUID = 8913272793070855004L;

	private Long id;
	private String descricao;
	private String segmento;
	private String periodo;
	private Set<Aluno> alunos = new HashSet<>();

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(
		name = "curso_aluno",
		joinColumns = @JoinColumn(name = "id_curso"),
		inverseJoinColumns = @JoinColumn(name = "id_aluno")
	)
	public Set<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}

	@Column( name = "descricao", nullable = false )
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column( name = "segmento", nullable = false )
	public String getSegmento() {
		return segmento;
	}

	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}

	@Column( name = "periodo", nullable = false )
	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", descricao=" + descricao + ", segmento=" + segmento + ", periodo=" + periodo + "]";
	}
	
}
