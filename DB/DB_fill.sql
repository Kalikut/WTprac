use internet_shop;

insert into author values (1, 'A. Strugatsky');
insert into author values (2, 'B. Strugatsky');
insert into author values (3, 'L.N. Tolstoy');

insert into genre values (1, 'Fantastic novel');
insert into genre values (2 ,'Science fiction novel');
insert into genre values (3, 'Romance epic');

insert into cover values (1, 'Soft');
insert into cover values (2, 'Hard');

insert into book values (1, 'Its hard to be a god', 1, 'Publishing house AST', 2016, 256, 31, 250, 1);
insert into book values (2, 'Roadside Picnic', 1, 'Publishing house AST', 2016, 318, 33, 300, 1);
insert into book values (3, 'Guy from the Underworld', 1, 'Publishing house AST', 2016, 198, 41, 200, 1);
insert into book values (4, 'Snail on the slope', 2, 'Publishing house AST', 2016, 320, 37, 300, 1);
insert into book values (5, 'War and Peace.', 3, 'SPB Alphabet', 2013, 1504, 17, 700, 2);

insert into book_author values (1, 1);
insert into book_author values (1, 2);
insert into book_author values (1, 3);
insert into book_author values (1, 4);
insert into book_author values (2, 1);
insert into book_author values (2, 2);
insert into book_author values (2, 3);
insert into book_author values (2, 4);
insert into book_author values (3, 5);

insert into client values (1, 'Ulyan', 'Matveyevich', 'Kondratev', '460505, Yuryev-Polsky, ul. Vagonnikov 3-d, house 13, apartment 117', '+79491251365', 'KondratevUlyan228@gmail.com', '5s48UB3wuXQy');
insert into client values (2, 'Galya', 'Semyonovna', 'Liutova', '171366, city of Bondari, ul. Gvardeiskaya, house 57, apartment 150', '+79601854913', 'LyutovaGalya247@mail.ru', 'zL6lnLi3SBgY');

insert into admin values (1, 'NedashkovskayaDomna264', 'WEgRQ38Bt0Qm');

insert into statuses values (1, 'Waiting for confirmation.');
insert into statuses values (2, 'Formation of the order.');
insert into statuses values (3, 'Transferred to the delivery service.');
insert into statuses values (4, 'Delivered.');

insert into orders values (1, 1, '20170127', '20170204', '460505, Yuryev-Polsky, ul. Vagonnikov 3-d, house 13, apartment 117', 300, 4, 450);
insert into orders values (2, 1, '20170130', '20170212', '460505, Yuryev-Polsky, ul. Vagonnikov 3-d, house 13, apartment 117', 300, 2, 700);
insert into orders values (3, 2, '20170124', '20170205', '171366, city of Bondari, ul. Gvardeiskaya, house 57, apartment 150', 300, 3, 600);

insert into orders_journal values (1, 1, 1, 1);
insert into orders_journal values (2, 1, 3, 1);
insert into orders_journal values (3, 2, 5, 1);
insert into orders_journal values (4, 3, 2, 1);
insert into orders_journal values (5, 3, 4, 1);