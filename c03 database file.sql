-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 22, 2019 at 10:03 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `c03`
--

-- --------------------------------------------------------

--
-- Table structure for table `manager`
--

CREATE TABLE `manager` (
  `mid` varchar(10) NOT NULL,
  `mname` varchar(10) NOT NULL,
  `designation` varchar(10) NOT NULL,
  `msalary` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `manager`
--

INSERT INTO `manager` (`mid`, `mname`, `designation`, `msalary`) VALUES
('m01', 'manager1', 'manager', 25000.00),
('w01', 'worker1', 'worker', 12000.00),
('w02', 'worker2', 'worker', 12000.00),
('w033', 'worker', 'worker', 10000.00),
('w04', 'worker4', 'worker', 10000.00),
('w05', 'worker5', 'worker', 8000.00),
('w06', 'worker6', 'worker', 8000.00),
('w07', 'worker7', 'worker', 12000.00);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `productId` varchar(10) NOT NULL,
  `pname` varchar(10) NOT NULL,
  `count` int(10) NOT NULL,
  `price` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`productId`, `pname`, `count`, `price`) VALUES
('p01', 'scissors', 10, 70.00),
('p02', 'comb', 10, 40.00),
('p03', 'trimmer', 5, 800.00),
('p04', 'hair cream', 8, 300.00),
('p05', 'hair color', 4, 400.00),
('p06', 'facial', 4, 500.00),
('p07', 'hair gel', 10, 250.00);

-- --------------------------------------------------------

--
-- Table structure for table `service`
--

CREATE TABLE `service` (
  `serviceId` varchar(10) NOT NULL,
  `sname` varchar(10) NOT NULL,
  `sprice` double(20,2) NOT NULL,
  `serviceDuration` double(20,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `service`
--

INSERT INTO `service` (`serviceId`, `sname`, `sprice`, `serviceDuration`) VALUES
('s01', 'hair cut', 80.00, 50.00),
('s02', 'shave', 80.00, 30.00),
('s03', 'trim', 50.00, 15.00),
('s04', 'facial', 150.00, 80.00),
('s05', 'massage', 150.00, 60.00),
('s07', 'hair color', 400.00, 80.00),
('s06', 'hair wash', 200.00, 20.00);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userId` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  `status` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userId`, `password`, `status`) VALUES
('m01', '00001', 0),
('s06', '15028868', 1),
('s08', '16265729', 1),
('w01', '00002', 1),
('w02', '00003', 1),
('w03', '00004', 1),
('w04', '00005', 1),
('w05', '00006', 1),
('w06', '00007', 1),
('w07', '00008', 1);

-- --------------------------------------------------------

--
-- Table structure for table `workers`
--

CREATE TABLE `workers` (
  `workerId` varchar(10) NOT NULL,
  `wname` varchar(10) NOT NULL,
  `wdesignation` varchar(10) NOT NULL,
  `wsalary` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `workers`
--

INSERT INTO `workers` (`workerId`, `wname`, `wdesignation`, `wsalary`) VALUES
('w01', 'worker1', 'worker', 12000.00),
('w02', 'worker2', 'worker', 12000.00),
('w03', 'worker3', 'worker', 10000.00),
('w04', 'worker4', 'worker', 10000.00),
('w05', 'worker5', 'worker', 8000.00),
('w06', 'worker6', 'worker', 8000.00);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `manager`
--
ALTER TABLE `manager`
  ADD PRIMARY KEY (`mname`,`designation`,`msalary`),
  ADD UNIQUE KEY `UNIQUE` (`mid`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`pname`,`count`,`price`),
  ADD UNIQUE KEY `UNIQUE` (`productId`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`password`,`status`),
  ADD UNIQUE KEY `UNIQUE` (`userId`);

--
-- Indexes for table `workers`
--
ALTER TABLE `workers`
  ADD PRIMARY KEY (`wname`,`wdesignation`,`wsalary`),
  ADD UNIQUE KEY `UNIQUE` (`workerId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
