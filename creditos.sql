-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 09-11-2015 a las 20:08:11
-- Versión del servidor: 5.5.46
-- Versión de PHP: 5.3.10-1ubuntu3.21

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `creditos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE IF NOT EXISTS `alumnos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `legajo` int(11) NOT NULL,
  `dni` varchar(8) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `apellido` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `carreras_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `carreras_id` (`carreras_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`id`, `legajo`, `dni`, `nombre`, `apellido`, `carreras_id`) VALUES
(1, 5893, '0', 'Alvaro German', 'Bruseghini', 1),
(2, 5967, '1', 'Joel', 'De Filippis', 1),
(3, 5972, '3', 'Matias Andres', 'Quevedo Cotela', 1),
(4, 5675, '4', 'Maximiliano Gabriel', 'Saavedra', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `anios`
--

CREATE TABLE IF NOT EXISTS `anios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `credito_minimo` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `anios`
--

INSERT INTO `anios` (`id`, `nombre`, `credito_minimo`) VALUES
(1, '1º Año', 100),
(2, '2º Año', 100),
(3, '3ª Año', 120),
(4, '4º Año', 120),
(5, '5º Año', 120);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carreras`
--

CREATE TABLE IF NOT EXISTS `carreras` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `carreras`
--

INSERT INTO `carreras` (`id`, `nombre`) VALUES
(1, 'Ingenieria en Informatica'),
(2, 'Ingenieria en Computacion'),
(3, 'Arquitectura'),
(5, 'Escribania');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carreras_materias`
--

CREATE TABLE IF NOT EXISTS `carreras_materias` (
  `carreras_id` int(11) NOT NULL,
  `materias_id` int(11) NOT NULL,
  PRIMARY KEY (`carreras_id`,`materias_id`),
  KEY `materias_id` (`materias_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `carreras_materias`
--

INSERT INTO `carreras_materias` (`carreras_id`, `materias_id`) VALUES
(1, 1),
(2, 1),
(1, 3),
(2, 3),
(3, 3),
(1, 5),
(3, 5),
(3, 7),
(1, 8),
(2, 8),
(1, 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gmaps`
--

CREATE TABLE IF NOT EXISTS `gmaps` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lat` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `lng` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `gmaps`
--

INSERT INTO `gmaps` (`id`, `lat`, `lng`, `nombre`) VALUES
(1, '-34.61788130602615', '-68.33096996826168', 'Universidad Champagnat'),
(2, '-34.61385500498892', '-68.32745091003414', 'Universidad de Mendoza'),
(3, '-34.61297201812472', '-68.32715050262448', 'UNCuyo'),
(4, '-34.60138636055336', '-68.32800880950924', 'U.T.N.'),
(5, '-34.60211492704595', '-68.33930090946194', 'I.E.S. 9-012 Instituto de EducaciÃÂ³n Superior'),
(6, '-34.61477330136454', '-68.33085195106503', 'LLALALA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materias`
--

CREATE TABLE IF NOT EXISTS `materias` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `legajo` varchar(8) COLLATE utf8_spanish_ci NOT NULL,
  `creditos` int(11) NOT NULL DEFAULT '0',
  `nombre` varchar(120) COLLATE utf8_spanish_ci NOT NULL,
  `anios_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `anios_id` (`anios_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=10 ;

--
-- Volcado de datos para la tabla `materias`
--

INSERT INTO `materias` (`id`, `legajo`, `creditos`, `nombre`, `anios_id`) VALUES
(1, 'A31B', 12, 'Ingenieria de Software Aplicada', 4),
(3, '1234', 10, 'Computacion IIr', 2),
(5, 'I100', 10, 'InglesÃ­a', 5),
(7, 'I200', 10, 'Ingles 2', 1),
(8, 'AB', 22, 'Algebra de Boole', 2),
(9, 'Ott', 12, 'Computacion I', 1);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD CONSTRAINT `alumnos_ibfk_1` FOREIGN KEY (`carreras_id`) REFERENCES `carreras` (`id`);

--
-- Filtros para la tabla `carreras_materias`
--
ALTER TABLE `carreras_materias`
  ADD CONSTRAINT `carreras_materias_ibfk_1` FOREIGN KEY (`carreras_id`) REFERENCES `carreras` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `carreras_materias_ibfk_2` FOREIGN KEY (`materias_id`) REFERENCES `materias` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `materias`
--
ALTER TABLE `materias`
  ADD CONSTRAINT `materias_ibfk_2` FOREIGN KEY (`anios_id`) REFERENCES `anios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
