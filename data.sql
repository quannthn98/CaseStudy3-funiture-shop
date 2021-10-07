use Project;





insert into Role(name, status)
VALUES ('admin', 1);
insert into Role(name, status)
VALUES ('customer', 1);

insert into Customer value (1, 'Quân', '1998-06-16', 'Ha noi', '034700233', 'quanbeo98@gmail.com', 'quanbeo98', 1);
insert into Customer value (2, 'Nam', '1995-03-12', 'Hải Phòng', '0234523343', 'Nam@gmail.com', '123456789', 1);
insert into Customer value (3, 'Linh', '1993-02-19', 'Nam Định', '0233432433', 'Linh@gmail.com', '123456789', 1);
insert into Customer value (4, 'Lan', '1999-09-30', 'Hà Nội', '02354634242', 'Lan@gmail.com', '123456789', 1);
insert into Customer value (5, 'Liên', '1997-03-28', 'Hà Nội', '04223531232', 'Lien@gmail.com', '123456789', 1);
insert into Customer value (6, 'Kiên', '1998-06-16', 'Hà Nội', '034700233', 'kien@gmail.com', '123456789', 1);
insert into Customer value (7, 'Mạnh', '1998-02-19', 'Ninh Bình', '034700233', 'manh@gmail.com', '123456789', 1);
insert into Customer value (8, 'Hùng', '1999-03-12', 'Lào Cai', '234200233', 'hung@gmail.com', '123456789', 1);
insert into Customer value (9, 'Hải', '1992-04-12', 'Nam Định', '0355745353', 'hai@gmail.com', '123456789', 1);
insert into Customer value (10, 'Tùng', '1991-06-13', 'Hà Nội', '03463454342', 'tung@gmail.com', '123456789', 1);
insert into Customer value (11, 'Phan', '1993-05-22', 'Ninh Bình', '0346342423', 'phan@gmail.com', '123456789', 1);
insert into Customer value (12, 'Ninh', '1994-02-13', 'Lào Cai', '03462324343', 'ninh@gmail.com', '123456789', 1);
insert into Customer value (13, 'Huyền', '1999-03-12', 'Nghệ An', '0347610975', 'huyen@gmail.com', '123456789', 1);
insert into Customer value (14, 'Oanh', '1996-03-30', 'Ninh Bình', '03452343434', 'oanh@gmail.com', '123456789', 1);


insert into Customer_Role(id_Customer, id_Role) VALUES (1,1);
insert into Customer_Role(id_Customer, id_Role) VALUES (2,2);
insert into Customer_Role(id_Customer, id_Role) VALUES (3,2);
insert into Customer_Role(id_Customer, id_Role) VALUES (4,2);
insert into Customer_Role(id_Customer, id_Role) VALUES (5,2);
insert into Customer_Role(id_Customer, id_Role) VALUES (6,2);
insert into Customer_Role(id_Customer, id_Role) VALUES (7,2);
insert into Customer_Role(id_Customer, id_Role) VALUES (8,2);
insert into Customer_Role(id_Customer, id_Role) VALUES (9,2);
insert into Customer_Role(id_Customer, id_Role) VALUES (10,2);
insert into Customer_Role(id_Customer, id_Role) VALUES (11,2);
insert into Customer_Role(id_Customer, id_Role) VALUES (12,2);
insert into Customer_Role(id_Customer, id_Role) VALUES (13,2);
insert into Customer_Role(id_Customer, id_Role) VALUES (14,2);

insert into orderProduct( createdDate, status, consignee, addressOrder, numberPhone, id_Customer) values ('2021-01-15', 1, 'Kiên', 'Ha Noi', '0354342423', 6);
insert into orderProduct( createdDate, status, consignee, addressOrder, numberPhone, id_Customer) values ('2021-02-15', 1, 'Quân', 'Ha Noi', '0354342423', 2);
insert into orderProduct( createdDate, status, consignee, addressOrder, numberPhone, id_Customer) values ('2021-03-15', 1, 'Lan', 'Ha Noi', '0354342423', 7);
insert into orderProduct( createdDate, status, consignee, addressOrder, numberPhone, id_Customer) values ('2021-04-15', 1, 'Liên', 'Ha Noi', '0354342423', 9);
insert into orderProduct( createdDate, status, consignee, addressOrder, numberPhone, id_Customer) values ('2021-05-15', 1, 'Mạnh', 'Ha Noi', '0354342423', 5);
insert into orderProduct( createdDate, status, consignee, addressOrder, numberPhone, id_Customer) values ('2021-06-15', 1, 'Huyền', 'Ha Noi', '0354342423', 10);
insert into orderDetailProduct(price, price_sell, quantity, id_Order, id_Product) values (20000000,0,1,1,1);
insert into orderDetailProduct(price, price_sell, quantity, id_Order, id_Product) values (18000000,0,1,1,2);
insert into orderDetailProduct(price, price_sell, quantity, id_Order, id_Product) values (21000000,0,1,2,3);
insert into orderDetailProduct(price, price_sell, quantity, id_Order, id_Product) values (16000000,0,1,3,4);
insert into orderDetailProduct(price, price_sell, quantity, id_Order, id_Product) values (21000000,0,1,4,2);
insert into orderDetailProduct(price, price_sell, quantity, id_Order, id_Product) values (15000000,0,1,5,3);
insert into orderDetailProduct(price, price_sell, quantity, id_Order, id_Product) values (25000000,0,1,6,7);

insert into Category(name) values ('Ghế Sofa');
insert into Category(name) values ('Ghế đôn');
insert into Category(name) values ('Kệ, Tủ TV');
insert into Category(name) values ('Đồng hồ');
insert into category(name, location, status) VALUES ('Bàn Ăn',2,1);
insert into category(name, location, status) VALUES ('Tủ Bếp',2,1);
insert into category(name, location, status) VALUES ('Bồn Rửa Bát',2,1);
insert into category(name, location, status) VALUES ('Máy Hút Mùi',2,1);
insert into category(name, location, status) VALUES ('Giường Ngủ',3,1);
insert into category(name, location, status) VALUES ('Bàn Trang Điểm',3,1);
insert into category(name, location, status) VALUES ('Rèm Cửa',3,1);
insert into category(name, location, status) VALUES ('Đèn ngủ',3,1);

insert into Brand(name) value ('Ashley Home Furniture');
insert into Brand(name) value ('Sofa French William');
insert into Brand(name) value ('Sofa Chateau d’Ax – Italia');
insert into Brand(name) value (' Sofa Malaysia Omega');
insert into brand (name, status) VALUES ('OCHU', 1);
insert into brand (name, status) VALUES ('SHOUSE VIỆT NAM', 1);
insert into brand (name, status) VALUES ('Nội Thất Thăng Long Plus', 1);
insert into brand (name, status) VALUES ('Nội Thất OEM', 1);
insert into brand (name, status) VALUES ('Nội Thất Luxfuni', 1);
insert into brand(name, status) VALUES ('Nội Thất Anh Quân',1);
insert into brand(name, status) VALUES ('Kales',1);
insert into brand(name, status) VALUES ('Munchen',1);
insert into brand(name, status) VALUES ('Luxcasa',1);
insert into brand(name, status) VALUES ('Dehome',1);


insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Ghế Sofa Da Cao Cấp SF324', 'user/src/img/sofa-da-cong-nghiep-van-phong.jpg', 'none', 23100000, 18500000,
        'Kích thước: 2,9m x 1m ', 'Chất liệu: Da Microfiber </br>Bảo hành: 5 năm</br>Tình trạng: Mới', 1, 13);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Ghế Sofa Da Cao Cấp SF319  ', 'user/src/img/kieu-dang-sofa-the-he-moi.jpg', 'none', 25000000, 22000000,
        'Kích thước:  2,7m * 1,7m * 0,9m ', 'Chất liệu: Da Microfiber</br>Bảo hành: 5 năm</br>Tình trạng: Mới', 1, 13);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Ghế Sofa Da Cao Cấp SF313', 'user/src/img/ghe-sofa-goc-tiep-khach-hien-dai.jpg', 'none', 27800000, 23400000,
        'Kích thước: 2,7m * 1,75m * 0,95 m', 'Chất liệu: Da Microfiber</br>Bảo hành: 5 năm</br>Tình trạng: Mới', 1, 2);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Sofa bọc da phòng khách chung cư SD948', 'user/src/img/set-sofa-boc-da-phong-khach-chung-cu-SD148.jpg', 'none', 15700000, 13000000,
        'Kích thước: 2,2m * 1m', 'Chất liệu: Da Microfiber</br>Bảo hành: 5 năm</br>Tình trạng: Mới', 1, 4);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Sofa chữ L phủ da bóng SD123', 'user/src/img/sofa-phu-da-bong-SD123.jpg', 'none', 24000000, 22500000,
        'Kích thước: 2,8m * 1,8m * 0,95 m', 'Chất liệu: Da Microfiber</br>Bảo hành: 5 năm</br>Tình trạng: Mới', 1, 3);




insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Ghế Tròn Đôn Sofa', 'user/src/img/ghe-don-trong-sofa.jpg', 'none', 690000, 0,
        'Kích thước:Cao 40 cm. Đường kính mặt ghế 42cm', 'Ghế đôn', 2, 5);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Đồng hồ Nội Thất DHA 14', 'user/src/img/do-ho-dha14.jpg', 'none', 1090000, 0,
        'Kích thước: 70x70cm', 'Đồng Hồ', 4, 1);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Đồng Hồ Giọt Nước Treo Tường', 'user/src/img/dong-ho-giot-nuoc.jpg', 'none', 1200000, 899000,
        'Kích thước: 70x70cm', 'Đồng Hồ', 4, 6);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Đồng Hồ Treo Tường Decor DC22', 'user/src/img/dong-ho-treo-tuong-kim-troi-4.jpg', 'none', 2200000, 1100000,
        'Kích thước tổng thể: 83cm x 48cm', 'Đồng Hồ', 4, 6);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Đồng Hồ Treo Tường Thuyền Buồm', 'user/src/img/dong-ho-thuyen-buom.jpg', 'none', 2680000, 999000,
        ' Kích thước tổng thể: 90cm x 69cm', 'Đồng Hồ', 4, 6);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Kệ Tủ TV Màu Sồi', 'user/src/img/ke-tu-tv-mau-soi.jpg', 'none', 3500000, 2800000,
        ' Kích thước   : (Cao 48 x Rộng 35 x Dài 190 – 250 ) (cm)', 'Kệ Tủ TV', 3, 7);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Kệ tủ gỗ đứng KG28', 'user/src/img/ke-go-dung.webp', 'none', 3000000, 2799000,
        'Kích thước : 1600*1600*240 mm .', 'Kệ Tủ TV', 3, 8);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Ghế Thư Giãn Xoay', 'user/src/img/ghe-thu-gian-xoay.jpg', 'none', 2400000, 1800000,
        'Kích thước : 820*590*480 mm .', 'Ghế đôn', 2, 9);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Kệ trang trí đương đại Patrick XM-CB2006', 'user/src/img/Ke-tivi-XM-CB2006.jpg', 'none', 23800000, 0,
        'Kích thước: 1860 * 550 * 820 mm', 'Kệ Tủ Tv', 3, 9);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Kệ Tivi Tommy Sơn Ngọc Trai 6001', 'user/src/img/ke-tu-tv-son-ngoc-trai.jpg', 'none', 12600000, 0,
        'Kích thước: 1860 * 550 * 820 mm', 'Kệ Tủ Tv', 3, 9);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Ghế Bắc Âu SD-CY102', 'user/src/img/ghe-bac-au-SD-CY102.jpg', 'none', 2400000, 3000000,
        'Kích thước: 490*600*950 mm', 'Ghế Đôn', 2, 9);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Ghế Bắc Âu HARP', 'user/src/img/ghe-HARP.png', 'none', 2000000, 1350000,
        'Kích thước: 490*600*950 mm', 'Ghế Đôn', 2, 9);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Ghế Bắc Âu HF2016', 'user/src/img/ghe-HF2016-xanh.jpg', 'none', 3000000, 2500000,
        'Kích thước: 490*600*950 mm', 'Ghế Đôn', 2, 9);



insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Bàn Ăn Thông Minh Bếp Từ Mặt Đá T5138', 'user/src/img/ban-an-thong-minh1.jpg', 'none', 11625000, 9300000,
        'Kích thước(1100-1400)*750*760 mm', 'Bàn Ăn', 5, 9);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Bàn ăn thông minh bếp từ T1959', 'user/src/img/ban-an-thong-minh-bep-tu-t1959-9.jpg', 'none', 13500000, 11500000,
        'Kích thước: 1350*850*780 mm', 'Bàn Ăn', 5, 9);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Bàn Ăn Thông Minh Bếp Từ Mặt Đá', 'user/src/img/ban-an-mat-da-075-4.png', 'none', 15500000, 14800000,
        'Kích thước(1100-1400)*750*760 mm', 'Bàn Ăn', 5, 9);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Bàn Ăn Thông Minh Tích Hợp Sạc Pin Điện Thoại', 'user/src/img/ban-an-thong-minh-mat-gom-bep-tu-tich-hop-sac-pin-dien-thoai-10.jpg', 'none', 10000000, 8300000,
        'Kích thước1300*800mm', 'Bàn Ăn', 5, 9);


insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Tủ kệ để lò vi sóng đa năng KVS17', 'user/src/img/tu-ke-de-lo-vi-song-da-nang-KVS17.webp', 'none', 2000000, 1590000,
        'Kích thước tủ kệ : Dài 110 cm , rộng 40 cm cao 90 cm', 'Tủ Bếp', 6, 10);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Tủ kệ bếp để lò vi sóng KVS11', 'user/src/img/tu-bep-de-lo-vi-song-TVS11-1.webp', 'none', 2890000, 2190000,
        'Kích thước tủ kệ :  Cao tổng thể 1800  x Sâu 400 x Rộng 900 mm ', 'Tủ Bếp', 6, 10);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Tủ để lò vi sóng cao cấp KVS10', 'user/src/img/tu-de-lo-vi-song-cao-cap-KVS10.webp', 'none', 2000000, 1590000,
        'Kích thước tủ kệ : Cao tổng thể 1800  x Sâu 400 x Rộng 900 mm', 'Tủ Bếp', 6, 10);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Kệ để lò vi sóng KVS02', 'user/src/img/ke-de-lo-vi-song-1-tang-kvs02.webp', 'none', 750000, 649000,
        'Kích thước tủ kệ : Cao tổng thể 680  x Sâu 300 x Rộng 640 mm', 'Tủ Bếp', 6, 10);


insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Chậu Rửa Bát Âm Bàn Kelas KA-8345', 'user/src/img/chau-rua-am-ban-da-kelas-ka-8345.webp', 'none', 8650000, 5800000,
        'Kích thước: 830 x 450 x 230 mm', 'Bồn Rửa Bát', 7, 11);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Chậu Rửa Bát Kelas KA-7643', 'user/src/img/chau-rua-bat-kelas-ka-7643.webp', 'none', 7500000, 5400000,
        'Kích thước: 760 x 430 x 230 mm', 'Bồn Rửa Bát', 7, 11);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Chậu Rửa Bát 1 Hố Kelas 8045', 'user/src/img/chau-rua-bat-kelas-8045.webp', 'none', 6200000, 4950000,
        'Kích thước chậu : 800 x 450 x 230mm', 'Bồn Rửa Bát', 7, 11);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Chậu Rửa Bát Kelas K 6846', 'user/src/img/k-6846.webp', 'none', 5415000, 3790000,
        'Kích thước chậu : 680 x 460 x 220mm', 'Bồn Rửa Bát', 7, 11);


insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Máy Hút Mùi Munchen AM 98W', 'user/src/img/munchen-98w.webp', 'none', 7900000, 6900000,
        'Kích thước: (WxDxH) : 700x500x40(mm)', 'Máy Hút Mùi', 8, 12);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Máy Hút Mùi Munchen AM 692', 'user/src/img/munchen-jpg.webp', 'none', 5200000, 4600000,
        'Kích thước : Ngang 70 cm – cao 27,1 cm', 'Máy Hút Mùi', 8, 12);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Máy Hút Mùi Munchen AM 335', 'user/src/img/may-hut-mui-munchen-am-335.webp', 'none', 21500000, 19300000,
        'Kích thước: ( W x D ) = 700 x 433 (mm)', 'Máy Hút Mùi', 8, 12);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Máy Hút Mùi Munchen AMC 8122', 'user/src/img/may-hut-mui-munchen-amc-8122.webp', 'none', 9800000, 7800000,
        'Chiều dài: 700mm, Chiều sâu: 480mm, Chiều cao: 530mm', 'Máy Hút Mùi', 8, 12);




insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Giường ngủ thông minh BM4', 'user/src/img/giuong-thong-minh1.webp', 'none', 42500000, 32000000,
        'Kích thước:1m8 x 2m', 'Giường Thông Minh', 9, 13);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Giường ngủ thông minh SBE27', 'user/src/img/giuong-ngu-thong-minh-tan-co-dien-1.jpg.webp', 'none', 48500000, 28500000,
        'Kích thước:1m8 x 2m', 'Giường Thông Minh', 9, 13);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Giường ngủ bọc da cao cấp GD314', 'user/src/img/mau-giuong-hien-dai-don-gian.jpg', 'none', 29700000, 21800000,
        'Kích thước:1m8 x 2m', 'Giường Ngủ Thường', 9, 13);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Giường ngủ bọc da cao cấp GD316', 'user/src/img/mau-giuong-boc-da-hien-dai.jpg', 'none', 32000000, 22200000,
        'Kích thước:1m8 x 2m', 'Giường Ngủ Thường', 9, 13);


insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Bàn trang điểm Dehome - DPVD612.2F', 'user/src/img/guong-khung-inox-nguyen-ban-ban-trang-diem_1623921542.jpg', 'none', 5500000, 4920000,
        'Kích thước: Rộng 600mm x Cao 1200mm', 'Bàn Và Gương Trang Điểm', 10, 14);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Gương bàn trang điểm oval khung mạ PVD cao cấp', 'user/src/img/guong-ban-trang-diem-oval-khung-ma-pvd-dehome---dpvd691a_1601623634.jpg', 'none', 4500000, 3560000,
        'Kích thước: Rộng 600mm x Cao 900mm', 'Bàn Và Gương Trang Điểm', 10, 14);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Bàn trang điểm Dehome Cao Cấp', 'user/src/img/ban-trang-diem-deco-d117.jpg', 'none', 7600000, 6350000,
        'Kích thước: Rộng 750mm x Cao 1200mm', 'Bàn Và Gương Trang Điểm', 10, 14);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Bàn Trang Điểm Deco D196', 'user/src/img/ban-trang-diem-deco-d196.jpg', 'none', 25300000, 22000000,
        'Kích thước: Rộng 600mm x Cao 1200mm', 'Bàn Và Gương Trang Điểm', 10, 14);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('RÈM VẢI THÔ MÀU XANH ĐẬM CẢN NẮNG', 'user/src/img/rem-vai-mau-xanh-2.jpg', 'none', 1200000, 950000,
        'Kích thước: Khổ vải: Cao 2.8m.', 'Rèm Cửa Hàn Quốc', 11, 13);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Rèm vải 2 lớp - HL065', 'user/src/img/rem-vai-2-lop-hl065.jpg', 'none', 1350000, 1100000,
        'Kích thước: Khổ vải: Cao 2.8m.', 'Rèm Cửa Hàn Quốc', 11, 13);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Rèm vải hai màu - NL465', 'user/src/img/rem-vai-hai-mau-nl465.jpg', 'none', 1150000, 900000,
        'Kích thước: Khổ vải: Cao 2.8m.', 'Rèm Cửa Hàn Quốc', 11, 13);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Rèm vải 2 lớp phòng khách - PK23', 'user/src/img/rem-vai-2-lop-phong-khach.jpg', 'none', 1200000, 980000,
        'Kích thước: Khổ vải: Cao 2.8m.', 'Rèm Cửa Hàn Quốc', 11, 13);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Đèn ngủ để bàn cao cấp', 'user/src/img/den-ngu-cao-cap1.jpeg', 'none', 3750000, 2580000,
        'Kích thước(DxR): 530x300mm', 'Đèn Ngủ Cao Cấp', 12, 13);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Đèn ngủ để bàn ICE mạ crom vàng', 'user/src/img/29086963f923454cc277473d96241c9e.jpg', 'none', 850000, 667000,
        'Kích thước(DxR): 530x300mm', 'Đèn Ngủ Cao Cấp', 12, 13);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Đèn ngủ để bàn ZILYN đế gỗ cao cấp', 'user/src/img/b47899f3b17ec64c82976cc34eb860f0.jpg', 'none', 830000, 680000,
        'Kích thước(DxR): 530x300mm', 'Đèn Ngủ Cao Cấp', 12, 13);

insert into product(name, image, subimage, price, price_sell, subdescription, description, id_Category,
                    id_Brand)
VALUES ('Đèn ngủ gỗ LUKA cao cấp chuyên dụng', 'user/src/img/den-ngu-cao-cap2.jpeg', 'none', 700000, 550000,
        'Kích thước(DxR): 530x300mm', 'Đèn Ngủ Cao Cấp', 12, 13);


drop view fullOrderWithDetails;

create view fullOrderWithDetails as
select o.id as orderId, o.id_Customer as customerId,p.id as productId, od.nameProduct as productName, od.price, od.price_sell, o.createdDate, od.quantity as quantity, total,  o.status, consignee, addressOrder, numberPhone, note
from orderDetailProduct od
         join orderProduct o on o.id = od.id_Order
         join Product p on P.id = od.id_Product;

create view totalPaymentByOrder as
select orderId, sum((price*(1-fullOrderWithDetails.price_sell/100))*quantity) as payment from fullOrderWithDetails group by orderId;

create view productDetail as
select p.*, B.name as brand, C.name as category, C.location
from Product p
         join Brand B on B.id = p.id_Brand
         join Category C on C.id = p.id_Category;

create trigger deleteCustomerRole
    before delete on Customer for each row
    delete from Customer_Role where id_Customer = old.id;

create trigger deleteOrderByCustomerId
    before delete on Customer for each row
    delete from orderProduct where id_Customer = old.id;

create trigger deleteOrderDetailId
    before delete on orderProduct for each row
    delete from orderDetailProduct where orderDetailProduct.id_Order = old.id;







