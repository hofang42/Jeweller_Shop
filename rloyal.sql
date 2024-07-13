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
	img_link nvarchar(50),
	product_id int foreign key references Product(product_id)
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
	product_info_id int identity(1,1) primary key,
	product_name nvarchar(50),
	product_small_desc nvarchar(150),
	product_full_desc nvarchar(500),
	material nvarchar(50),
	gemstone nvarchar(50),
	size nvarchar(50),
	resizeable nvarchar(50),
	pendant nvarchar(50),
	diamond nvarchar(50),
	olfactive_family nvarchar(50),
	colour varchar,
	original_price nvarchar(50),
	sale_price nvarchar(50),
	product_id int,
	foreign key (product_id) references Product(product_id) 
)

alter table user_web
add created_at date default getdate()
drop table user_web
create table user_web(
	user_id INT IDENTITY(1,1) PRIMARY KEY,
	user_name nvarchar(100),
	user_phone varchar(15)  CONSTRAINT chk_phone CHECK (user_phone LIKE '[0-9]%'),
	user_email varchar(255) CONSTRAINT chk_email CHECK (user_email LIKE '%_@_%._%'),
	password VARCHAR(255) NOT NULL,
    CONSTRAINT chk_password CHECK (LEN(password) >= 8),
	user_firstname nvarchar(50) not null,
	user_lastname nvarchar(50) not null,
	isAdmin int not null,
	created_at date default getdate(),
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

create table order_details(
	id int identity(1,1) primary key,
	user_id int,
	full_name nvarchar(50),
	email nvarchar(255) CONSTRAINT chkEmail CHECK (Email LIKE '%_@__%.__%'),
	address nvarchar(100),
	city nvarchar(50),
	phone_number nvarchar(20) CONSTRAINT chk_PhoneNumber CHECK (phone_number LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
	state nvarchar(50),
	zipcode int,
	foreign key (user_id) references user_web(user_id)
);

create table order_items(
	id int identity(1,1) primary key,
	product_id int foreign key references product(product_id), 
	quantity int,
	payment_id int foreign key references payment_details(id)
)

create table payment_details(
	id int identity(1,1) primary key,
	user_id int,
	full_name nvarchar(50),
	email nvarchar(255) CONSTRAINT chkEmail CHECK (Email LIKE '%_@__%.__%'),
	address nvarchar(100),
	city nvarchar(50),
	phone_number nvarchar(20) CONSTRAINT chk_PhoneNumber CHECK (phone_number LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
	state nvarchar(50),
	zipcode int,
	amount int,
	status nvarchar(30),
	created_at date default getdate(),
	foreign key (user_id) references user_web(user_id)
)

create table user_google_login(
	google_id nvarchar(255) primary key,
	user_fullname nvarchar(50),
	user_firstname nvarchar(50),
	user_lastname nvarchar(50),
	user_phone nvarchar(15)  CONSTRAINT phone CHECK (user_phone LIKE '[0-9]%'),
	user_email nvarchar(255) CONSTRAINT email CHECK (user_email LIKE '%_@_%._%'),
	created_at date default getdate()
)
