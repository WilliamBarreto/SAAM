/*
	CRIANDO BANCO DE DADOS 'saam'
*/

DROP DATABASE IF EXISTS saam;
CREATE DATABASE saam;
ALTER SCHEMA saam  DEFAULT CHARACTER SET utf8 ;

USE saam;

/*
	CRIANDO TABELAS
	
*/

/*
	Tabela: funcionalidades
 */
CREATE TABLE funcionalidades(
	id_funcionalidade INT(11) NOT NULL AUTO_INCREMENT,
	nome VARCHAR(45),
	PRIMARY KEY (id_funcionalidade)
);


/*
	Tabela: perfis
 */
CREATE TABLE perfis(
	id_perfil INT(11) NOT NULL AUTO_INCREMENT,
	nome VARCHAR(45),
	PRIMARY KEY (id_perfil)
);

/*
	Tabela: perf_func
	Estï¿½ tabela ï¿½ da associaï¿½ï¿½o entre a tabela perfis e funcionalidades
 */	
CREATE TABLE perf_func(
	id_perfil INT(11) NOT NULL,
	id_funcionalidade INT(11) NOT NULL,
	PRIMARY KEY(id_perfil,id_funcionalidade)
);

/*
	Tabela: usuarios
 */
CREATE TABLE usuarios(
	id_usuario INT(11) NOT NULL AUTO_INCREMENT,
	usuario VARCHAR(20),
	senha VARCHAR(15),
	id_perfil INT(11),
	PRIMARY KEY(id_usuario)
);

CREATE TABLE areas(
	id_area INT(11) NOT NULL AUTO_INCREMENT,
	nome VARCHAR(30),
	PRIMARY KEY (id_area)
);

CREATE TABLE voluntarios(
	id_voluntario INT(11) NOT NULL AUTO_INCREMENT,
	nome VARCHAR(50),
	email VARCHAR(40),
	telefone VARCHAR(10),
	sexo VARCHAR(2),
	id_area	INT (11) NOT NULL,
	PRIMARY KEY(id_voluntario)
);

/*
	Tabela: Perguntas Frequentes
 */

CREATE TABLE perguntas_frequentes(
 id_pergunta_frequente INT(11) NOT NULL AUTO_INCREMENT,
 pergunta VARCHAR(255),
 resposta VARCHAR(255),
 data_publicacao DATE,
 id_area INT(11) NOT NULL,
 PRIMARY KEY(id_pergunta_frequente)
);

/*
	CRIANDO CHAVES ESTRANGEIRAS
 */
ALTER TABLE usuarios ADD CONSTRAINT fk_usuario_id_perfil FOREIGN KEY(id_perfil) REFERENCES perfis(id_perfil);
ALTER TABLE perf_func ADD CONSTRAINT fk_perf_func_id_perfil FOREIGN KEY(id_perfil) REFERENCES perfis(id_perfil);
ALTER TABLE perf_func ADD CONSTRAINT fk_perf_func_id_funcionalidade FOREIGN KEY(id_funcionalidade) REFERENCES funcionalidades(id_funcionalidade);
ALTER TABLE voluntarios ADD CONSTRAINT fk_voluntario_id_area FOREIGN KEY (id_area) REFERENCES areas(id_area);
ALTER TABLE perguntas_frequentes ADD CONSTRAINT fk_perguntas_frequentes_id_area FOREIGN KEY (id_area) REFERENCES areas(id_area);

/*
	INSERINDO DADOS
*/

/*
 	Inserindo funcionalidades
 
 */

INSERT INTO funcionalidades VALUES (NULL,'Solicitar Atendimento');/* 1 */
INSERT INTO funcionalidades VALUES (NULL,'Atender Vitima');/* 2 */
INSERT INTO funcionalidades VALUES (NULL,'Consultar histórico de atendimentos');/* 3 */
INSERT INTO funcionalidades VALUES (NULL,'Atender Mensagens');/* 4 */
INSERT INTO funcionalidades VALUES (NULL,'Manter Atendentes');/* 5 */
INSERT INTO funcionalidades VALUES (NULL,'Manter Usuários');/* 6 */
INSERT INTO funcionalidades VALUES (NULL,'Manter Perfil');/* 7 */
INSERT INTO funcionalidades VALUES (NULL,'Avaliar Cadastro de Atendentes');/* 8 */
INSERT INTO funcionalidades VALUES (NULL,'Consultar Logs');/* 9 */
INSERT INTO funcionalidades VALUES (NULL,'Manter Perguntas Frequentes');/* 10 */
INSERT INTO funcionalidades VALUES (NULL,'Relatório de Atendimentos');/* 11 */
INSERT INTO funcionalidades VALUES (NULL,'Relatório de Acessos');/* 12 */
INSERT INTO funcionalidades VALUES (NULL,'Relatório de Avaliações');/* 13 */
INSERT INTO funcionalidades VALUES (NULL,'Relatório de Pessoas');/* 14 */

/*
 	Inserindo perfis 
 
 */

INSERT INTO perfis VALUES(NULL,'Administrador');
INSERT INTO perfis VALUES(NULL,'Atendente');
INSERT INTO perfis VALUES(NULL,'Diretoria');
INSERT INTO perfis VALUES(NULL,'Gerente');
INSERT INTO perfis VALUES(NULL,'Mulher');

/*
 Funções do Admnistrador
 
 */
INSERT INTO perf_func VALUES(1,3);
INSERT INTO perf_func VALUES(1,5);
INSERT INTO perf_func VALUES(1,6);
INSERT INTO perf_func VALUES(1,7);
INSERT INTO perf_func VALUES(1,9);

/*
 
 Funções do Atendente
 
 */
INSERT INTO perf_func VALUES(2,2);
INSERT INTO perf_func VALUES(2,3);
INSERT INTO perf_func VALUES(2,4);

/*
 
 Funções da Diretoria
 
 */
INSERT INTO perf_func VALUES(3,11);
INSERT INTO perf_func VALUES(3,12);
INSERT INTO perf_func VALUES(3,13);
INSERT INTO perf_func VALUES(3,14);

/*
 
 Funções do Gerente
 
 */
INSERT INTO perf_func VALUES(4,3);
INSERT INTO perf_func VALUES(4,10);
INSERT INTO perf_func VALUES(4,11);
INSERT INTO perf_func VALUES(4,12);
INSERT INTO perf_func VALUES(4,13);
INSERT INTO perf_func VALUES(4,14);

/*
 
 Funções da Mulher
 
 */
INSERT INTO perf_func VALUES(5,1);
INSERT INTO perf_func VALUES(5,3);

/*
	Inserindo usuarios
  
*/

INSERT INTO usuarios VALUES(NULL,'admin','admin',1);
INSERT INTO usuarios VALUES(NULL,'atendente','atendente',2);
INSERT INTO usuarios VALUES(NULL,'diretoria','diretoria',3);
INSERT INTO usuarios VALUES(NULL,'gerente','gerente',4);
INSERT INTO usuarios VALUES(NULL,'mulher','mulher',5);

/*
 	Inserindo areas
*/

INSERT INTO areas VALUES(NULL,'Jurídica');
INSERT INTO areas VALUES(NULL,'Social');
INSERT INTO areas VALUES(NULL,'Psicológica');

/*
 
 VERIFICANDO RESULTADOS

*/
DESCRIBE usuarios;
DESCRIBE perfis;
DESCRIBE perf_func;
DESCRIBE funcionalidades;


SELECT * FROM usuarios;
SELECT * FROM perfis;
SELECT * FROM funcionalidades;
SELECT * FROM perf_func;
SELECT * FROM areas;



