-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-09-2020 a las 04:39:52
-- Versión del servidor: 10.1.40-MariaDB
-- Versión de PHP: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `test`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `buy_transaction`
--

CREATE TABLE `buy_transaction` (
  `id` bigint(20) NOT NULL,
  `id_client` bigint(20) DEFAULT NULL,
  `id_product` bigint(20) DEFAULT NULL,
  `approved` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `buy_transaction`
--

INSERT INTO `buy_transaction` (`id`, `id_client`, `id_product`, `approved`) VALUES
(1, 2, 4, b'1'),
(2, 1, 7, b'1'),
(3, 1, 2, b'0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `client`
--

CREATE TABLE `client` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `cuit` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `client`
--

INSERT INTO `client` (`id`, `created_at`, `cuit`, `name`, `surname`, `updated_at`) VALUES
(1, '2020-09-20 00:33:56.000000', '20290191964', 'Ale', 'Isoba', '2020-09-20 00:33:56.000000'),
(2, '2020-09-20 00:33:56.000000', '20290191964', 'Maxi', 'Isoba', '2020-09-20 00:33:56.000000');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `product`
--

CREATE TABLE `product` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `product`
--

INSERT INTO `product` (`id`, `created_at`, `description`, `name`, `price`, `updated_at`) VALUES
(1, '2020-09-19 23:07:30.000000', 'product1', 'product1', '1.00', '2020-09-19 23:07:30.000000'),
(2, '2020-09-19 23:18:21.000000', 'product2', 'product2', '1.00', '2020-09-19 23:18:21.000000'),
(3, '2020-09-19 23:18:21.000000', 'producto modificado', 'producto modificado', '1.00', '2020-09-19 23:41:50.000000'),
(7, '2020-09-19 23:38:18.000000', 'product7', 'product7', '1.00', '2020-09-19 23:38:18.000000');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `buy_transaction`
--
ALTER TABLE `buy_transaction`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `buy_transaction`
--
ALTER TABLE `buy_transaction`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `client`
--
ALTER TABLE `client`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `product`
--
ALTER TABLE `product`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
