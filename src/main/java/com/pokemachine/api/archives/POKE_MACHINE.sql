-- MySQL Script generated by MySQL Workbench
-- Fri Jun 11 21:00:09 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema POKE_MACHINE
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema POKE_MACHINE
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `POKE_MACHINE` DEFAULT CHARACTER SET utf8 ;
USE `POKE_MACHINE` ;

-- -----------------------------------------------------
-- Table `POKE_MACHINE`.`CLIENT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `POKE_MACHINE`.`CLIENT` (
  `CLI_ID` INT NOT NULL AUTO_INCREMENT,
  `CLI_FULL_NAME` VARCHAR(80) NOT NULL,
  `CLI_RG` VARCHAR(15) NOT NULL UNIQUE,
  `CLI_CPF` VARCHAR(15) NOT NULL UNIQUE,
  `CLI_BIRTHDAY` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`CLI_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `POKE_MACHINE`.`CLIENT_ADDRESS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `POKE_MACHINE`.`CLIENT_ADDRESS` (
  `CLA_ID` INT NOT NULL AUTO_INCREMENT,
  `CLA_CLI_ID` INT NOT NULL,
  `CLA_ZIP_CODE` VARCHAR(45) NOT NULL,
  `CLA_ADDRESS` VARCHAR(150) NOT NULL,
  `CLA_NUMBER` INT NOT NULL,
  `CLA_DISTRICTY` VARCHAR(80) NOT NULL,
  `CLA_CITY` VARCHAR(80) NOT NULL,
  `CLA_UF` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`CLA_ID`),
  CONSTRAINT `fk_CLIENT_ADDRESS_CLIENT`
    FOREIGN KEY (`CLA_CLI_ID`)
    REFERENCES `POKE_MACHINE`.`CLIENT` (`CLI_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `POKE_MACHINE`.`CLIENT_TELEPHONE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `POKE_MACHINE`.`CLIENT_TELEPHONE` (
  `CLT_ID` INT NOT NULL AUTO_INCREMENT,
  `CLT_CLI_ID` INT NOT NULL,
  `CLT_TELEPHONE` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`CLT_ID`),
  CONSTRAINT `fk_CLIENT_TELEPHONE_CLIENT1`
    FOREIGN KEY (`CLT_CLI_ID`)
    REFERENCES `POKE_MACHINE`.`CLIENT` (`CLI_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `POKE_MACHINE`.`BANK`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `POKE_MACHINE`.`BANK` (
  `BNK_ID` INT NOT NULL AUTO_INCREMENT,
  `BNK_NAME` VARCHAR(80) NOT NULL,
  `BNK_CODE` VARCHAR(5) NOT NULL UNIQUE,
  PRIMARY KEY (`BNK_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `POKE_MACHINE`.`AGENCY`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `POKE_MACHINE`.`AGENCY` (
  `AGE_ID` INT NOT NULL AUTO_INCREMENT,
  `AGE_BNK_ID` INT NOT NULL,
  `AGE_NAME` VARCHAR(80) NOT NULL,
  `AGE_CODE` VARCHAR(10) NOT NULL UNIQUE,
  PRIMARY KEY (`AGE_ID`),
  CONSTRAINT `fk_AGENCY_BANK1`
    FOREIGN KEY (`AGE_BNK_ID`)
    REFERENCES `POKE_MACHINE`.`BANK` (`BNK_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `POKE_MACHINE`.`ACCOUNT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `POKE_MACHINE`.`ACCOUNT` (
  `ACC_ID` INT NOT NULL AUTO_INCREMENT,
  `ACC_CLI_ID` INT NOT NULL,
  `ACC_AGE_ID` INT NOT NULL,
  `ACC_CODE` VARCHAR(15) NOT NULL UNIQUE,
  `ACC_PASSWORD` VARCHAR(80) NOT NULL,
  `ACC_STATUS` TINYINT NOT NULL DEFAULT 1,
  `ACC_BALANCE` FLOAT(10,2) NOT NULL,
  `ACC_TYPE` ENUM('P', 'C') NOT NULL,
  PRIMARY KEY (`ACC_ID`),
  CONSTRAINT `fk_ACCOUNT_CLIENT1`
    FOREIGN KEY (`ACC_CLI_ID`)
    REFERENCES `POKE_MACHINE`.`CLIENT` (`CLI_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ACCOUNT_AGENCY1`
    FOREIGN KEY (`ACC_AGE_ID`)
    REFERENCES `POKE_MACHINE`.`AGENCY` (`AGE_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `POKE_MACHINE`.`CARD`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `POKE_MACHINE`.`CARD` (
  `CAR_ID` INT NOT NULL AUTO_INCREMENT,
  `CAR_ACC_ID` INT NOT NULL,
  `CAR_CODE` INT(20) NOT NULL UNIQUE,
  `CAR_EXPIRATION_DATE` DATE NOT NULL,
  `CAR_TYPE` ENUM('D', 'C', 'DC') NOT NULL,
  `CAR_CVV` INT(3) NOT NULL,
  `CAR_STATUS` TINYINT NOT NULL DEFAULT 1,
  `CAR_PASSWORD` VARCHAR(80) NOT NULL,
  `CAR_LIMIT` FLOAT(10,2),
  PRIMARY KEY (`CAR_ID`),
  CONSTRAINT `fk_CARD_ACCOUNT1`
    FOREIGN KEY (`CAR_ACC_ID`)
    REFERENCES `POKE_MACHINE`.`ACCOUNT` (`ACC_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `POKE_MACHINE`.`TRANSFER_HISTORY`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `POKE_MACHINE`.`TRANSFER_HISTORY` (
  `TRH_ID` INT NOT NULL AUTO_INCREMENT,
  `TRH_ORIGIN_ACC_ID` INT NOT NULL,
  `TRH_DESTINY_ACC_ID` INT NOT NULL,
  `TRH_VALUE` FLOAT(10,2) NOT NULL,
  `TRH_DATETIME` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`TRH_ID`),
  CONSTRAINT `fk_TRANSFER_HISTORY_ACCOUNT1`
    FOREIGN KEY (`TRH_ORIGIN_ACC_ID`)
    REFERENCES `POKE_MACHINE`.`ACCOUNT` (`ACC_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TRANSFER_HISTORY_ACCOUNT2`
    FOREIGN KEY (`TRH_DESTINY_ACC_ID`)
    REFERENCES `POKE_MACHINE`.`ACCOUNT` (`ACC_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `POKE_MACHINE`.`CASH_MACHINE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `POKE_MACHINE`.`CASH_MACHINE` (
  `CSM_ID` INT NOT NULL AUTO_INCREMENT,
  `CSM_NAME` VARCHAR(80) NOT NULL,
  `CSM_AVAILABLE_VALUE` FLOAT(10,2) NOT NULL,
  `CSM_STATUS` ENUM('AT','IN','EU') NOT NULL,
  PRIMARY KEY (`CSM_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `POKE_MACHINE`.`HISTORIC`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `POKE_MACHINE`.`HISTORIC` (
  `HIS_ID` INT NOT NULL AUTO_INCREMENT,
  `HIS_CSM_ID` INT NOT NULL,
  `HIS_ACC_ID` INT NOT NULL,
  `HIS_OPERATION` ENUM('S', 'D', 'T') NOT NULL,
  `HIS_DATETIME` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `HIS_VALUE` FLOAT(10,2) NOT NULL,
  PRIMARY KEY (`HIS_ID`),
  CONSTRAINT `fk_HISTORIC_CASH_MACHINE1`
    FOREIGN KEY (`HIS_CSM_ID`)
    REFERENCES `POKE_MACHINE`.`CASH_MACHINE` (`CSM_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_HISTORIC_ACCOUNT1`
    FOREIGN KEY (`HIS_ACC_ID`)
    REFERENCES `POKE_MACHINE`.`ACCOUNT` (`ACC_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Insert `POKE_MACHINE`.`BANK`
-- -----------------------------------------------------
INSERT INTO BANK (BNK_NAME,BNK_CODE) VALUES ("BANCO DO BRASIL", "01");
INSERT INTO BANK (BNK_NAME,BNK_CODE) VALUES ("ITAU", "33");
INSERT INTO BANK (BNK_NAME,BNK_CODE) VALUES ("CAIXA", "65");
INSERT INTO BANK (BNK_NAME,BNK_CODE) VALUES ("SANTANDER", "93");
INSERT INTO BANK (BNK_NAME,BNK_CODE) VALUES ("BRADESCO", "105");

-- -----------------------------------------------------
-- Insert `POKE_MACHINE`.`AGENCY`
-- -----------------------------------------------------

INSERT INTO AGENCY (AGE_BNK_ID, AGE_NAME, AGE_CODE) VALUES(1, "Banco do Brasil S.A. - Sorocaba", "99547");
INSERT INTO AGENCY (AGE_BNK_ID, AGE_NAME, AGE_CODE) VALUES(2, "Itaú - Boituva","19879");
INSERT INTO AGENCY (AGE_BNK_ID, AGE_NAME, AGE_CODE) VALUES(3, "Caixa Economica - Tietê", "16794");
INSERT INTO AGENCY (AGE_BNK_ID, AGE_NAME, AGE_CODE) VALUES(4, "Santander - Sorocaba", "47244");
INSERT INTO AGENCY (AGE_BNK_ID, AGE_NAME, AGE_CODE) VALUES(5, "Bradesco - Sorocaba", "10547");