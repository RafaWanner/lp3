-- MySQL Script generated by MySQL Workbench
-- Mon Aug 30 19:07:24 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Anime_Rafael_Abilio
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Anime_Rafael_Abilio
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Anime_Rafael_Abilio` DEFAULT CHARACTER SET utf8 ;
USE `Anime_Rafael_Abilio` ;

-- -----------------------------------------------------
-- Table `Anime_Rafael_Abilio`.`estudio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Anime_Rafael_Abilio`.`estudio` (
  `id_estudio` INT NOT NULL,
  `nome_estudio` VARCHAR(99) NOT NULL,
  PRIMARY KEY (`id_estudio`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Anime_Rafael_Abilio`.`anime`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Anime_Rafael_Abilio`.`anime` (
  `id_anime` INT NOT NULL,
  `nome_anime` VARCHAR(99) NULL,
  `nota` DOUBLE NULL,
  `estudio_id_estudio` INT NOT NULL,
  PRIMARY KEY (`id_anime`),
  INDEX `fk_anime_estudio1_idx` (`estudio_id_estudio` ASC) ,
  CONSTRAINT `fk_anime_estudio1`
    FOREIGN KEY (`estudio_id_estudio`)
    REFERENCES `Anime_Rafael_Abilio`.`estudio` (`id_estudio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Anime_Rafael_Abilio`.`genero`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Anime_Rafael_Abilio`.`genero` (
  `id_genero` INT NOT NULL,
  `nome_genero` VARCHAR(99) NULL,
  PRIMARY KEY (`id_genero`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Anime_Rafael_Abilio`.`genero_has_anime`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Anime_Rafael_Abilio`.`genero_has_anime` (
  `genero_id_genero` INT NOT NULL,
  `anime_id_anime` INT NOT NULL,
  PRIMARY KEY (`genero_id_genero`, `anime_id_anime`),
  INDEX `fk_genero_has_anime_anime1_idx` (`anime_id_anime` ASC) ,
  INDEX `fk_genero_has_anime_genero1_idx` (`genero_id_genero` ASC) ,
  CONSTRAINT `fk_genero_has_anime_genero1`
    FOREIGN KEY (`genero_id_genero`)
    REFERENCES `Anime_Rafael_Abilio`.`genero` (`id_genero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_genero_has_anime_anime1`
    FOREIGN KEY (`anime_id_anime`)
    REFERENCES `Anime_Rafael_Abilio`.`anime` (`id_anime`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Anime_Rafael_Abilio`.`staff`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Anime_Rafael_Abilio`.`staff` (
  `id_staff` INT NOT NULL,
  `nome_staff` VARCHAR(99) NULL,
  `profissao_staff` VARCHAR(99) NULL,
  PRIMARY KEY (`id_staff`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Anime_Rafael_Abilio`.`anime_has_staff`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Anime_Rafael_Abilio`.`anime_has_staff` (
  `anime_id_anime` INT NOT NULL,
  `staff_id_staff` INT NOT NULL,
  PRIMARY KEY (`anime_id_anime`, `staff_id_staff`),
  INDEX `fk_anime_has_staff_staff1_idx` (`staff_id_staff` ASC) ,
  INDEX `fk_anime_has_staff_anime1_idx` (`anime_id_anime` ASC) ,
  CONSTRAINT `fk_anime_has_staff_anime1`
    FOREIGN KEY (`anime_id_anime`)
    REFERENCES `Anime_Rafael_Abilio`.`anime` (`id_anime`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_anime_has_staff_staff1`
    FOREIGN KEY (`staff_id_staff`)
    REFERENCES `Anime_Rafael_Abilio`.`staff` (`id_staff`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Anime_Rafael_Abilio`.`personagem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Anime_Rafael_Abilio`.`personagem` (
  `id_personagem` INT NOT NULL,
  `nome_personagem` VARCHAR(99) NULL,
  `papel` VARCHAR(99) NULL,
  `informação` VARCHAR(5000) NULL,
  PRIMARY KEY (`id_personagem`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Anime_Rafael_Abilio`.`dublador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Anime_Rafael_Abilio`.`dublador` (
  `id_dublador` INT NOT NULL,
  `nome_dublador` VARCHAR(99) NULL,
  `data_nascimento` DATE NULL,
  `redes_sociais` VARCHAR(5000) NULL,
  `idioma` VARCHAR(99) NULL,
  PRIMARY KEY (`id_dublador`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Anime_Rafael_Abilio`.`dublador_has_personagem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Anime_Rafael_Abilio`.`dublador_has_personagem` (
  `dublador_id_dublador` INT NOT NULL,
  `personagem_id_personagem` INT NOT NULL,
  `anime_id_anime` INT NOT NULL,
  PRIMARY KEY (`dublador_id_dublador`, `personagem_id_personagem`, `anime_id_anime`),
  INDEX `fk_dublador_has_personagem_personagem1_idx` (`personagem_id_personagem` ASC) ,
  INDEX `fk_dublador_has_personagem_dublador1_idx` (`dublador_id_dublador` ASC) ,
  INDEX `fk_dublador_has_personagem_anime1_idx` (`anime_id_anime` ASC) ,
  CONSTRAINT `fk_dublador_has_personagem_dublador1`
    FOREIGN KEY (`dublador_id_dublador`)
    REFERENCES `Anime_Rafael_Abilio`.`dublador` (`id_dublador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_dublador_has_personagem_personagem1`
    FOREIGN KEY (`personagem_id_personagem`)
    REFERENCES `Anime_Rafael_Abilio`.`personagem` (`id_personagem`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_dublador_has_personagem_anime1`
    FOREIGN KEY (`anime_id_anime`)
    REFERENCES `Anime_Rafael_Abilio`.`anime` (`id_anime`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SELECT * FROM estudio;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
