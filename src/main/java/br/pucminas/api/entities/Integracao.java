package br.pucminas.api.entities;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "integracao")
public class Integracao implements Serializable {

	private static final long serialVersionUID = 6309845788527232032L;

	private Long id;
	private Set<Resultado> resultado;
	private Date dtaIntegracao;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_resultado")
	public Set<Resultado> getResultado() {
		return resultado;
	}

	public void setResultado(Set<Resultado> resultado) {
		this.resultado = resultado;
	}

	@Column(name = "dta_integracao", nullable = false)
	public Date getDtaIntegracao() {
		return dtaIntegracao;
	}
	
	@PreUpdate
    public void preUpdate() {
        dtaIntegracao = Date.valueOf(LocalDate.now());
    }
     
    @PrePersist
    public void prePersist() {
        final Date atual = Date.valueOf(LocalDate.now());
        dtaIntegracao = atual;
    }

	public void setDtaIntegracao(Date dtaIntegracao) {
		this.dtaIntegracao = dtaIntegracao;
	}

}
