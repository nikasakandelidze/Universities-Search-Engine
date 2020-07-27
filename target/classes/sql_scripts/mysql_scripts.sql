create database if not exists projectK;

use projectK;
set foreign_key_checks = 0;
DROP TABLE IF exists University;
DROP TABLE IF exists University_Subject;
DROP TABLE IF exists Faculty;
DROP TABLE IF exists users;


create table University
(
    id              int primary key not null auto_increment,
    university_name varchar(100)    not null unique,
    city            varchar(100)    not null,
    address         varchar(100)    not null,
    web_page_link   varchar(100),
    descriptions    varchar(255),
    username        varchar(45)     NOT NULL,
    foreign key (username)
        REFERENCES users (username)
);



create table Faculty
(
    faculty_id    integer primary key not null auto_increment,
    category      varchar(100)        not null,
    university_id INT                 NOT NULL,
    name          varchar(255)        not null,
    dean_info     varchar(500)        not null,
    price         INT                 not null,
    description   varchar(1000)       not null,
    web_page_link varchar(100),
    foreign key (university_id)
        references University (id)
);

CREATE TABLE University_Subject
(
    subject_id   INT PRIMARY KEY not null auto_increment,
    faculty_id   INT             NOT NULL,
    subject_name VARCHAR(255)    NOT NULL,
    credits      INT,
    descriptions varchar(1000),
    semester     INT             not null,
    foreign key (faculty_id)
        references Faculty (faculty_id)
);

CREATE TABLE users
(

    username VARCHAR(45) NOT NULL,
    password VARCHAR(45) NOT NULL,
    enabled  TINYINT     NOT NULL DEFAULT 1,
    PRIMARY KEY (username)
);
insert into users
values ('testUser', 'password', 1);
insert into university
values (2, 'TSU', 'Tbilisi', 'Melikishili', 'bla.com', 'good', 'testUser');
insert into faculty
values (1, 'COMPUTERSCIENCE', 2, 'Mathematics and Computer science TSU', 'Shota gv', 10000, 'magaria', 'axala.ge');
insert into university_subject
values (1, 1, 'Calculus I', 6, 'sigua magari kacia', 2);

insert into users
values ('freeuniUser', 'password', 1);
insert into university
values (121, 'freeUni', 'Tbilisi', 'digomi', 'freeuni.edu.ge', 'good', 'freeuniUser');
insert into faculty
values (132, 'BUSINESS', 121, 'ESM', 'KFJWE', 6950, 'magaria', 'axala.ge');
insert into university_subject
values (2, 2, 'OOP', 6, 'LEKVA', 2);

insert into users
values ('agruniUser', 'password', 1);
insert into university
values (122, 'agruni', 'Tbilisi', 'digomi', 'agruni.edu.ge', 'good', 'agruniUser');
insert into faculty
values (1212, 'PSYCHOLOGY', 122, 'MACS', 'KFJWE', 6950, 'magaria', 'axala.ge');
insert into university_subject
values (3, 3, 'OOP', 6, 'LEKVA', 2);

insert into users
values ('georgianUniUser', 'password', 1);
insert into university
values (123, 'georgianUni', 'Tbilisi', 'digomi', 'agruni.edu.ge', 'good', 'georgianUniUser');
insert into faculty
values (1213, 'ENGINEERING', 123, 'MACS', 'KFJWE', 6950, 'magaria', 'axala.ge');
insert into university_subject
values (4, 4, 'OOP', 6, 'arvici', 2);

insert into users
values ('seuUser', 'password', 1);
insert into university
values (124, 'seu', 'Tbilisi', '300 aragveli', 'agruni.edu.ge', 'good', 'seuUser');
insert into faculty
values (1214, 'LAW', 124, 'MACS', 'KFJWE', 6950, 'magaria', 'axala.ge');
insert into university_subject
values (5, 5, 'OOP', 6, 'arvici', 2);

insert into users
values ('medicalUniUser', 'password', 1);
insert into university
values (125, 'medicalUni', 'Tbilisi', '300 aragveli', 'agruni.edu.ge', 'good', 'medicalUniUser');
insert into faculty
values (1215, 'MEDICINE', 125, 'MACS', 'KFJWE', 6950, 'magaria', 'axala.ge');
insert into university_subject
values (6, 6, 'OOP', 6, 'arvici', 2);

insert into users
values ('tsuUser', 'password', 1);
insert into university
values (126, 'TSSU', 'Tbilisi', '300 aragveli', 'agruni.edu.ge', 'good', 'tsuUser');
insert into faculty
values (1216, 'PHILOSOPHY', 126, 'MACS', 'KFJWE', 6950, 'magaria', 'axala.ge');
insert into university_subject
values (7, 7, 'OOP', 6, 'arvici', 2);