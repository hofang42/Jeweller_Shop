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
('hoangphuc', '0905536131', 'phuctvhde180493@gmail.com', 'na290604', 'Hoang Phuc Tran Van', 0, 1)

insert into Product_Info (product_info_id, product_small_desc, product_full_desc, material