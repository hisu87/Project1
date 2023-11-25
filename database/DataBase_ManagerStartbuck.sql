Create database QLStarbucks;
go
use QLStarbucks;
Go

CREATE TABLE [Nguyên Liệu] (
  [MaNL] nvarchar(50) PRIMARY KEY,
  [TenNL] nvarchar(200),
  [SoLuongCon] float,
  [GiaNL] float,
  [DonViDoLuong] nvarchar(20)
);

go

CREATE TABLE [Công thức] (
  [MaCT] nvarchar(50) PRIMARY KEY,
  [TenCongThuc] nvarchar(50),
);

go



CREATE TABLE CT_NL (
  MaCT nvarchar(50) FOREIGN KEY REFERENCES [Công Thức](MaCT),
  MaNL nvarchar(50) FOREIGN KEY REFERENCES [Nguyên Liệu](MaNL),
  Soluong int,
  DonViDoLuong nvarchar(10)
)

go

select * from CT_NL
select * from [Nguyên Liệu]
select * from [Công thức]

SELECT  CT_NL.MaCT, [Công thức].TenCongThuc, CT_NL.MaNL, [Nguyên Liệu].TenNL, CT_NL.SoLuong, CT_NL.DonViDoLuong
FROM CT_NL
JOIN [Công thức] ON CT_NL.MaCT = [Công thức].MaCT
JOIN [Nguyên Liệu]ON CT_NL.MaNL =[Nguyên Liệu].MaNL
where [Công thức].MaCT = 2;



CREATE TABLE [Sản Phẩm] (
  [MaSP] nvarchar(50) PRIMARY KEY,
  [TenSP] nvarchar(50),
  [Anh] nvarchar(50),
  [Gia] float,
  [MaCT] nvarchar(50) FOREIGN KEY REFERENCES [Công thức]([MaCT])
);

CREATE TABLE [Nhân Viên] (
  [MaNV] nvarchar(15) PRIMARY KEY,
  [MatKhau] nvarchar(50),
  [VaiTro] nvarchar(50),
  [TenNV] nvarchar(50),
  [Tuoi] int,
  [GioiTinh] varchar(15),
  [SDT] int,
  [DiaChi] nvarchar(50),
  [Anh] nvarchar(50)
);

go

CREATE TABLE [Hóa Đơn] (
  [MaHD] nvarchar(15) PRIMARY KEY,
  [MaNV] nvarchar(15) FOREIGN KEY REFERENCES [Nhân Viên]([MaNV]),
  [NgayTao] date,
  [TrangThai] nvarchar(50),
  [TongCong] float,
);

go

CREATE TABLE HD_SP (
    MaHD nvarchar(15)  FOREIGN KEY (MaHD) REFERENCES [Hóa Đơn](MaHD),
    MaSP nvarchar(50) FOREIGN KEY (MaSP) REFERENCES [Sản Phẩm](MaSP),
    soluong INT,
);


<<<<<<< HEAD
CREATE TABLE [Nguyên Liệu] (
  [MaNL] nvarchar(15) PRIMARY KEY,
  [TenNL] nvarchar(50),
  [SoLuongCon] float,
  [GiaNL] float,
  [DonViDoLuong] nvarchar(20)
);
select *from [Sản Phẩm]
select * from [Công thức]
-- Thêm công thức mẫu vào bảng "Công thức"
INSERT INTO [Công thức] ([MaCT], [MaNL], [TenNL], [SoLuong], [DonViDoLuong])
VALUES ('CT001', 'NL001', 'Nguyên liệu mẫu', 50.0, 'gram');
-- Thêm nguyên liệu mẫu vào bảng "Nguyên Liệu"
INSERT INTO [Nguyên Liệu] ([MaNL], [TenNL], [SoLuongCon], [GiaNL], [DonViDoLuong])
VALUES ('NL001', 'Nguyên liệu mẫu', 100.0, 10.0, 'gram');
=======
go

INSERT INTO [Nguyên Liệu]
VALUES
(N'Wsugar', N'Đường Trắngb', 100, 25000, N'KG'),
(N'SiroDD', N'Siro đường đen Eurodeli can 2.5 kg', 10, 275000, N'CAN'),
(N'RobustaMR', N'Robusta Medium Roast', 200, 85000, N'KG'),
(N'HongTra', N'Hồng Trà Thượng Hạng', 100, 117000, N'KG'),
(N'LucTraLaiLP', N'Lục Trà Lài Lộc Phát Thượng Hạng', 100, 145000, N'KG'),
(N'OLong', N'Trà Ô Long Thượng Hàng', 100, 200000, N'KG'),
(N'BlackTeaFuckLong', N'Trà Đen FuckLong', 100, 200000, N'KG'),
(N'SyrupPMCherry', N'Pomona Cherry Syrup x 1000ml', 5, 290000, N'Chai'),
(N'SyrupPMSmoky', N'Pomona Smoky Earlgrey Syrup x 1000ml', 5, 290000, N'Chai'),
(N'SyrupPMLemon', N'Pomona Lemon Syrup x 1000ml', 5, 290000, N'Chai'),
(N'SyrupPMGinxLemon', N'Pomona Ginger and Lemon Syrup x 1000ml', 5, 290000, N'Chai'),
(N'SyrupPMStrawberry', N'Pomona Strawberry Syrup x 1000ml', 5, 290000, N'Chai'),
(N'SyrupPMPinacolada', N'Pomona Pinacolada Syrup x 1000ml (Dứa Dừa)', 5, 290000, N'Chai'),
(N'SyrupPMPeach', N'Pomona Peach Syrup x 1000ml', 5, 290000, N'Chai'),
(N'SyrupPMCaramel', N'Pomona Caramel Syrup x 1000ml', 5, 290000, N'Chai'),
(N'SyrupPMMarron', N'Pomona Marron Syrup x 1000ml', 5, 290000, N'Chai'),
(N'SyrupPMHazelnut', N'Pomona Hazelnut Syrup x 1000ml (Hạt Phi)', 5, 290000, N'Chai'),
(N'SyrupPMKiwi', N'Pomona Kiwi Syrup x 1000ml', 5, 290000, N'Chai'),
(N'SyrupPMRaspberry', N'Pomona Raspberry Syrup x 1000ml', 5, 290000, N'Chai'),
(N'SyrupPMApple', N'Pomona Apple Syrup x 1000ml', 5, 290000, N'Chai'),
(N'SyrupPMBlueberry', N'Pomona Blueberry Syrup x 1000ml', 5, 290000, N'Chai'),
(N'KBRichlun', N'Kem béo Rich lùn x 454g', 20, 30000, N'Hộp'),
(N'STMilkLab', N'Sữa tươi MilkLab x 1000ml', 20, 30000, N'Hộp'),
(N'SDLechera', N'Sữa Đặc La Lechera x 379g', 50, 70000, N'Lon'),
(N'WCIsigny', N'Whipping Cream Isigny Ste Mère x 200gr', 20, 194000, N'Lon'),
(N'BSBoduo', N'Bột sữa Boduo Premium x 25kg', 5, 2100000, N'Bao'),
(N'BBAlmer', N'Bột sữa béo Bột Almer 941 x 25kg', 5, 2000000, N'Bao'),
(N'BPMVerozyme', N'Bột Phô Mai Verozyme 1Kg', 10, 330000, N'Bịch'),
(N'BSCPomona', N'Bột Sữa Chua Pomona 800g', 10, 305000, N'Bịch'),
(N'BMCCozy', N'Bột Matcha Cozy 500g', 10, 304000, N'Bịch'),
(N'CCAnchor', N'Cream Cheese Anchor 1Kg', 10, 215000, N'Hộp'),
(N'DelPeaches', N'Delmonte Sliced Freestone Peaches', 10, 330000, N'Lon'),
(N'DelOranges-SF', N'Delmonte Mandarin Oranges - No Sugar Added', 10, 330000, N'Lon'),
(N'DelPears-SF', N'Delmonte Sliced Pears - No Sugar Added', 10, 330000, N'Lon'),
(N'DelPinapple', N'Delmonte Canned Gold Pineapple Chunks in 100% Pineapple Juice', 10, 330000, N'Lon'),
(N'DelCitrus', N'Delmonte Citrus Salad', 10, 330000, N'Lon'),
(N'DelFruitCocktail', N'Delmonte Fruit Cocktail - No Sugar Added', 10, 330000, N'Lon'),
(N'DelCherryMix', N'Delmonte Cherry Mixed Fruit - 100 Calories', 10, 330000, N'Lon'),
(N'DelPittedCherry', N'Delmonte Pitted Cherries', 10, 330000, N'Lon'),
(N'DelRedGrape', N'Delmonte Red Grapefruit - No Sugar Added', 10, 330000, N'Lon'),
(N'DelApricot', N'Delmonte Apricot Halves', 10, 330000, N'Lon'),
(N'SmcGrape', N'Smucker"s Jams CONCORD GRAPE JAM', 10, 330000, N'Lon'),
(N'SmcStrawberry', N'Smucker"s Jams STRAWBERRY JAM', 10, 330000, N'Lon'),
(N'SmcResRaspberry-SL', N'Smucker"s Jams SEEDLESS RED RASPBERRY JAM', 10, 330000, N'Lon'),
(N'SmcBlackberry', N'Smucker"s Jams Black Berry JAM', 10, 330000, N'Lon'),
(N'SmcBlackberry-SL', N'Smucker"s Jams Seedless Black Berry JAM', 10, 330000, N'Lon'),
(N'SmcRedPlum', N'Smucker"s Jams RED PLUM JAM', 10, 330000, N'Lon'),
(N'SmcCiderApple', N'Smucker"s Jams CIDER APPLE BUTTER', 10, 330000, N'Lon'),
(N'SmcSQStrawberry', N'SQUEEZE SUGAR FREE STRAWBERRY JAM WITH SPLENDA® BRAND SWEETENER', 10, 330000, N'Lon'),
(N'SmcSQGrape', N'SQUEEZE SUGAR FREE CONCORD GRAPE JAM WITH SPLENDA® BRAND SWEETENER', 10, 330000, N'Lon'),
(N'AgarCafe', N'Thạch Agar Cafe x 3kg2', 10, 330000, N'Hộp'),
(N'AgarFruit', N'Thạch Agar Fruit x 3kg2', 10, 330000, N'Hộp'),
(N'AgarTraXanh', N'Thạch Agar Trà Xanh x 3kg2', 10, 330000, N'Hộp'),
(N'AgarPhaLe', N'Thạch Agar Pha Lê x 3kg2', 10, 330000, N'Hộp'),
(N'AgarCaramel', N'Thạch Agar Caramel x 3kg2', 10, 330000, N'Hộp'),
(N'FMCamCara', N'Farmers Market CamCara x 8kg', 1, 300000, N'Thùng'),
(N'FMVietQuocJumbo', N'Farmers Market Việt Quất New Zealand size Jumbo (Hộp 125G x 12)', 1, 1800000, N'Thùng'),
(N'FMDauMinori', N'Farmers Market Dâu Nhật Minori (270G/Hộp)', 3, 300000, N'Hộp'),
(N'FMSả', N'Farmers Market Sả Cây x 1kg', 10, 80000, N'KG'),
(N'FMMint', N'Farmers Market Mint x 1kg', 10, 132000, N'KG'),
(N'FMLemon', N'Farmers Market Lemon (1kg/Hộp)', 10, 132000, N'Hộp'),
(N'FMLemonGrass', N'Farmers Market Lemon Grass', 10, 50000, N'KG'),
(N'SodaScheweppers', N'Thùng 24 lon soda Schweppes 320ml', 4, 132000, N'Thùng');


go

insert [Công thức]
values
(1,'White Coffee'),
(2,'Black Coffe'),
(3,'Citrus peach tea'),
(4,'White VietNamese Coffe'),
(5,'Capuchino'),
(6,'Strawberry Mojito'),
(7,'Blueberry Mocktail');

go
select * from [Nguyên Liệu] where [Nguyên Liệu].MaNL = 'SyrupPMCaramel'

insert into CT_NL
values
(2,N'Wsugar',10,'Gram'),
(3,N'Wsugar',25,'Gram'),
(3,N'BlackTeaFuckLong',5,'Gram'),
(3,N'RobustaMR',15,'Gram'),
(3,N'WCIsigny',80,'Gram'),
(3,N'SodaScheweppers',1,'Lon'),
(3,N'BlackTeaFuckLong',100,'Ml'),
(3,N'SyrupPMPeach',25,'Ml'),
(3,N'Wsugar',3,'Gram'),
(3,N'FMLemonGrass',1,'Cây'),
(3,N'FMCamCara',1,'Lát'),
(3,N'DelPeaches',4,'Lát'),
(4,N'RobustaMR',30,'Ml'),
(4,N'SDLechera',100,'Ml'),
(4,N'STMilkLab',200,'Ml'),
(5,N'RobustaMR',15,'Gram'),
(5,N'STMilkLab',80,'Gram'),
(5,N'Wsugar',10,'Gram'),
(6,N'SodaScheweppers',200,'Ml'),
(6,N'FMDauMinori',50,'Gram'),
(6,N'SyrupPMPeach',45,'Ml'),
(6,N'SyrupPMGinxLemon',25,'Ml'),
(6,N'SmcStrawberry',25,'Ml'),
(6,N'SyrupPMCaramel',25,'Ml'),
(6,N'FMMint',25,'Gram'),
(7,N'SyrupPMBlueberry',50,'Ml'),
(7,N'FMVietQuocJumbo',30,'ML'),
(7,N'FMLemon',30,'Ml'),
(7,N'SodaScheweppers',1,'Lon');

go

/*Xem công thức có nguyên liệu nào*/
select ct.MaCT, ct.TenCongThuc from [Công thức] ct
join CT_NL on ct.MaCT = CT_NL.MaCT join [Nguyên Liệu] nl on nl.MaNL = CT_NL.MaNL
where ct.MaCT = 5;

go

insert into [Nhân Viên]
values
('Hisu','0807',N'Quản Lý',N'Phạm Văn Hiếu','19','Nam','0999999999','TPHCM','x'),
('SonSoi','0807',N'Quản Lý',N'Ngô Vũ Sơn','19','Nam','0999999999','TPHCM','x'),
('HuyLight','0807',N'Nhân Viên',N'Quang Huy','19','Nam','0999999999','TPHCM','x'),
('Poem','0807',N'Nhân Viên',N'Minh Thơ','19','Nam','0999999999','TPHCM','x'),
('Hung','0807',N'Nhân Viên',N'Sĩ Hùng','19','Nam','0999999999','TPHCM','x');

go

insert into [Sản Phẩm]
values
<<<<<<< HEAD
(1,'Cà Phê Sữa','xxxxx',35000,1),
(2,'Cà Phê Đen','xxxxx',30000,2),
(3,'Citrus peach tea','xxxxx',45000,4),
(4,'Bạc Xĩu','xxxxx',40000,5),
(5,'Capuchino','xxxxx',55000,3),
(6,'Strawberry Mojito','xxxxx',55000,1),
(7,'Blueberry Mocktail','xxxxx',35000,1);
UPDATE [Sản Phẩm]
SET [Anh] = 'cfsua.png', [TenSP]=N'Cà Phê Sữa'
WHERE [MaSP] = 1;
=======
(1,N'Cà Phê Sữa','xxxxx',35000,1),
(2,N'Cà Phê Đen','xxxxx',30000,2),
(3,N'Citrus peach tea','xxxxx',45000,4),
(4,N'Bạc Xĩu','xxxxx',40000,5),
(5,N'Capuchino','xxxxx',55000,3),
(6,N'Strawberry Mojito','xxxxx',55000,1),
(7,N'Blueberry Mocktail','xxxxx',35000,1);
>>>>>>> main

UPDATE [Sản Phẩm]
SET [Anh] = 'matcha.png' , [TenSP]=N'Matcha Đá Xay'
WHERE [MaSP] = 2;
UPDATE [Sản Phẩm]
SET [Anh] = 'hongdao.png' , [TenSP]=N'Hồng đào'
WHERE [MaSP] = 3;
delete [Sản Phẩm] where [MaSP]=3
UPDATE [Sản Phẩm]
SET [Anh] = 'traolongdua.png' , [TenSP]=N'Trà Ô Long Dừa'
WHERE [MaSP] = 4;
UPDATE [Sản Phẩm]
SET [Anh] = 'oreocf.png' , [TenSP]=N'Oreo Cà Phê Sữa'
WHERE [MaSP] = 5;
UPDATE [Sản Phẩm]
SET [Anh] = 'phindenda.png' , [TenSP]=N'Phin Đen Đá'
WHERE [MaSP] = 6;
UPDATE [Sản Phẩm]
SET [Anh] = 'traolongdau.png' , [TenSP]=N'Trà Ô Long Dâu'
WHERE [MaSP] = 7;
go

insert into [Hóa Đơn]
values
('HD12372','Hisu','2023-11-11','Đã Thanh Toán','35000')

insert into HD_SP
values
('HD12372','1',1),
('HD12372','2',3),
('HD12372','4',2),
('HD12372','5',1);

go

--Xem hóa đơn có sản phẩm nào

select HD.MaHD, sp.MaSP, sp.TenSP, sp.Gia, HD_SP.soluong from [Hóa Đơn] hd
join HD_SP on hd.MaHD = HD_SP.MaHD join [Sản Phẩm] sp on sp.MaSP = HD_SP.MaSP
where hd.MaHD = 'HD12372';

select *from [Sản Phẩm]
-- Thêm công thức mẫu vào bảng "Công thức"
INSERT INTO [Công thức] ([MaCT], [MaNL], [TenNL], [SoLuong], [DonViDoLuong])
VALUES ('CT001', 'NL001', 'Nguyên liệu mẫu', 50.0, 'gram');
-- Thêm nguyên liệu mẫu vào bảng "Nguyên Liệu"
INSERT INTO [Nguyên Liệu] ([MaNL], [TenNL], [SoLuongCon], [GiaNL], [DonViDoLuong])
VALUES ('NL001', 'Nguyên liệu mẫu', 100.0, 10.0, 'gram');
