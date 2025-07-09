CREATE DATABASE `empleados_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE empleados_db;

CREATE TABLE `empleado` (
  `documento` int NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `horas` int DEFAULT NULL,
  `salario` double DEFAULT NULL,
  `aumento` double DEFAULT NULL,
  `total` double DEFAULT NULL,
  PRIMARY KEY (`documento`)
);
