DROP TABLE IF EXISTS curso;
CREATE TABLE IF NOT EXISTS curso (
	id SERIAL PRIMARY KEY,
	descricao VARCHAR(100) NOT NULL,
	segmento VARCHAR(50) NOT NULL,
	periodo VARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS aluno;
CREATE TABLE IF NOT EXISTS aluno (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
	cpf SMALLINT NOT NULL,
	dta_nascimento DATE NOT NULL,
	endereco TEXT NOT NULL
);

DROP TABLE IF EXISTS curso_aluno;
CREATE TABLE IF NOT EXISTS curso_aluno (
	id_curso INTEGER NOT NULL,
	id_aluno INTEGER NOT NULL,
	CONSTRAINT fk_curso FOREIGN KEY (id_curso)
		REFERENCES curso (id) MATCH SIMPLE
		ON UPDATE NO ACTION
		ON DELETE NO ACTION,
	CONSTRAINT fk_aluno FOREIGN KEY (id_aluno)
		REFERENCES aluno (id) MATCH SIMPLE
		ON UPDATE NO ACTION
		ON DELETE NO ACTION
);

DROP TABLE IF EXISTS resultado;
CREATE TABLE IF NOT EXISTS resultado (
	id SERIAL PRIMARY KEY,
	id_aluno INTEGER NOT NULL,
	materia VARCHAR(75) NOT NULL,
	nota DECIMAL NOT NULL DEFAULT 0.0,
	CONSTRAINT fk_aluno FOREIGN KEY (id_aluno)
		REFERENCES aluno (id) MATCH SIMPLE
		ON UPDATE NO ACTION
		ON DELETE NO ACTION
);

DROP TABLE IF EXISTS integracao;
CREATE TABLE IF NOT EXISTS integracao (
	id SERIAL PRIMARY KEY,
	id_resultado INTEGER NOT NULL,
	dta_integracao DATE NOT NULL DEFAULT CURRENT_DATE,
	CONSTRAINT fk_resultado FOREIGN KEY (id_resultado)
		REFERENCES resultado (id) MATCH SIMPLE
		ON UPDATE NO ACTION
		ON DELETE NO ACTION
);

DROP TABLE IF EXISTS usuario;
CREATE TABLE IF NOT EXISTS usuario (
	id SERIAL PRIMARY KEY,
	email VARCHAR(75) NOT NULL,
	senha VARCHAR(25) NOT NULL,
	perfil VARCHAR(25) NOT NULL
);