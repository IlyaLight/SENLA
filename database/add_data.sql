use bookshop;

SET NAMES utf8;

insert into book (id, name, date_publication, date_issue, description, price, in_stock) 
	values(2, 'Машина времени', '1888.1.1', '2017.04.01', 
		'Роман Герберта Уэллса, его первое крупное научно-фантастическое произведение. Переработана из рассказа 1888 года «Аргонавты времени» и издана в 1895 году. «Машина времени» ввела в фантастику идею путешествия во времени и используемой для этого машины времени, которые 		использовались позднее множеством писателей и создали направление хронофантастики. Более того, как отмечал Ю. И. Кагарлицкий, как в научном, так и в общемировоззренческом отношении Уэллс «…в известном смысле предвосхитил Эйнштейна», сформулировавшего специальную теорию относительности спустя десять лет после выхода романа',
		32.5, 4);

insert into book (id, name, date_publication, date_issue, description, price, in_stock) 
	values(3, 'Чужак в чужой стране', '1962.1.1', '2017.08.01', 
		'Фантастический философский роман Роберта Хайнлайна, в 1962 году удостоенный премии «Хьюго». На Западе имеет «культовый» статус, считаясь самым известным из фантастических романов, когда-либо написанных. Одно из немногих фантастических произведений, включённых Библиотекой Конгресса в список книг, сформировавших Америку.',
		40.5, 7);

insert into book (id, name, date_publication, date_issue, description, price, in_stock) 
	values(4, 'Дюна ', '1965.1.1', '2017.07.01', 
		'Первый роман Фрэнка Герберта из саги «Хроники Дюны» о песчаной планете Арракис. Именно эта книга сделала его известным. «Дюна» была удостоена премий Хьюго и Небьюла. «Дюна» — один из самых известных научно-фантастических романов XX века.',
		50.5, 7);  

insert into book (id, name, date_publication, date_issue, description, price, in_stock) 
	values(5, 'Нейромант', '1984.1.1', '2017.08.31', 
		'Роман Уильяма Гибсона, каноническое произведение в жанре «киберпанк», удостоенное премий «Небьюла» (1984), «Хьюго» (1985) и Приза Филипа Дика. Это первый роман Гибсона, открывающий трилогию «Киберпространство». Опубликован в 1984 году.',
		39.15, 2);  


insert into book (id, name, date_publication, date_issue, description, price, in_stock) 
	values(6, 'Мечтают ли андроиды об электроовцах?', '1968.1.1', '2017.08.21', 
		'Научно-фантастический роман Филипа Дика, написанный в 1968 году. Рассказывает историю «охотника за головами» Рика Декарда, который преследует андроидов — существ, почти неотличимых от человека, объявленных вне закона на Земле. Действие происходит в отравленном радиацией и частично заброшенном Сан-Франциско будущего.',
		40.5, 7);  

insert into book (id, name, date_publication, date_issue, description, price, in_stock) 
	values(7, 'Врата', '1977.1.1', '2017.12.21', 
		'Научно-фантастический роман американского писателя Фредерика Пола, изданный в 1977 году и получивший все три главные американские премии жанра — «Небьюлу» (1977), «Хьюго» (1978) и Локус (1978). Роман открывает цикл «Хичи».',
		41.51, 14);



insert into request (id, book_id, quantity)
	values(1, 2, 3);

insert into request (id, book_id, quantity)
	values(2, 4, 2);

insert into request (id, book_id, quantity)
	values(3, 5, 2);



insert into orders (id, price, data_completion, details, status, completed)
	values(1, 999.9, '2018.02.21', 'подарочная упаковка', 'PROCESSED', FALSE );

insert into orders (id, price, data_completion, details, status, completed)
	values(2, 999.9, '2018.02.21', 'подтвердить заказ перед отправкой', 'PROCESSED', FALSE );

insert into orders (id, price, data_completion, details, status, completed)
	values(3, 999.9, '2018.02.21', 'хорошо упаковать', 'PROCESSED', FALSE );

insert into orders (id, price, data_completion, details, status, completed)
	values(4, 999.9, '2018.02.21', 'срочный', 'PROCESSED', FALSE );

insert into orders (id, price, data_completion, details, status, completed)
	values(5, 999.9, '2018.02.21', 'разбить на 2 посылки', 'PROCESSED', FALSE );

insert into orders (id, price, data_completion, details, status, completed)
	values(6, 999.9, '2018.02.21', 'нарисовать пингвина в цилиндре', 'PROCESSED', FALSE );



insert into order_book_list (id, book_id, orders_id )
	values(1, 2, 1);

insert into order_book_list (id, book_id, orders_id )
	values(2, 3, 1);

insert into order_book_list (id, book_id, orders_id )
	values(3, 6, 1);

insert into order_book_list (id, book_id, orders_id )
	values(5, 2, 2);

insert into order_book_list (id, book_id, orders_id )
	values(6, 2, 3);

insert into order_book_list (id, book_id, orders_id )
	values(7, 4, 4);

insert into order_book_list (id, book_id, orders_id )
	values(8, 5, 5);

insert into order_book_list (id, book_id, orders_id )
	values(9, 2, 6);
