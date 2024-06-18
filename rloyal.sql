create database rloyal_demo
use rloyal_demo_1
create table Product_Category(
	product_category_id INT IDENTITY(1,1) PRIMARY KEY,
	product_category_parent_id int ,
	product_category_name varchar(50),
	foreign key (product_category_parent_id) references Product_Category(product_category_id)
)

create table Product_Collection (
	product_collection_id INT IDENTITY(1,1) PRIMARY KEY,
	product_collection_name varchar(50),
	product_category_id int,
	image NVARCHAR(500),
	foreign key (product_category_id) references Product_Category(product_category_id) 
)

create table Discount(
	discount_id int primary key,
	discount_name varchar,
	discount_percent decimal(10,2),
	active bit ,
	created_at date, 
	modified_at date,
	deleted_at date,
)

create table Product(
	product_id INT IDENTITY(1,1) primary key,
	product_name varchar(50),
	product_category_id int,
	product_collection_id int,
	created_at date default getdate(), 
	modified_at date,
	discount_id int,
	original_price decimal(10,2),
	sale_price decimal(10,2),
	image NVARCHAR(500),
	foreign key(product_category_id) references Product_Category(product_category_id),
	foreign key(product_collection_id) references Product_Collection(product_collection_id),
	foreign key(discount_id) references Discount(discount_id),
)
drop table Product

create table Product_img(
	img_id int identity(1,1) primary key,
	img_
)

drop table Product_Inventory
create table Product_Inventory(
	product_inventory_id int primary key ,
	quantity int
)


drop table Discount

create table Product_Item (
	product_item_id int primary key,
	product_id int,
	size int,
	product_inventory_id int unique,
	foreign key (product_id) references Product(product_id),
	foreign key (product_inventory_id) references Product_Inventory(product_inventory_id)
)

drop table Product_Item

create table Product_Info(
	product_id int primary key,
	product_desc varchar,
	full_desc varchar(500),
	diamondpave varchar,
	gemstone varchar,
	resizeable varchar,
	pendant varchar,
	colour varchar,
	foreign key (product_id) references Product(product_id) 
)
drop table user_web
create table user_web(
	user_id INT IDENTITY(1,1) PRIMARY KEY,
	user_name nvarchar(100),
	user_phone varchar(15)  CONSTRAINT chk_phone CHECK (user_phone LIKE '[0-9]%'),
	user_email varchar(255) CONSTRAINT chk_email CHECK (user_email LIKE '%_@_%._%'),
	password VARCHAR(255) NOT NULL,
    CONSTRAINT chk_password CHECK (LEN(password) >= 8),
	user_realname nvarchar(100) not null,
	isUser int,
	isAdmin int,
	created_at date,
)

INSERT INTO Product_Category ( product_category_parent_id, product_category_name) VALUES
(NULL, 'Jewelry'),
(NULL, 'Engagement and Wedding'),
(NULL, 'Watches'),
(NULL, 'Bags And Accessories'),
(NULL, 'Fragrances'),

(1, 'Necklaces'),
(1, 'Rings'),
(1, 'Bracelets'),
(1, 'Earrings'),
(1, 'Cufflinks And More'),

(2, 'Couple Rings'),
(2, 'Engagement Rings'),
(2, 'Women''s Wedding Bands'),
(2, 'Men''s Wedding Bands'),
(2, 'Diamond Gifts'),

(3, 'Gold Watches'),
(3, 'Rose Gold Watches'),
(3, 'Diamond Watches'),
(3, 'Skeleton Watches'),
(3, 'Automatic Watches'),
(3, 'Leather Watches'),

(4, 'Bags'),
(4, 'Wallets'),
(4, 'Small Leather Goods'),
(4, 'Leather Bracelets'),
(4, 'Eyewear'),
(3, 'Scarves And Stoles'),

(5, 'Bvlgari Allegra'),
(5, 'Bvlgari Le Gemme'),
(5, 'Omnia'),
(5, 'Eau Parfumée'),
(5, 'Goldea'),
(5, 'Petits et Mamans')



INSERT INTO Product_Collection (product_collection_name, product_category_id, image) VALUES
('B.Zero1', 1, 'B.zero1_1.avif'),
('Serpenti', 1, 'serpenti_1.avif'),
('Divas'' Dream', 1, 'DivasDream_1.avif'),
('Bvlgari Cabochon', 1, '1525660_1.avif'),
('Bvlgari Bvlgari', 1, '1525664.avif'),
('Fiorever', 1, '1526563.avif'),
('Save the Children', 1, '1497491_1.avif'),
('Monete', 1, '1361768_1.avif'),

('Incontro d''Amore', 2, '466687_2.avif'),
('Infinito', 2,'478847_2.avif'),
('Dedicata a Venezia', 2, '472455_2.avif'),
('Marryme', 2, '476282_2.avif'),
('Fedi', 2, '477983_2.avif'),

('Serpenti', 3, '1534755_3.avif'),
('Bvlgari Bvlgari', 3, '1448024_3.avif'),
('Lvcea', 3, '1578872_3.avif'),
('Divas''s Dream', 3, '1580697_3.avif'),
('Octo', 3,'1577950_3.avif'),
('Grandes Complications', 3, '1480087_3.avif'),

('Serpenti', 4, '1499362_4.avif'),
('Bvlagri Roma', 4, '1466379_4.avif'),
('Bvlagri Logo', 4, '1572898_4.avif'),
('B.Zero1', 4, '1556590_4.avif'),
('Bvlgari Bvlgari', 4, '1576286_4.avif'),
('Bvlgari Bvlgari Man', 4, '1544937_4.avif'),

('Bvlagri Allegra', 5, '1570311_5.avif'),
('Bvlagri Le Gemme', 5, '1363359_5.avif'),
('Omnia', 5, '1484433_5.avif'),
('Eau Paurfmée', 5, '325066_5.avif'),
('Goldea', 5, '1374784_5.avif'),
('Petits et Mamans', 5, '1245514_5.avif'),
('Bvlagri Man', 5, '1411432_5.avif');

create table Product(
	product_id int primary key,
	product_name varchar(50),
	product_category_id int,
	product_collection_id int,
	created_at date, 
	modified_at date,
	deleted_at date,
	discount_id int,
	original_price decimal(10,2),
	sale_price decimal(10,2),
	foreign key(product_category_id) references Product_Category(product_category_id),
	foreign key(product_collection_id) references Product_Collection(product_collection_id),
	foreign key(discount_id) references Discount(discount_id),
)

INSERT INTO Product (product_name, product_category_id, product_collection_id, image) VALUES
('B.Zero1 Necklace', 6, 1,'B.ZERO1 NECKLACE.avif'),
('Serpenti Viper Ring', 7, 2, 'Serpenti Viper Ring.avif'),
('Serpenti Viper Bracelet', 8, 2, 'Serpenti Viper Bracelet.avif'),
('Divas'' Dream Earrings', 9, 3, 'Divas'' Dream Earrings.avif'),
('Bvlgari Cabochon Ring', 7, 4, 'Bvlgari Cabochon Ring.avif'),
('Fiorever Necklace', 6, 6, 'Fiorever Necklace.png'),
('Save the Children Necklace', 6, 7, 'Save the Children Necklace.avif'),
('Monete Cufflinks', 10, 8, 'MONETE CUFFLINKS.avif'),
('Incontro d''Amore Ring', 11, 9, 'Incontro d''Amore Ring.avif'),
('Infinito Wedding Band', 12, 10, 'Infinito Wedding Band.avif'),
('Dedicata a Venezia Engagement Ring', 12, 11, 'Dedicata a Venezia Engagement Ring.avif'),
('Marryme Wedding Band', 12, 12, 'Marryme Wedding Band.avif'),
('Serpenti Tubogas Watch', 16, 14, 'SERPENTI TUBOGAS WATCH.avif'),
('Lvcea Watch', 18, 16, 'Lvcea Watch.avif'),
('Octo Roma Watch', 18, 18, 'Octo Roma Watch.avif'),
('Bvlgari Roma Medium Top Handle Bag', 22, 21, 'Bvlgari Roma Medium Top Handle Bag.avif'),
('BVLGARI ALLEGRA PASSEGGIATA EAU DE PARFUM', 28, 26, 'BVLGARI ALLEGRA PASSEGGIATA EAU DE PARFUM.avif'),
('OMNIA CRYSTALLINE EAU DE TOILETTE', 29, 28, 'OMNIA CRYSTALLINE EAU DE TOILETTE.avif'),
('EAU PARFUMÉE AU THÉ BLANC EAU DE COLOGNE SPRAY', 30, 29, 'EAU PARFUMÉE AU THÉ BLANC EAU DE COLOGNE SPRAY.avif')

ALTER TABLE product_collection
ADD image NVARCHAR(500);

insert into user_web (user_name, user_phone, user_email, password, user_realname, isUser, isAdmin) values
('hwangphuc76', '0983028278', 'vacpro66@gmail.com', 'na290604', 'Tran Van Hoang Phuc', 1, 0),
('hoangphuc', '0905536131', 'phuctvhde180493@gmail.com', 'na290604', 'Hoang Phuc Tran Van', 0, 1),