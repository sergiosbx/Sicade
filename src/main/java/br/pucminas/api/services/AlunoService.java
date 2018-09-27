package br.pucminas.api.services;

import java.util.List;

import br.pucminas.api.entities.Aluno;

public interface AlunoService {

	List<Aluno> listar();
	
	Aluno inserir(Aluno curso);
	Aluno atualizar(Aluno curso);
}
