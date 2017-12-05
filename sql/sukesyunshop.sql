DROP database if EXISTS sukesyunshopdb;

CREATE database sukesyunshopdb;

use sukesyunshopdb;

CREATE TABLE user_info(
id int not null primary key auto_increment,
user_id varchar(16) unique,
password varchar(16),
family_name varchar(16),
first_name varchar(16),
famiry_name_kana varchar(16),
first_name_kana varchar(16),
sex tinyint(1) default 0,
email varchar(32),
status tinyint(1) default 1,
logined tinyint(1) default 0,
insert_date datetime,
update_date datetime
);

CREATE TABLE m_category(
id int not null primary key auto_increment,
category_id int unique,
category_name varchar(20)unique,
category_description varchar(100),
insert_date datetime,
update_date datetime
);

CREATE TABLE product_info(
id int primary key auto_increment,
product_id int unique,
product_name varchar(100) unique,
product_name_kana varchar(100) unique,
product_description varchar(255),
category_id int,
price int,
image_file_path varchar(100),
image_file_name varchar(50),
release_date datetime,
relrease_company varchar(50),
status tinyint(1) default 1,
insert_date datetime,
update_date datetime,
foreign key(category_id) references m_category(category_id)
ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE cart_info(
id int primary key auto_increment,
user_id varchar(128),
product_id int,
insert_date datetime,
update_date datetime,
foreign key(user_id) references user_info(user_id)
ON UPDATE CASCADE ON DELETE CASCADE,
foreign key(product_id) references product_info(product_id)
ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE purchase_history_info(
id int primary key auto_increment,
user_id varchar(16),
product_id int,
insert_date datetime,
update_date datetime,
foreign key(user_id) references user_info(user_id)
ON UPDATE CASCADE ON DELETE CASCADE,
foreign key(product_id) references product_info(product_id)
ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE destination_info(
id int primary key auto_increment,
user_id varchar(16) unique,
family_name varchar(16),
first_name varchar(16),
family_name_kana varchar(16),
first_name_kana varchar(16),
email varchar(32),
tel_number varchar(13),
user_address varchar(50),
insert_date datetime,
update_date datetime,
foreign key(user_id) references user_info(user_id)
ON UPDATE CASCADE ON DELETE CASCADE
);