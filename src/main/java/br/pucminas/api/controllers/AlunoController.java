package br.pucminas.api.controllers;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucminas.api.dtos.AlunoDto;
import br.pucminas.api.entities.Aluno;
import br.pucminas.api.response.Response;
import br.pucminas.api.services.AlunoService;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;

	@GetMapping
	public ResponseEntity<Response<List<AlunoDto>>> listar() {
		Response<List<AlunoDto>> response = new Response<List<AlunoDto>>();
		
		List<AlunoDto> alunos = alunoService.listar()
				.stream()
				.map(this::converterAlunoParaDto)
				.collect(Collectors.toList());
		
		response.setData(alunos);
		
		return ResponseEntity.ok(response);
	}
	
	private AlunoDto converterAlunoParaDto(Aluno aluno) {
		AlunoDto alunoDto = new AlunoDto();
		alunoDto.setCpf(aluno.getCpf());
		alunoDto.setDtaNascimento(aluno.getDtaNascimento().toString());
		alunoDto.setEndereco(aluno.getEndereco());
		alunoDto.setId(Optional.of(aluno.getId()));
		alunoDto.setNome(aluno.getNome());
		
		return alunoDto;
	}
	
	private Aluno converterDtoParaAluno(AlunoDto alunoDto) {
		Aluno aluno = new Aluno();
		aluno.setCpf(alunoDto.getCpf());
		aluno.setDtaNascimento(Date.valueOf(alunoDto.getDtaNascimento()));
		aluno.setEndereco(alunoDto.getEndereco());
		aluno.setNome(alunoDto.getNome());
		
		return aluno;
	}
}
