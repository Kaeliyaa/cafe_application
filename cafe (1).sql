-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 21, 2024 at 05:46 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cafe`
--

-- --------------------------------------------------------

--
-- Table structure for table `cek_reservasi`
--

CREATE TABLE `cek_reservasi` (
  `ID_Reservasi` int(50) NOT NULL,
  `Nama_Cust` varchar(50) NOT NULL,
  `No_Telp` varchar(50) NOT NULL,
  `Jenis_Meja` varchar(50) NOT NULL,
  `No_Meja` varchar(50) NOT NULL,
  `Catatan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cek_reservasi`
--

INSERT INTO `cek_reservasi` (`ID_Reservasi`, `Nama_Cust`, `No_Telp`, `Jenis_Meja`, `No_Meja`, `Catatan`) VALUES
(101, 'aaaa', 'aaaaaaa', 'Item 1', 'Item 1', 'aaaaaa'),
(102, 'aaaaaa', 'bbbbbbb', 'Item 1', 'Item 1', 'bbbb');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `ID_Cust` int(10) NOT NULL,
  `Nama_Cust` varchar(20) NOT NULL,
  `No_Telp` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `desert`
--

CREATE TABLE `desert` (
  `ID_Desert` int(10) NOT NULL,
  `Nama_Desert` varchar(20) NOT NULL,
  `Harga_Desert` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `history`
--

CREATE TABLE `history` (
  `ID_Order` int(20) NOT NULL,
  `ID_Menu` int(20) NOT NULL,
  `Nama_Menu` varchar(20) NOT NULL,
  `Harga_Menu` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `history_info`
--

CREATE TABLE `history_info` (
  `ID_Order` int(11) NOT NULL,
  `Nama_Cust` varchar(50) NOT NULL,
  `Jenis_Meja` varchar(20) NOT NULL,
  `No_Meja` varchar(20) NOT NULL,
  `Pesanan` varchar(255) NOT NULL,
  `Total_Harga` varchar(50) NOT NULL,
  `Status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `history_info`
--

INSERT INTO `history_info` (`ID_Order`, `Nama_Cust`, `Jenis_Meja`, `No_Meja`, `Pesanan`, `Total_Harga`, `Status`) VALUES
(101, '-', '-', '-', '-', '-', 'Completed'),
(102, '', '', '', '', '', 'Completed'),
(103, '', '', '', '', '', 'Completed'),
(104, 'aaaaa', 'Normal', '1', '', '-', 'Completed');

-- --------------------------------------------------------

--
-- Table structure for table `kasir`
--

CREATE TABLE `kasir` (
  `ID_Kasir` int(10) NOT NULL,
  `Nama_Kasir` varchar(20) NOT NULL,
  `JK_Kasir` varchar(10) NOT NULL,
  `Shift_Kasir` varchar(5) NOT NULL,
  `Gaji_Kasir` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `makanan`
--

CREATE TABLE `makanan` (
  `ID_Makanan` int(10) NOT NULL,
  `Nama_Makanan` varchar(20) NOT NULL,
  `Harga_Makanan` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `makanan`
--

INSERT INTO `makanan` (`ID_Makanan`, `Nama_Makanan`, `Harga_Makanan`) VALUES
(1001, 'Nasi Goreng', 12500),
(1002, 'Nasi Ayam', 12500);

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `ID_Menu` int(10) NOT NULL,
  `Nama_Menu` varchar(20) NOT NULL,
  `Harga_Menu` int(10) NOT NULL,
  `ID_Kategori` int(10) NOT NULL,
  `Stock` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `menu`
--

INSERT INTO `menu` (`ID_Menu`, `Nama_Menu`, `Harga_Menu`, `ID_Kategori`, `Stock`) VALUES
(1001, 'Nasi goreng', 13000, 0, 0),
(1002, 'Nasi Bakar', 10000, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `menulain`
--

CREATE TABLE `menulain` (
  `ID_Menu` int(11) NOT NULL,
  `Nama_Menu` varchar(50) NOT NULL,
  `Harga_Menu` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `menulain`
--

INSERT INTO `menulain` (`ID_Menu`, `Nama_Menu`, `Harga_Menu`) VALUES
(3001, 'Kerupuk', 4000);

-- --------------------------------------------------------

--
-- Table structure for table `minuman`
--

CREATE TABLE `minuman` (
  `ID_Minuman` int(10) NOT NULL,
  `Nama_Minuman` varchar(20) NOT NULL,
  `Harga_Minuman` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `minuman`
--

INSERT INTO `minuman` (`ID_Minuman`, `Nama_Minuman`, `Harga_Minuman`) VALUES
(2001, 'Jus Apel', 8500);

-- --------------------------------------------------------

--
-- Table structure for table `order_info`
--

CREATE TABLE `order_info` (
  `ID_Order` int(20) NOT NULL,
  `Nama_Cust` varchar(20) NOT NULL,
  `Jenis_Meja` varchar(10) NOT NULL,
  `No_Meja` varchar(5) NOT NULL,
  `Pesanan` varchar(255) NOT NULL,
  `Total_Harga` varchar(20) NOT NULL,
  `Status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `order_info`
--

INSERT INTO `order_info` (`ID_Order`, `Nama_Cust`, `Jenis_Meja`, `No_Meja`, `Pesanan`, `Total_Harga`, `Status`) VALUES
(101, '-', '-', '-', '-', '-', '-'),
(105, 'aaaaa', 'Normal', '1', 'Nasi Padang			x2\nAir			x1\nNasi			x1\n', '-', 'Pending');

-- --------------------------------------------------------

--
-- Table structure for table `receipt`
--

CREATE TABLE `receipt` (
  `ID_Receipt` int(10) NOT NULL,
  `ID_Kasir` int(20) NOT NULL,
  `ID_Cust` int(20) NOT NULL,
  `No_Order` int(10) NOT NULL,
  `Total_Hrg` int(10) NOT NULL,
  `Kembali` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(20) NOT NULL,
  `Cpassword` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `token` varchar(5) NOT NULL,
  `Ctoken` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `Cpassword`, `password`, `token`, `Ctoken`) VALUES
('admin', 'admin', 'admin', '12345', '12345');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cek_reservasi`
--
ALTER TABLE `cek_reservasi`
  ADD PRIMARY KEY (`ID_Reservasi`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`ID_Cust`);

--
-- Indexes for table `history`
--
ALTER TABLE `history`
  ADD PRIMARY KEY (`ID_Order`);

--
-- Indexes for table `history_info`
--
ALTER TABLE `history_info`
  ADD PRIMARY KEY (`ID_Order`);

--
-- Indexes for table `kasir`
--
ALTER TABLE `kasir`
  ADD PRIMARY KEY (`ID_Kasir`);

--
-- Indexes for table `makanan`
--
ALTER TABLE `makanan`
  ADD PRIMARY KEY (`ID_Makanan`);

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`ID_Menu`);

--
-- Indexes for table `menulain`
--
ALTER TABLE `menulain`
  ADD PRIMARY KEY (`ID_Menu`);

--
-- Indexes for table `order_info`
--
ALTER TABLE `order_info`
  ADD PRIMARY KEY (`ID_Order`);

--
-- Indexes for table `receipt`
--
ALTER TABLE `receipt`
  ADD PRIMARY KEY (`ID_Receipt`),
  ADD KEY `Foreignkey Kasir` (`ID_Kasir`),
  ADD KEY `ForeignKey Cust` (`ID_Cust`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cek_reservasi`
--
ALTER TABLE `cek_reservasi`
  MODIFY `ID_Reservasi` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=105;

--
-- AUTO_INCREMENT for table `history_info`
--
ALTER TABLE `history_info`
  MODIFY `ID_Order` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=105;

--
-- AUTO_INCREMENT for table `order_info`
--
ALTER TABLE `order_info`
  MODIFY `ID_Order` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=106;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `history`
--
ALTER TABLE `history`
  ADD CONSTRAINT `Foreignkey menu` FOREIGN KEY (`ID_Menu`) REFERENCES `menu` (`ID_Menu`);

--
-- Constraints for table `receipt`
--
ALTER TABLE `receipt`
  ADD CONSTRAINT `ForeignKey Cust` FOREIGN KEY (`ID_Cust`) REFERENCES `customer` (`ID_Cust`),
  ADD CONSTRAINT `Foreignkey Kasir` FOREIGN KEY (`ID_Kasir`) REFERENCES `kasir` (`ID_Kasir`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
