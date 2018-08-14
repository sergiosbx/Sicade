package br.pucminas.api.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "resultado")
public class Resultado implements Serializable {

	private static final long serialVersionUID = -713545263599116642L;

	private Long id;
	private Aluno aluno;
	private Materia materia;
	private BigDecimal nota;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToMany(mappedBy = "resultado", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@OneToMany(mappedBy = "resultado", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	@Column(name = "nota", nullable = false)
	public BigDecimal getNota() {
		return nota;
	}

	public void setNota(BigDecimal nota) {
		this.nota = nota;
	}

}
