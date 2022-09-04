use shop_online;
-- App Role
INSERT INTO app_role (role_name) VALUES ('ROLE_ADMIN'); 
INSERT INTO app_role (role_name) VALUES ('ROLE_USER');

-- App User
INSERT INTO app_user (`password`, user_name, creation_date) 
VALUES ('$2a$10$NaPco7fYsB2Y/0xbQaOruum.w9V1nzHKqNYQ98/GQr7jCkKdZEg6q', 'manager', '2022-09-04');
INSERT INTO app_user (`password`, user_name, creation_date) 
VALUES ('$2a$10$NaPco7fYsB2Y/0xbQaOruum.w9V1nzHKqNYQ98/GQr7jCkKdZEg6q', 'admin', '2022-09-04');
INSERT INTO app_user (`password`, user_name, creation_date) 
VALUES ('$2a$10$NaPco7fYsB2Y/0xbQaOruum.w9V1nzHKqNYQ98/GQr7jCkKdZEg6q', 'levantai', '2022-09-04');
INSERT INTO app_user (`password`, user_name, creation_date) 
VALUES ('$2a$10$NaPco7fYsB2Y/0xbQaOruum.w9V1nzHKqNYQ98/GQr7jCkKdZEg6q', 'lethiphuong', '2022-09-04');
INSERT INTO app_user (`password`, user_name, creation_date) 
VALUES ('$2a$10$NaPco7fYsB2Y/0xbQaOruum.w9V1nzHKqNYQ98/GQr7jCkKdZEg6q', 'lethibinh', '2022-09-04');

-- admin account
INSERT INTO user_role (role_id, user_id) VALUES ('1', '1'); 
INSERT INTO user_role (role_id, user_id) VALUES ('2', '1');
INSERT INTO user_role (role_id, user_id) VALUES ('1', '2');
INSERT INTO user_role (role_id, user_id) VALUES ('2', '2'); 
-- user account
INSERT INTO user_role (role_id, user_id) VALUES ('2', '3');
INSERT INTO user_role (role_id, user_id) VALUES ('2', '4'); 
INSERT INTO user_role (role_id, user_id) VALUES ('2', '5');

-- category
INSERT INTO `category` (`id`, `name`) VALUES ('1', 'Điện Thoại');
INSERT INTO `category` (`id`, `name`) VALUES ('2', 'Laptop');
INSERT INTO `category` (`id`, `name`) VALUES ('3', 'Máy Ảnh');
INSERT INTO `category` (`id`, `name`) VALUES ('4', 'Phụ Kiện');
INSERT INTO `category` (`id`, `name`) VALUES ('5', 'Tivi');

-- product
INSERT INTO `product` (`id`, `name`, `image`, `description`, `price`, `is_deleted`, `category_id`) VALUES ('1', 'Iphone', 'https://firebasestorage.googleapis.com/v0/b/print-2-shop-online.appspot.com/o/product-7.jpg?alt=media&token=abf1329c-482e-4907-bd67-b090b0a338d1', '6.1 inch, OLED, Super Retina XDR, 2532 x 1170 Pixels', 22000000, 0, 1);
INSERT INTO `product` (`id`, `name`, `image`, `description`, `price`, `is_deleted`, `category_id`) VALUES ('2', 'SamSung', 'https://firebasestorage.googleapis.com/v0/b/print-2-shop-online.appspot.com/o/product-8.jpg?alt=media&token=30ad49b3-8ecb-42af-b604-366169e83f35', '6.1 inch, OLED, Super Retina XDR, 2532 x 1170 Pixels', 11000000,0, 1);
INSERT INTO `product` (`id`, `name`, `image`, `description`, `price`, `is_deleted`, `category_id`) VALUES ('3', 'SamSung', 'https://firebasestorage.googleapis.com/v0/b/print-2-shop-online.appspot.com/o/product-9.jpg?alt=media&token=0bd81d68-326b-4c70-afce-e064272f89c6', '6.1 inch, OLED, Super Retina XDR, 2532 x 1170 Pixels', 12000000,0, 1);
INSERT INTO `product` (`id`, `name`, `image`, `description`, `price`, `is_deleted`, `category_id`) VALUES ('4', 'Appo', 'https://firebasestorage.googleapis.com/v0/b/print-2-shop-online.appspot.com/o/product-10.jpg?alt=media&token=c62ce430-dfc0-4b5d-b1a7-b19b777fc5f7', '6.1 inch, OLED, Super Retina XDR, 2532 x 1170 Pixels', 8000000,0, 1);
INSERT INTO `product` (`id`, `name`, `image`, `description`, `price`, `is_deleted`, `category_id`) VALUES ('5', 'Nokia', 'https://firebasestorage.googleapis.com/v0/b/print-2-shop-online.appspot.com/o/product-11.jpg?alt=media&token=8f7a148a-1da0-4bbf-8018-f6bff0ea7f14', '6.1 inch, OLED, Super Retina XDR, 2532 x 1170 Pixels', 7000000,0, 1);
INSERT INTO `product` (`id`, `name`, `image`, `description`, `price`, `is_deleted`, `category_id`) VALUES ('6', 'Nokia', 'https://firebasestorage.googleapis.com/v0/b/print-2-shop-online.appspot.com/o/product-12.jpg?alt=media&token=d4cae853-cea7-41fb-afc8-edb8af7d4d6f', '6.1 inch, OLED, Super Retina XDR, 2532 x 1170 Pixels', 6000000,0, 1);
INSERT INTO `product` (`id`, `name`, `image`, `description`, `price`, `is_deleted`, `category_id`) VALUES ('7', 'LG', 'https://firebasestorage.googleapis.com/v0/b/print-2-shop-online.appspot.com/o/product-19.jpg?alt=media&token=b326f93c-9924-4eae-af2e-c28eeb293762', '6.1 inch, OLED, Super Retina XDR, 2532 x 1170 Pixels', 5000000,0, 5);
INSERT INTO `product` (`id`, `name`, `image`, `description`, `price`, `is_deleted`, `category_id`) VALUES ('8', 'Panasonic', 'https://firebasestorage.googleapis.com/v0/b/print-2-shop-online.appspot.com/o/product-23.jpg?alt=media&token=7e3704f3-841b-4209-8c3b-14bfef8ad749', '6.1 inch, OLED, Super Retina XDR, 2532 x 1170 Pixels', 4000000,0, 5);
INSERT INTO `product` (`id`, `name`, `image`, `description`, `price`, `is_deleted`, `category_id`) VALUES ('9', 'LG', 'https://firebasestorage.googleapis.com/v0/b/print-2-shop-online.appspot.com/o/product-21.jpg?alt=media&token=3e29ae75-aed7-4831-b4b6-3a7f6086ada2', '6.1 inch, OLED, Super Retina XDR, 2532 x 1170 Pixels', 3000000,0, 5);
INSERT INTO `product` (`id`, `name`, `image`, `description`, `price`, `is_deleted`, `category_id`) VALUES ('10', 'LG', 'https://firebasestorage.googleapis.com/v0/b/print-2-shop-online.appspot.com/o/product-22.jpg?alt=media&token=84c6d98c-8138-420b-81b5-4d0ab44c28a2', '6.1 inch, OLED, Super Retina XDR, 2532 x 1170 Pixels', 2000000,0, 5);
INSERT INTO `product` (`id`, `name`, `image`, `description`, `price`, `is_deleted`, `category_id`) VALUES ('11', 'VTB', 'https://firebasestorage.googleapis.com/v0/b/print-2-shop-online.appspot.com/o/product-20.jpg?alt=media&token=2d91d9db-1c41-4ecf-8929-b9c3d573a4a0', '6.1 inch, OLED, Super Retina XDR, 2532 x 1170 Pixels', 1000000,0, 5);
INSERT INTO `product` (`id`, `name`, `image`, `description`, `price`, `is_deleted`, `category_id`) VALUES ('12', 'Phụ Kiện Nolo', 'https://firebasestorage.googleapis.com/v0/b/print-2-shop-online.appspot.com/o/product-24.jpg?alt=media&token=839fc060-6b84-4478-9af2-9f4c8084d64b', '6.1 inch, OLED, Super Retina XDR, 2532 x 1170 Pixels', 12000000,0, 4);
INSERT INTO `product` (`id`, `name`, `image`, `description`, `price`, `is_deleted`, `category_id`) VALUES ('13', 'ASUS', 'https://firebasestorage.googleapis.com/v0/b/print-2-shop-online.appspot.com/o/product-2.jpg?alt=media&token=a2b49e8a-0b4b-4af3-b54f-b9f57eb9dea7', '6.1 inch, OLED, Super Retina XDR, 2532 x 1170 Pixels', 17000000,0, 2);
INSERT INTO `product` (`id`, `name`, `image`, `description`, `price`, `is_deleted`, `category_id`) VALUES ('14', 'Vavivo', 'https://firebasestorage.googleapis.com/v0/b/print-2-shop-online.appspot.com/o/product-1.jpg?alt=media&token=b13e340f-8390-4a81-a22a-131ab5b6316e', '6.1 inch, OLED, Super Retina XDR, 2532 x 1170 Pixels', 21000000,0, 2);
INSERT INTO `product` (`id`, `name`, `image`, `description`, `price`, `is_deleted`, `category_id`) VALUES ('15', 'Cáp HDMI', 'https://firebasestorage.googleapis.com/v0/b/print-2-shop-online.appspot.com/o/product-3.jpg?alt=media&token=7995fe3c-3a71-4783-affa-77d39c50df8a', '6.1 inch, OLED, Super Retina XDR, 2532 x 1170 Pixels', 11000000,0, 4);
INSERT INTO `product` (`id`, `name`, `image`, `description`, `price`, `is_deleted`, `category_id`) VALUES ('16', 'LCD Để Bàn', 'https://firebasestorage.googleapis.com/v0/b/print-2-shop-online.appspot.com/o/product-4.jpg?alt=media&token=1b6d3c7f-b623-4cdc-81d2-32052f9b960b', '6.1 inch, OLED, Super Retina XDR, 2532 x 1170 Pixels', 16000000,0, 2);
INSERT INTO `product` (`id`, `name`, `image`, `description`, `price`, `is_deleted`, `category_id`) VALUES ('17', 'RTX', 'https://firebasestorage.googleapis.com/v0/b/print-2-shop-online.appspot.com/o/product-5.jpg?alt=media&token=6a83ad5a-3518-44ed-9a1b-1ba1425e0858', '6.1 inch, OLED, Super Retina XDR, 2532 x 1170 Pixels', 12000000,0, 4);
INSERT INTO `product` (`id`, `name`, `image`, `description`, `price`, `is_deleted`, `category_id`) VALUES ('18', 'ASUS', 'https://firebasestorage.googleapis.com/v0/b/print-2-shop-online.appspot.com/o/product-6.jpg?alt=media&token=963dbddf-9f69-459d-9476-5aa2c613e85a', '6.1 inch, OLED, Super Retina XDR, 2532 x 1170 Pixels', 18000000,0, 2);
INSERT INTO `product` (`id`, `name`, `image`, `description`, `price`, `is_deleted`, `category_id`) VALUES ('19', 'Camera X115', 'https://firebasestorage.googleapis.com/v0/b/print-2-shop-online.appspot.com/o/product-13.jpg?alt=media&token=f91fb210-bc8c-48d2-8173-ee6289ed3bf2', '6.1 inch, OLED, Super Retina XDR, 2532 x 1170 Pixels', 33000000,0, 3);
INSERT INTO `product` (`id`, `name`, `image`, `description`, `price`, `is_deleted`, `category_id`) VALUES ('20', 'Camera 007', 'https://firebasestorage.googleapis.com/v0/b/print-2-shop-online.appspot.com/o/product-14.jpg?alt=media&token=6bc09fd7-4a0f-42d3-9ace-28bab862e5b6', '6.1 inch, OLED, Super Retina XDR, 2532 x 1170 Pixels', 22000000,0, 3);
INSERT INTO `product` (`id`, `name`, `image`, `description`, `price`, `is_deleted`, `category_id`) VALUES ('21', 'Camera Hường', 'https://firebasestorage.googleapis.com/v0/b/print-2-shop-online.appspot.com/o/product-15.jpg?alt=media&token=587c2acf-03e1-42a5-b4c9-a66708735fc1', '6.1 inch, OLED, Super Retina XDR, 2532 x 1170 Pixels', 14000000,0, 3);
INSERT INTO `product` (`id`, `name`, `image`, `description`, `price`, `is_deleted`, `category_id`) VALUES ('22', 'Phụ Kiện xx', 'https://firebasestorage.googleapis.com/v0/b/print-2-shop-online.appspot.com/o/product-16.jpg?alt=media&token=0c03123d-c33a-46e0-8ede-98d5078b6a92', '6.1 inch, OLED, Super Retina XDR, 2532 x 1170 Pixels', 18000000,0, 4);
INSERT INTO `product` (`id`, `name`, `image`, `description`, `price`, `is_deleted`, `category_id`) VALUES ('23', 'Sony Camera', 'https://firebasestorage.googleapis.com/v0/b/print-2-shop-online.appspot.com/o/product-17.jpg?alt=media&token=574c4fd8-8e18-428d-a763-5539b849f5b9', '6.1 inch, OLED, Super Retina XDR, 2532 x 1170 Pixels', 19000000,0, 3);
INSERT INTO `product` (`id`, `name`, `image`, `description`, `price`, `is_deleted`, `category_id`) VALUES ('24', 'Gram camera', 'https://firebasestorage.googleapis.com/v0/b/print-2-shop-online.appspot.com/o/product-18.jpg?alt=media&token=788420b9-7b77-41ac-b95a-0185889786c6', '6.1 inch, OLED, Super Retina XDR, 2532 x 1170 Pixels', 21000000,0, 3);
