-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema schooldb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema schooldb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `schooldb`;
CREATE SCHEMA IF NOT EXISTS `schooldb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `schooldb` ;

-- -----------------------------------------------------
-- Table `schooldb`.`bill`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schooldb`.`bill` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `orderID` INT NOT NULL,
  `firstName` VARCHAR(45) NULL DEFAULT NULL,
  `lastName` VARCHAR(45) NULL DEFAULT NULL,
  `productName` VARCHAR(45) NULL DEFAULT NULL,
  `quantity` INT NULL DEFAULT NULL,
  `price` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `schooldb`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schooldb`.`client` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NULL DEFAULT NULL,
  `lastName` VARCHAR(45) NULL DEFAULT NULL,
  `address` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 31
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `schooldb`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schooldb`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `price` DOUBLE NULL DEFAULT NULL,
  `stock` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `schooldb`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schooldb`.`orders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `clientID` INT NOT NULL,
  `productID` INT NOT NULL,
  `quantity` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `order-client_idx` (`clientID` ASC) VISIBLE,
  INDEX `order-product_idx` (`productID` ASC) VISIBLE,
  CONSTRAINT `order-client`
    FOREIGN KEY (`clientID`)
    REFERENCES `schooldb`.`client` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `order-product`
    FOREIGN KEY (`productID`)
    REFERENCES `schooldb`.`product` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 29
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
