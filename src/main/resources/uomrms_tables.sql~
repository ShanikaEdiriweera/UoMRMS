-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema uomrms_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema uomrms_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `uomrms_db` DEFAULT CHARACTER SET utf8 ;
USE `uomrms_db` ;

-- -----------------------------------------------------
-- Table `uomrms_db`.`Faculty`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `uomrms_db`.`Faculty` (
  `ID` INT NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `uomrms_db`.`Department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `uomrms_db`.`Department` (
  `ID` INT NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `Faculty_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Department_Faculty_idx` (`Faculty_ID` ASC),
  CONSTRAINT `fk_Department_Faculty`
    FOREIGN KEY (`Faculty_ID`)
    REFERENCES `uomrms_db`.`Faculty` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `uomrms_db`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `uomrms_db`.`User` (
  `ID` VARCHAR(10) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `user_type` ENUM('System Admin', 'University Admin', 'Academic Staff', 'Examinations Staff', 'Student') NULL,
  `Department_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_User_Department1_idx` (`Department_ID` ASC),
  CONSTRAINT `fk_User_Department1`
    FOREIGN KEY (`Department_ID`)
    REFERENCES `uomrms_db`.`Department` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `uomrms_db`.`Batch`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `uomrms_db`.`Batch` (
  `ID` INT NOT NULL,
  `year` INT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `uomrms_db`.`Student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `uomrms_db`.`Student` (
  `ID` VARCHAR(10) NOT NULL,
  `name` VARCHAR(100) NULL,
  `CGPA` DECIMAL(5,4) NULL,
  `rank` INT NULL,
  `User_ID` VARCHAR(10) NULL,
  `Department_ID` INT NOT NULL,
  `Batch_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Student_Department1_idx` (`Department_ID` ASC),
  INDEX `fk_Student_Batch1_idx` (`Batch_ID` ASC),
  CONSTRAINT `fk_Student_Department1`
    FOREIGN KEY (`Department_ID`)
    REFERENCES `uomrms_db`.`Department` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Student_Batch1`
    FOREIGN KEY (`Batch_ID`)
    REFERENCES `uomrms_db`.`Batch` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `uomrms_db`.`Semester`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `uomrms_db`.`Semester` (
  `ID` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `uomrms_db`.`Module`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `uomrms_db`.`Module` (
  `code` VARCHAR(10) NOT NULL,
  `title` VARCHAR(100) NULL,
  `credits` DECIMAL(2,1) NULL,
  `gpa` TINYINT(1) NULL,
  `Semester_ID` INT NOT NULL,
  PRIMARY KEY (`Semester_ID`, `code`),
  CONSTRAINT `fk_Module_Semester1`
    FOREIGN KEY (`Semester_ID`)
    REFERENCES `uomrms_db`.`Semester` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `uomrms_db`.`Grade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `uomrms_db`.`Grade` (
  `grade` VARCHAR(10) NOT NULL,
  `mark` DECIMAL(2,1) NULL,
  PRIMARY KEY (`grade`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `uomrms_db`.`Student_Semester_Results`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `uomrms_db`.`Student_Semester_Results` (
  `Student_ID` VARCHAR(10) NOT NULL,
  `Semester_ID` INT NOT NULL,
  `SGPA` DECIMAL(5,4) NULL,
  `rank` VARCHAR(45) NULL,
  PRIMARY KEY (`Student_ID`, `Semester_ID`),
  INDEX `fk_Student_has_Semester_Semester1_idx` (`Semester_ID` ASC),
  INDEX `fk_Student_has_Semester_Student1_idx` (`Student_ID` ASC),
  CONSTRAINT `fk_Student_has_Semester_Student1`
    FOREIGN KEY (`Student_ID`)
    REFERENCES `uomrms_db`.`Student` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Student_has_Semester_Semester1`
    FOREIGN KEY (`Semester_ID`)
    REFERENCES `uomrms_db`.`Semester` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `uomrms_db`.`Student_has_Module`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `uomrms_db`.`Student_has_Module` (
  `Student_ID` VARCHAR(10) NOT NULL,
  `Grade_grade` VARCHAR(10) NOT NULL,
  `Module_Semester_ID` INT NOT NULL,
  `Module_code` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`Student_ID`, `Module_Semester_ID`, `Module_code`),
  INDEX `fk_Student_has_Module_Student1_idx` (`Student_ID` ASC),
  INDEX `fk_Student_has_Module_Grade1_idx` (`Grade_grade` ASC),
  INDEX `fk_Student_has_Module_Module1_idx` (`Module_Semester_ID` ASC, `Module_code` ASC),
  CONSTRAINT `fk_Student_has_Module_Student1`
    FOREIGN KEY (`Student_ID`)
    REFERENCES `uomrms_db`.`Student` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Student_has_Module_Grade1`
    FOREIGN KEY (`Grade_grade`)
    REFERENCES `uomrms_db`.`Grade` (`grade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Student_has_Module_Module1`
    FOREIGN KEY (`Module_Semester_ID` , `Module_code`)
    REFERENCES `uomrms_db`.`Module` (`Semester_ID` , `code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
