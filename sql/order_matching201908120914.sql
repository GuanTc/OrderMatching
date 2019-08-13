/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/8/12 9:14:55                            */
/*==============================================================*/


drop table if exists buy_order_book;

drop table if exists orders;

drop table if exists price;

drop table if exists sell_order_book;

drop table if exists stock;

drop table if exists trade;

drop table if exists user;

/*==============================================================*/
/* Table: buy_order_book                                        */
/*==============================================================*/
create table buy_order_book
(
   bob_id               bigint(20) not null auto_increment,
   stock_id             bigint(20),
   order_id             bigint(20),
   buy_size             int not null,
   buy_price            float not null,
   primary key (bob_id)
);

/*==============================================================*/
/* Table: orders                                                */
/*==============================================================*/
create table orders
(
   order_id             bigint(20) not null auto_increment,
   user_id              bigint not null,
   stock_id             bigint(20) not null,
   type                 varchar(10) not null,
   price                float,
   qty                  int not null,
   remain_qty           int not null,
   order_type           varchar(50) not null,
   market_price         float,
   limit_price          float,
   trigger_price        float,
   stop_price           float,
   full_or_kill         int not null,
   duration             varchar(50) not null,
   gtd_date             date,
   minute               int,
   submit_date          date not null,
   status               int not null,
   send_out_date        date,
   final_date           date,
   primary key (order_id)
);

/*==============================================================*/
/* Table: price                                                 */
/*==============================================================*/
create table price
(
   price_id             bigint(20) not null auto_increment,
   stock_id             bigint(20),
   buy_current_price    float not null,
   sell_current_price   float not null,
   price_current_date   date not null,
   primary key (price_id)
);

/*==============================================================*/
/* Table: sell_order_book                                       */
/*==============================================================*/
create table sell_order_book
(
   sob_id               bigint(20) not null auto_increment,
   stock_id             bigint(20),
   order_id             bigint(20),
   ask_size             int not null,
   ask_price            float,
   primary key (sob_id)
);

/*==============================================================*/
/* Table: stock                                                 */
/*==============================================================*/
create table stock
(
   stock_id             bigint(20) not null auto_increment,
   stock_code           varchar(100) not null,
   stock_name           varchar(255) not null,
   primary key (stock_id)
);

/*==============================================================*/
/* Table: trade                                                 */
/*==============================================================*/
create table trade
(
   trade_id             bigint(20) not null auto_increment,
   user_id              bigint,
   stock_id             bigint(20),
   buy_order_id         bigint(20),
   sell_order_id        bigint(20),
   price                float not null,
   qty                  int not null,
   trade_date           date,
   primary key (trade_id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   user_id              bigint not null auto_increment,
   username             varchar(100) not null,
   password             varchar(255) not null,
   name                 varchar(100) not null,
   primary key (user_id)
);

alter table buy_order_book add constraint FK_Reference_11 foreign key (order_id)
      references orders (order_id) on delete restrict on update restrict;

alter table buy_order_book add constraint FK_Reference_9 foreign key (stock_id)
      references stock (stock_id) on delete restrict on update restrict;

alter table orders add constraint FK_Reference_1 foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

alter table orders add constraint FK_Reference_2 foreign key (stock_id)
      references stock (stock_id) on delete restrict on update restrict;

alter table price add constraint FK_Reference_7 foreign key (stock_id)
      references stock (stock_id) on delete restrict on update restrict;

alter table sell_order_book add constraint FK_Reference_10 foreign key (order_id)
      references orders (order_id) on delete restrict on update restrict;

alter table sell_order_book add constraint FK_Reference_8 foreign key (stock_id)
      references stock (stock_id) on delete restrict on update restrict;

alter table trade add constraint FK_Reference_3 foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

alter table trade add constraint FK_Reference_4 foreign key (stock_id)
      references stock (stock_id) on delete restrict on update restrict;

alter table trade add constraint FK_Reference_5 foreign key (buy_order_id)
      references orders (order_id) on delete restrict on update restrict;

alter table trade add constraint FK_Reference_6 foreign key (sell_order_id)
      references orders (order_id) on delete restrict on update restrict;

