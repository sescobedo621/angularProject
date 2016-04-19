-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema tododb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `tododb` ;

-- -----------------------------------------------------
-- Schema tododb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tododb` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `tododb` ;

-- -----------------------------------------------------
-- Table `users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `users` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE UNIQUE INDEX `email_UNIQUE` ON `users` (`email` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `todos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `todos` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `todos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `todo` VARCHAR(45) NULL,
  `users_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_todos_users`
    FOREIGN KEY (`users_id`)
    REFERENCES `users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `fk_todos_users_idx` ON `todos` (`users_id` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `todo_items`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `todo_items` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `todo_items` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `todo` VARCHAR(45) NULL,
  `completed` DATE NULL,
  `todos_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_todo_items_todos1`
    FOREIGN KEY (`todos_id`)
    REFERENCES `todos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `fk_todo_items_todos1_idx` ON `todo_items` (`todos_id` ASC);

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
