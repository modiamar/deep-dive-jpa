create table person
(
	id int not null AUTO_INCREMENT,
	name varchar(255) not null,
	location varchar(255),
	birth_date timestamp,
	primary key(id)
);


insert into person (id, name, location, birth_date) 
	values (10001,'Amar', 'Maryland', sysdate());
insert into person (id, name, location, birth_date) 
	values (10002,'Bob', 'Maryland', sysdate());
insert into person (id, name, location, birth_date) 
	values (10003,'Joe', 'Maryland', sysdate());