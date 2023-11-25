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

insert into [Nguyên Liệu]
values 
('Wsugar','Đường Trắngb',100,25000,'KG'),
('SiroDD','Siro đường đen Eurodeli can 2.5 kg',10,275000,'CAN'),
('RobustaMR','Robusta Medium Roast',200,85000,'KG'),
('HongTra','Hồng Trà Thượng Hạng',100,117000,'KG'),
('LucTraLaiLP','Lục Trà Lài Lộc Phát Thượng Hạng',100,145000,'KG'),
('OLong','Trà Ô Long Thượng Hàng',100,200000,'KG'),
('BlackTeaFuckLong','Trà Đen FuckLong',100,200000,'KG'),
('SyrupPMCherry','Pomona Cherry Syrup x 1000ml',5,290000,'Chai'),
('SyrupPMSmoky','Pomona Smoky Earlgrey Syrup x 1000ml',5,290000,'Chai'),
('SyrupPMLemon','Pomona Lemon Syrup x 1000ml',5,290000,'Chai'),
('SyrupPMGinxLemon','Pomona Ginger and Lemon Syrup x 1000ml',5,290000,'Chai'),
('SyrupPMStrawberry','Pomona Strawberry Syrup x 1000ml',5,290000,'Chai'),
('SyrupPMPinacolada','Pomona Pinacolada Syrup x 1000ml (Dứa Dừa)',5,290000,'Chai'),
('SyrupPMPeach','Pomona Peach Syrup x 1000ml',5,290000,'Chai'),
('SyrupPMCaramel','Pomona Caramel Syrup x 1000ml',5,290000,'Chai'),
('SyrupPMMarron','Pomona Marron Syrup x 1000ml',5,290000,'Chai'),
('SyrupPMHazelnut','Pomona Hazelnut Syrup x 1000ml (Hạt Phi)',5,290000,'Chai'),
('SyrupPMKiwi','Pomona Kiwi Syrup x 1000ml',5,290000,'Chai'),
('SyrupPMRaspberry','Pomona Raspberry Syrup x 1000ml',5,290000,'Chai'),
('SyrupPMApple','Pomona Apple Syrup x 1000ml',5,290000,'Chai'),
('SyrupPMBlueberry','Pomona Blueberry Syrup x 1000ml',5,290000,'Chai'),
('KBRichlun','Kem béo Rich lùn x 454g',20,30000,'Hộp'),
('STMilkLab','Sữa tươi MilkLab x 1000ml',20,30000,'Hộp'),
('SDLechera','Sữa Đặc La Lechera x 379g',50,70000,'Lon'),
('WCIsigny','Whipping Cream Isigny Ste Mère x 200gr',20,194000,'Lon'),
('BSBoduo','Bột sữa Boduo Premium x 25kg',5,2100000,'Bao'),
('BBAlmer','Bột sữa béo Bột Almer 941 x 25kg',5,2000000,'Bao'),
('BPMVerozyme','Bột Phô Mai Verozyme 1Kg',10,330000,'Bịch'),
('BSCPomona','Bột Sữa Chua Pomona 800g',10,305000,'Bịch'),
('BMCCozy','Bột Matcha Cozy 500g',10,304000,'Bịch'),
('CCAnchor','Cream Cheese Anchor 1Kg',10,215000,'Hộp'),
('DelPeaches','Delmonte Sliced Freestone Peaches',10,330000,'Lon'),
('DelOranges-SF','Delmonte Mandarin Oranges - No Sugar Added',10,330000,'Lon'),
('DelPears-SF','Delmonte Sliced Pears - No Sugar Added',10,330000,'Lon'),
('DelPinapple','Delmonte Canned Gold Pineapple Chunks in 100% Pineapple Juice',10,330000,'Lon'),
('DelCitrus','Delmonte Citrus Salad',10,330000,'Lon'),
('DelFruitCocktail','Delmonte Fruit Cocktail - No Sugar Added',10,330000,'Lon'),
('DelCherryMix','Delmonte Cherry Mixed Fruit - 100 Calories',10,330000,'Lon'),
('DelPittedCherry','Delmonte Pitted Cherries',10,330000,'Lon'),
('DelRedGrape','Delmonte Red Grapefruit - No Sugar Added',10,330000,'Lon'),
('DelApricot','Delmonte Apricot Halves',10,330000,'Lon'),
('SmcGrape','Smucker"s Jams CONCORD GRAPE JAM',10,330000,'Lon'),
('SmcStrawberry','Smucker"s Jams STRAWBERRY JAM',10,330000,'Lon'),
('SmcResRaspberry-SL','Smucker"s Jams SEEDLESS RED RASPBERRY JAM',10,330000,'Lon'),
('SmcBlackberry','Smucker"s Jams Black Berry JAM',10,330000,'Lon'),
('SmcBlackberry-SL','Smucker"s Jams Seedless Black Berry JAM',10,330000,'Lon'),
('SmcRedPlum','Smucker"s Jams RED PLUM JAM',10,330000,'Lon'),
('SmcCiderApple','Smucker"s Jams CIDER APPLE BUTTER',10,330000,'Lon'),
('SmcSQStrawberry','SQUEEZE SUGAR FREE STRAWBERRY JAM WITH SPLENDA® BRAND SWEETENER',10,330000,'Lon'),
('SmcSQGrape','SQUEEZE SUGAR FREE CONCORD GRAPE JAM WITH SPLENDA® BRAND SWEETENER',10,330000,'Lon'),
('AgarCafe','Thạch Agar Cafe x 3kg2',10,330000,'Hộp'),
('AgarFruit','Thạch Agar Fruit x 3kg2',10,330000,'Hộp'),
('AgarTraXanh','Thạch Agar Trà Xanh x 3kg2',10,330000,'Hộp'),
('AgarPhaLe','Thạch Agar Pha Lê x 3kg2',10,330000,'Hộp'),
('AgarCaramel','Thạch Agar Caramel x 3kg2',10,330000,'Hộp'),
('FMCamCara','Farmers Market CamCara x 8kg',1,300000,'Thùng'),
('FMVietQuocJumbo','Farmers Market Việt Quất New Zealand size Jumbo (Hộp 125G x 12)',1,1800000,'Thùng'),
('FMDauMinori','Farmers Market Dâu Nhật Minori (270G/Hộp)',3,300000,'Hộp'),
('FMSả','Farmers Market Sả Cây x 1kg',10,80000,'KG'),
('FMMint','Farmers Market Mint x 1kg',10,132000,'KG'),
('FMLemon','Farmers Market Lemon (1kg/Hộp)',10,132000,'Hộp'),
('FMLemonGrass','Farmers Market Lemon Grass',10,50000,'KG'),
('SodaScheweppers','Thùng 24 lon soda Schweppes 320ml',4,132000,'Thùng');

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
(2,'Wsugar',10,'Gram'),
(3,'Wsugar',25,'Gram'),
(3,'BlackTeaFuckLong',5,'Gram'),
(3,'RobustaMR',15,'Gram'),
(3,'WCIsigny',80,'Gram'),
(3,'SodaScheweppers',1,'Lon'),
(3,'BlackTeaFuckLong',100,'Ml'),
(3,'SyrupPMPeach',25,'Ml'),
(3,'Wsugar',3,'Gram'),
(3,'FMLemonGrass',1,'Cây'),
(3,'FMCamCara',1,'Lát'),
(3,'DelPeaches',4,'Lát'),
(4,'RobustaMR',30,'Ml'),
(4,'SDLechera',100,'Ml'),
(4,'STMilkLab',200,'Ml'),
(5,'RobustaMR',15,'Gram'),
(5,'STMilkLab',80,'Gram'),
(5,'Wsugar',10,'Gram'),
(6,'SodaScheweppers',200,'Ml'),
(6,'FMDauMinori',50,'Gram'),
(6,'SyrupPMPeach',45,'Ml'),
(6,'SyrupPMGinxLemon',25,'Ml'),
(6,'SmcStrawberry',25,'Ml'),
(6,'SyrupPMCaramel',25,'Ml'),
(6,'FMMint',25,'Gram'),
(7,'SyrupPMBlueberry',50,'Ml'),
(7,'FMVietQuocJumbo',30,'ML'),
(7,'FMLemon',30,'Ml'),
(7,'SodaScheweppers',1,'Lon');

go

/*Xem công thức có nguyên liệu nào*/
select ct.MaCT, ct.TenCongThuc from [Công thức] ct
join CT_NL on ct.MaCT = CT_NL.MaCT join [Nguyên Liệu] nl on nl.MaNL = CT_NL.MaNL
where ct.MaCT = 5;

go

insert into [Nhân Viên]
values
('Hisu','0807','Quản Lý','Phạm Văn Hiếu','19','Nam','0999999999','TPHCM'),
('SonSoi','0807','Quản Lý','Ngô Vũ Sơn','19','Nam','0999999999','TPHCM'),
('HuyLight','0807','Nhân Viên','Quang Huy','19','Nam','0999999999','TPHCM'),
('Poem','0807','Nhân Viên','Minh Thơ','19','Nam','0999999999','TPHCM'),
('Hung','0807','Nhân Viên','Sĩ Hùng','19','Nam','0999999999','TPHCM');

go

insert into [Sản Phẩm]
values
(1,'Cà Phê Sữa','xxxxx',35000,1),
(2,'Cà Phê Đen','xxxxx',30000,2),
(3,'Citrus peach tea','xxxxx',45000,4),
(4,'Bạc Xĩu','xxxxx',40000,5),
(5,'Capuchino','xxxxx',55000,3),
(6,'Strawberry Mojito','xxxxx',55000,1),
(7,'Blueberry Mocktail','xxxxx',35000,1);

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
