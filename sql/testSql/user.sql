/*
SQLyog Ultimate - MySQL GUI v8.2 
MySQL - 5.5.27 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `user` (
	`user_id` double ,
	`username` varchar (300),
	`password` varchar (765),
	`name` varchar (300)
); 
insert into `user` (`user_id`, `username`, `password`, `name`) values('1','222','333','123');
