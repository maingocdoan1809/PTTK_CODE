-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 14, 2023 at 03:09 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

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
  `MaPhieu` varchar(10) NOT NULL,
  `MaSp` varchar(10) NOT NULL,
  `SoLuongNhap` int(11) DEFAULT NULL,
  `ThanhTien` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chitietnhaphang`
--

INSERT INTO `chitietnhaphang` (`MaPhieu`, `MaSp`, `SoLuongNhap`, `ThanhTien`) VALUES
('1122', '1223', 4, 0),
('1122', '2426', 1, 0),
('1234', '2426', 1, 0),
('1234', 'SP1', 3, 0),
('1235', 'SP1', 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `chitietxuathang`
--

CREATE TABLE `chitietxuathang` (
  `MaPhieu` varchar(10) NOT NULL,
  `MaSp` varchar(10) NOT NULL,
  `SoLuong` int(11) DEFAULT NULL,
  `ThanhTien` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chitietxuathang`
--

INSERT INTO `chitietxuathang` (`MaPhieu`, `MaSp`, `SoLuong`, `ThanhTien`) VALUES
('989890', '1223', 1, 0),
('989890', '2426', 1, 0),
('99876', '2426', 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `chitietyeucaunhaphang`
--

CREATE TABLE `chitietyeucaunhaphang` (
  `MaPhieuYCN` varchar(10) NOT NULL,
  `MaSp` varchar(10) NOT NULL,
  `SoLuongTheoYeuCau` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chitietyeucaunhaphang`
--

INSERT INTO `chitietyeucaunhaphang` (`MaPhieuYCN`, `MaSp`, `SoLuongTheoYeuCau`) VALUES
('1000', '1223', 4),
('1000', '2426', 1),
('1234', '2426', 1),
('1234', 'SP1', 4),
('18999', '1223', 3);

-- --------------------------------------------------------

--
-- Table structure for table `chitietyeucauxuathang`
--

CREATE TABLE `chitietyeucauxuathang` (
  `MaPhieuYCX` varchar(10) NOT NULL,
  `MaSp` varchar(10) NOT NULL,
  `SoLuongYeuCau` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chitietyeucauxuathang`
--

INSERT INTO `chitietyeucauxuathang` (`MaPhieuYCX`, `MaSp`, `SoLuongYeuCau`) VALUES
('00998', '1223', 1),
('00998', '2426', 2);

-- --------------------------------------------------------

--
-- Table structure for table `cuahang`
--

CREATE TABLE `cuahang` (
  `MaCH` varchar(10) NOT NULL,
  `TenCH` varchar(60) DEFAULT NULL,
  `DiaChi` varchar(60) DEFAULT NULL,
  `SoDienThoai` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cuahang`
--

INSERT INTO `cuahang` (`MaCH`, `TenCH`, `DiaChi`, `SoDienThoai`) VALUES
('7423', 'T-Mart Minh Khai', '189 Minh Khai - Hai Ba Trung', '042938423');

-- --------------------------------------------------------

--
-- Table structure for table `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `MaNCC` varchar(10) NOT NULL,
  `TenNCC` varchar(60) DEFAULT NULL,
  `DiaChi` varchar(60) DEFAULT NULL,
  `SoDienThoai` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nhacungcap`
--

INSERT INTO `nhacungcap` (`MaNCC`, `TenNCC`, `DiaChi`, `SoDienThoai`) VALUES
('1565', 'DDT', 'Đống Đa, Hà Nội', '0343354235'),
('3124', 'An An', 'Định công, Hoàng Mai, Hà Nội', '023984343');

-- --------------------------------------------------------

--
-- Table structure for table `phankhu`
--

CREATE TABLE `phankhu` (
  `MaPhanKhu` varchar(10) NOT NULL,
  `TenPhanKhu` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `phankhu`
--

INSERT INTO `phankhu` (`MaPhanKhu`, `TenPhanKhu`) VALUES
('PK1', 'Khu đồ gia dụng'),
('PK2-BK', 'Bánh kẹo');

-- --------------------------------------------------------

--
-- Table structure for table `phieunhap`
--

CREATE TABLE `phieunhap` (
  `MaPhieu` varchar(10) NOT NULL,
  `MaPhieuYCN` varchar(10) DEFAULT NULL,
  `NgayLapPhieu` date DEFAULT current_timestamp(),
  `DiaDiemLapPhieu` varchar(60) DEFAULT NULL,
  `TongSoTien` float DEFAULT NULL,
  `MaNguoiLap` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `phieunhap`
--

INSERT INTO `phieunhap` (`MaPhieu`, `MaPhieuYCN`, `NgayLapPhieu`, `DiaDiemLapPhieu`, `TongSoTien`, `MaNguoiLap`) VALUES
('1122', '1000', '2023-01-13', 'Tai kho', 0, 'admin'),
('1234', '1234', '2023-01-13', 'Tai kho', 0, 'admin'),
('1235', '1234', '2023-01-13', 'Tai kho', 0, 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `phieuxuat`
--

CREATE TABLE `phieuxuat` (
  `MaPhieu` varchar(10) NOT NULL,
  `MaPhieuYCX` varchar(10) NOT NULL,
  `NgayLapPhieu` date DEFAULT NULL,
  `DiaDiemLapPhieu` varchar(60) DEFAULT NULL,
  `TongSoTien` float DEFAULT NULL,
  `MaNguoiLap` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `phieuxuat`
--

INSERT INTO `phieuxuat` (`MaPhieu`, `MaPhieuYCX`, `NgayLapPhieu`, `DiaDiemLapPhieu`, `TongSoTien`, `MaNguoiLap`) VALUES
('989890', '00998', '2023-01-14', 'Tại kho', 0, 'admin'),
('99876', '00998', '2023-01-14', 'Tại kho', 0, 'admin');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `phieuyeucaunhap`
--

INSERT INTO `phieuyeucaunhap` (`MaPhieuYCN`, `MaNCC`, `NgayLap`, `TrangThai`, `MaNguoiLap`) VALUES
('1000', '3124', '2022-12-26 07:04:12', 'Hoàn thành', 'admin'),
('1234', '3124', '2022-10-27 07:05:19', 'Hoàn thành', 'admin'),
('18999', '1565', '2023-01-11 00:00:00', 'Đang chờ', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `phieuyeucauxuat`
--

CREATE TABLE `phieuyeucauxuat` (
  `MaPhieuYCX` varchar(10) NOT NULL,
  `MaCH` varchar(10) DEFAULT NULL,
  `NgayLap` date DEFAULT NULL,
  `TrangThai` varchar(30) DEFAULT NULL,
  `LyDo` varchar(255) DEFAULT NULL,
  `MaNguoiLap` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `phieuyeucauxuat`
--

INSERT INTO `phieuyeucauxuat` (`MaPhieuYCX`, `MaCH`, `NgayLap`, `TrangThai`, `LyDo`, `MaNguoiLap`) VALUES
('00998', '7423', '2023-01-14', 'Hoàn thành', 'Hehe', 'staff');

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `MaSp` varchar(10) NOT NULL,
  `TenSp` varchar(60) DEFAULT NULL,
  `MaViTri` varchar(10) NOT NULL,
  `XuatXu` varchar(60) DEFAULT NULL,
  `NhaSx` varchar(60) DEFAULT NULL,
  `NSX` date DEFAULT NULL,
  `HSD` date DEFAULT NULL,
  `GiaNhap` float DEFAULT NULL,
  `GiaBan` float DEFAULT NULL,
  `DonVi` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`MaSp`, `TenSp`, `MaViTri`, `XuatXu`, `NhaSx`, `NSX`, `HSD`, `GiaNhap`, `GiaBan`, `DonVi`) VALUES
('1223', 'Máy bơm mini', 'SP2', 'Trung quốc', 'Trung quốc', NULL, NULL, 430, 500, 'Cái'),
('2426', 'Bánh gạo An An', 'BK1AA', 'Việt Nam', 'Công ty CP Bánh kẹo AN AN', '2021-12-23', '2023-01-01', 17.5, 20, 'Gói'),
('SP1', 'Tủ lạnh', 'VT1', 'Việt Nam', 'HO2', '0000-00-00', '0000-00-00', 1000000, 150000, 'chiếc');

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

CREATE TABLE `taikhoan` (
  `TenTaiKhoan` varchar(60) NOT NULL,
  `MatKhau` varchar(60) DEFAULT NULL,
  `ChucVu` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `taikhoan`
--

INSERT INTO `taikhoan` (`TenTaiKhoan`, `MatKhau`, `ChucVu`) VALUES
('admin', 'admin1234', 1),
('staff', 'staf1234', 0);

-- --------------------------------------------------------

--
-- Table structure for table `vitri`
--

CREATE TABLE `vitri` (
  `MaViTri` varchar(10) NOT NULL,
  `MaPhanKhu` varchar(10) DEFAULT NULL,
  `SoLuongToiDa` int(11) DEFAULT NULL,
  `SoLuongThucTe` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `vitri`
--

INSERT INTO `vitri` (`MaViTri`, `MaPhanKhu`, `SoLuongToiDa`, `SoLuongThucTe`) VALUES
('BK1AA', 'PK2-BK', 50, 19),
('SP2', 'PK1', 20, 22),
('VT1', 'PK1', 12, 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitietnhaphang`
--
ALTER TABLE `chitietnhaphang`
  ADD PRIMARY KEY (`MaPhieu`,`MaSp`),
  ADD KEY `MaPhieu` (`MaPhieu`),
  ADD KEY `MaSp` (`MaSp`);

--
-- Indexes for table `chitietxuathang`
--
ALTER TABLE `chitietxuathang`
  ADD PRIMARY KEY (`MaPhieu`,`MaSp`),
  ADD KEY `MaPhieu` (`MaPhieu`),
  ADD KEY `MaSp` (`MaSp`);

--
-- Indexes for table `chitietyeucaunhaphang`
--
ALTER TABLE `chitietyeucaunhaphang`
  ADD PRIMARY KEY (`MaPhieuYCN`,`MaSp`),
  ADD KEY `MaPhieuYCN` (`MaPhieuYCN`),
  ADD KEY `MaSp` (`MaSp`);

--
-- Indexes for table `chitietyeucauxuathang`
--
ALTER TABLE `chitietyeucauxuathang`
  ADD PRIMARY KEY (`MaPhieuYCX`,`MaSp`),
  ADD KEY `MaPhieu` (`MaPhieuYCX`),
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
  ADD KEY `MaNguoiLap` (`MaNguoiLap`),
  ADD KEY `MPYCX` (`MaPhieuYCX`);

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
  ADD PRIMARY KEY (`MaPhieuYCX`),
  ADD KEY `MaCH` (`MaCH`),
  ADD KEY `MaNguoiLap` (`MaNguoiLap`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`MaSp`,`MaViTri`),
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
  ADD CONSTRAINT `chitietyeucaunhaphang_ibfk_3` FOREIGN KEY (`MaSp`) REFERENCES `sanpham` (`MaSp`) ON DELETE CASCADE;

--
-- Constraints for table `chitietyeucauxuathang`
--
ALTER TABLE `chitietyeucauxuathang`
  ADD CONSTRAINT `chitietyeucauxuathang_ibfk_1` FOREIGN KEY (`MaPhieuYCX`) REFERENCES `phieuyeucauxuat` (`MaPhieuYCX`) ON DELETE CASCADE,
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
  ADD CONSTRAINT `MPYCX` FOREIGN KEY (`MaPhieuYCX`) REFERENCES `phieuyeucauxuat` (`MaPhieuYCX`),
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
