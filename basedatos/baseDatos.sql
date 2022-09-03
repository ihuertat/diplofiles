
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

DROP TABLE IF EXISTS `diplojava`.`Usuario` ;
CREATE TABLE IF NOT EXISTS `diplojava`.`Usuario`
(
	`id_usuario` VARCHAR(50) NOT NULL,
	`password` VARCHAR(50) NULL,
	`cifra` VARCHAR(256) NULL,
	CONSTRAINT `PK_USUARIO` PRIMARY KEY (`id_usuario` ASC)
)
;

DROP TABLE IF EXISTS `diplojava`.`Usuario_Rol` ;
CREATE TABLE IF NOT EXISTS `diplojava`.`Usuario_Rol`
(
	`id_usuario` VARCHAR(50) NOT NULL,
	`id_rol` SMALLINT NOT NULL,
	CONSTRAINT `PK_USUARIO_ROL` PRIMARY KEY (`id_usuario` ASC, `id_rol` ASC)
)
;

DROP TABLE IF EXISTS `diplojava`.`Rol` ;
CREATE TABLE IF NOT EXISTS `diplojava`.`Rol`
(
	`id_rol` SMALLINT NOT NULL,
	`descripcion` VARCHAR(50) NULL,
	CONSTRAINT `PK_ID_ROL` PRIMARY KEY (`id_rol` ASC)
)
;

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

INSERT INTO EMPLEADO VALUES  (null, "EMPLEADO ALFA",10000,null,3);
INSERT INTO EMPLEADO VALUES (null, "EMPLEADO BETA",20000,null,2);
INSERT INTO EMPLEADO VALUES (null, "EMPLEADO GAMA",25000,null,2);

INSERT INTO EmpleadosProyecto VALUES(1,2);
INSERT INTO EmpleadosProyecto VALUES(2,2);
INSERT INTO EmpleadosProyecto VALUES(3,4);

INSERT INTO Rol VALUES (1,'ROL1');
INSERT INTO Rol VALUES (2,'ROL2');
INSERT INTO Rol VALUES (3,'ROL3');

/*-- Usuario */
INSERT INTO Usuario VALUES ('ihuertat@gmail.com','ihuerta123','b5rQLeOcb90x7aTLWtcRvkgw+fgWn//wqrKA9p0YiIM=');
INSERT INTO Usuario VALUES ('medico1@gmail.com','medico1','GKewyS6fQbCv7iftLATkkZJInwZImUD2FmHjqOQ9/t0=');
INSERT INTO Usuario VALUES ('colaborador1@correo.com','medico1','GKewyS6fQbCv7iftLATkkZJInwZImUD2FmHjqOQ9/t0=');

/*---usuario rol*/
INSERT INTO Usuario_Rol VALUES ('ihuertat@gmail.com',1);
INSERT INTO Usuario_Rol VALUES ('ihuertat@gmail.com',2);
INSERT INTO Usuario_Rol VALUES ('medico1@gmail.com',2);
INSERT INTO Usuario_Rol VALUES ('colaborador1@correo.com',3);


commit;
