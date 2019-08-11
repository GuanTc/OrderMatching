/*
SQLyog Ultimate - MySQL GUI v8.2 
MySQL - 5.5.27 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `orders` (
	`order_id` double ,
	`user_id` double ,
	`stock_id` double ,
	`type` varchar (30),
	`price` float ,
	`qty` double ,
	`order_type` varchar (150),
	`submit_date` date 
); 
insert into `orders` (`order_id`, `user_id`, `stock_id`, `type`, `price`, `qty`, `order_type`, `submit_date`) values('2','1','1','11','123','123','xxx','2018-09-07');
insert into `orders` (`order_id`, `user_id`, `stock_id`, `type`, `price`, `qty`, `order_type`, `submit_date`) values('3','1','1','213','12','1234','xxx','2018-09-07');
insert into `orders` (`order_id`, `user_id`, `stock_id`, `type`, `price`, `qty`, `order_type`, `submit_date`) values('4','1','1','432','123','421','223sa','2016-09-07');
