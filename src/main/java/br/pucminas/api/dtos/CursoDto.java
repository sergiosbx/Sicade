package br.pucminas.api.dtos;

import java.util.Optional;

import javax.validation.constraints.NotNull;

public class CursoDto {

	private Optional<Long> id = Optional.empty();
	private String descricao;
	private String segmento;
	private String periodo;

	public Optional<Long> getId() {
		return id;
	}

	public void setId(Optional<Long> id) {
		this.id = id;
	}

	@NotNull( message = "Campo obrigatório não informado: Descrição" )
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@NotNull( message = "Campo obrigatório não informado: Segmento" )
	public String getSegmento() {
		return segmento;
	}

	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
	@Override
	public String toString() {
		return "CursoDto [id=" + id + ", descricao=" + descricao + ", segmento=" + segmento + ", periodo=" + periodo + "]";
	}
	
}
