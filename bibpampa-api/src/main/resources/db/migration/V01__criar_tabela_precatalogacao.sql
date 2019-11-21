CREATE TABLE `bibpampa_db`.`catalogacao` (
  `codigo` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `classificacao` VARCHAR(45) NOT NULL,
  `cutter` VARCHAR(45) NOT NULL,
  `autor` VARCHAR(200) NOT NULL,
  `titulo` VARCHAR(100) NOT NULL,
  `subtitulo` VARCHAR(100) NULL,
  `indicacao_responsabilidade` VARCHAR(500) NOT NULL,
  `edicao` VARCHAR(45) NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `editora` VARCHAR(70) NOT NULL,
  `data_publicacao` INT NOT NULL,
  `quantidade_paginas` INT NOT NULL,
  `resumo` LONGTEXT NULL,
  `codigo_cdu` INT NOT NULL,
  `exportado` TINYINT NOT NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;



