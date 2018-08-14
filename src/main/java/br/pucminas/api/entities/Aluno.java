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

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "aluno")
public class Aluno implements Serializable {

	private static final long serialVersionUID = 2988578591926756875L;

	private Long id;
	private String nome;
	private Integer cpf;
	private Date dtaNascimento;
	private String endereco;
	private Set<Curso> cursos = new HashSet<>();
	private Set<Materia> materias = new HashSet<>();

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToMany(mappedBy = "alunos")//aluno ?
	public Set<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "resultado",
		joinColumns =  @JoinColumn(name = "id_aluno"),
		inverseJoinColumns =  @JoinColumn(name = "id_materia")
	)
	public Set<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(Set<Materia> materias) {
		this.materias = materias;
	}

	@NaturalId
	@Column( name = "nome", nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column( name = "cpf", nullable = false)
	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	@Temporal(TemporalType.DATE)
	@Column( name = "dta_nascimento", nullable = false)
	public Date getDtaNascimento() {
		return dtaNascimento;
	}

	public void setDtaNascimento(Date dtaNascimento) {
		this.dtaNascimento = dtaNascimento;
	}

	@Column( name = "endereco")
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", dtaNascimento=" + dtaNascimento
				+ ", endereco=" + endereco + "]";
	}

}
