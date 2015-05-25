-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-05-2015 a las 08:27:26
-- Versión del servidor: 5.6.20
-- Versión de PHP: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `packets`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE IF NOT EXISTS `clientes` (
`ID` int(5) NOT NULL,
  `nombre` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `nombre_compañia` varchar(70) COLLATE utf8_spanish_ci DEFAULT NULL,
  `RFC` varchar(12) COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefono` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `direccion` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `numero` int(6) NOT NULL,
  `CP` int(5) NOT NULL,
  `ciudad` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `estado` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `pais` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `puesto` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `titulo` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `email` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `nombre_usuario` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `contraseña` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `fecha_registro` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_eliminado` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `costo_envio`
--

CREATE TABLE IF NOT EXISTS `costo_envio` (
  `about` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `package` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `overweight` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE IF NOT EXISTS `empleados` (
`id` int(15) NOT NULL,
  `last_name` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `name` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `address` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `phone` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `postal_code` int(15) NOT NULL,
  `branch` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `type_employee` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `sex` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `fecha_registro` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `fecha_eliminado` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `envio`
--

CREATE TABLE IF NOT EXISTS `envio` (
`id` int(5) NOT NULL,
  `location` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `guider_number` varchar(10) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `compromise` varchar(10) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `type_send` varchar(10) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `content` varchar(40) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `area_destination` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `sender` varchar(70) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `shipments_cost` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `localizacion`
--

CREATE TABLE IF NOT EXISTS `localizacion` (
`id` int(5) NOT NULL,
  `description` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `id_branch` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sucursales`
--

CREATE TABLE IF NOT EXISTS `sucursales` (
`id` int(11) NOT NULL,
  `nombre_sucursal` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `direccion` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `numero` int(15) NOT NULL,
  `cp` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `ciudad` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `estado` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `pais` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `telefono` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `fecha_registro` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `fecha_eliminado` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_titulo`
--

CREATE TABLE IF NOT EXISTS `tipo_titulo` (
`id` int(5) NOT NULL,
  `descripcion` varchar(30) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_vehiculo`
--

CREATE TABLE IF NOT EXISTS `tipo_vehiculo` (
`id` int(5) NOT NULL,
  `weight_capacity` varchar(15) NOT NULL,
  `type` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculos`
--

CREATE TABLE IF NOT EXISTS `vehiculos` (
`id` int(5) NOT NULL,
  `brand` varchar(40) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `model` varchar(10) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `plate` varchar(8) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `number_vehicle` varchar(4) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `type_vehicle` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `driver` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `registration_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `removed_date` datetime DEFAULT NULL,
  `status` varchar(40) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `vehiculos`
--

INSERT INTO `vehiculos` (`id`, `brand`, `model`, `plate`, `number_vehicle`, `type_vehicle`, `driver`, `registration_date`, `removed_date`, `status`) VALUES
(1, 'Ford', 'F-150', 'GC265H93', '01', 'Camioneta', 'Gabino Cortez', '2015-05-18 11:06:41', NULL, 'javax.swing.ButtonGroup@11cfb589');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
 ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
 ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `envio`
--
ALTER TABLE `envio`
 ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `localizacion`
--
ALTER TABLE `localizacion`
 ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `sucursales`
--
ALTER TABLE `sucursales`
 ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipo_titulo`
--
ALTER TABLE `tipo_titulo`
 ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipo_vehiculo`
--
ALTER TABLE `tipo_vehiculo`
 ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `vehiculos`
--
ALTER TABLE `vehiculos`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
MODIFY `ID` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `empleados`
--
ALTER TABLE `empleados`
MODIFY `id` int(15) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `envio`
--
ALTER TABLE `envio`
MODIFY `id` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `localizacion`
--
ALTER TABLE `localizacion`
MODIFY `id` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `sucursales`
--
ALTER TABLE `sucursales`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `tipo_titulo`
--
ALTER TABLE `tipo_titulo`
MODIFY `id` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `tipo_vehiculo`
--
ALTER TABLE `tipo_vehiculo`
MODIFY `id` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `vehiculos`
--
ALTER TABLE `vehiculos`
MODIFY `id` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
