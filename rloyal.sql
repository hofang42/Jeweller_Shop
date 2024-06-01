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
	image NVARCHAR(500),
	foreign key(product_category_id) references Product_Category(product_category_id),
	foreign key(product_collection_id) references Product_Collection(product_collection_id),
	foreign key(discount_id) references Discount(discount_id),
)
drop table Product

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

INSERT INTO Product (product_id, product_name, product_category_id, product_collection_id) VALUES
(1, 'B.Zero1 Necklace', 6, 1),
(2, 'Serpenti Viper Ring', 7, 2),
(3, 'Serpenti Viper Bracelet', 8, 2),
(4, 'Divas'' Dream Earrings', 9, 3),
(5, 'Bvlgari Cabochon Ring', 7, 4),
(6, 'Fiorever Pendant', 6, 6),
(7, 'Save the Children Necklace', 6, 7),
(8, 'Monete Bracelet', 8, 8),
(9, 'Incontro d''Amore Ring', 11, 9),
(10, 'Infinito Wedding Band', 12, 10)
(11, 'Dedicata a Venezia Engagement Ring', 11, 11),
(12, 'Marryme Wedding Band', 12, 11),
(13, 'Serpenti Watch', 16, 13),
(14, 'Lvcea Watch', 16, 14),
(15, 'Octo Watch', 16, 16),
(16, 'Bvlgari Bvlgari Bag', 21, 5),
(17, 'Bvlgari Allegra Fragrance', 22, 22),
(18, 'Omnia Fragrance', 24, 24),
(19, 'Bvlgari Man Fragrance', 27, 27)

ALTER TABLE product_collection
ADD image NVARCHAR(500);
