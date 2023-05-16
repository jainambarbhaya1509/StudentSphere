-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 05, 2023 at 08:40 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `python_mini_project`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin_data`
--

CREATE TABLE `admin_data` (
  `sr_no` int(11) NOT NULL,
  `username` text NOT NULL,
  `password` text NOT NULL,
  `admin_name` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin_data`
--

INSERT INTO `admin_data` (`sr_no`, `username`, `password`, `admin_name`) VALUES
(1, 'admin', 'admin', 'Jainam Barbhaya');

-- --------------------------------------------------------

--
-- Table structure for table `student_data`
--

CREATE TABLE `student_data` (
  `sr_no` int(11) NOT NULL,
  `sap_no` text NOT NULL,
  `roll_no` text NOT NULL,
  `yoa` text NOT NULL,
  `toa` text NOT NULL,
  `branch` text NOT NULL,
  `stu_name` text NOT NULL,
  `contact1` text NOT NULL,
  `contact2` text NOT NULL,
  `email1` text NOT NULL,
  `email2` text NOT NULL,
  `dob` text NOT NULL,
  `address` text NOT NULL,
  `ssc_pass_year` text NOT NULL,
  `ssc_marks` text NOT NULL,
  `hsc_pass_year` text NOT NULL,
  `hsc_marks` text NOT NULL,
  `present_year` text NOT NULL,
  `sem1` text NOT NULL,
  `sem2` text NOT NULL,
  `sem3` text NOT NULL,
  `sem4` text NOT NULL,
  `sem5` text NOT NULL,
  `sem6` text NOT NULL,
  `sem1_percent` text NOT NULL,
  `sem2_percent` text NOT NULL,
  `sem3_percent` text NOT NULL,
  `sem4_percent` text NOT NULL,
  `sem5_percent` text NOT NULL,
  `sem6_percent` text NOT NULL,
  `image_binary` longblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student_data`
--


--
-- Indexes for table `admin_data`
--
ALTER TABLE `admin_data`
  ADD PRIMARY KEY (`sr_no`);

--
-- Indexes for table `student_data`
--
ALTER TABLE `student_data`
  ADD PRIMARY KEY (`sr_no`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin_data`
--
ALTER TABLE `admin_data`
  MODIFY `sr_no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `student_data`
--
ALTER TABLE `student_data`
  MODIFY `sr_no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
