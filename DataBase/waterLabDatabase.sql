-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema water_laboratory
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `water_laboratory` ;

-- -----------------------------------------------------
-- Schema water_laboratory
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `water_laboratory` ;
-- -----------------------------------------------------
-- Schema water_laboratory
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `water_laboratory` ;

-- -----------------------------------------------------
-- Schema water_laboratory
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `water_laboratory` ;
USE `water_laboratory` ;

-- -----------------------------------------------------
-- Table `water_laboratory`.`PACKAGE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `water_laboratory`.`PACKAGE` ;

CREATE TABLE IF NOT EXISTS `water_laboratory`.`PACKAGE` (
  `id_package` VARCHAR(10) NOT NULL,
  `name_package` VARCHAR(45) NOT NULL,
  `package_cost` DOUBLE NOT NULL,
  PRIMARY KEY (`id_package`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `water_laboratory`.`DEPARTMENT`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `water_laboratory`.`DEPARTMENT` ;

CREATE TABLE IF NOT EXISTS `water_laboratory`.`DEPARTMENT` (
  `id_department` INT NOT NULL AUTO_INCREMENT,
  `name_department` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_department`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `water_laboratory`.`MUNICIPALITY`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `water_laboratory`.`MUNICIPALITY` ;

CREATE TABLE IF NOT EXISTS `water_laboratory`.`MUNICIPALITY` (
  `id_municipality` INT NOT NULL AUTO_INCREMENT,
  `name_municipality` VARCHAR(45) NOT NULL,
  `department_id` INT NOT NULL,
  PRIMARY KEY (`id_municipality`),
  INDEX `fk_MUNICIPALITY_DEPARTMENT1_idx` (`department_id` ASC),
  CONSTRAINT `fk_MUNICIPALITY_DEPARTMENT1`
    FOREIGN KEY (`department_id`)
    REFERENCES `water_laboratory`.`DEPARTMENT` (`id_department`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `water_laboratory`.`COSTUM_CLIENT`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `water_laboratory`.`COSTUM_CLIENT` ;

CREATE TABLE IF NOT EXISTS `water_laboratory`.`COSTUM_CLIENT` (
  `id_costum_category` INT NOT NULL,
  `name_costum_category` VARCHAR(45) NOT NULL,
  `description` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`id_costum_category`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `water_laboratory`.`CLIENT`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `water_laboratory`.`CLIENT` ;

CREATE TABLE IF NOT EXISTS `water_laboratory`.`CLIENT` (
  `dpi_client` VARCHAR(14) NOT NULL,
  `name_client` VARCHAR(60) NOT NULL,
  `direction_client` VARCHAR(60) NULL DEFAULT NULL,
  `city_client` VARCHAR(45) NULL DEFAULT NULL,
  `company_client` VARCHAR(60) NULL DEFAULT NULL,
  `phone_client` VARCHAR(15) NOT NULL,
  `phone_client_extra` VARCHAR(15) NULL DEFAULT NULL,
  `phone_extra` VARCHAR(15) NULL DEFAULT NULL,
  `email_client` VARCHAR(45) NULL DEFAULT NULL,
  `web_site_client` VARCHAR(45) NULL DEFAULT NULL,
  `costum_client_id` INT NOT NULL,
  PRIMARY KEY (`dpi_client`),
  INDEX `fk_CLIENT_COSTUM_CLIENT1_idx` (`costum_client_id` ASC),
  CONSTRAINT `fk_CLIENT_COSTUM_CLIENT1`
    FOREIGN KEY (`costum_client_id`)
    REFERENCES `water_laboratory`.`COSTUM_CLIENT` (`id_costum_category`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `water_laboratory`.`SAMPLE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `water_laboratory`.`SAMPLE` ;

CREATE TABLE IF NOT EXISTS `water_laboratory`.`SAMPLE` (
  `id_sample` INT NOT NULL AUTO_INCREMENT,
  `admission_date` DATE NOT NULL,
  `sampling_date` DATE NOT NULL,
  `batch` VARCHAR(45) NOT NULL,
  `sampling_time` TIME NOT NULL,
  `container` VARCHAR(45) NULL DEFAULT NULL,
  `is_refrigerated` TINYINT(1) NOT NULL,
  `temperature` DOUBLE NOT NULL,
  `sample_quantity` DOUBLE NOT NULL,
  `is_water_birth` TINYINT(1) NOT NULL,
  `hamlet` VARCHAR(45) NULL DEFAULT NULL,
  `observations` TINYTEXT NULL DEFAULT NULL,
  `village` VARCHAR(45) NULL DEFAULT NULL,
  `note_sample` TINYTEXT NULL DEFAULT NULL,
  `acceptance` TINYINT(1) NOT NULL COMMENT 'aceptacion: 1->Aceptado, 2->Rechazado,3->Bajo Condicion\n',
  `Boleta_de_pago` VARCHAR(45) NULL DEFAULT NULL,
  `municipality_id` INT NOT NULL,
  `client_dpi` VARCHAR(14) NOT NULL,
  `no_hoja_campo` VARCHAR(45) NULL,
  `tecnico_evaluador` VARCHAR(45) NULL,
  `coordenadas` VARCHAR(50) NULL,
  `temperatura_lugar` DOUBLE NULL,
  `ph_lugar` DOUBLE NULL,
  `std_lugar` VARCHAR(45) NULL,
  `u_s_lugar` VARCHAR(45) NULL,
  `salinidad_lugar` VARCHAR(45) NULL,
  PRIMARY KEY (`id_sample`),
  INDEX `fk_SAMPLE_MUNICIPALITY1_idx` (`municipality_id` ASC),
  INDEX `fk_SAMPLE_CLIENT1_idx` (`client_dpi` ASC),
  CONSTRAINT `fk_SAMPLE_MUNICIPALITY1`
    FOREIGN KEY (`municipality_id`)
    REFERENCES `water_laboratory`.`MUNICIPALITY` (`id_municipality`),
  CONSTRAINT `fk_SAMPLE_CLIENT1`
    FOREIGN KEY (`client_dpi`)
    REFERENCES `water_laboratory`.`CLIENT` (`dpi_client`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `water_laboratory`.`STAFF_POSITION`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `water_laboratory`.`STAFF_POSITION` ;

CREATE TABLE IF NOT EXISTS `water_laboratory`.`STAFF_POSITION` (
  `id_staff_position` INT NOT NULL,
  `name_staff_position` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_staff_position`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `water_laboratory`.`EMPLOYEE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `water_laboratory`.`EMPLOYEE` ;

CREATE TABLE IF NOT EXISTS `water_laboratory`.`EMPLOYEE` (
  `dpi_employee` VARCHAR(14) NOT NULL,
  `password` VARCHAR(400) NOT NULL,
  `name_employee` VARCHAR(60) BINARY NOT NULL,
  `is_active` TINYINT(1) NOT NULL,
  `phone_employee` VARCHAR(10) NULL DEFAULT NULL,
  `staff_position_id` INT NOT NULL,
  PRIMARY KEY (`dpi_employee`),
  INDEX `fk_EMPLOYEE_PERSONAL_CHARGE1_idx` (`staff_position_id` ASC),
  CONSTRAINT `fk_EMPLOYEE_PERSONAL_CHARGE1`
    FOREIGN KEY (`staff_position_id`)
    REFERENCES `water_laboratory`.`STAFF_POSITION` (`id_staff_position`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `water_laboratory`.`ANALYSIS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `water_laboratory`.`ANALYSIS` ;

CREATE TABLE IF NOT EXISTS `water_laboratory`.`ANALYSIS` (
  `id_analysis` INT NOT NULL AUTO_INCREMENT,
  `date_analysis` DATE NOT NULL,
  `cost_analysis` DOUBLE NOT NULL,
  `sample_id` INT NOT NULL,
  `employee_dpi` VARCHAR(14) NOT NULL,
  PRIMARY KEY (`id_analysis`),
  INDEX `fk_ANALYSIS_SAMPLE1_idx` (`sample_id` ASC),
  INDEX `fk_ANALYSIS_EMPLOYEE1_idx` (`employee_dpi` ASC),
  CONSTRAINT `fk_ANALYSIS_SAMPLE1`
    FOREIGN KEY (`sample_id`)
    REFERENCES `water_laboratory`.`SAMPLE` (`id_sample`),
  CONSTRAINT `fk_ANALYSIS_EMPLOYEE1`
    FOREIGN KEY (`employee_dpi`)
    REFERENCES `water_laboratory`.`EMPLOYEE` (`dpi_employee`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `water_laboratory`.`ANALYSIS_PACKAGE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `water_laboratory`.`ANALYSIS_PACKAGE` ;

CREATE TABLE IF NOT EXISTS `water_laboratory`.`ANALYSIS_PACKAGE` (
  `id_analysis_package` INT NOT NULL AUTO_INCREMENT,
  `package_id` VARCHAR(10) NOT NULL,
  `analysis_id` INT NOT NULL,
  PRIMARY KEY (`id_analysis_package`),
  INDEX `fk_ANALYSIS_PACKAGE_PACKAGE_idx` (`package_id` ASC),
  INDEX `fk_ANALYSIS_PACKAGE_ANALYSIS1_idx` (`analysis_id` ASC),
  CONSTRAINT `fk_ANALYSIS_PACKAGE_PACKAGE`
    FOREIGN KEY (`package_id`)
    REFERENCES `water_laboratory`.`PACKAGE` (`id_package`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ANALYSIS_PACKAGE_ANALYSIS1`
    FOREIGN KEY (`analysis_id`)
    REFERENCES `water_laboratory`.`ANALYSIS` (`id_analysis`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `water_laboratory` ;

-- -----------------------------------------------------
-- Table `water_laboratory`.`EQUIPMENT`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `water_laboratory`.`EQUIPMENT` ;

CREATE TABLE IF NOT EXISTS `water_laboratory`.`EQUIPMENT` (
  `id_equipment` INT NOT NULL AUTO_INCREMENT,
  `name_equipment` VARCHAR(45) NOT NULL,
  `model_equipment` VARCHAR(45) NOT NULL,
  `working_hours` INT NOT NULL,
  `maintenance_time` INT NOT NULL,
  PRIMARY KEY (`id_equipment`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `water_laboratory`.`PROVIDER`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `water_laboratory`.`PROVIDER` ;

CREATE TABLE IF NOT EXISTS `water_laboratory`.`PROVIDER` (
  `id_provider` INT NOT NULL AUTO_INCREMENT,
  `nit_provider` VARCHAR(14) NOT NULL,
  `name_provider` VARCHAR(45) NOT NULL,
  `phone_provider` VARCHAR(15) NOT NULL,
  `direction_provider` TINYTEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id_provider`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `water_laboratory`.`MAINTENANCE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `water_laboratory`.`MAINTENANCE` ;

CREATE TABLE IF NOT EXISTS `water_laboratory`.`MAINTENANCE` (
  `id_maintenance` INT NOT NULL AUTO_INCREMENT,
  `maintenance_date` DATE NOT NULL,
  `maintenance_cost` DOUBLE NOT NULL,
  `equipment_id` INT NOT NULL,
  `provider_id` INT NOT NULL,
  PRIMARY KEY (`id_maintenance`),
  INDEX `fk_MAINTENANCE_EQUIPMENT1_idx` (`equipment_id` ASC),
  INDEX `fk_MAINTENANCE_PROVIDER1_idx` (`provider_id` ASC),
  CONSTRAINT `fk_MAINTENANCE_EQUIPMENT1`
    FOREIGN KEY (`equipment_id`)
    REFERENCES `water_laboratory`.`EQUIPMENT` (`id_equipment`),
  CONSTRAINT `fk_MAINTENANCE_PROVIDER1`
    FOREIGN KEY (`provider_id`)
    REFERENCES `water_laboratory`.`PROVIDER` (`id_provider`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `water_laboratory`.`MEASURE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `water_laboratory`.`MEASURE` ;

CREATE TABLE IF NOT EXISTS `water_laboratory`.`MEASURE` (
  `id_measure` INT NOT NULL AUTO_INCREMENT,
  `name_measure` VARCHAR(45) NOT NULL,
  `description` TINYTEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id_measure`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `water_laboratory`.`PARAMETER`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `water_laboratory`.`PARAMETER` ;

CREATE TABLE IF NOT EXISTS `water_laboratory`.`PARAMETER` (
  `id_parameter` VARCHAR(10) NOT NULL,
  `name_parameter` VARCHAR(45) NOT NULL,
  `MR_code` VARCHAR(20) NOT NULL,
  `below_limit` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id_parameter`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `water_laboratory`.`PARAMETER_PACKAGE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `water_laboratory`.`PARAMETER_PACKAGE` ;

CREATE TABLE IF NOT EXISTS `water_laboratory`.`PARAMETER_PACKAGE` (
  `id_PP` INT NOT NULL AUTO_INCREMENT,
  `LMA` DOUBLE NOT NULL,
  `LMP` DOUBLE NOT NULL,
  `parameter_id` VARCHAR(10) NOT NULL,
  `package_id` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id_PP`),
  INDEX `fk_PARAMENTER_PACKAGE_PARAMETER1_idx` (`parameter_id` ASC),
  INDEX `fk_PARAMETER_PACKAGE_PACKAGE1_idx` (`package_id` ASC),
  CONSTRAINT `fk_PARAMENTER_PACKAGE_PARAMETER1`
    FOREIGN KEY (`parameter_id`)
    REFERENCES `water_laboratory`.`PARAMETER` (`id_parameter`),
  CONSTRAINT `fk_PARAMETER_PACKAGE_PACKAGE1`
    FOREIGN KEY (`package_id`)
    REFERENCES `water_laboratory`.`PACKAGE` (`id_package`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `water_laboratory`.`PARAMETER_EQUIPMENT`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `water_laboratory`.`PARAMETER_EQUIPMENT` ;

CREATE TABLE IF NOT EXISTS `water_laboratory`.`PARAMETER_EQUIPMENT` (
  `id_parameter_equipment` INT NOT NULL AUTO_INCREMENT,
  `working_hours` DOUBLE NOT NULL,
  `equipment_id` INT NOT NULL,
  `parameter_id` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id_parameter_equipment`),
  INDEX `fk_PARAMETER_EQUIPMENT_EQUIPMENT1_idx` (`equipment_id` ASC),
  INDEX `fk_PARAMETER_EQUIPMENT_PARAMETER1_idx` (`parameter_id` ASC),
  CONSTRAINT `fk_PARAMETER_EQUIPMENT_EQUIPMENT1`
    FOREIGN KEY (`equipment_id`)
    REFERENCES `water_laboratory`.`EQUIPMENT` (`id_equipment`),
  CONSTRAINT `fk_PARAMETER_EQUIPMENT_PARAMETER1`
    FOREIGN KEY (`parameter_id`)
    REFERENCES `water_laboratory`.`PARAMETER` (`id_parameter`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `water_laboratory`.`PARAMETER_RESULT`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `water_laboratory`.`PARAMETER_RESULT` ;

CREATE TABLE IF NOT EXISTS `water_laboratory`.`PARAMETER_RESULT` (
  `id_parameter_result` INT NOT NULL AUTO_INCREMENT,
  `result` DOUBLE NOT NULL,
  `analysis_package_id` INT NOT NULL,
  `parameter_id` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id_parameter_result`),
  INDEX `fk_PARAMETER_RESULT_ANALYSIS_PACKAGE1_idx` (`analysis_package_id` ASC),
  INDEX `fk_PARAMETER_RESULT_PARAMETER1_idx` (`parameter_id` ASC),
  CONSTRAINT `fk_PARAMETER_RESULT_ANALYSIS_PACKAGE1`
    FOREIGN KEY (`analysis_package_id`)
    REFERENCES `water_laboratory`.`ANALYSIS_PACKAGE` (`id_analysis_package`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PARAMETER_RESULT_PARAMETER1`
    FOREIGN KEY (`parameter_id`)
    REFERENCES `water_laboratory`.`PARAMETER` (`id_parameter`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `water_laboratory`.`SUPPLY`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `water_laboratory`.`SUPPLY` ;

CREATE TABLE IF NOT EXISTS `water_laboratory`.`SUPPLY` (
  `id_supply` INT NOT NULL AUTO_INCREMENT,
  `name_supply` VARCHAR(45) NOT NULL,
  `date_expiry` DATE NOT NULL,
  `quantity_available` DOUBLE NOT NULL,
  `security_sheet` TINYBLOB NULL DEFAULT NULL,
  `measure_id` INT NOT NULL,
  PRIMARY KEY (`id_supply`),
  INDEX `fk_SUPPLY_MEASURE1_idx` (`measure_id` ASC),
  CONSTRAINT `fk_SUPPLY_MEASURE1`
    FOREIGN KEY (`measure_id`)
    REFERENCES `water_laboratory`.`MEASURE` (`id_measure`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `water_laboratory`.`PARAMETER_SUPPLY`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `water_laboratory`.`PARAMETER_SUPPLY` ;

CREATE TABLE IF NOT EXISTS `water_laboratory`.`PARAMETER_SUPPLY` (
  `id_parameter_supply` INT NOT NULL AUTO_INCREMENT,
  `amount_used` DOUBLE NOT NULL,
  `parameter_id` VARCHAR(10) NOT NULL,
  `supply_id` INT NOT NULL,
  PRIMARY KEY (`id_parameter_supply`),
  INDEX `fk_PARAMETER_SUPPLY_PARAMETER1_idx` (`parameter_id` ASC),
  INDEX `fk_PARAMETER_SUPPLY_SUPPLY1_idx` (`supply_id` ASC),
  CONSTRAINT `fk_PARAMETER_SUPPLY_PARAMETER1`
    FOREIGN KEY (`parameter_id`)
    REFERENCES `water_laboratory`.`PARAMETER` (`id_parameter`),
  CONSTRAINT `fk_PARAMETER_SUPPLY_SUPPLY1`
    FOREIGN KEY (`supply_id`)
    REFERENCES `water_laboratory`.`SUPPLY` (`id_supply`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `water_laboratory`.`SHOPPING`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `water_laboratory`.`SHOPPING` ;

CREATE TABLE IF NOT EXISTS `water_laboratory`.`SHOPPING` (
  `id_shopping` INT NOT NULL AUTO_INCREMENT,
  `amount_purchased` DOUBLE NOT NULL,
  `date_shopping` DATE NOT NULL,
  `note_shopping` VARCHAR(200) NULL DEFAULT NULL,
  `supply_id` INT NULL DEFAULT NULL,
  `equipment_id` INT NULL DEFAULT NULL,
  `provider_id` INT NOT NULL,
  PRIMARY KEY (`id_shopping`),
  INDEX `fk_SHOPPING_SUPPLY1_idx` (`supply_id` ASC),
  INDEX `fk_SHOPPING_PROVIDER1_idx` (`provider_id` ASC),
  INDEX `fk_SHOPPING_EQUIPMENT1_idx` (`equipment_id` ASC),
  CONSTRAINT `fk_SHOPPING_EQUIPMENT1`
    FOREIGN KEY (`equipment_id`)
    REFERENCES `water_laboratory`.`EQUIPMENT` (`id_equipment`),
  CONSTRAINT `fk_SHOPPING_PROVIDER1`
    FOREIGN KEY (`provider_id`)
    REFERENCES `water_laboratory`.`PROVIDER` (`id_provider`),
  CONSTRAINT `fk_SHOPPING_SUPPLY1`
    FOREIGN KEY (`supply_id`)
    REFERENCES `water_laboratory`.`SUPPLY` (`id_supply`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
