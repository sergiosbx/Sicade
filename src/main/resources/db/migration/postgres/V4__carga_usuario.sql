ALTER TABLE usuario ALTER COLUMN senha TYPE character varying(250);
DELETE FROM usuario WHERE email = 'adm@sicade.com.br';
INSERT INTO usuario (email, senha, perfil) VALUES
('adm@sicade.com.br','$2a$10$mGENmHzO6auxgbLAXuixpOwQrxnmmOylY9uhHTQ0meLeP90FsFriq','ROLE_ADMIN');