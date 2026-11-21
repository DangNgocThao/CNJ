USE MASTER
GO
CREATE DATABASE QL_NHAHANG
GO
USE QL_NHAHANG
GO

CREATE TABLE THUCPHAM
(
	MATP INT IDENTITY(1,1) NOT NULL,
	TENTP NVARCHAR(30),
	DONVITINH NVARCHAR (10),
	MOTA NVARCHAR(50),
	CONSTRAINT PK_THUCPHAM PRIMARY KEY (MATP)
)

CREATE TABLE BANAN
(
	MABAN INT IDENTITY(1,1) NOT NULL,
	TENBAN NVARCHAR(30), 
	CONSTRAINT PK_BANAN PRIMARY KEY (MABAN),
)

CREATE TABLE LOAIMON
(
	MALOAI INT IDENTITY(1,1) NOT NULL,
	TENLOAI NVARCHAR (50),
	MOTA NVARCHAR(80),
	CONSTRAINT PK_LOAIMON PRIMARY KEY (MALOAI)
)

CREATE TABLE MONAN
(
	MAMONAN INT IDENTITY(1,1) NOT NULL,
	MALOAI INT NOT NULL,
	TENMONAN NVARCHAR (30),
	SOLUONG INT CHECK (SOLUONG >= 0),
	HINH NVARCHAR(30),
	DONVITINH NVARCHAR (30),
	DONGIA FLOAT CHECK (DONGIA > 0),
	MOTA NVARCHAR(90),
	CONSTRAINT PK_MONAN PRIMARY KEY (MAMONAN),
	CONSTRAINT FK_MONAN_LOAIMON FOREIGN KEY (MALOAI) REFERENCES LOAIMON(MALOAI)
)


CREATE TABLE KHACHHANG
(
	MAKH INT IDENTITY(1,1) NOT NULL,
	HOTENKH NVARCHAR(30),
	DIACHI NVARCHAR(30),
	SDT NCHAR (10),
	CONSTRAINT PK_KHACHHANG PRIMARY KEY (MAKH)
)

CREATE TABLE BOPHAN
(
	MABP INT IDENTITY(1,1) NOT NULL,
	TENBP NVARCHAR (30),
	CHUCNANG NVARCHAR (30),
	CONSTRAINT PK_BOPHAN PRIMARY KEY (MABP),
)

CREATE TABLE NHANVIEN
(
	MANV INT IDENTITY(1,1) NOT NULL,
	MABP INT NOT NULL,
	HINH NVARCHAR(30),
	HOTENNV NVARCHAR(30),
	SDT NCHAR (10),
	NGAYSINH  DATE,
	GIOITINH NVARCHAR (3) CHECK(GIOITINH = N'Nam' OR GIOITINH = N'Nữ') DEFAULT 'Nam',
	DIACHI NVARCHAR(30),
	CONSTRAINT PK_NHANVIEN PRIMARY KEY (MANV),
	CONSTRAINT FK_PK_NHANVIEN_BOPHAN FOREIGN KEY (MABP) REFERENCES BOPHAN(MABP)
)

CREATE TABLE HOADON
(
	MAHD INT IDENTITY(1,1) NOT NULL ,
	MAKH INT NOT NULL,
	MANV INT NOT NULL,
	NGAYTHANHTOAN DATE,
	TRANGTHAI NVARCHAR (30),
	TONGTIEN FLOAT CHECK (TONGTIEN > 0),
	CONSTRAINT PK_HOADON PRIMARY KEY (MAHD),
	CONSTRAINT FK_HOADON_KHACHHANG FOREIGN KEY (MAKH) REFERENCES KHACHHANG(MAKH),
	CONSTRAINT FK_HOADON_NHANVIEN FOREIGN KEY (MANV) REFERENCES NHANVIEN(MANV)
)

CREATE TABLE PHIEUGOIMON
(
	MAMONAN INT NOT NULL,
	MABAN INT NOT NULL,
	MANV INT NOT NULL,
	SOLUONG INT CHECK (SOLUONG > 0),
	CONSTRAINT PK_PHIEUGOIMON PRIMARY KEY (MAMONAN, MABAN),
	CONSTRAINT FK_PHIEUGOIMON_MONAN FOREIGN KEY (MAMONAN) REFERENCES MONAN(MAMONAN),
	CONSTRAINT FK_PHIEUGOIMON_KHACHHANG FOREIGN KEY (MABAN) REFERENCES BANAN(MABAN),
	CONSTRAINT FK_PHIEUGOIMON_NHANVIEN FOREIGN KEY (MANV) REFERENCES NHANVIEN(MANV)
)

CREATE TABLE PHIEUNHAP
(
	MAPN INT IDENTITY(1,1) NOT NULL,
	MANV INT NOT NULL,
	NGAYNHAP DATE,
	CONSTRAINT PK_DPHIEUNHAP PRIMARY KEY (MAPN),
	CONSTRAINT FK_PHIEUNHAP_NHANVIEN FOREIGN KEY (MANV) REFERENCES NHANVIEN(MANV),
)

CREATE TABLE CHITIETPHIEUNHAP
(
	MAPN INT NOT NULL,
	MATP INT NOT NULL,
	DONVINHAP NVARCHAR (10),
	SOLUONG INT CHECK (SOLUONG > 0),
	DIACHI NVARCHAR (30),
	CONSTRAINT PK_CHITIETPHIEUNHAP PRIMARY KEY (MAPN, MATP),
	CONSTRAINT FK_CHITIETPHIEUNHAP_PHIEUNHAP FOREIGN KEY (MAPN) REFERENCES PHIEUNHAP(MAPN),
	CONSTRAINT FK_CHITIETPHIEUNHAP_THUCPHAM FOREIGN KEY (MATP) REFERENCES THUCPHAM(MATP)
)

CREATE TABLE KHACHPHANHOINHANVIEN
(
	MAKH INT NOT NULL,
	MANV INT NOT NULL,
	NGAYPHANHOI DATE,
	NOIDUNG NVARCHAR (50),
	CONSTRAINT PK_KHACHPHANHOINHANVIEN PRIMARY KEY (MAKH, MANV),
	CONSTRAINT FK_KHACHPHANHOINHANVIEN_KHACHHANG FOREIGN KEY (MAKH) REFERENCES KHACHHANG(MAKH),
	CONSTRAINT FK_KHACHPHANHOINHANVIEN_NHANVIEN FOREIGN KEY (MANV) REFERENCES NHANVIEN(MANV)
)

CREATE TABLE CHITIETHOADON
(
	MAHD INT NOT NULL,
	MAMONAN INT NOT NULL,
	SOLUONG INT CHECK(SOLUONG > 0),
	CONSTRAINT PK_CHITIETHOADON PRIMARY KEY (MAHD, MAMONAN),
	CONSTRAINT FK_CHITIETHOADON_HOADON FOREIGN KEY (MAHD) REFERENCES HOADON(MAHD),
	CONSTRAINT FK_CHITIETHOADON_MONAN FOREIGN KEY (MAMONAN) REFERENCES MONAN(MAMONAN)
)

CREATE TABLE CALAMVIEC
(
	MACA INT IDENTITY(1,1) NOT NULL,
	TENCA NVARCHAR (30),
	GIOBD VARCHAR (30),
	GIOKT VARCHAR (30),
	CONSTRAINT PK_CALAMVIEC PRIMARY KEY (MACA),
)

CREATE TABLE NHANVIENCA
(
	MANV INT NOT NULL,
	MACA INT NOT NULL,
	CONSTRAINT PK_NHANVIENCA PRIMARY KEY (MANV, MACA),
	CONSTRAINT FK_NHANVIENCA_NHANVIEN FOREIGN KEY (MANV) REFERENCES NHANVIEN(MANV),
	CONSTRAINT FK_NHANVIENCA_CALAMVIEC FOREIGN KEY (MACA) REFERENCES CALAMVIEC(MACA)
)

CREATE TABLE NGUOIDUNG
(
	MANV INT NOT NULL,
	TAIKHOAN NCHAR(30) NOT NULL,
	MATKHAU NCHAR(30),
	CONSTRAINT PK_NGUOIDUNG PRIMARY KEY (TAIKHOAN, MANV),
	CONSTRAINT FK_NGUOIDUNG_NHANVIEN FOREIGN KEY (MANV) REFERENCES NHANVIEN(MANV)
)

INSERT INTO THUCPHAM VALUES
(N'Thịt bò Mỹ', 'kg', N'Thịt tươi và chắc'),
(N'Tôm càng xanh', 'kg', N'Tôm xanh tươi và ngon'),
(N'Bạch tuột', 'kg', N'Hàng mới nhập về còn rất tươi'),
(N'Mực ống', 'kg', N'Mực mới nhập còn sống và tươi'),
(N'Thịt lợn', 'kg', N'Thịt mới nhập còn tươi và ngon'),
(N'Hào sữa', 'kg', N'Hào mới nhập về còn sống và tươi ngon'),
(N'Rau muống', 'kg', N'Rau mới nhập về nên còn tươi không bị héo và dập'),
(N'Thịt gà', 'kg', N'Gà mới nhập nên còn rất tươi'),
(N'Ốc móng tay', 'kg', N'Ốc mới nhập về còn sống và tươi ngon'),
(N'Cá điêu hồng', 'kg', N'Cá mới nhập về còn sống và tươi ngon')

INSERT INTO BANAN VALUES
(N'Bàn 1'),
(N'Bàn 2'),
(N'Bàn 3'),
(N'Bàn 4'),
(N'Bàn 5'),
(N'Bàn 6'),
(N'Bàn 7'),
(N'Bàn 8'),
(N'Bàn 9'),
(N'Bàn 10'),
(N'Bàn 11'),
(N'Bàn 12')

INSERT INTO LOAIMON VALUES
(N'Lẩu', N'Lẩu thái chua cay, lẩu ngọt, lầu bò, lẩu gà'),
(N'Ốc', N'Ốc móng tay, ốc hương, ốc giác, ốc len, nghêu'),
(N'Tôm', N'Tôm càng xanh, tôm hùm, tôm alatka'),
(N'Cua', N'Cua đồng, cua biển, cua hoàng đế'),
(N'Thịt', N'Thịt bò Mỹ, thịt lợn, thịt gà, thịt vịt'),
(N'Cơm', N'Cơm chiên thập cẩm, cơm chiên hải sản, cơm chiên trân châu'),
(N'Mỳ', N'Mỳ xào hải sản, mỳ xào thịt bò'),
(N'Cá', N'Cá điêu hồng, cá hồi, cá ba sa, cá trứng'),
(N'Mực', N'Mực hấp, mực chiên giòn'),
(N'Rau câu', N'Rau câu dừa, rau câu giòn'),
(N'Kem', N'Kem vani'),
(N'Trái cây', N'Dưa hấu, xoài, nho, thơm'),
(N'Nước uống', N'Bia, Strongbow, nước khoáng Lavi, nước ngọt')

INSERT INTO MONAN VALUES
('1', N'Lẩu hải sản chua cay', 15, 'Hinh1.jpg', N'Một nồi lẩu', 200000, N'Lẩu gồm có bún, mực, tôm, rau, cá viên'),
('2', N'Ốc móng tay xào mỳ', 10, 'Hinh2.jpg', N'Một dĩa', 100000, N'Ốc xào với mỳ và rau muống ăn kèm với nước tương'),
('3', N'Tôm sốt thái', 18, 'Hinh3.jpg', N'Một dĩa', 150000, N'Tôm sống sốt với nước sốt chua cay'),
('4', N'Cua rang me', 30, 'Hinh4.jpg', N'Một dĩa', 175000, N'Cua rang với nước sốt me chua ngọt'),
('5', N'Bò nướng cuộn kim châm', 26, 'Hinh5.jpg', N'Một dĩa', 125000, N'Bò nướng ăn kèm với nước chấm muối ớt xanh'),
('6', N'Cơm chiên thập cẩm', 10, 'Hinh6.jpg', N'Một dĩa', 90000, N'Cơm chiên gồm có lạp xưởng, đậu que, cà rốt và trứng ăn kèm với nước tương'),
('7', N'Mỳ xào bò', 13, 'Hinh7.jpg', N'Một dĩa', 80000, N'Mỳ xào cùng với thịt và rau ăn kèm với nước tương'),
('8', N'Cá trứng chiên giòn', 14, 'Hinh8.jpg', N'Một dĩa', 95000, N'Cá trứng chiên giòn ăn kèm với mắm me'),
('9', N'Mực hỏa diệm sơn', 19, 'Hinh9.jpg', N'Một nồi', 135000, N'Mực hấp trong trái dừa và có phô mai kéo sợi ở trên mặt'),
('10', N'Rau câu dừa', 100, 'Hinh10.jpg', N'Một hủ', 10000, N'Rau câu dừa có những sợi dừa nhỏ được bào mỏng bên trong rau câu'),
('11', N'Kem vani', 60, 'Hinh11.jpg', N'Một hủ', 20000, N'Kem vani thơm ngon có quặng bánh ở dưới'),
('12', N'Trái cây', 40, 'Hinh12.jpg', N'Một dĩa', 65000, N'Dĩa trái cây gồm có nho, dưa hấu, xoài, thơm'),
('13', N'Nước ngọt', 200, 'Hinh13.jpg', N'Một lon', 14000, N'Nước ngọt gồm có cocacola, pepsi, mirinda, 7up, sting, xá xị'),
('13', N'Nước có cồn', 300, 'Hinh13.jpg', N'Một lon', 17000, N'Cồn ít Strongbow, Cồn mạnh bia'),
('1', N'Lẩu gà ớt hiểm', 20, 'Hinh14.jpg', N'Một nồi lẩu', 195000, N'Lẩu gồm có bún, thịt gà, rau, ớt hiểm'),
('8', N'Cá diêu hồng chưng tương', 16, 'Hinh15.jpg', N'Một dĩa', 93000, N'Cá điêu hồng chưng tương ăn kèm với nước tương')

INSERT INTO KHACHHANG VALUES
(N'Nguyễn Văn Bình', '0888013460', N'TP.HCM'),
(N'Lê Thị Thủy', '0924224675', N'Long An'),
(N'Trần Thanh Tuấn', '0919698351', N'Tiền Giang'),
(N'Dương Thanh Tài', '0336670451', N'Phú Yên'),
(N'Nguyễn Ngọc Thảo', '0123889124', N'Bình Phước'),
(N'Nguyễn Duy Quang', '0945772391', N'Đà Lạt'),
(N'Lưu Học Nghĩa', '0978776543', N'TP.HCM'),
(N'Mai Văn Thắng', '0965327532', N'Lâm Đồng')

INSERT INTO BOPHAN VALUES
(N'Quản Lý', N'Quản lý nhà hàng'),
(N'Phục vụ', N'Bưng dọn đồ ăn'),
(N'Kế toán', N'Thanh toán tiền'),
(N'Bảo vệ', N'Giữ xe'),
(N'Nhân sự', N'Tuyển và kiểm soát nhân viên'),
(N'Lao công', N'Quét dọn'),
(N'Đầu bếp', N'Chế biến món ăn')

SET DATEFORMAT DMY
INSERT INTO NHANVIEN VALUES
('4', 'Anh1.jpg', N'Nguyễn Văn Phúc', '0919567327', '12/02/2000', N'Nam', N'TP.HCM'),
('1', 'Anh2.jpg', N'Mai Thị Thanh', '0123445786', '19/08/2001', N'Nữ', N'Long An'),
('2', 'Anh3.jpg', N'Đinh Bão Trụ', '0871254638', '27/11/1998', N'Nam', N'Bình Phước'),
('6', 'Anh4.jpg', N'Trần Hồ Lực', '0912325610', '08/03/2002', N'Nam', N'Lâm Đồng'),
('3', 'Anh5.jpg', N'Lê Thị Tâm Như', '0123789254', '02/12/1999', N'Nữ', N'TP.HCM'),
('6', 'Anh6.jpg', N'Lê Minh Thiện', '0264873920', '14/09/1997', N'Nam', N'Phú Yên'),
('5', 'Anh7.jpg', N'Dương Thị Nhi', '0127592530', '27/06/1999', N'Nữ', N'TP.HCM'),
('3', 'Anh8.jpg', N'Lương Thị Mơ', '0897645327', '17/05/2000', N'Nữ', N'Bạc Liêu'),
('1', 'Anh9.jpg', N'Tống Gia Đạt', '0546378924', '24/11/1996', N'Nam', N'Hải Phòng'),
('2', 'Anh10.jpg', N'Đinh Minh Thư', '0164728940', '09/03/1998', N'Nữ', N'TP.HCM'),
('7', 'Anh11.jpg', N'Mai Anh Tuấn Đạt', '0987564537', '13/03/1990', N'Nam', N'TP.HCM'),
('7', 'Anh12.jpg', N'Lê Long Vinh', '0945367128', '07/09/1993', N'Nam', N'TP.HCM'),
('7', 'Anh13.jpg', N'Mai Bảo Yến', '0174635286', '27/11/1987', N'Nữ', N'TP.HCM')

INSERT INTO PHIEUGOIMON VALUES
('1', '1', '3', 10),
('3', '2', '10', 9),
('5', '3', '3', 6),
('9', '4', '10', 3),
('10', '5', '3', 5),
('15', '6', '10', 10),
('13', '7', '3', 6),
('2', '8', '10', 8),
('8', '9', '3', 7),
('11', '10', '10', 4)

SET DATEFORMAT DMY
INSERT INTO PHIEUNHAP VALUES
('2', '26/11/2022'),
('7', '25/08/2022'),
('2', '16/10/2021'),
('5', '06/09/2023'),
('8', '12/02/2022'),
('2', '05/06/2023'),
('7', '21/11/2021'),
('2', '11/08/2022'),
('8', '09/02/2021'),
('5', '10/12/2022')

INSERT INTO CHITIETPHIEUNHAP VALUES
('1', '1', 'kg', 50, N'TP.HCM'),
('2', '2', 'kg', 30, N'Vũng Tàu'),
('3', '3', 'kg', 25, N'Vũng Tàu'),
('4', '4', 'kg', 16, N'Vũng Tàu'),
('5', '5', 'kg', 13, N'Tiền Giang'),
('6', '6', 'kg', 12, N'Kiên Giang'),
('7', '7', 'kg', 10, N'Vũng Tàu'),
('8', '8', 'kg', 13, N'Vũng Tàu'),
('9', '9', 'kg', 8, N'Kiên Giang'),
('10', '10', 'kg', 9, N'Long An')

SET DATEFORMAT DMY
INSERT INTO KHACHPHANHOINHANVIEN VALUES
('1', '9', '16/08/2022', N'Nhà hàng cho đồ ăn lên nhanh'),
('2', '9', '13/07/2023', N'Nhân viên nhiệt tình'),
('3', '9', '27/12/2022', N'Nhà hàng gọn gàng, giá cả phù hợp'),
('4', '9', '07/09/2023', N'Nhân viên nhiệt tình, vui vẻ'),
('5', '2', '10/11/2021', N'Nhà hàng sạch sẽ'),
('6', '2', '03/06/2022', N'Nhân viên tư vấn nhiệt tình'),
('7', '2', '18/04/2023', N'Nhân viên nhiệt tình, vui vẻ'),
('8', '2', '25/08/2021', N'Nhân viên nhiệt tình, vui vẻ')

SET DATEFORMAT DMY
INSERT INTO HOADON VALUES
('1', '5', '09/10/2022', N'Thanh toán', 2500000),
('2', '5', '19/11/2021', N'Thanh toán', 3250000),
('3', '5', '14/12/2023', N'Chưa thanh toán', 10000000),
('4', '5', '07/09/2022', N'Thanh toán', 9700000),
('5', '8', '02/05/2021', N'Chưa thanh toán', 7800000),
('6', '8', '10/01/2023', N'Thanh toán', 6500000),
('7', '8', '27/03/2021', N'Thanh toán', 6780000),
('8', '8', '24/07/2022', N'Chưa thanh toán', 7690000)

INSERT INTO CHITIETHOADON VALUES
('1', '1', 10),
('2', '3', 13),
('3', '7', 5),
('4', '11', 8),
('5', '1', 7),
('6', '9', 12),
('7', '4', 11),
('8', '15', 10)

INSERT INTO CALAMVIEC VALUES
('ParTime', N'17:00:00', N'22:00:00'),
('FullTime', N'7:00:00', N'17:00:00'),
('ParTime', N'7:00:00', N'12:00:00'),
('FullTime', N'16:00:00', N'22:00:00'),
('ParTime', N'12:00:00', N'17:00:00')

INSERT INTO NHANVIENCA VALUES
('1', '1'),
('2', '2'),
('3', '3'),
('4', '5'),
('5', '4'),
('6', '1'),
('7', '3'),
('8', '4'),
('9', '1'),
('10', '5')

INSERT INTO NGUOIDUNG VALUES
('2', 'Admin1', '123'),
('9', 'Admin2', '123')
GO

--CREATE TRIGGER CapNhatSLSanPham ON CHITIETHOADON
--FOR INSERT
--AS
--	BEGIN
--		DECLARE CS_CapNhatSLSanPham CURSOR FOR SELECT MAMONAN,SOLUONG FROM inserted
--		DECLARE @MAMONAN INT,@SOLUONG INT
--		OPEN  CS_CapNhatSLSanPham
--		FETCH NEXT FROM  CS_CapNhatSLSanPham INTO @MAMONAN,@SOLUONG
--		WHILE(@@FETCH_STATUS=0)
--			BEGIN
--				update MONAN
--				SET SOLUONG=SOLUONG-@SOLUONG
--				WHERE MAMONAN=@MAMONAN
--				FETCH NEXT FROM  CS_CapNhatSLSanPham INTO @MAMONAN,@SOLUONG
--			END
--		CLOSE CS_CapNhatSLSanPham
--		DEALLOCATE CS_CapNhatSLSanPham
--	END
--GO

CREATE FUNCTION F_TK_SLTungSanPham (@START DATE,@FINISH DATE)
RETURNS @DS3 TABLE(MASP NCHAR(30),TENSP NVARCHAR(50),SOLUONG INT)
AS
	BEGIN
		DECLARE @MAMONAN NCHAR(30),@TENMONAN NVARCHAR(50),@SOLUONG INT
		DECLARE CS_DS3 CURSOR FOR SELECT MAMONAN,TENMONAN FROM MONAN
		OPEN CS_DS3
		FETCH NEXT FROM CS_DS3 INTO @MAMONAN,@TENMONAN
		WHILE(@@FETCH_STATUS=0)
			BEGIN
				SET @SOLUONG=(SELECT SUM(CT.SOLUONG) FROM CHITIETHOADON CT,HOADON HD WHERE MAMONAN=@MAMONAN AND HD.MAHD=CT.MAHD AND HD.NGAYTHANHTOAN BETWEEN @START AND @FINISH)
				IF(@SOLUONG IS NULL)
					SET @SOLUONG=0
				INSERT INTO @DS3 VALUES(@MAMONAN,@TENMONAN,@SOLUONG)
				FETCH NEXT FROM CS_DS3 INTO @MAMONAN,@TENMONAN
			END
		CLOSE CS_DS3
		DEALLOCATE CS_DS3
		RETURN
	END
GO

CREATE FUNCTION F_TK_TienTungSanPham(@START DATE,@FINISH DATE)
RETURNS @DS2 TABLE(MASP NCHAR(30),TENSP NVARCHAR(50),THANHTIEN FLOAT)
AS
	BEGIN
		DECLARE @MASP NCHAR(30),@TENSP NVARCHAR(50),@THANHTIEN FLOAT
		DECLARE CS_DS2 CURSOR FOR SELECT MAMONAN,TENMONAN FROM MONAN
		OPEN CS_DS2
		FETCH NEXT FROM CS_DS2 INTO @MASP,@TENSP
		WHILE(@@FETCH_STATUS=0)
			BEGIN
				SET @THANHTIEN=(SELECT SUM(CT.SOLUONG *SP.DONGIA) FROM CHITIETHOADON CT,HOADON HD,MONAN SP WHERE CT.MAMONAN=@MASP AND SP.MAMONAN=CT.MAMONAN AND HD.MAHD=CT.MAHD AND NGAYTHANHTOAN BETWEEN @START AND @FINISH)
				IF(@THANHTIEN IS NULL)
					SET @THANHTIEN=0
				INSERT INTO @DS2 VALUES(@MASP,@TENSP,@THANHTIEN)
				FETCH NEXT FROM CS_DS2 INTO @MASP,@TENSP
			END
		CLOSE CS_DS2
		DEALLOCATE CS_DS2
		RETURN
	END
GO

CREATE TRIGGER CapNhatSLSanPhamQuaPhieuGoi ON PHIEUGOIMON
FOR INSERT
AS
	BEGIN
		DECLARE CS_CapNhatSLSanPham CURSOR FOR SELECT MAMONAN,SOLUONG FROM inserted
		DECLARE @MAMONAN INT,@SOLUONG INT
		OPEN  CS_CapNhatSLSanPham
		FETCH NEXT FROM  CS_CapNhatSLSanPham INTO @MAMONAN,@SOLUONG
		WHILE(@@FETCH_STATUS=0)
			BEGIN
				UPDATE MONAN
				SET SOLUONG=SOLUONG-@SOLUONG
				WHERE MAMONAN=@MAMONAN
				FETCH NEXT FROM  CS_CapNhatSLSanPham INTO @MAMONAN,@SOLUONG
			END
		CLOSE CS_CapNhatSLSanPham
		DEALLOCATE CS_CapNhatSLSanPham
	END
GO

CREATE TRIGGER CapNhatSLSanPhamuUpdateQuaPhieuGoi ON PHIEUGOIMON
FOR UPDATE
AS
	BEGIN
		DECLARE CS_CapNhatSLSanPham CURSOR FOR SELECT MAMONAN,SOLUONG FROM inserted
		DECLARE @MAMONAN INT,@SOLUONG INT,@SOLUONGDELETE INT
		SET @SOLUONGDELETE=(SELECT SOLUONG FROM deleted )
		OPEN  CS_CapNhatSLSanPham
		FETCH NEXT FROM  CS_CapNhatSLSanPham INTO @MAMONAN,@SOLUONG
		WHILE(@@FETCH_STATUS=0)
			BEGIN
				UPDATE MONAN
				SET SOLUONG=SOLUONG-(@SOLUONG-@SOLUONGDELETE)
				WHERE MAMONAN=@MAMONAN
				FETCH NEXT FROM  CS_CapNhatSLSanPham INTO @MAMONAN,@SOLUONG
			END
		CLOSE CS_CapNhatSLSanPham
		DEALLOCATE CS_CapNhatSLSanPham
	END
GO

CREATE TRIGGER CapNhatSLSanPhamuDeleteQuaPhieuGoi ON PHIEUGOIMON
FOR DELETE
AS
	BEGIN
		DECLARE CS_CapNhatSLSanPham CURSOR FOR SELECT MAMONAN,SOLUONG FROM deleted
		DECLARE @MAMONAN INT,@SOLUONG INT
		OPEN  CS_CapNhatSLSanPham
		FETCH NEXT FROM  CS_CapNhatSLSanPham INTO @MAMONAN,@SOLUONG
		WHILE(@@FETCH_STATUS=0)
			BEGIN
				UPDATE MONAN
				SET SOLUONG=SOLUONG+@SOLUONG
				WHERE MAMONAN=@MAMONAN
				FETCH NEXT FROM  CS_CapNhatSLSanPham INTO @MAMONAN,@SOLUONG
			END
		CLOSE CS_CapNhatSLSanPham
		DEALLOCATE CS_CapNhatSLSanPham
	END
GO

CREATE PROC disableTrigger
AS
DISABLE TRIGGER CapNhatSLSanPhamuDeleteQuaPhieuGoi ON PHIEUGOIMON;
GO

CREATE PROC enableTrigger
AS
ENABLE TRIGGER CapNhatSLSanPhamuDeleteQuaPhieuGoi ON PHIEUGOIMON
GO