/*
SQLyog Ultimate - MySQL GUI v8.2 
MySQL - 5.5.27 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `stock` (
	`stock_id` double ,
	`stock_code` varchar (300),
	`stock_name` varchar (765)
); 
insert into `stock` (`stock_id`, `stock_code`, `stock_name`) values('1','1','123');
