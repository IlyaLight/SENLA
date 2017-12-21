DROP DATABASE Senla;

CREATE DATABASE Senla;
use Senla;

create table product(
maker varchar(10) not null,
model varchar(50) not null unique,
type varcharacter(50) not null,
primary key(model)
);

create table laptop(
code int not null auto_increment,
model varchar(50) not null unique,
speed smallint not null,
ram smallint not null,
hd real not null,
price decimal(15,2),
screen tinyint not null,
primary key(code),
foreign key(model) references product(model)
);

create table pc(
code int auto_increment,
model varchar(50) not null unique,
speed smallint not null,
ram smallint not null,
hd real not null,
cd varchar(10) not null,
price decimal(15,2),
primary key(code),
foreign key(model) references product(model)
);

create table printer(
code int auto_increment,
model varchar(50) not null unique,
color char(1) not null,
type varchar(10) not null,
price decimal(15,2),
primary key(code),
foreign key(model) references product(model)
);

insert product (maker, model, type) 
values
('A', 1, 'PC'),
('A', 2, 'Laptop'),
('A', 3, 'Printer'),
('C', 5, 'Laptop'),
('C', 6, 'Printer'),
('A', 7, 'PC'),
('A', 8, 'Laptop'),
('A', 9, 'Printer'),
('B', 10, 'Laptop'),
('B', 11, 'Laptop'),
('B', 12, 'Laptop');

insert laptop(model, speed, ram, hd, price, screen) 
value
(2, 4000, 8000, 500, 500.3, 13),
(5, 4000, 8000, 1000, 1400.3, 13),
(8, 4000, 8000, 250, 1300.3, 13),
(10, 5000, 8000, 250, 1300.3, 13),
(11, 5000, 8000, 250, 1300.3, 13),
(12, 4000, 8000, 250, 900.3, 13);

insert pc(model, speed, ram, hd, cd, price) 
value
(1, 4000, 8000, 500, '4x', 500.3),
(7, 300, 8000, 250, '12x', 300.3);


insert printer(model, color, type, price) 
value
(3, 'Y', 'Lser', 100),
(6, 'M', 'Jet', 101),
(9, 'Y', 'Matrix', 102);