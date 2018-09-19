package br.pucminas.api.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucminas.api.constants.Mensagem;
import br.pucminas.api.constants.Validador;
import br.pucminas.api.dtos.CursoDto;
import br.pucminas.api.entities.Curso;
import br.pucminas.api.response.Response;
import br.pucminas.api.services.CursoService;

@RestController
@RequestMapping("/api/curso")
@CrossOrigin(origins = "*")
public class CursoController {

	@Autowired
	private CursoService cursoService;
	
	@PostMapping
	public ResponseEntity<Response<Curso>> inserir(@RequestBody CursoDto cursoDto) {
		Response<Curso> response = new Response<Curso>();
		List<String> erros = Validador.validate(cursoDto);
		
		if (!erros.isEmpty()) {
			response.setErro(erros.get(0));
			return ResponseEntity.badRequest().body(response);
		}
		
		try {
			Curso curso = this.converterDtoParaCurso(cursoDto);
			response.setData(cursoService.inserir(curso));
		} catch (Exception e) {
			response.setErro(Mensagem.ERRO.SALVAR);
		}

		return ResponseEntity.ok(response);
	}
	
	@GetMapping
	public ResponseEntity<Response<List<CursoDto>>> listar() {
		Response<List<CursoDto>> response = new Response<List<CursoDto>>();

		List<CursoDto> cursos = cursoService.listar()
				.stream()
				.map(this::converterCursoParaDto)
				.collect(Collectors.toList());

		response.setData(cursos);

		return ResponseEntity.ok(response);
	}
	
	private CursoDto converterCursoParaDto(Curso curso) {
		CursoDto cursoDto = new CursoDto();
		cursoDto.setId(Optional.of(curso.getId()));
		cursoDto.setDescricao(curso.getDescricao());
		cursoDto.setSegmento(curso.getSegmento());
		cursoDto.setPeriodo(curso.getPeriodo());
		
		return cursoDto;
	}
	
	private Curso converterDtoParaCurso(CursoDto cursoDto) {
		Curso curso = new Curso();
		curso.setDescricao(cursoDto.getDescricao());
		curso.setSegmento(cursoDto.getSegmento());
		curso.setPeriodo(cursoDto.getPeriodo());
		
		return curso;
	}
}
