INSERT INTO saam.areas (NOME) VALUES ('JURÍDICA');

INSERT INTO saam.areas (NOME) VALUES ('PSICOLÓGICA');

INSERT INTO saam.areas (NOME) VALUES ('SOCIAL');


INSERT INTO saam.perfis (NOME) VALUES ('ADMINISTRADOR');

INSERT INTO saam.perfis (NOME) VALUES ('ATENDENTE');

INSERT INTO saam.perfis (NOME) VALUES ('DIRETORIA');

INSERT INTO saam.perfis (NOME) VALUES ('GERENTE');

INSERT INTO saam.perfis (NOME) VALUES ('MULHER');


INSERT INTO saam.perguntas_frequentes (PERGUNTA, RESPOSTA, DATA_CRIACAO, COD_AREA) VALUES ('TESTANDO UMA PERGUNTA?', 'ESTA AI A RESPOSTA.', '2013-04-13', '1');
INSERT INTO saam.perguntas_frequentes (PERGUNTA, RESPOSTA, DATA_CRIACAO, COD_AREA) VALUES ('TESTANDO OUTRA PERGUNTA?', 'ESTA OUTRA  RESPOSTA.','2013-04-13','2');


INSERT INTO saam.funcionalidades VALUES (NULL,'SOLICITAR ATENDIMENTO','');

INSERT INTO saam.funcionalidades VALUES (NULL,'ATENDER VÍTIMA','');

INSERT INTO saam.funcionalidades VALUES (NULL,'CONSULTAR HISTÓRICO DE ATENDIMENTOS','');

INSERT INTO saam.funcionalidades VALUES (NULL,'ATENDER MENSAGENS','');

INSERT INTO saam.funcionalidades VALUES (NULL,'MANTER ATENDENTES','');

INSERT INTO saam.funcionalidades VALUES (NULL,'MANTER USUÁRIOS','');

INSERT INTO saam.funcionalidades VALUES (NULL,'MANTER PERFIL','');

INSERT INTO saam.funcionalidades VALUES (NULL,'AVALIAR CADASTRO DE ATENDENTES','');

INSERT INTO saam.funcionalidades VALUES (NULL,'CONSULTAR LOGS','');

INSERT INTO saam.funcionalidades VALUES (NULL,'MANTER PERGUNTAS FREQUENTES','');

INSERT INTO saam.funcionalidades VALUES (NULL,'RELATÓRIO DE ATENDIMENTOS','');

INSERT INTO saam.funcionalidades VALUES (NULL,'RELATÓRIO DE ACESSOS','');

INSERT INTO saam.funcionalidades VALUES (NULL,'RELATÓRIO DE AVALIACOES','');

INSERT INTO saam.funcionalidades VALUES (NULL,'RELATÓRIO DE PESSOAS','');

INSERT INTO saam.perfis VALUES(NULL,'ADMINISTRADOR');
INSERT INTO saam.perfis VALUES(NULL,'ATENDENTE');
INSERT INTO saam.perfis VALUES(NULL,'DIRETORIA');
INSERT INTO saam.perfis VALUES(NULL,'GERENTE');
INSERT INTO saam.perfis VALUES(NULL,'MULHER');


-- --------------------------------------------------------------
-- CONFIGURANDO PERFIS
-- --------------------------------------------------------------


-- --------------------------------------------------------------
-- Funções do Admnistrador
-- --------------------------------------------------------------

INSERT INTO saam.perf_func VALUES(1,3);
INSERT INTO saam.perf_func VALUES(1,5);
INSERT INTO saam.perf_func VALUES(1,6);
INSERT INTO saam.perf_func VALUES(1,7);
INSERT INTO saam.perf_func VALUES(1,9);


-- --------------------------------------------------------------
-- Funções do Atendente
-- --------------------------------------------------------------


INSERT INTO saam.perf_func VALUES(2,2);
INSERT INTO saam.perf_func VALUES(2,3);
INSERT INTO saam.perf_func VALUES(2,4);


-- --------------------------------------------------------------
-- Funções da Diretoria
-- --------------------------------------------------------------


INSERT INTO saam.perf_func VALUES(3,11);
INSERT INTO saam.perf_func VALUES(3,12);
INSERT INTO saam.perf_func VALUES(3,13);
INSERT INTO saam.perf_func VALUES(3,14);


-- --------------------------------------------------------------
-- Funções do Gerente
-- --------------------------------------------------------------

INSERT INTO saam.perf_func VALUES(4,3);
INSERT INTO saam.perf_func VALUES(4,10);
INSERT INTO saam.perf_func VALUES(4,11);
INSERT INTO saam.perf_func VALUES(4,12);
INSERT INTO saam.perf_func VALUES(4,13);
INSERT INTO saam.perf_func VALUES(4,14);


-- --------------------------------------------------------------
-- Funções da Mulher
-- --------------------------------------------------------------

INSERT INTO perf_func VALUES(5,1);
INSERT INTO perf_func VALUES(5,3);

-- --------------------------------------------------------------
-- CRIANDO USUARIOS - PARA FINS DE TESTE
-- --------------------------------------------------------------


-- --------------------------------------------------------------
-- CRIANDO ENDERECOS 
-- --------------------------------------------------------------
INSERT INTO saam.enderecos VALUES(NULL,'QD 301 LT 01','BRASILIA','BRASILIA','DF','72000001','BRASIL');
INSERT INTO saam.enderecos VALUES(NULL,'QD 302 LT 02','BRASILIA','BRASILIA','DF','72000002','BRASIL');
INSERT INTO saam.enderecos VALUES(NULL,'QD 303 LT 03','BRASILIA','BRASILIA','DF','72000003','BRASIL');
INSERT INTO saam.enderecos VALUES(NULL,'QD 304 LT 04','BRASILIA','BRASILIA','DF','72000004','BRASIL');
INSERT INTO saam.enderecos VALUES(NULL,'QD 305 LT 05','BRASILIA','BRASILIA','DF','72000005','BRASIL');
INSERT INTO saam.enderecos VALUES(NULL,'QD 306 LT 06','BRASILIA','BRASILIA','DF','72000006','BRASIL');

-- --------------------------------------------------------------
-- CRIANDO PESSOAS 
-- --------------------------------------------------------------
INSERT INTO saam.pessoas VALUES(NULL,'PESSOA 01 - ADM','adm@saam.com','M','SOLTEIRO','33333333','99999999','33333333',1);
INSERT INTO saam.pessoas VALUES(NULL,'PESSOA 02 - ATD','atd@saam.com','F','SOLTEIRO','33333333','99999999','33333333',2);
INSERT INTO saam.pessoas VALUES(NULL,'PESSOA 03 - DIR','dir@saam.com','F','SOLTEIRO','33333333','99999999','33333333',3);
INSERT INTO saam.pessoas VALUES(NULL,'PESSOA 04 - GER','ger@saam.com','M','SOLTEIRO','33333333','99999999','33333333',4);
INSERT INTO saam.pessoas VALUES(NULL,'PESSOA 05 - MLH','mlh@saam.com','F','SOLTEIRO','33333333','99999999','33333333',5);


-- --------------------------------------------------------------
-- CRIANDO USUARIOS
-- --------------------------------------------------------------
INSERT INTO saam.usuarios VALUES(NULL,'admin','admin',1,1); 
INSERT INTO saam.usuarios VALUES(NULL,'atendente','atendente',2,2); 
INSERT INTO saam.usuarios VALUES(NULL,'diretoria','diretoria',3,3); 
INSERT INTO saam.usuarios VALUES(NULL,'gerente','gerente',4,4); 
INSERT INTO saam.usuarios VALUES(NULL,'mulher','mulher',5,5); 

-- --------------------------------------------------------------
-- CRIANDO TIPO ATENDIMENTOS
-- --------------------------------------------------------------
INSERT INTO saam.tipo_atendimentos (NOME) VALUES ('CHAT');
INSERT INTO saam.tipo_atendimentos (NOME) VALUES ('MENSAGEM');

