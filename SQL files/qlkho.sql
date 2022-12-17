-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 16, 2022 at 07:36 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `qlkho`
--

-- --------------------------------------------------------

--
-- Table structure for table `chitietnhaphang`
--

CREATE TABLE `chitietnhaphang` (
  `MaPhieuChiTietNhapHang` varchar(10) NOT NULL,
  `MaPhieu` varchar(10) DEFAULT NULL,
  `MaSp` varchar(10) DEFAULT NULL,
  `SoLuongNhap` int(11) DEFAULT NULL,
  `SoLuongTheoYeuCau` int(11) DEFAULT NULL,
  `ThanhTien` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `chitietxuathang`
--

CREATE TABLE `chitietxuathang` (
  `MaPhieuChiTietXuatHang` varchar(10) NOT NULL,
  `MaPhieu` varchar(10) DEFAULT NULL,
  `MaSp` varchar(10) DEFAULT NULL,
  `SoLuong` int(11) DEFAULT NULL,
  `SoLuongTheoYeuCau` int(11) DEFAULT NULL,
  `ThanhTien` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `chitietyeucaunhaphang`
--

CREATE TABLE `chitietyeucaunhaphang` (
  `MaPhieuChiTietYCN` varchar(10) NOT NULL,
  `MaPhieuYCN` varchar(10) DEFAULT NULL,
  `MaNCC` varchar(10) DEFAULT NULL,
  `MaSp` varchar(10) DEFAULT NULL,
  `SoLuongTheoYeuCau` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `chitietyeucauxuathang`
--

CREATE TABLE `chitietyeucauxuathang` (
  `MaPhieuChiTietXuatHang` varchar(10) NOT NULL,
  `MaPhieu` varchar(10) DEFAULT NULL,
  `MaSp` varchar(10) DEFAULT NULL,
  `SoLuong` int(11) DEFAULT NULL,
  `ThanhTien` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `cuahang`
--

CREATE TABLE `cuahang` (
  `MaCH` varchar(10) NOT NULL,
  `TenCH` varchar(60) DEFAULT NULL,
  `DiaChi` varchar(60) DEFAULT NULL,
  `SoDienThoai` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `MaNCC` varchar(10) NOT NULL,
  `TenNCC` varchar(60) DEFAULT NULL,
  `DiaChi` varchar(60) DEFAULT NULL,
  `SoDienThoai` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `phankhu`
--

CREATE TABLE `phankhu` (
  `MaPhanKhu` varchar(10) NOT NULL,
  `TenPhanKhu` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `phankhu`
--

INSERT INTO `phankhu` (`MaPhanKhu`, `TenPhanKhu`) VALUES
('PK1', 'Khu đồ gia dụng');

-- --------------------------------------------------------

--
-- Table structure for table `phieunhap`
--

CREATE TABLE `phieunhap` (
  `MaPhieu` varchar(10) NOT NULL,
  `MaPhieuYCN` varchar(10) DEFAULT NULL,
  `NgayLapPhieu` date DEFAULT NULL,
  `DiaDiemLapPhieu` varchar(60) DEFAULT NULL,
  `TongSoTien` float DEFAULT NULL,
  `TrangThai` varchar(30) DEFAULT NULL,
  `MaNguoiLap` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `phieuxuat`
--

CREATE TABLE `phieuxuat` (
  `MaPhieu` varchar(10) NOT NULL,
  `MaCH` varchar(10) DEFAULT NULL,
  `NgayLapPhieu` date DEFAULT NULL,
  `DiaDiemLapPhieu` varchar(60) DEFAULT NULL,
  `TongSoTien` float DEFAULT NULL,
  `TrangThai` varchar(30) DEFAULT NULL,
  `MaNguoiLap` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `phieuyeucaunhap`
--

CREATE TABLE `phieuyeucaunhap` (
  `MaPhieuYCN` varchar(10) NOT NULL,
  `MaNCC` varchar(10) DEFAULT NULL,
  `NgayLap` datetime DEFAULT NULL,
  `TrangThai` varchar(30) DEFAULT NULL,
  `MaNguoiLap` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `phieuyeucauxuat`
--

CREATE TABLE `phieuyeucauxuat` (
  `MaPhieu` varchar(10) NOT NULL,
  `MaCH` varchar(10) DEFAULT NULL,
  `NgayLapPhieu` date DEFAULT NULL,
  `DiaDiemLapPhieu` varchar(60) DEFAULT NULL,
  `TongSoTien` float DEFAULT NULL,
  `TrangThai` varchar(30) DEFAULT NULL,
  `LyDo` varchar(255) DEFAULT NULL,
  `MaNguoiLap` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `MaSp` varchar(10) NOT NULL,
  `TenSp` varchar(60) DEFAULT NULL,
  `MaViTri` varchar(10) DEFAULT NULL,
  `XuatXu` varchar(60) DEFAULT NULL,
  `NhaSx` varchar(60) DEFAULT NULL,
  `NSX` date DEFAULT NULL,
  `HSD` date DEFAULT NULL,
  `GiaNhap` float DEFAULT NULL,
  `GiaBan` float DEFAULT NULL,
  `DonVi` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`MaSp`, `TenSp`, `MaViTri`, `XuatXu`, `NhaSx`, `NSX`, `HSD`, `GiaNhap`, `GiaBan`, `DonVi`) VALUES
('SP1', 'Tủ lạnh', 'VT1', 'Việt Nam', 'HO2', '0000-00-00', '0000-00-00', 1000000, 150000, 'chiếc');

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

CREATE TABLE `taikhoan` (
  `TenTaiKhoan` varchar(60) NOT NULL,
  `MatKhau` varchar(60) DEFAULT NULL,
  `ChucVu` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `vitri`
--

CREATE TABLE `vitri` (
  `MaViTri` varchar(10) NOT NULL,
  `MaPhanKhu` varchar(10) DEFAULT NULL,
  `SoLuongToiDa` int(11) DEFAULT NULL,
  `SoLuongThucTe` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `vitri`
--

INSERT INTO `vitri` (`MaViTri`, `MaPhanKhu`, `SoLuongToiDa`, `SoLuongThucTe`) VALUES
('VT1', 'PK1', 10, 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitietnhaphang`
--
ALTER TABLE `chitietnhaphang`
  ADD PRIMARY KEY (`MaPhieuChiTietNhapHang`),
  ADD KEY `MaPhieu` (`MaPhieu`),
  ADD KEY `MaSp` (`MaSp`);

--
-- Indexes for table `chitietxuathang`
--
ALTER TABLE `chitietxuathang`
  ADD PRIMARY KEY (`MaPhieuChiTietXuatHang`),
  ADD KEY `MaPhieu` (`MaPhieu`),
  ADD KEY `MaSp` (`MaSp`);

--
-- Indexes for table `chitietyeucaunhaphang`
--
ALTER TABLE `chitietyeucaunhaphang`
  ADD PRIMARY KEY (`MaPhieuChiTietYCN`),
  ADD KEY `MaPhieuYCN` (`MaPhieuYCN`),
  ADD KEY `MaNCC` (`MaNCC`),
  ADD KEY `MaSp` (`MaSp`);

--
-- Indexes for table `chitietyeucauxuathang`
--
ALTER TABLE `chitietyeucauxuathang`
  ADD PRIMARY KEY (`MaPhieuChiTietXuatHang`),
  ADD KEY `MaPhieu` (`MaPhieu`),
  ADD KEY `MaSp` (`MaSp`);

--
-- Indexes for table `cuahang`
--
ALTER TABLE `cuahang`
  ADD PRIMARY KEY (`MaCH`);

--
-- Indexes for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`MaNCC`);

--
-- Indexes for table `phankhu`
--
ALTER TABLE `phankhu`
  ADD PRIMARY KEY (`MaPhanKhu`);

--
-- Indexes for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`MaPhieu`),
  ADD KEY `MaPhieuYCN` (`MaPhieuYCN`),
  ADD KEY `MaNguoiLap` (`MaNguoiLap`);

--
-- Indexes for table `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD PRIMARY KEY (`MaPhieu`),
  ADD KEY `MaCH` (`MaCH`),
  ADD KEY `MaNguoiLap` (`MaNguoiLap`);

--
-- Indexes for table `phieuyeucaunhap`
--
ALTER TABLE `phieuyeucaunhap`
  ADD PRIMARY KEY (`MaPhieuYCN`),
  ADD KEY `MaNCC` (`MaNCC`),
  ADD KEY `MaNguoiLap` (`MaNguoiLap`);

--
-- Indexes for table `phieuyeucauxuat`
--
ALTER TABLE `phieuyeucauxuat`
  ADD PRIMARY KEY (`MaPhieu`),
  ADD KEY `MaCH` (`MaCH`),
  ADD KEY `MaNguoiLap` (`MaNguoiLap`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`MaSp`),
  ADD KEY `MaViTri` (`MaViTri`);

--
-- Indexes for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`TenTaiKhoan`);

--
-- Indexes for table `vitri`
--
ALTER TABLE `vitri`
  ADD PRIMARY KEY (`MaViTri`),
  ADD KEY `MaPhanKhu` (`MaPhanKhu`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chitietnhaphang`
--
ALTER TABLE `chitietnhaphang`
  ADD CONSTRAINT `chitietnhaphang_ibfk_1` FOREIGN KEY (`MaPhieu`) REFERENCES `phieunhap` (`MaPhieu`) ON DELETE CASCADE,
  ADD CONSTRAINT `chitietnhaphang_ibfk_2` FOREIGN KEY (`MaSp`) REFERENCES `sanpham` (`MaSp`) ON DELETE CASCADE;

--
-- Constraints for table `chitietxuathang`
--
ALTER TABLE `chitietxuathang`
  ADD CONSTRAINT `chitietxuathang_ibfk_1` FOREIGN KEY (`MaPhieu`) REFERENCES `phieuxuat` (`MaPhieu`) ON DELETE CASCADE,
  ADD CONSTRAINT `chitietxuathang_ibfk_2` FOREIGN KEY (`MaSp`) REFERENCES `sanpham` (`MaSp`) ON DELETE CASCADE;

--
-- Constraints for table `chitietyeucaunhaphang`
--
ALTER TABLE `chitietyeucaunhaphang`
  ADD CONSTRAINT `chitietyeucaunhaphang_ibfk_1` FOREIGN KEY (`MaPhieuYCN`) REFERENCES `phieuyeucaunhap` (`MaPhieuYCN`) ON DELETE CASCADE,
  ADD CONSTRAINT `chitietyeucaunhaphang_ibfk_2` FOREIGN KEY (`MaNCC`) REFERENCES `nhacungcap` (`MaNCC`) ON DELETE CASCADE,
  ADD CONSTRAINT `chitietyeucaunhaphang_ibfk_3` FOREIGN KEY (`MaSp`) REFERENCES `sanpham` (`MaSp`) ON DELETE CASCADE;

--
-- Constraints for table `chitietyeucauxuathang`
--
ALTER TABLE `chitietyeucauxuathang`
  ADD CONSTRAINT `chitietyeucauxuathang_ibfk_1` FOREIGN KEY (`MaPhieu`) REFERENCES `phieuxuat` (`MaPhieu`) ON DELETE CASCADE,
  ADD CONSTRAINT `chitietyeucauxuathang_ibfk_2` FOREIGN KEY (`MaSp`) REFERENCES `sanpham` (`MaSp`) ON DELETE CASCADE;

--
-- Constraints for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `phieunhap_ibfk_1` FOREIGN KEY (`MaPhieuYCN`) REFERENCES `phieuyeucaunhap` (`MaPhieuYCN`) ON DELETE CASCADE,
  ADD CONSTRAINT `phieunhap_ibfk_2` FOREIGN KEY (`MaNguoiLap`) REFERENCES `taikhoan` (`TenTaiKhoan`) ON DELETE CASCADE;

--
-- Constraints for table `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD CONSTRAINT `phieuxuat_ibfk_1` FOREIGN KEY (`MaCH`) REFERENCES `cuahang` (`MaCH`) ON DELETE CASCADE,
  ADD CONSTRAINT `phieuxuat_ibfk_2` FOREIGN KEY (`MaNguoiLap`) REFERENCES `taikhoan` (`TenTaiKhoan`) ON DELETE CASCADE;

--
-- Constraints for table `phieuyeucaunhap`
--
ALTER TABLE `phieuyeucaunhap`
  ADD CONSTRAINT `phieuyeucaunhap_ibfk_1` FOREIGN KEY (`MaNCC`) REFERENCES `nhacungcap` (`MaNCC`) ON DELETE CASCADE,
  ADD CONSTRAINT `phieuyeucaunhap_ibfk_2` FOREIGN KEY (`MaNguoiLap`) REFERENCES `taikhoan` (`TenTaiKhoan`) ON DELETE CASCADE;

--
-- Constraints for table `phieuyeucauxuat`
--
ALTER TABLE `phieuyeucauxuat`
  ADD CONSTRAINT `phieuyeucauxuat_ibfk_1` FOREIGN KEY (`MaCH`) REFERENCES `cuahang` (`MaCH`) ON DELETE CASCADE,
  ADD CONSTRAINT `phieuyeucauxuat_ibfk_2` FOREIGN KEY (`MaNguoiLap`) REFERENCES `taikhoan` (`TenTaiKhoan`) ON DELETE CASCADE;

--
-- Constraints for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`MaViTri`) REFERENCES `vitri` (`MaViTri`) ON DELETE CASCADE;

--
-- Constraints for table `vitri`
--
ALTER TABLE `vitri`
  ADD CONSTRAINT `vitri_ibfk_1` FOREIGN KEY (`MaPhanKhu`) REFERENCES `phankhu` (`MaPhanKhu`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
