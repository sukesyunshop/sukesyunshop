DROP database if EXISTS sukesyunshopdb;

CREATE database sukesyunshopdb;

use sukesyunshopdb;

CREATE TABLE user_info(
id int not null primary key auto_increment,
user_id varchar(16) unique not null,
password varchar(16) not null,
family_name varchar(32) not null,
first_name varchar(32) not null,
family_name_kana varchar(32) not null,
first_name_kana varchar(32) not null,
sex tinyint(1) not null,
email varchar(32) not null,
status tinyint(1) default 1 not null,
logined tinyint(1) default 0 not null,
insert_date datetime default NOW() not null,
update_date datetime
)
comment='会員情報テーブル';

CREATE TABLE m_category(
id int not null primary key auto_increment,
category_id int unique not null,
category_name varchar(20) unique not null,
category_description varchar(100) not null,
insert_date datetime default NOW() not null,
update_date datetime
)
comment='カテゴリマスタテーブル';

CREATE TABLE product_info(
id int not null primary key auto_increment,
product_id int unique not null,
product_name varchar(100) unique not null,
product_name_kana varchar(100) unique not null,
product_description varchar(255) not null,
category_id int not null,
price int,
image_file_path varchar(100),
image_file_name varchar(50),
release_date datetime not null,
release_company varchar(50),
status tinyint(1) default 1 not null,
insert_date datetime default NOW() not null,
update_date datetime,
foreign key(category_id) references m_category(category_id)
ON UPDATE CASCADE ON DELETE CASCADE
)
comment='商品情報テーブル';

CREATE TABLE cart_info(
id int not null primary key auto_increment,
user_id varchar(16),
temp_user_id varchar(128),
product_id int not null,
insert_date datetime default NOW() not null,
update_date datetime,
foreign key(user_id) references user_info(user_id)
ON UPDATE CASCADE ON DELETE CASCADE,
foreign key(product_id) references product_info(product_id)
ON UPDATE CASCADE ON DELETE CASCADE
)
comment='カート情報テーブル';

CREATE TABLE purchase_history_info(
id int not null primary key auto_increment,
user_id varchar(16) not null,
product_id int not null,
insert_date datetime default NOW() not null,
update_date datetime,
foreign key(user_id) references user_info(user_id)
ON UPDATE CASCADE ON DELETE CASCADE,
foreign key(product_id) references product_info(product_id)
ON UPDATE CASCADE ON DELETE CASCADE
)
comment='購入履歴情報テーブル';

CREATE TABLE destination_info(
id int not null primary key auto_increment,
user_id varchar(16) not null,
family_name varchar(32) not null,
first_name varchar(32) not null,
family_name_kana varchar(32) not null,
first_name_kana varchar(32) not null,
sex tinyint(1) not null,
email varchar(32) not null,
tel_number varchar(13) not null,
user_address varchar(50) not null,
insert_date datetime default NOW() not null,
update_date datetime,
foreign key(user_id) references user_info(user_id)
ON UPDATE CASCADE ON DELETE CASCADE
)
comment='宛先情報テーブル';
