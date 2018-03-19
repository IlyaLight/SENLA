
DROP DATABASE car_parts_shop;
CREATE DATABASE car_parts_shop;
use car_parts_shop;

create table person(
	id BIGINT  not null auto_increment,
	email varchar(25) not null,
	status ENUM('ADMINISTRATOR', 'BUYER'),
	active BOOL not null,
	primary key(id)
);

create table login(
	id BIGINT  not null auto_increment,
	login varchar(25) not null,
	pass varchar(25) not null,
	UNIQUE(login),
	primary key(id),
	foreign key(id) references person(id)
);

create table car(
	id BIGINT  not null auto_increment,
	brand varchar(25) not null,
	model varchar(25) not null,
	year int not null,
	type_of_fuel varchar(25) not null,
	engine_capacity FLOAT(5.2) ,
	primary key(id)
);

create table car_parson(
	car_id BIGINT  not null,
	person_id BIGINT  not null,
	PRIMARY KEY(car_id, person_id),
	foreign key(car_id) references car(id),
	foreign key(person_id) references person(id)
);


create table goods(
	id BIGINT  not null auto_increment,
	img_link varchar(25),
	category varchar(25),
	name varchar(25) not null,
	description varchar(225),
	characteristics varchar(225),
	price DECIMAL(10,2),
	in_stock int,
	primary key(id)
);

create table car_goods(
	car_id BIGINT  not null,
	goods_id BIGINT  not null,
	PRIMARY KEY(car_id, goods_id),
	foreign key(car_id) references car(id),
	foreign key(goods_id) references goods(id)

);

create table address(
	id BIGINT  not null auto_increment,
	person_id BIGINT not null,
	city varchar(25) not null,
	address varchar(25) not null,
	postCode int not null,
	primary key(id),
	foreign key(person_id) references person(id)
);

create table _order_(
	id BIGINT not null auto_increment,
	price decimal(10,2),
	person_id BIGINT not null,
	address_id BIGINT not null,
	orderDate date not null,
	orderDetails varchar(225),
	status ENUM('processing', 'shipped', 'delivered', 'canceled'),
	primary key(id),
	foreign key(person_id) references person(id),
	foreign key(address_id) references address(id)
);

create table ordered_goods(
	id BIGINT  not null auto_increment,
	copy_id BIGINT  not null,
	order_id BIGINT  not null,
	img_link varchar(25),
	name varchar(25) not null,
	category varchar(25),
	description varchar(225),
	characteristics varchar(225),
	price DECIMAL(10,2),
	quantity int not null,
	primary key(id),
	foreign key(order_id) references _order_(id),
	foreign key(copy_id) references goods(id)
);

create table cart(
	person_id BIGINT not null,
	goods_id BIGINT not null,
	quantity int not null,
	primary key(person_id),
	foreign key(person_id) references person(id),
	foreign key(goods_id) references goods(id)
);