use car_parts_shop;

SET NAMES utf8;

insert into person(id, email, status, active)
	values(1, '@gamail.com_1', 'ADMINISTRATOR', TRUE);

insert into login(id, login, pass)
	values(1, 'root_1', 'root_1');

insert into car(id, brand, model, year, type_of_fuel, engine_capacity)
	values(1, 'AUDI','A1 Sportback', 2007, 'petrol', 1.4 );
insert into car(id, brand, model, year, type_of_fuel, engine_capacity)
	values(2, 'AUDI','A1 Sportback', 2004, 'petrol', 1.6 );
insert into car(id, brand, model, year, type_of_fuel, engine_capacity)
	values(3, 'AUDI','A1 Sportback', 2011, 'petrol', 1.6 );
insert into car(id, brand, model, year, type_of_fuel, engine_capacity)
	values(4, 'AUDI','A3 Limousine', 2013, 'petrol', 1.2 );
insert into car(id, brand, model, year, type_of_fuel, engine_capacity)
	values(5, 'AUDI','A3 Limousine', 2013, 'petrol', 1.6 );

