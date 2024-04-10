-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema medicaldatabase
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema medicaldatabase
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `medicaldatabase` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `medicaldatabase` ;

-- -----------------------------------------------------
-- Table `medicaldatabase`.`patient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicaldatabase`.`patient` (
  `id` INT NOT NULL,
  `full_name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `medicaldatabase`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicaldatabase`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `role` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `medicaldatabase`.`doctor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicaldatabase`.`doctor` (
  `id` INT NOT NULL,
  `full_name` VARCHAR(255) NULL DEFAULT NULL,
  `credentials` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `doctor_ibfk_1`
    FOREIGN KEY (`id`)
    REFERENCES `medicaldatabase`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `medicaldatabase`.`appointment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicaldatabase`.`appointment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `patient_id` INT NULL DEFAULT NULL,
  `doctor_id` INT NULL DEFAULT NULL,
  `date` DATETIME NULL DEFAULT NULL,
  `status` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `patient_id` (`patient_id` ASC) VISIBLE,
  INDEX `doctor_id` (`doctor_id` ASC) VISIBLE,
  CONSTRAINT `appointment_ibfk_1`
    FOREIGN KEY (`patient_id`)
    REFERENCES `medicaldatabase`.`patient` (`id`),
  CONSTRAINT `appointment_ibfk_2`
    FOREIGN KEY (`doctor_id`)
    REFERENCES `medicaldatabase`.`doctor` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `medicaldatabase`.`medicalhistory`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicaldatabase`.`medicalhistory` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `patient_id` INT NULL DEFAULT NULL,
  `medical_history` TEXT NULL DEFAULT NULL,
  `current_residence_city` VARCHAR(255) NULL DEFAULT NULL,
  `previous_residence_cities` TEXT NULL DEFAULT NULL,
  `current_symptoms` INT NULL DEFAULT NULL,
  `contact_with_sick_people` INT NULL DEFAULT NULL,
  `release_date` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `patient_id` (`patient_id` ASC) VISIBLE,
  CONSTRAINT `medicalhistory_ibfk_1`
    FOREIGN KEY (`patient_id`)
    REFERENCES `medicaldatabase`.`patient` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `medicaldatabase`.`notification`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicaldatabase`.`notification` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NULL DEFAULT NULL,
  `message` TEXT NULL DEFAULT NULL,
  `type` VARCHAR(255) NULL DEFAULT NULL,
  `date` DATETIME NULL DEFAULT NULL,
  `sender_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `user_id` (`user_id` ASC) VISIBLE,
  CONSTRAINT `notification_ibfk_1`
    FOREIGN KEY (`user_id`)
    REFERENCES `medicaldatabase`.`user` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `medicaldatabase`.`sample`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicaldatabase`.`sample` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `appointment_id` INT NULL DEFAULT NULL,
  `type` VARCHAR(255) NULL DEFAULT NULL,
  `collection_date` DATETIME NULL DEFAULT NULL,
  `analysis_date` DATETIME NULL DEFAULT NULL,
  `status` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `appointment_id` (`appointment_id` ASC) VISIBLE,
  CONSTRAINT `sample_ibfk_1`
    FOREIGN KEY (`appointment_id`)
    REFERENCES `medicaldatabase`.`appointment` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
