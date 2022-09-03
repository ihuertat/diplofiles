
-- -----------------------------------------------------
-- Schema diplojava
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `diplojava` DEFAULT CHARACTER SET utf8 ;
USE `diplojava` ;

SET FOREIGN_KEY_CHECKS=0;

-- CREATE TABLE `producto` (
--  `id` int NOT NULL AUTO_INCREMENT,
--  `nombre` varchar(45) NOT NULL,
--  `descripcion` varchar(45) NOT NULL,
--  `precio` float NOT NULL,
--  PRIMARY KEY (`id`)
-- ) AUTO_INCREMENT=11

-- -----------------------------------------------------
-- Table `diplojava`.`Departamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `diplojava`.`Departamento` ;

CREATE TABLE IF NOT EXISTS `diplojava`.`Departamento` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

-- -----------------------------------------------------
-- Table `diplojava`.`Empleado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `diplojava`.`Empleado` ;

CREATE TABLE IF NOT EXISTS `diplojava`.`Empleado` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `salario` REAL NOT NULL,
  `correo` VARCHAR(45),
  `departamento` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_departamento_idx` (`departamento` ASC) VISIBLE,
  CONSTRAINT `fk_departamento`
    FOREIGN KEY (`departamento`)
    REFERENCES `diplojava`.`Departamento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- -----------------------------------------------------
-- Table `diplojava`.`Proyecto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `diplojava`.`Proyecto` ;

CREATE TABLE IF NOT EXISTS `diplojava`.`Proyecto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

-- -----------------------------------------------------
-- Table `diplojava`.`EmpleadosProyecto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `diplojava`.`EmpleadosProyecto` ;

CREATE TABLE IF NOT EXISTS `diplojava`.`EmpleadosProyecto` (
  `idEmpleado` INT NOT NULL,
  `idProyecto` INT NOT NULL,
  PRIMARY KEY (`idEmpleado`, `idProyecto`),
  INDEX `fk_id_proyecto_idx` (`idProyecto` ASC) VISIBLE,
  CONSTRAINT `fk_id_empleado`
    FOREIGN KEY (`idEmpleado`)
    REFERENCES `diplojava`.`Empleado` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_id_proyecto`
    FOREIGN KEY (`idProyecto`)
    REFERENCES `diplojava`.`Proyecto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

SET FOREIGN_KEY_CHECKS=1
;
COMMIT;


INSERT INTO Proyecto VALUES (1,"Proyecto A");
INSERT INTO Proyecto VALUES (2,"Proyecto B");
INSERT INTO Proyecto VALUES (3,"Proyecto C");
INSERT INTO Proyecto VALUES (4,"Proyecto D");

INSERT INTO Departamento VALUES (1,"Departamento 1");
INSERT INTO Departamento VALUES (2,"Departamento 2");
INSERT INTO Departamento VALUES (3,"Departamento 3");
INSERT INTO Departamento VALUES (4,"Departamento 4");
INSERT INTO Departamento VALUES (5,"Departamento 5");

INSERT INTO Empleado VALUES  (null, "EMPLEADO ALFA",10000,null,3);
INSERT INTO Empleado VALUES (null, "EMPLEADO BETA",20000,null,2);
INSERT INTO Empleado VALUES (null, "EMPLEADO GAMA",25000,null,2);

INSERT INTO EmpleadosProyecto VALUES(1,2);
INSERT INTO EmpleadosProyecto VALUES(2,2);
INSERT INTO EmpleadosProyecto VALUES(3,4);

commit;
