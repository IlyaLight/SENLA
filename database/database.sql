
DROP DATABASE car_parts_shop;
CREATE DATABASE car_parts_shop;
use car_parts_shop;

create table person(
	id int not null auto_increment,
	name varchar(25) not null,
	email varchar(25) not null,
	status varchar(25) not null,
	primary key(id)
);

create table login(
	id int not null auto_increment,
	login varchar(25) not null,
	pass varchar(25) not null,
	primary key(id),
	foreign key(id) references person(id)
);

create table car(
	id int not null auto_increment,
	brand varchar(25) not null,
	model varchar(25) not null,
	year int not null,
	type_of_fuel varchar(25) not null,
	engine_capacity int not null,
	primary key(id)
);

create table car_parson(
	car_id int not null,
	person_id int not null,
	PRIMARY KEY(car_id, person_id),
	foreign key(car_id) references car(id),
	foreign key(person_id) references person(id)
);


create table goods(
	id int not null auto_increment,
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
	car_id int not null,
	goods_id int not null,
	PRIMARY KEY(car_id, goods_id),
	foreign key(car_id) references car(id),
	foreign key(goods_id) references goods(id)

);

create table addres(
	id int not null auto_increment,
	city varchar(25) not null,
	addres varchar(25) not null,
	postCode int not null,
	person_id int not null,
	primary key(id),
	foreign key(person_id) references person(id)
);

create table _order_(
	id int not null auto_increment,
	price decimal(10,2),
	person_id int not null,
	addres_id int not null,
	orderDate date not null,
	orderDetails varchar(225),
	status varchar(25),
	primary key(id),
	foreign key(person_id) references person(id),
	foreign key(addres_id) references addres(id)
);

create table ordered_goods(
	copy_id int not null,
	img_link varchar(25),
	name varchar(25) not null,
	category varchar(25),
	description varchar(225),
	characteristics varchar(225),
	price DECIMAL(10,2),
	order_id int not null,
	quantity int not null,
	primary key(order_id, copy_id),
	foreign key(order_id) references _order_(id)
);

create table cart(
	person_id int not null,
	goods_id int not null,
	quantity int not null,
	primary key(person_id),
	foreign key(person_id) references person(id),
	foreign key(goods_id) references goods(id)
);