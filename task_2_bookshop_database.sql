DROP DATABASE bookshop;
CREATE DATABASE bookshop;
use bookshop;

create table book(
	id int not null auto_increment,
	name varchar(100) not null,
	date_publication date,
	date_issue date,
	price decimal(15,2),
	inStock int,
	primary key(id)
);

create table request(
    id int not null auto_increment,
    book_id int not null,
    quantity int not null,
    primary key(id),
    foreign key(book_id) references book(id)
);

create table orders(
    id int not null auto_increment,
    price decimal(15,2),
    data_completion date,
    details varchar(100),
    status varchar(100),
    completed char(1),
    primary key(id)
);

create table order_book_list(
	id int not null auto_increment,
	orders_id int not null,
	book_id int not null,
	primary key(id),
	foreign key(book_id) references book(id),
	foreign key(orders_id) references orders(id)
);