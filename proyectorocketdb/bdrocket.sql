-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.9.2-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para registros
CREATE DATABASE IF NOT EXISTS `registros` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `registros`;

-- Volcando estructura para tabla registros.habitaciones
CREATE TABLE IF NOT EXISTS `habitaciones` (
  `id` int(11) NOT NULL,
  `capacidad` int(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla registros.habitaciones: ~5 rows (aproximadamente)
DELETE FROM `habitaciones`;
/*!40000 ALTER TABLE `habitaciones` DISABLE KEYS */;
INSERT INTO `habitaciones` (`id`, `capacidad`) VALUES
	(1, 2),
	(2, 3),
	(3, 4),
	(4, 5),
	(5, 6),
	(10, 1);
/*!40000 ALTER TABLE `habitaciones` ENABLE KEYS */;

-- Volcando estructura para tabla registros.registros
CREATE TABLE IF NOT EXISTS `registros` (
  `id_registro` int(11) NOT NULL AUTO_INCREMENT,
  `cedula` varchar(15) NOT NULL,
  `fecha_llegada` varchar(50) NOT NULL DEFAULT '',
  `fecha_salida` varchar(50) NOT NULL DEFAULT '',
  `ciudad_origen` varchar(100) NOT NULL,
  `id_habitacion` int(11) NOT NULL,
  PRIMARY KEY (`id_registro`),
  KEY `cedula` (`cedula`),
  KEY `id_habitacion` (`id_habitacion`),
  CONSTRAINT `registros_ibfk_1` FOREIGN KEY (`cedula`) REFERENCES `usuarios` (`cedula`),
  CONSTRAINT `registros_ibfk_2` FOREIGN KEY (`id_habitacion`) REFERENCES `habitaciones` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla registros.registros: ~41 rows (aproximadamente)
DELETE FROM `registros`;
/*!40000 ALTER TABLE `registros` DISABLE KEYS */;
INSERT INTO `registros` (`id_registro`, `cedula`, `fecha_llegada`, `fecha_salida`, `ciudad_origen`, `id_habitacion`) VALUES
	(1, '1111222333', '0000-00-00', '0000-00-00', 'Medellín', 1),
	(2, '1111222333', '2022-08-22', '2022-08-28', 'Medellín', 1),
	(3, '1111222333', '2022-08-22', '2022-08-28', 'Medellín', 5),
	(4, '1020333444', '2022-12-26', '2022-12-26', 'Medellín', 3),
	(5, '1020340560', '2022-12-26', '2022-12-26', 'Pereira', 5),
	(6, '1111222333', '2022-12-26', '2022-12-26', 'Medellín', 4),
	(7, '1111222333', '2022-12-26', '2022-12-26', 'Medellín', 4),
	(8, '1111222333', '2022-12-26', '2022-12-26', 'Medellín', 4),
	(9, '1020333444', '2022-09-17', '2022-09-18', 'Lima', 10),
	(10, '1020333444', '2022-09-17', '2022-09-18', 'Lima', 10),
	(11, '1020333444', '2022-09-17', '2022-09-18', 'Lima', 10),
	(12, '1020333444', '2022-09-17', '2022-09-18', 'Lima', 10),
	(13, '1020333444', '2022-09-17', '2022-09-18', 'Lima', 10),
	(14, '1020333444', '2022-09-17', '2022-09-18', 'Lima', 10),
	(15, '1020333444', '2022-09-17', '2022-09-18', 'Lima', 10),
	(16, '1020333444', '2022-09-17', '2022-09-18', 'Lima', 10),
	(17, '1020333444', '2022-09-17', '2022-09-18', 'Lima', 10),
	(18, '1020333444', '2022-09-17', '2022-09-18', 'Lima', 10),
	(19, '1234567890', '2022-12-26', '2022-12-26', 'Cartagena', 2),
	(20, '1234567890', '2022-12-26', '2022-12-26', 'Cartagena', 2),
	(21, '1234567890', '2022-12-26', '2022-12-26', 'Cartagena', 2),
	(22, '1234567890', '2022-12-26', '2022-12-26', 'Cartagena', 4),
	(23, '1020333448', '2022-12-26', '2022-12-26', 'Medellín', 5),
	(24, '1234567890', '2022-12-31', '2023-08-28', 'Medellín', 5),
	(25, '1234567890', '2022-12-26', '2022-12-26', 'Medellín', 4),
	(26, '1020333444', '2022-12-26', '2022-12-26', 'Bello', 3),
	(27, '1111444555', '2022-12-26', '2022-12-26', 'Medellín', 3),
	(28, '1234567890', '2022-09-22', '2022-12-26', 'Cali', 4),
	(29, '1020333444', '2022-09-22', '2022-09-22', 'Barranquilla', 5),
	(30, '1020333444', '2022-09-22', '2022-09-22', 'Barranquilla', 5),
	(31, '1020333444', '2022-09-22', '2022-09-22', 'Barranquilla', 1),
	(32, '1020333444', '2022-12-26', '2022-12-26', 'Medellín', 2),
	(33, '1020333444', '2022-12-26', '2022-12-26', 'Medellín', 1),
	(34, '1234567890', '2022-12-26', '2022-12-26', 'Medellín', 2),
	(35, '1020333444', '2021-12-26', '2021-12-26', 'Medellín', 1),
	(36, '1020333444', '2022-10-07', '2022-10-08', 'Medellín', 5),
	(37, '1020333444', '2022-10-07', '2022-10-08', 'Medellín', 5),
	(38, '1020333444', '2022-11-16', '2022-11-24', 'Medellín', 1),
	(39, '1020333444', '2022-12-01', '2022-12-31', 'Medellín', 1),
	(40, '1020333449', '2022-09-22', '2022-09-29', 'Medellín', 3),
	(41, '1152777888', '2022-09-22', '2022-09-26', 'Rionegro', 1),
	(42, '1111444555', '2022-09-01', '2022-09-30', 'Medellín', 5);
/*!40000 ALTER TABLE `registros` ENABLE KEYS */;

-- Volcando estructura para tabla registros.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `cedula` varchar(15) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `telefono` varchar(100) NOT NULL,
  `nacionalidad` varchar(50) NOT NULL,
  PRIMARY KEY (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla registros.usuarios: ~12 rows (aproximadamente)
DELETE FROM `usuarios`;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` (`cedula`, `nombre`, `apellido`, `email`, `telefono`, `nacionalidad`) VALUES
	('1020333444', 'Jésus', 'Gómez', 'jesus@gmail.com', '3112114455', 'Colombiano'),
	('1020333448', 'prueba', 'ape', 'prueba@gmail.com', '3003335566', 'Argentino'),
	('1020333449', 'Carlos', 'Perez', 'cp@gmail.com', '3112881122', 'Español'),
	('1020333456', 'prueba', 'ape', 'prueba@gmail.com', '3003335566', 'Colombiano'),
	('1020340560', 'Juan', 'Polo', 'jp@gmail.com', '3118119922', 'Mexicano'),
	('1110123456', 'Luis', 'Gomez', 'lg@gmail.com', '3005556622', 'Chileno'),
	('1111222333', 'Miguel', 'Perez', 'pperez@gmail.com', '3112223344', 'Peruano'),
	('1111444555', 'Marcos', 'Méndez', 'mm@gmail.com', '3113002211', 'Mexicano'),
	('1111777888', 'Juan', 'Diaz', 'jd@gmail.com', '3016014455', 'Chileno'),
	('1152777888', 'Maria', 'Lopez', 'mp@gmail.com', '3112003344', 'Colombiana'),
	('1234567890', 'Jose', 'Jose', 'jj@gmail.com', '3002001111', 'Paraguayo'),
	('43588699', 'Luz', 'Diaz', 'ld@gmail.com', '3206204455', 'Venezolana');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
