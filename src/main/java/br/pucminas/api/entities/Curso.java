package br.pucminas.api.entities;

import java.io.Serializable;
import java.sql.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "curso")
public class Curso implements Serializable {

	private static final long serialVersionUID = 8913272793070855004L;

	private Long id;
	private String descricao;
	private String segmento;
	private Date dtaInicio;
	private Date dtaFim;
	private Set<Aluno> alunos = new HashSet<>();

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
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

	@Temporal(TemporalType.DATE)
	@Column( name = "dta_inicio", nullable = false )
	public Date getDtaInicio() {
		return dtaInicio;
	}

	public void setDtaInicio(Date dtaInicio) {
		this.dtaInicio = dtaInicio;
	}

	@Temporal(TemporalType.DATE)
	@Column( name = "dta_fim", nullable = false )
	public Date getDtaFim() {
		return dtaFim;
	}

	public void setDtaFim(Date dtaFim) {
		this.dtaFim = dtaFim;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", descricao=" + descricao + ", segmento=" + segmento + ", dtaInicio=" + dtaInicio
				+ ", dtaFim=" + dtaFim + "]";
	}

}
