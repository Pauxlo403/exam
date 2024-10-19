create database phonebook;

use phonebook;

create table teachers
(
    id         int primary key auto_increment,
    first_name varchar(100)       not null,
    last_name  varchar(100),
    phone      varchar(20) unique not null
);

insert into teachers(first_name, last_name, phone)
values ('Ivan', 'Ivanov', '666');
insert into teachers(first_name, last_name, phone)
values ('Petr', 'Petrov', '777');