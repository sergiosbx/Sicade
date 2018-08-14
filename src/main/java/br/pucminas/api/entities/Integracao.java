package br.pucminas.api.entities;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "integracao")
public class Integracao implements Serializable {

	private static final long serialVersionUID = 6309845788527232032L;

	private Long id;
	private Resultado resultado;
	private Date dtaIntegracao;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToMany(mappedBy = "integracao", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
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
