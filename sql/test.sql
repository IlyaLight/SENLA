

-- 1
select model, speed, hd 
from pc 
where price<500;

-- 2
select distinct maker 
from product 
where type='Printer';

-- 3
select model, ram, screen 
from laptop 
where price>1000;

-- 4
select * 
from printer 
where color='Y';

-- 5
select model from pc 
where cd='12x' or cd='24x';

-- 6
select maker, speed 
from pc 
left join product 
using(model) 
where hd>10;

-- 7
select model, price from pc 
left join product using(model)
where maker = 'A'
union
select model, price from laptop  
left join product using(model)
where maker = 'A'
union
select model, price from printer 
left join product using(model)
where maker = 'A';

-- 8
select a.maker 
from (select distinct maker from product where type='PC') as a
where a.maker 
not in (select distinct maker from product where type='Laptop');

-- 9
select maker 
from pc, product 
where speed > 450 and pc.model = product.model;

-- 10
select model, price
from printer
order by price desc;

-- 11
select avg(speed)
from pc;

-- 12
select avg(speed)
from ( select*from laptop where price > 1000)as t;

-- 13
select avg(speed)
from pc, product
where maker = 'A' and product.model = pc.model;

