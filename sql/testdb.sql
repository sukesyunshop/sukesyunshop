drop database if exists testdb;
create database testdb;
use testdb;
create table test_table(
userId int,
password varchar (255),
familyName varchar(255),
firstName varchar(255),
familyNameKana varchar(255),
firstNameKana varchar(255),
sex varchar(255),
email varchar (255)
);

insert into test_table values("taro","123","山田","太郎","やまだ","たろう","男","aassddss@sss.co.jp");
insert into test_table values("kensuke","456","鈴木","健介","すずき","けんすけ","男","dkdkdkdjs@kkk.co.jp");
insert into test_table values("sakura","789","小島","桜","こじま","さくら","女","saksaku@sks.co.jp");
