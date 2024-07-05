use rloyal_demo_1

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

ALTER TABLE product_info
ADD original_price nvarchar(50);


insert into user_web (user_name, user_phone, user_email, password, isAdmin, user_firstname, user_lastname, user_fullname) values
('hwangphuc76', '0983028278', 'vacpro66@gmail.com', 'na290604', 1, 'Tran Van', 'Hoang Phuc', 'Tran Van Hoang Phuc'),

insert into Product_Info (product_name, product_small_desc, product_full_desc, material, gemstone, size, resizeable, pendant, diamond, olfactive_family, colour, original_price , sale_price, product_id)
values ('B.ZERO1 NECKLACE', 'B.zero1 18 kt yellow gold mini pendant necklace with chain', 'Drawing its inspiration from the world’s most renowned amphitheatre, the Colosseum, the B.zero1 18 kt yellow gold chain necklace is a groundbreaking statement of Bvlgari’s daring',
'Yellow gold', 'No Gemstones', null, null, null, null, null, null, 53400000, null, 27),
('Serpenti Viper Ring', 'Serpenti Viper 18 kt rose gold single-spiral ring set with demi pavé diamonds', 'With its signature blend of pure aesthetics, enveloping shapes and charismatic flair, the Serpenti Viper 18 kt rose gold single-spiral ring with demi pavé diamonds is an essential interpretation of Bvlgari’s icon of endless metamorphosis. Capturing the powerful and ever-evolving nature of the mythical serpent, the magnetic jewellery creation inspires us to embrace change as a source of strength and self-confidence. Easy to mix and match, the ring offers endless styling options, embodying the collection’s versatile spirit.
Serpenti Viper ring in 18 kt rose gold with demi pavé', 'Rose gold', 'Diamonds', null, null, null, '0.14', null, null, 95600000, null, 2)

insert into product_img (img_link, product_id)
values ('1375629.avif', 27), ('1375631.avif', 27), ('1448222 (1).avif', 27), ('1448274.png', 27), ('1544336.avif', 27),
('1529968.avif', 2), ('1529988.avif', 2), ('1530522.avif', 2)
delete from Product_img
delete from Product_Info
