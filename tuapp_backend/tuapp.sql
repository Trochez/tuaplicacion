-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 09, 2018 at 10:38 PM
-- Server version: 5.7.24-0ubuntu0.18.04.1
-- PHP Version: 7.2.10-0ubuntu1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tuapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `additionalinfo`
--

CREATE TABLE `additionalinfo` (
  `id` int(11) NOT NULL,
  `art` varchar(80) NOT NULL,
  `music` varchar(80) NOT NULL,
  `movies` varchar(80) NOT NULL,
  `basicid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `basicinfo`
--

CREATE TABLE `basicinfo` (
  `id` int(11) NOT NULL,
  `name` varchar(80) NOT NULL,
  `lastname` varchar(80) NOT NULL,
  `tel` int(11) NOT NULL,
  `email` varchar(80) NOT NULL,
  `address` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `additionalinfo`
--
ALTER TABLE `additionalinfo`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `basicinfo`
--
ALTER TABLE `basicinfo`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `additionalinfo`
--
ALTER TABLE `additionalinfo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `basicinfo`
--
ALTER TABLE `basicinfo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
