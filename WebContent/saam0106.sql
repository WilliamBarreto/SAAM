CREATE DATABASE  IF NOT EXISTS `saam` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `saam`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: saam
-- ------------------------------------------------------
-- Server version	5.5.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `areas`
--

DROP TABLE IF EXISTS `areas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `areas` (
  `COD_AREA` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(45) NOT NULL,
  PRIMARY KEY (`COD_AREA`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `areas`
--

/*!40000 ALTER TABLE `areas` DISABLE KEYS */;
INSERT INTO `areas` (`COD_AREA`, `NOME`) VALUES (1,'Jur¡dica'),(2,'Psic¢logica'),(3,'Social');
/*!40000 ALTER TABLE `areas` ENABLE KEYS */;

--
-- Table structure for table `aten_mens`
--

DROP TABLE IF EXISTS `aten_mens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aten_mens` (
  `COD_ATENDIMENTO` int(11) NOT NULL,
  `COD_MENSAGEM` int(11) NOT NULL,
  PRIMARY KEY (`COD_ATENDIMENTO`,`COD_MENSAGEM`),
  KEY `FRK_ATEN_MENS_COD_MENSAGEM` (`COD_MENSAGEM`),
  CONSTRAINT `FRK_ATEN_MENS_COD_ATENDIMENTO` FOREIGN KEY (`COD_ATENDIMENTO`) REFERENCES `atendimentos` (`COD_ATENDIMENTO`),
  CONSTRAINT `FRK_ATEN_MENS_COD_MENSAGEM` FOREIGN KEY (`COD_MENSAGEM`) REFERENCES `mensagens` (`COD_MENSAGEM`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aten_mens`
--

/*!40000 ALTER TABLE `aten_mens` DISABLE KEYS */;
INSERT INTO `aten_mens` (`COD_ATENDIMENTO`, `COD_MENSAGEM`) VALUES (1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),(1,18),(1,19),(1,20),(1,21),(1,22),(1,23),(1,24),(1,25),(1,26),(1,27),(1,28),(1,29),(1,30),(1,31),(1,32),(1,33),(1,34),(1,35),(1,36),(1,37),(1,38),(1,39),(1,40),(1,41),(1,42),(1,43),(1,44),(2,45),(2,46),(2,47),(2,48),(4,50);
/*!40000 ALTER TABLE `aten_mens` ENABLE KEYS */;

--
-- Table structure for table `atendimentos`
--

DROP TABLE IF EXISTS `atendimentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atendimentos` (
  `COD_ATENDIMENTO` int(11) NOT NULL AUTO_INCREMENT,
  `COD_AVALIACAO` int(11) DEFAULT NULL,
  `COD_AREA` int(11) NOT NULL,
  `COD_ATENDIDO` int(11) NOT NULL,
  `COD_ATENDENTE` int(11) DEFAULT NULL,
  `COD_TIPO_ATENDIMENTO` int(11) NOT NULL,
  `DATA_INICIO` datetime NOT NULL,
  `DATA_FIM` datetime DEFAULT NULL,
  PRIMARY KEY (`COD_ATENDIMENTO`),
  KEY `FRK_ATENDIMENTOS_COD_ATENDENTE` (`COD_ATENDIDO`),
  KEY `FRK_ATENDIMENTOS_COD_AREA` (`COD_AREA`),
  KEY `FRK_ATENDIMENTOS_COD_AVALIACAO` (`COD_AVALIACAO`),
  KEY `FRK_ATENDIMENTOS_COD_TIPO_ATENDIMENTOS` (`COD_TIPO_ATENDIMENTO`),
  KEY `FRK_ATENDIMENTOS_COD_ATENDIDO` (`COD_ATENDENTE`),
  CONSTRAINT `FRK_ATENDIMENTOS_COD_AREA` FOREIGN KEY (`COD_AREA`) REFERENCES `areas` (`COD_AREA`),
  CONSTRAINT `FRK_ATENDIMENTOS_COD_ATENDENTE` FOREIGN KEY (`COD_ATENDIDO`) REFERENCES `usuarios` (`COD_USUARIO`),
  CONSTRAINT `FRK_ATENDIMENTOS_COD_ATENDIDO` FOREIGN KEY (`COD_ATENDENTE`) REFERENCES `usuarios` (`COD_USUARIO`),
  CONSTRAINT `FRK_ATENDIMENTOS_COD_AVALIACAO` FOREIGN KEY (`COD_AVALIACAO`) REFERENCES `avaliacoes` (`COD_AVALIACAO`),
  CONSTRAINT `FRK_ATENDIMENTOS_COD_TIPO_ATENDIMENTOS` FOREIGN KEY (`COD_TIPO_ATENDIMENTO`) REFERENCES `tipo_atendimentos` (`COD_TIPO_ATENDIMENTO`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atendimentos`
--

/*!40000 ALTER TABLE `atendimentos` DISABLE KEYS */;
INSERT INTO `atendimentos` (`COD_ATENDIMENTO`, `COD_AVALIACAO`, `COD_AREA`, `COD_ATENDIDO`, `COD_ATENDENTE`, `COD_TIPO_ATENDIMENTO`, `DATA_INICIO`, `DATA_FIM`) VALUES (1,NULL,1,3,4,1,'2013-05-27 13:51:19','2013-05-27 13:52:10'),(2,NULL,1,3,4,1,'2013-05-27 14:00:35','2013-05-27 14:01:30'),(3,NULL,1,3,NULL,2,'2013-05-28 22:23:08',NULL),(4,NULL,2,3,NULL,2,'2013-05-28 22:27:20',NULL);
/*!40000 ALTER TABLE `atendimentos` ENABLE KEYS */;

--
-- Table structure for table `avaliacoes`
--

DROP TABLE IF EXISTS `avaliacoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `avaliacoes` (
  `COD_AVALIACAO` int(11) NOT NULL AUTO_INCREMENT,
  `COD_ATENDIMENTO` int(11) NOT NULL,
  `cla_COD_CLASSIFICACAO` int(11) NOT NULL,
  `COD_CLASSIFICACAO` int(11) NOT NULL,
  `SUGESTAO` varchar(250) DEFAULT NULL,
  `DATA` datetime DEFAULT NULL,
  PRIMARY KEY (`COD_AVALIACAO`),
  KEY `FRK_AVALIACOES_COD_CLASSFICACAO` (`cla_COD_CLASSIFICACAO`),
  CONSTRAINT `FRK_AVALIACOES_COD_CLASSFICACAO` FOREIGN KEY (`cla_COD_CLASSIFICACAO`) REFERENCES `classificacoes` (`COD_CLASSIFICACAO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avaliacoes`
--

/*!40000 ALTER TABLE `avaliacoes` DISABLE KEYS */;
/*!40000 ALTER TABLE `avaliacoes` ENABLE KEYS */;

--
-- Table structure for table `classificacoes`
--

DROP TABLE IF EXISTS `classificacoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classificacoes` (
  `COD_CLASSIFICACAO` int(11) NOT NULL,
  `NOME` varchar(50) NOT NULL,
  PRIMARY KEY (`COD_CLASSIFICACAO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classificacoes`
--

/*!40000 ALTER TABLE `classificacoes` DISABLE KEYS */;
/*!40000 ALTER TABLE `classificacoes` ENABLE KEYS */;

--
-- Table structure for table `enderecos`
--

DROP TABLE IF EXISTS `enderecos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enderecos` (
  `COD_ENDERECO` int(11) NOT NULL AUTO_INCREMENT,
  `LOGRADOURO` varchar(150) NOT NULL,
  `BAIRRO` varchar(50) NOT NULL,
  `CIDADE` varchar(50) NOT NULL,
  `ESTADO` varchar(2) NOT NULL,
  `CEP` varchar(8) NOT NULL,
  `PAIS` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`COD_ENDERECO`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enderecos`
--

/*!40000 ALTER TABLE `enderecos` DISABLE KEYS */;
INSERT INTO `enderecos` (`COD_ENDERECO`, `LOGRADOURO`, `BAIRRO`, `CIDADE`, `ESTADO`, `CEP`, `PAIS`) VALUES (1,'Logradouro Admin','Bairro Admin','Cidade Admin','DF','72000000','Brasil'),(2,'Quadra 300 Conjunto 14 Casa 16','Recanto das Emas','Recanto das Emas','DF','72622216','Brasil'),(3,'asfsdf','asdfsf','adf','AL','72622216','Brasil'),(4,'Quadra 300','Brasilia','BrasÃ­lia','DF','72000000','Brasil'),(5,'Quadra 10','Bla','\'Rec das Emas','DF','74555555','Brasil');
/*!40000 ALTER TABLE `enderecos` ENABLE KEYS */;

--
-- Table structure for table `funcionalidades`
--

DROP TABLE IF EXISTS `funcionalidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionalidades` (
  `COD_FUNCIONALIDADE` int(11) NOT NULL AUTO_INCREMENT,
  `NOME_TECNICO` varchar(50) NOT NULL,
  `NOME_USUARIO` varchar(50) NOT NULL,
  `URL` varchar(50) NOT NULL,
  PRIMARY KEY (`COD_FUNCIONALIDADE`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionalidades`
--

/*!40000 ALTER TABLE `funcionalidades` DISABLE KEYS */;
INSERT INTO `funcionalidades` (`COD_FUNCIONALIDADE`, `NOME_TECNICO`, `NOME_USUARIO`, `URL`) VALUES (1,'Solicitar um atendimento','Solicitar um atendimento','#{atendimentoMB.solicitar}'),(2,'Atender Vítima','Atender Vítima','#{atendimentoMB.atender}'),(3,'Histórico de atendimentos','Histórico de atendimentos','#{relatorioMB.historico}'),(4,'Atender Mensagens','Atender Mensagens','#{menuMB.naoProgramado}'),(5,'Manter Atendentes','Manter Atendentes','#{usuarioMB.atendenteIndex}'),(6,'Manter Usuários','Manter Usuários','#{usuarioMB.index}'),(7,'Manter Perfis','Manter Perfis','#{perfilMB.index}'),(8,'Avaliar Cadastro de Atendentes','Avaliar Cadastro de Atendentes','#{voluntarioMB.index}'),(9,'Consultar Logs','Consultar Logs','#{menuMB.naoProgramado}'),(10,'Manter Perguntas Frequentes','Manter Perguntas Frequentes','#{perguntaFrequenteMB.index	}'),(11,'Relatório de Atendimentos','Relatório de Atendimentos','#{menuMB.naoProgramado}'),(12,'Relatório de Acessos','Relatório de Acessos','#{menuMB.naoProgramado}'),(13,'Relatório de Avaliações','Relatório de Avaliações','#{menuMB.naoProgramado}'),(14,'Relatório de Pessoas','Relatório de Pessoas','#{menuMB.naoProgramado}'),(15,'Acompanhar Atendimentos','Acompanhar Atendimentos','#{menuMB.naoProgramado}');
/*!40000 ALTER TABLE `funcionalidades` ENABLE KEYS */;

--
-- Table structure for table `logs`
--

DROP TABLE IF EXISTS `logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `logs` (
  `COD_LOG` int(11) NOT NULL AUTO_INCREMENT,
  `COD_USUARIO` int(11) NOT NULL,
  `COD_TIPO_LOG` int(11) NOT NULL,
  `NOME` varchar(45) NOT NULL,
  `DATA` datetime NOT NULL,
  `MENSAGEM` varchar(150) NOT NULL,
  PRIMARY KEY (`COD_LOG`),
  KEY `FRK_LOGS_COD_TIPO_LOG` (`COD_TIPO_LOG`,`NOME`),
  KEY `FRK_LOGS_COD_USUARIO` (`COD_USUARIO`),
  CONSTRAINT `FRK_LOGS_COD_TIPO_LOG` FOREIGN KEY (`COD_TIPO_LOG`, `NOME`) REFERENCES `tipo_logs` (`COD_TIPO_LOG`, `NOME`),
  CONSTRAINT `FRK_LOGS_COD_USUARIO` FOREIGN KEY (`COD_USUARIO`) REFERENCES `usuarios` (`COD_USUARIO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logs`
--

/*!40000 ALTER TABLE `logs` DISABLE KEYS */;
/*!40000 ALTER TABLE `logs` ENABLE KEYS */;

--
-- Table structure for table `mensagens`
--

DROP TABLE IF EXISTS `mensagens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mensagens` (
  `COD_MENSAGEM` int(11) NOT NULL AUTO_INCREMENT,
  `COD_USUARIO` int(11) NOT NULL,
  `DATA_CRIACAO` datetime NOT NULL,
  `TEXTO` varchar(200) NOT NULL,
  PRIMARY KEY (`COD_MENSAGEM`),
  KEY `FRK_MENSAGENS_COD_USUARIO` (`COD_USUARIO`),
  CONSTRAINT `FRK_MENSAGENS_COD_USUARIO` FOREIGN KEY (`COD_USUARIO`) REFERENCES `usuarios` (`COD_USUARIO`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mensagens`
--

/*!40000 ALTER TABLE `mensagens` DISABLE KEYS */;
INSERT INTO `mensagens` (`COD_MENSAGEM`, `COD_USUARIO`, `DATA_CRIACAO`, `TEXTO`) VALUES (1,4,'2013-05-27 12:52:56','Ola'),(2,4,'2013-05-27 12:53:07','Ola'),(3,3,'2013-05-27 12:53:14','Ola'),(4,3,'2013-05-27 12:53:25','tudo bem?'),(5,4,'2013-05-27 12:53:32','xD'),(6,3,'2013-05-27 12:53:41','=)'),(7,3,'2013-05-27 13:51:30','ola'),(8,4,'2013-05-27 13:51:32','asdf'),(9,4,'2013-05-27 13:51:35','asdf'),(10,4,'2013-05-27 13:51:37','asdf'),(11,4,'2013-05-27 13:51:38','asdf'),(12,3,'2013-05-27 13:51:40','asdf'),(13,3,'2013-05-27 13:51:42','asdf'),(14,3,'2013-05-27 13:51:43','asdf'),(15,3,'2013-05-27 13:51:44','adf'),(16,4,'2013-05-27 13:51:45','asdf'),(17,4,'2013-05-27 13:51:48','asdfas'),(18,3,'2013-05-27 13:51:50','ads'),(19,4,'2013-05-27 13:51:52','asdf'),(20,3,'2013-05-27 13:51:57','adf'),(21,3,'2013-05-27 13:51:58','asdf'),(22,3,'2013-05-27 13:51:59',''),(23,3,'2013-05-27 13:52:00',''),(24,4,'2013-05-27 13:52:02',''),(25,4,'2013-05-27 13:52:02',''),(26,4,'2013-05-27 13:52:03',''),(27,4,'2013-05-27 13:52:03',''),(28,4,'2013-05-27 13:52:04',''),(29,4,'2013-05-27 13:52:04',''),(30,4,'2013-05-27 13:52:04',''),(31,4,'2013-05-27 13:52:05',''),(32,4,'2013-05-27 13:52:05',''),(33,4,'2013-05-27 13:52:06',''),(34,4,'2013-05-27 13:52:06',''),(35,4,'2013-05-27 13:52:07',''),(36,4,'2013-05-27 13:52:07',''),(37,4,'2013-05-27 13:52:07',''),(38,4,'2013-05-27 13:52:08',''),(39,4,'2013-05-27 13:52:08',''),(40,4,'2013-05-27 13:52:08',''),(41,4,'2013-05-27 13:52:08',''),(42,4,'2013-05-27 13:52:09',''),(43,4,'2013-05-27 13:52:09',''),(44,4,'2013-05-27 13:52:09',''),(45,3,'2013-05-27 14:00:43','Olá'),(46,4,'2013-05-27 14:00:53','Tudo bem?'),(47,4,'2013-05-27 14:01:14','está é a apresentação do trabalho de conclusão de curso'),(48,4,'2013-05-27 14:01:28','apresentção do chat'),(49,3,'2013-05-28 22:23:08','Envio de Mensagem'),(50,3,'2013-05-28 22:27:20','a');
/*!40000 ALTER TABLE `mensagens` ENABLE KEYS */;

--
-- Table structure for table `paginas`
--

DROP TABLE IF EXISTS `paginas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paginas` (
  `COD_PAGINA` int(11) NOT NULL AUTO_INCREMENT,
  `URL` varchar(100) DEFAULT NULL,
  `NOME` varchar(50) DEFAULT NULL,
  `COD_FUNCIONALIDADE` int(11) DEFAULT NULL,
  PRIMARY KEY (`COD_PAGINA`),
  KEY `FRK_PAGINAS_COD_FUNCIONALIDADE_idx` (`COD_FUNCIONALIDADE`),
  CONSTRAINT `FRK_PAGINAS_COD_FUNCIONALIDADE` FOREIGN KEY (`COD_FUNCIONALIDADE`) REFERENCES `funcionalidades` (`COD_FUNCIONALIDADE`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paginas`
--

/*!40000 ALTER TABLE `paginas` DISABLE KEYS */;
INSERT INTO `paginas` (`COD_PAGINA`, `URL`, `NOME`, `COD_FUNCIONALIDADE`) VALUES (1,'/SAAM/atendimento/index.xhtml','Bla!',1),(2,'/SAAM/atendimento/chat.xhtml','Bla!',1),(3,'/SAAM/atendimento/aguarde.xhtml','Bla!',1),(4,'/SAAM/atendimento/historico.xhtml','Bla!',3),(5,'/SAAM/atendimento/show.xhtml','Bla!',3),(6,'/SAAM/atendimento/mensagem.xhtml','Bla!',1);
/*!40000 ALTER TABLE `paginas` ENABLE KEYS */;

--
-- Table structure for table `perf_func`
--

DROP TABLE IF EXISTS `perf_func`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `perf_func` (
  `COD_PERFIL` int(11) NOT NULL,
  `COD_FUNCIONALIDADE` int(11) NOT NULL,
  PRIMARY KEY (`COD_PERFIL`,`COD_FUNCIONALIDADE`),
  KEY `FRK_PERF_FUNC_COD_FUNCIONALIDADE` (`COD_FUNCIONALIDADE`),
  CONSTRAINT `FRK_PERF_FUNC_COD_FUNCIONALIDADE` FOREIGN KEY (`COD_FUNCIONALIDADE`) REFERENCES `funcionalidades` (`COD_FUNCIONALIDADE`),
  CONSTRAINT `FRK_PERF_FUNC_COD_PERFIL` FOREIGN KEY (`COD_PERFIL`) REFERENCES `perfis` (`COD_PERFIL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perf_func`
--

/*!40000 ALTER TABLE `perf_func` DISABLE KEYS */;
INSERT INTO `perf_func` (`COD_PERFIL`, `COD_FUNCIONALIDADE`) VALUES (5,1),(6,1),(2,2),(2,3),(4,3),(5,3),(2,4),(1,5),(1,6),(1,7),(4,8),(1,9),(4,10),(3,11),(4,11),(3,12),(4,12),(3,13),(4,13),(3,14),(4,14),(4,15);
/*!40000 ALTER TABLE `perf_func` ENABLE KEYS */;

--
-- Table structure for table `perfis`
--

DROP TABLE IF EXISTS `perfis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `perfis` (
  `COD_PERFIL` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(20) NOT NULL,
  PRIMARY KEY (`COD_PERFIL`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfis`
--

/*!40000 ALTER TABLE `perfis` DISABLE KEYS */;
INSERT INTO `perfis` (`COD_PERFIL`, `NOME`) VALUES (1,'Administrador'),(2,'Atendente'),(3,'Diretoria'),(4,'Gerente'),(5,'Mulher'),(6,'Anonimo');
/*!40000 ALTER TABLE `perfis` ENABLE KEYS */;

--
-- Table structure for table `perguntas_frequentes`
--

DROP TABLE IF EXISTS `perguntas_frequentes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `perguntas_frequentes` (
  `COD_PERGUNTA_FREQUENTE` int(11) NOT NULL AUTO_INCREMENT,
  `COD_AREA` int(11) NOT NULL,
  `PERGUNTA` varchar(100) NOT NULL,
  `RESPOSTA` varchar(100) NOT NULL,
  `DATA_CRIACAO` datetime NOT NULL,
  PRIMARY KEY (`COD_PERGUNTA_FREQUENTE`),
  KEY `FRK_PERGUNTAS_FREQUENTES_COD_AREA` (`COD_AREA`),
  CONSTRAINT `FRK_PERGUNTAS_FREQUENTES_COD_AREA` FOREIGN KEY (`COD_AREA`) REFERENCES `areas` (`COD_AREA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perguntas_frequentes`
--

/*!40000 ALTER TABLE `perguntas_frequentes` DISABLE KEYS */;
/*!40000 ALTER TABLE `perguntas_frequentes` ENABLE KEYS */;

--
-- Table structure for table `pessoas`
--

DROP TABLE IF EXISTS `pessoas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessoas` (
  `COD_PESSOA` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Código identificador de pessoa',
  `COD_ENDERECO` int(11) DEFAULT NULL,
  `NOME` varchar(60) NOT NULL COMMENT 'Nome da pessoa',
  `EMAIL` varchar(50) NOT NULL COMMENT 'E-mail de pessoa',
  `SEXO` varchar(1) NOT NULL COMMENT 'Sexo de pessoa',
  `ESTADO_CIVIL` varchar(20) DEFAULT NULL COMMENT 'Estado civil de pessoa\n            ',
  `TELEFONE_RESIDENCIAL` varchar(45) NOT NULL COMMENT 'Telefone residencia da pessoa',
  `CELULAR` varchar(45) NOT NULL,
  `TELEFONE_COMERCIAL` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`COD_PESSOA`),
  KEY `FRK_PESSOA_COD_ENDERECO` (`COD_ENDERECO`),
  CONSTRAINT `FRK_PESSOA_COD_ENDERECO` FOREIGN KEY (`COD_ENDERECO`) REFERENCES `enderecos` (`COD_ENDERECO`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoas`
--

/*!40000 ALTER TABLE `pessoas` DISABLE KEYS */;
INSERT INTO `pessoas` (`COD_PESSOA`, `COD_ENDERECO`, `NOME`, `EMAIL`, `SEXO`, `ESTADO_CIVIL`, `TELEFONE_RESIDENCIAL`, `CELULAR`, `TELEFONE_COMERCIAL`) VALUES (1,1,'Administrador','saamprojeto@gmail.com','M','Solteiro','(61) 9999 - 9999','(61) 9999-9999','(61) 0000 - 0000'),(2,2,'Ana Fulano de Tal','bsi.william@gmail.com','M','Solteiro','(61) 2222 - 2222','(61) 3333-3333',''),(3,3,'Nelson Borges','nelsongborges@gmail.com','M','Solteiro','(61) 2222 - 2222','(61) 2222-2222','(62) 1111 - 1111'),(4,4,'Gerente','gerente@saam.com','M','Solteiro','(99) 9999 - 9999','(99) 9999-9999',''),(5,5,'Diretoria','diretoria@saam.com','M','Solteiro','(99) 9999 - 9999','(99) 9999-9999','');
/*!40000 ALTER TABLE `pessoas` ENABLE KEYS */;

--
-- Table structure for table `tipo_atendimentos`
--

DROP TABLE IF EXISTS `tipo_atendimentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_atendimentos` (
  `COD_TIPO_ATENDIMENTO` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(20) NOT NULL,
  PRIMARY KEY (`COD_TIPO_ATENDIMENTO`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_atendimentos`
--

/*!40000 ALTER TABLE `tipo_atendimentos` DISABLE KEYS */;
INSERT INTO `tipo_atendimentos` (`COD_TIPO_ATENDIMENTO`, `NOME`) VALUES (1,'Chat'),(2,'Mensagem');
/*!40000 ALTER TABLE `tipo_atendimentos` ENABLE KEYS */;

--
-- Table structure for table `tipo_logs`
--

DROP TABLE IF EXISTS `tipo_logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_logs` (
  `COD_TIPO_LOG` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(45) NOT NULL,
  PRIMARY KEY (`COD_TIPO_LOG`,`NOME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_logs`
--

/*!40000 ALTER TABLE `tipo_logs` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_logs` ENABLE KEYS */;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `COD_USUARIO` int(11) NOT NULL AUTO_INCREMENT,
  `COD_PERFIL` int(11) NOT NULL,
  `COD_PESSOA` int(11) NOT NULL COMMENT 'Código identificador de pessoa',
  `USUARIO` varchar(50) DEFAULT NULL,
  `SENHA` varchar(15) DEFAULT NULL,
  `ATIVO` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`COD_USUARIO`),
  KEY `FRK_USUARIOS_COD_PERFIL` (`COD_PERFIL`),
  KEY `FRK_USUARIOS_COD_PESSOA` (`COD_PESSOA`),
  CONSTRAINT `FRK_USUARIOS_COD_PERFIL` FOREIGN KEY (`COD_PERFIL`) REFERENCES `perfis` (`COD_PERFIL`),
  CONSTRAINT `FRK_USUARIOS_COD_PESSOA` FOREIGN KEY (`COD_PESSOA`) REFERENCES `pessoas` (`COD_PESSOA`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` (`COD_USUARIO`, `COD_PERFIL`, `COD_PESSOA`, `USUARIO`, `SENHA`, `ATIVO`) VALUES (2,1,1,'admin','saam',1),(3,5,2,'bsi.william@gmail.com','mulher',NULL),(4,2,3,'nelsongborges@gmail.com','123456',NULL),(5,4,4,'gerente@saam.com','gerente',NULL),(6,3,5,'diretoria@saam.com','diretoria',NULL);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;

--
-- Table structure for table `voluntarios`
--

DROP TABLE IF EXISTS `voluntarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `voluntarios` (
  `COD_VOLUNTARIO` int(11) NOT NULL AUTO_INCREMENT,
  `COD_AREA` int(11) NOT NULL,
  `SITUACAO` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`COD_VOLUNTARIO`),
  KEY `FRK_VOLUNTARIOS_COD_AREA` (`COD_AREA`),
  CONSTRAINT `FRK_VOLUNTARIOS_COD_AREA` FOREIGN KEY (`COD_AREA`) REFERENCES `areas` (`COD_AREA`),
  CONSTRAINT `FRK_VOLUNTARIOS_COD_VOLUNTARIO` FOREIGN KEY (`COD_VOLUNTARIO`) REFERENCES `pessoas` (`COD_PESSOA`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voluntarios`
--

/*!40000 ALTER TABLE `voluntarios` DISABLE KEYS */;
INSERT INTO `voluntarios` (`COD_VOLUNTARIO`, `COD_AREA`, `SITUACAO`) VALUES (3,1,1);
/*!40000 ALTER TABLE `voluntarios` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-06-01 15:05:34
