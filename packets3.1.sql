-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 14-05-2015 a las 18:21:21
-- Versión del servidor: 5.6.12
-- Versión de PHP: 5.5.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `packets`
--
CREATE DATABASE IF NOT EXISTS `packets` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `packets`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE IF NOT EXISTS `clientes` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(35) COLLATE utf8_spanish_ci NOT NULL,
  `nombre_compañia` varchar(70) COLLATE utf8_spanish_ci DEFAULT NULL,
  `rfc` varchar(12) COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefono` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `direccion` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `codigo_postal` int(5) NOT NULL,
  `ciudad` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `estado` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `pais` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `puesto` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `titulo` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `email` varchar(40) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre_usuario` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `contraseña` varchar(32) COLLATE utf8_spanish_ci NOT NULL,
  `fecha_registro` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_eliminado` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id`, `nombre`, `apellidos`, `nombre_compañia`, `rfc`, `telefono`, `direccion`, `codigo_postal`, `ciudad`, `estado`, `pais`, `puesto`, `titulo`, `email`, `nombre_usuario`, `contraseña`, `fecha_registro`, `fecha_eliminado`) VALUES
(1, 'Cortez Hernandez', 'Gabino', 'null', 'null', '6951091757', 'Infonavit Playas calle Ramon F. Iturbe #502', 82580, 'Mazatlan ', 'Sinaloa', 'Mexico', 'null', 'Lic.', 'onibag_93@hotmail.com', 'gabino93', '84f0ac1160190ae4b2cf5bef9cd526a6', '2015-05-14 10:07:25', NULL),
(2, 'Lòpez Castañeda', 'Paul Antonio', 'null', 'null', '9820269', 'Calle #2249 Col centro', 82000, 'Mazatlan', 'Sinaloa', 'Mexico', 'null', 'Dr.', 'paul_1mk@hotmail.com', 'paul123', '00a4de914aee7e0318532803fdd554f8', '2015-05-14 10:16:26', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE IF NOT EXISTS `empleados` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `apellido_paterno` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `apellido_materno` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `telefono` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `direccion` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `codigo_postal` int(5) NOT NULL,
  `sucursal` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `correo` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `tipo_empleado` int(11) NOT NULL,
  `fecha_registro` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_eliminado` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `envio`
--

CREATE TABLE IF NOT EXISTS `envio` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `localizacion` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `numero_guia` varchar(10) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `tipo_envio` varchar(10) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `contenido` varchar(40) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `destino` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `remitente` varchar(70) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `costo_envio` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `localizacion`
--

CREATE TABLE IF NOT EXISTS `localizacion` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `numero_guia` varchar(10) NOT NULL,
  `id_sucursal` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sucursales`
--

CREATE TABLE IF NOT EXISTS `sucursales` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_sucursal` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `direccion` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `codigo_postal` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `ciudad` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `estado` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `pais` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `telefono` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `fecha_registro` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_eliminado` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_envio`
--

CREATE TABLE IF NOT EXISTS `tipo_envio` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_vehiculo`
--

CREATE TABLE IF NOT EXISTS `tipo_vehiculo` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `capacidad_peso` varchar(15) NOT NULL,
  `descripcion` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculos`
--

CREATE TABLE IF NOT EXISTS `vehiculos` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `modelo` varchar(4) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `placa` varchar(8) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `numero_vehiculo` varchar(4) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `tipo_vehiculo` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `chofer` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `estado` varchar(25) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `localizacion` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `fecha_registro` datetime DEFAULT CURRENT_TIMESTAMP,
  `fecha_eliminado` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
