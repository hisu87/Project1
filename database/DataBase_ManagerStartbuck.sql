Create database duan1;

use duan1;
Go

CREATE TABLE [Nhân Viên] (
  [MaNV] nvarchar(15) PRIMARY KEY,
  [MatKhau] nvarchar(50),
  [VaiTro] nvarchar(50),
  [TenNV] nvarchar(50),
  [Tuoi] int,
  [GioiTinh] varchar(15),
  [SDT] int,
  [DiaChi] nvarchar(50),
  [MaQL] nvarchar(15) FOREIGN KEY REFERENCES [Nhân Viên]([MaNV])
);

CREATE TABLE [Hóa Đơn] (
  [MaHD] nvarchar(15) PRIMARY KEY,
  [MaNV] nvarchar(15) FOREIGN KEY REFERENCES [Nhân Viên]([MaNV]),
  [MaSP] nvarchar(15) FOREIGN KEY REFERENCES [Sản Phẩm]([MaSP]),
  [SoLuong] int,
  [NgayTao] date,
  [TrangThai] nvarchar(50),
  [TongCong] float,
);

CREATE TABLE [Sản Phẩm] (
  [MaSP] nvarchar(15) PRIMARY KEY,
  [TenSP] nvarchar(50),
  [Anh] nvarchar(50),
  [Gia] float,
  [MaCT] nvarchar(20) FOREIGN KEY REFERENCES [Công thức]([MaCT])
);

CREATE TABLE [Công thức] (
  [MaCT] nvarchar(20) PRIMARY KEY,
  [MaNL] nvarchar(15) FOREIGN KEY REFERENCES [Nguyên Liệu]([MaNL]),
  [TenNL] nvarchar(50),
  [SoLuong] float,
  [DonViDoLuong] nvarchar(20)
);

CREATE TABLE [Nguyên Liệu] (
  [MaNL] nvarchar(15) PRIMARY KEY,
  [TenNL] nvarchar(50),
  [SoLuongCon] float,
  [GiaNL] float,
  [DonViDoLuong] nvarchar(20)
);
select *from [Sản Phẩm]
-- Thêm công thức mẫu vào bảng "Công thức"
INSERT INTO [Công thức] ([MaCT], [MaNL], [TenNL], [SoLuong], [DonViDoLuong])
VALUES ('CT001', 'NL001', 'Nguyên liệu mẫu', 50.0, 'gram');
-- Thêm nguyên liệu mẫu vào bảng "Nguyên Liệu"
INSERT INTO [Nguyên Liệu] ([MaNL], [TenNL], [SoLuongCon], [GiaNL], [DonViDoLuong])
VALUES ('NL001', 'Nguyên liệu mẫu', 100.0, 10.0, 'gram');
