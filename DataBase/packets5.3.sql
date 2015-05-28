-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-05-2015 a las 10:11:30
-- Versión del servidor: 5.6.21
-- Versión de PHP: 5.6.3

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
-- Estructura de tabla para la tabla `branchs`
--

CREATE TABLE IF NOT EXISTS `branchs` (
`id` int(11) NOT NULL,
  `branch_name` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `address` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `postal_code` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `city` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `state` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `country` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `phone` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `registration_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `date_removed` datetime DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `branchs`
--

INSERT INTO `branchs` (`id`, `branch_name`, `address`, `postal_code`, `city`, `state`, `country`, `phone`, `registration_date`, `date_removed`) VALUES
(1, 'sucursales', 'nnjkl7', '82000', 'opo', 'ppp', 'kkk', '9820269', '2015-05-28 01:28:19', '2015-05-28 01:28:19');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `customers`
--

CREATE TABLE IF NOT EXISTS `customers` (
`ID` int(5) NOT NULL,
  `name` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `last_name` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `company_name` varchar(70) COLLATE utf8_spanish_ci DEFAULT NULL,
  `RFC` varchar(12) COLLATE utf8_spanish_ci DEFAULT NULL,
  `phone` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `address` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `postal_code` int(5) NOT NULL,
  `city` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `state` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `country` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `position` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `degree` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `email` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `username` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(32) COLLATE utf8_spanish_ci NOT NULL,
  `registration_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `date_removed` datetime DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `customers`
--

INSERT INTO `customers` (`ID`, `name`, `last_name`, `company_name`, `RFC`, `phone`, `address`, `postal_code`, `city`, `state`, `country`, `position`, `degree`, `email`, `username`, `password`, `registration_date`, `date_removed`) VALUES
(1, 'Humberto', 'Lugo Aguilar', 'NULL', 'NULL', '6691536979', 'Bahia Ceuta #501 Col. Mazatlan 3', 82193, 'Mazatlan', 'Sinaloa', 'Mexico', 'NULL', 'Dr.', 'lugoe_@hotmail.com', 'lugoe', '6779c91708de5fbb697206fa7dbe84d0', '2015-05-25 12:15:31', NULL),
(2, 'Cortez Hernandez', 'Gabino', 'NULL', 'NULL', '6951091757', 'Ramon F. Iturbe #502 Colonia Infonavit Playas', 82580, 'Mazatlan', 'Sinaloa', 'Mexico', 'NULL', 'Dr.', 'onibag_93@hotmail.com', 'gabino93', '84f0ac1160190ae4b2cf5bef9cd526a6', '2015-05-25 12:19:08', NULL),
(3, 'Lopez Castañeda', 'Paul Antonio', 'NULL', 'NULL', '9820269', 'Francisco Villa #2249. Col. Centro', 82000, 'Mazatlan', 'Sinaloa', 'Mexico', 'NULL', 'Lic.', 'paul@hotmail.com', 'paul', '25d55ad283aa400af464c76d713c07ad', '2015-05-25 12:24:48', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `employees`
--

CREATE TABLE IF NOT EXISTS `employees` (
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
  `registration_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `date_removed` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `location`
--

CREATE TABLE IF NOT EXISTS `location` (
`id` int(5) NOT NULL,
  `number_guide` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `id_branch` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `shipments`
--

CREATE TABLE IF NOT EXISTS `shipments` (
`id` int(5) NOT NULL,
  `location` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `number_guide` varchar(10) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `compromise` varchar(10) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `type_send` varchar(10) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `content` varchar(40) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `area_destination` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `sender` varchar(70) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `shipments_cost` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `shipments_costs`
--

CREATE TABLE IF NOT EXISTS `shipments_costs` (
  `about` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `package` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `overweight` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `type_branch`
--

CREATE TABLE IF NOT EXISTS `type_branch` (
`id` int(11) NOT NULL,
  `description` varchar(30) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `type_degree`
--

CREATE TABLE IF NOT EXISTS `type_degree` (
`id` int(5) NOT NULL,
  `description` varchar(30) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `type_degree`
--

INSERT INTO `type_degree` (`id`, `description`) VALUES
(1, 'DR.'),
(2, 'Lic.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `type_employee`
--

CREATE TABLE IF NOT EXISTS `type_employee` (
  `id` int(11) NOT NULL,
  `description` varchar(30) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `type_vehicles`
--

CREATE TABLE IF NOT EXISTS `type_vehicles` (
`id` int(5) NOT NULL,
  `capacity_weight` varchar(15) NOT NULL,
  `type` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehicles`
--

CREATE TABLE IF NOT EXISTS `vehicles` (
`id` int(5) NOT NULL,
  `brand` varchar(40) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `model` varchar(10) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `plate` varchar(8) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `number_vehicle` varchar(4) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `type_vehicle` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `driver` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `registration_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `removed_date` datetime DEFAULT NULL,
  `status` varchar(70) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `vehicles`
--

INSERT INTO `vehicles` (`id`, `brand`, `model`, `plate`, `number_vehicle`, `type_vehicle`, `driver`, `registration_date`, `removed_date`, `status`) VALUES
(2, 'Ford', 'F-200', 'PA2665LC', '02', 'Camioneta', 'Paul Lopez', '2015-05-26 11:25:30', NULL, 'javax.swing.ButtonGroup@51a20fb5'),
(3, 'Ford', 'F-250', 'HC265G9', '03', 'Camioneta', 'Gabino Cortez', '2015-05-26 12:01:43', NULL, 'javax.swing.ButtonGroup@1351c368'),
(4, 'Toyota', 'Tacoma', 'HL416A', '04', 'Camioneta', 'Humberto Lugo', '2015-05-26 12:11:27', NULL, 'javax.swing.JToggleButton$ToggleButtonModel@6d565f45'),
(5, 'rfgf', 'ghgh', 'hfjhf', 'ghgh', 'Trailer', 'Gabino Cortez', '2015-05-26 12:16:39', NULL, 'javax.swing.JToggleButton$ToggleButtonModel@3f928b84'),
(6, 'fg', 'fg', 'fg', 'fg', 'Trailer', 'Gabino Cortez', '2015-05-26 12:20:36', NULL, 'javax.swing.JToggleButton$ToggleButtonModel@461b3399');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `branchs`
--
ALTER TABLE `branchs`
 ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `customers`
--
ALTER TABLE `customers`
 ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `employees`
--
ALTER TABLE `employees`
 ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `location`
--
ALTER TABLE `location`
 ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `shipments`
--
ALTER TABLE `shipments`
 ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `type_branch`
--
ALTER TABLE `type_branch`
 ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `type_degree`
--
ALTER TABLE `type_degree`
 ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `type_employee`
--
ALTER TABLE `type_employee`
 ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `type_vehicles`
--
ALTER TABLE `type_vehicles`
 ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `vehicles`
--
ALTER TABLE `vehicles`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `branchs`
--
ALTER TABLE `branchs`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `customers`
--
ALTER TABLE `customers`
MODIFY `ID` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `employees`
--
ALTER TABLE `employees`
MODIFY `id` int(15) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `location`
--
ALTER TABLE `location`
MODIFY `id` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `shipments`
--
ALTER TABLE `shipments`
MODIFY `id` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `type_branch`
--
ALTER TABLE `type_branch`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `type_degree`
--
ALTER TABLE `type_degree`
MODIFY `id` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `type_vehicles`
--
ALTER TABLE `type_vehicles`
MODIFY `id` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `vehicles`
--
ALTER TABLE `vehicles`
MODIFY `id` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
