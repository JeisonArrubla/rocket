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

-- Volcando datos para la tabla registros.habitaciones: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `habitaciones` DISABLE KEYS */;
INSERT INTO `habitaciones` (`id`, `capacidad`) VALUES
	(1, 2),
	(2, 3),
	(3, 4),
	(4, 5),
	(5, 6),
	(10, 1);
/*!40000 ALTER TABLE `habitaciones` ENABLE KEYS */;

-- Volcando datos para la tabla registros.ingresos: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `ingresos` DISABLE KEYS */;
INSERT INTO `ingresos` (`id_registro`, `cedula`, `fecha_llegada`, `fecha_salida`, `ciudad_origen`, `id_habitacion`) VALUES
	(1, '1111222333', '0000-00-00', '0000-00-00', 'Medellín', 1),
	(2, '1111222333', '2022-08-22', '2022-08-28', 'Medellín', 1),
	(3, '1111222333', '2022-08-22', '2022-08-28', 'Medellín', 5);
/*!40000 ALTER TABLE `ingresos` ENABLE KEYS */;

-- Volcando datos para la tabla registros.usuarios: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` (`cedula`, `nombre`, `apellido`, `email`, `telefono`, `nacionalidad`) VALUES
	('1111222333', 'Pedro', 'Perez', 'pperez@gmail.com', '3112223344', 'Peruano'),
	('1111222334', 'Pedro', 'Perez', 'pperez@gmail.com', '3112223344', 'Peruano'),
	('1111222335', 'Bladimir', 'Perez', 'pperez@gmail.com', '3112223344', 'Peruano'),
	('1111222336', 'jeremias', 'Perez', 'pperez@gmail.com', '3112223344', 'Peruano'),
	('1111222337', 'didier', 'Perez', 'pperez@gmail.com', '3112223344', 'Peruano'),
	('1111222338', '', 'Perez', 'pperez@gmail.com', '3112223344', 'Peruano');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
