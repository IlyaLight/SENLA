

DROP DATABASE users;
CREATE DATABASE users;
use users;

create table user_detail(
	id int not null auto_increment,
	user_name varchar(25) not null,
	email varchar(25),
	primary key(id)
);

create table users_validate(
	id int not null auto_increment,
	login varchar(25) not null,
	pass varchar(25) not null,
	primary key(id),
	foreign key(id) references user_detail(id)
);