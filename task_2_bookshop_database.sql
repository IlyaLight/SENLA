DROP DATABASE bookshop;
CREATE DATABASE bookshop;
use bookshop;

create table books(
	id int not null auto_increment,
	name varchar(100) not null,
	datePublication date,
	dateIssueb date,
	price decimal(15,2),
	inStock int,
	primary key(id)
);

create table requests(
    id int not null auto_increment,
    bookId int not null,
    quantity int not null,
    primary key(id),
    foreign key(bookId) references books(id)
);

create table orders(
    id int not null auto_increment,
    orders_book_list  int not null,
    price decimal(15,2),
    dataCompletion date,
    details varchar(100),
    status varchar(100),
    completed char(1),
    primary key(id)
);

create table orders_book_list(
	id int not null auto_increment,
	orderId int not null,
	bookId int not null,
	primary key(id),
	foreign key(bookId) references books(id),
	foreign key(orderId) references orders(id)
);