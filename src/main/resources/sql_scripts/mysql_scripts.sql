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

INSERT INTO projectk.users (username, password, enabled) VALUES ('admin1', 'd033e22ae348aeb5660fc2140aec35850c4da997', 0);
INSERT INTO projectk.users (username, password, enabled) VALUES ('admin2', 'd033e22ae348aeb5660fc2140aec35850c4da997', 0);

INSERT INTO projectk.university (id, university_name, city, address, web_page_link, descriptions, username) VALUES (2, 'TSU', 'Tbilisi', 'Melikishili Ave 1', 'tsu.edu.ge', 'TSU the third the Middle', 'admin1');
INSERT INTO projectk.university (id, university_name, city, address, web_page_link, descriptions, username) VALUES (121, 'Free University Tbilisi', 'Tbilisi', 'Digomi ave 242', 'freeuni.edu.ge', 'Best of both worlds', 'admin2');

INSERT INTO projectk.faculty (faculty_id, category, university_id, name, dean_info, price, description, web_page_link) VALUES (1, 'COMPUTERSCIENCE', 2, 'Mathematics and Computer science TSU', 'Giorgi abramishcili', 10000, 'description1', 'tsu.edu.ge');
INSERT INTO projectk.faculty (faculty_id, category, university_id, name, dean_info, price, description, web_page_link) VALUES (132, 'BUSINESS', 2, 'Economy and Financies TSU', 'John Bond', 6950, 'description2', 'tsu.edu.ge');
INSERT INTO projectk.faculty (faculty_id, category, university_id, name, dean_info, price, description, web_page_link) VALUES (1322, 'MEDICINE', 2, 'Medical Health TSU', 'Gregory House', 5000, 'description3', 'tsu.edu.ge');
INSERT INTO projectk.faculty (faculty_id, category, university_id, name, dean_info, price, description, web_page_link) VALUES (1323, 'BUSINESS', 121, 'Business Administration, Financies', 'Mirian Metreveli', 6000, 'description1', null);
INSERT INTO projectk.faculty (faculty_id, category, university_id, name, dean_info, price, description, web_page_link) VALUES (1324, 'BUSINESS', 121, 'Business Administration, Marketing', 'Mirian Metreveli', 6000, 'description2', null);
INSERT INTO projectk.faculty (faculty_id, category, university_id, name, dean_info, price, description, web_page_link) VALUES (1325, 'COMPUTERSCIENCE', 121, 'MACS, Software Engineering', 'Uncle Bob', 7500, 'description3', null);

INSERT INTO projectk.university_subject (subject_id, faculty_id, subject_name, credits, descriptions, semester) VALUES (1, 1, 'Calculus I', 6, 'During this course students will...', 2);
INSERT INTO projectk.university_subject (subject_id, faculty_id, subject_name, credits, descriptions, semester) VALUES (22, 1, 'Programming I', 4, 'During this course students will...', 1);
INSERT INTO projectk.university_subject (subject_id, faculty_id, subject_name, credits, descriptions, semester) VALUES (2222, 1, 'Physics II', 6, 'During this course students will...', 2);
INSERT INTO projectk.university_subject (subject_id, faculty_id, subject_name, credits, descriptions, semester) VALUES (2223, 132, 'Macro Economy I', 4, 'During this course students will...', 1);
INSERT INTO projectk.university_subject (subject_id, faculty_id, subject_name, credits, descriptions, semester) VALUES (2224, 132, 'Business in action I', 6, 'During this course students will...', 1);
INSERT INTO projectk.university_subject (subject_id, faculty_id, subject_name, credits, descriptions, semester) VALUES (2225, 132, 'Business Calculus', 6, 'During this course students will...', 1);
INSERT INTO projectk.university_subject (subject_id, faculty_id, subject_name, credits, descriptions, semester) VALUES (2226, 1322, 'Introduction to Anathomy', 12, 'During this course students will...', 1);
INSERT INTO projectk.university_subject (subject_id, faculty_id, subject_name, credits, descriptions, semester) VALUES (2227, 1322, 'Biology I', 6, 'During this course students will...', 1);
INSERT INTO projectk.university_subject (subject_id, faculty_id, subject_name, credits, descriptions, semester) VALUES (2228, 1322, 'Physiology II', 6, 'During this course students will...', 2);
INSERT INTO projectk.university_subject (subject_id, faculty_id, subject_name, credits, descriptions, semester) VALUES (2229, 1325, 'Calculus I', 6, 'During this course students will...', 2);
INSERT INTO projectk.university_subject (subject_id, faculty_id, subject_name, credits, descriptions, semester) VALUES (2230, 1325, 'Programming Methodology', 4, 'During this course students will...', 1);
INSERT INTO projectk.university_subject (subject_id, faculty_id, subject_name, credits, descriptions, semester) VALUES (2231, 1325, 'Discrete Mathematics', 6, 'During this course students will...', 2);
INSERT INTO projectk.university_subject (subject_id, faculty_id, subject_name, credits, descriptions, semester) VALUES (2232, 1324, 'Marketing I', 4, 'During this course students will...', 1);
INSERT INTO projectk.university_subject (subject_id, faculty_id, subject_name, credits, descriptions, semester) VALUES (2233, 1324, 'Business in action I', 6, 'During this course students will...', 1);
INSERT INTO projectk.university_subject (subject_id, faculty_id, subject_name, credits, descriptions, semester) VALUES (2234, 1324, 'Sales II', 6, 'During this course students will...', 2);
INSERT INTO projectk.university_subject (subject_id, faculty_id, subject_name, credits, descriptions, semester) VALUES (2239, 1323, 'Macro Economy I', 4, 'During this course students will...', 1);
INSERT INTO projectk.university_subject (subject_id, faculty_id, subject_name, credits, descriptions, semester) VALUES (2240, 1323, 'Business in action I', 6, 'During this course students will...', 1);
INSERT INTO projectk.university_subject (subject_id, faculty_id, subject_name, credits, descriptions, semester) VALUES (2241, 1323, 'Business Calculus', 6, 'During this course students will...', 1);