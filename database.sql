Create database Project;
use Project;
ALTER DATABASE Project CHARACTER SET utf8 COLLATE utf8_unicode_ci;
/*================Brand===============*/

Create table Brand(
                      id int auto_increment ,
                      name nvarchar(50) unique,
                      status boolean,
                      primary key (id)
);
/*================Category===============*/
Create table Category(
                         id int auto_increment ,
                         name nvarchar(50) unique,
                         location int ,/* vị trí sắp xếp hiển thị trang chủ trên thanh nagative*/

                         status boolean,
                         primary key (id)
);
/*================Product===============*/
Create table Product(
                        id int auto_increment,
                        name nvarchar(50) unique,
                        image nvarchar(255),
                        subimage text,
                        price float,
                        price_sell int default(0),
                        subdescription nvarchar(255),
                        description text,
                        createdDate datetime default(time(now())),
                        status boolean,

                        id_Category int ,
                        id_Brand int,
                        primary key (id),
                        foreign key (id_Category) references Category(id),
                        foreign key (id_Brand) references Brand(id)
);
/*================Customer===============*/
Create table Customer(
                         id int auto_increment,
                         name nvarchar(50),
                         birthday date ,
                         address nvarchar(100),
                         phone varchar(11),
                         email varchar(100),
                         password varchar(100) check(length(password) > 8),
                         status boolean,

                         primary key (id)
);
/*================orderProduct===============*/
Create table orderProduct(
                             id int auto_increment,
                             totalMoney double,
                             createdDate datetime default(time(now())),
                             status boolean,

                             consignee  nvarchar(50),/*Tên người nhận hàng*/
                             addressOrder nvarchar(86),
                             numberPhone varchar(11),
                             note nvarchar(50),

                             id_Customer int,
                             primary key(id),
                             foreign key (id_Customer) references Customer(id)
);
/*================orderDetailProduct===============*/
Create table orderDetailProduct(
                                   id int auto_increment,
                                   nameProduct nvarchar(50),
                                   price float,
                                   price_sell int default(0),
                                   quantity int,
                                   total double,

                                   id_Order int,
                                   id_Product int,
                                   primary key (id),
                                   foreign key (id_Order) references orderProduct(id),
                                   foreign key (id_Product) references Product(id)
);

/*================Role===============*/
Create table Role (
                      id int auto_increment,
                      name nvarchar(50),
                      status boolean,
                      primary key (id)
);
/*================Customer_Role===============*/
Create table Customer_Role(
                              id int auto_increment,
                              id_Customer int,
                              id_Role int,

                              primary key(id),
                              foreign key(id_Customer) references Customer(id),
                              foreign key(id_Role) references Role(id)
);
/*================Banner===============*/
Create table Banner(
                       id int auto_increment,
                       name nvarchar(50),
                       image varchar(100),
                       location int,
                       status boolean,

                       primary key (id)
);
/*================News===============*/
Create table News(
                     id int auto_increment,
                     title nvarchar(100),
                     subtitle nvarchar(50),
                     createdDate datetime default(time(now())),
                     description text,
                     status boolean,

                     id_Customer int,
                     primary key (id),
                     foreign key (id_Customer) references Customer(id)

);
/*================Company===============*/
Create table Company(
                        id int auto_increment,
                        name nvarchar(100),
                        address nvarchar(100),
                        hotline varchar(11),
                        note nvarchar(100),
                        status boolean,
                        primary key (id)
);
/*================Settings===============*/
Create table Settings(
                         id int auto_increment,
                         title nvarchar(50),
                         logo nvarchar(100),
                         hotline varchar(11),
                         address nvarchar(100),
                         linkMap varchar(200),
                         email varchar(100),
                         pageFacebook varchar(100),
                         logo_payment nvarchar(100),
                         note nvarchar(100),
                         primary key (id)
);
/*================Procedure===============*/
