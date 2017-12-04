

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

-- 6 Укажите производителя и скорость для тех лаптопов, которые 
-- имеют hd объемом не менее 10
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

-- 12 найти среднюю скорость лаптопов, цена которох выще 1000
select avg(speed)
from ( select*from laptop where price > 1000)as t;

-- 13 найти среднюю скорость ПК, выпущенных производителем А
select avg(speed)
 from pc, product
where maker = 'A' and product.model = pc.model;

-- 14 для каждого значения скорости найти среднюю стоимость
select avg(price)
from pc
group by speed;

-- 15 найдите размеры жеских дисков, совподающих у двух и более PC. Вывести hd
select hd, count(*)
 from pc
group by hd
HAVING count(*) > 1
ORDER BY count(*);

-- 16 найти пары моделей pc, имеющих одинаковые скорость и ram, В результате каждую 
-- пару указывается только один раз, т.е. (i,j), но не (j,i). Порядок вывода: модель 
-- с большим номера, модель с меньшим номером, скорость и ram
