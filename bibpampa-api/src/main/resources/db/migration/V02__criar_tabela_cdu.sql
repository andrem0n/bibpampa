CREATE TABLE `bibpampa_db`.`cdu` (
`codigo` INT NOT NULL,
`descricao` VARCHAR(45) NOT NULL,
PRIMARY KEY (`codigo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;

ALTER TABLE `bibpampa_db`.`catalogacao` 
ADD CONSTRAINT `codigo_cdu`
  FOREIGN KEY (`codigo_cdu`)
  REFERENCES `bibpampa_db`.`cdu` (`codigo`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;



