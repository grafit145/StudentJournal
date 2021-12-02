DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS classes;
DROP SEQUENCE IF EXISTS classes_id_seq;
CREATE TABLE IF NOT EXISTS classes
(
    class_id   INTEGER PRIMARY KEY,
    class_name VARCHAR(10) UNIQUE NOT NULL
);
CREATE SEQUENCE classes_id_seq START WITH 1 INCREMENT BY 1;

DROP SEQUENCE IF EXISTS students_id_seq;

CREATE TABLE IF NOT EXISTS students
(
    student_id    INTEGER PRIMARY KEY,
    firstname     VARCHAR(200)                                NOT NULL,
    patronymic    VARCHAR(200)                                NOT NULL,
    surname       VARCHAR(50)                                 NOT NULL,
    date_of_birth date                                        NOT NULL,
    class_name    VARCHAR(10) REFERENCES classes (class_name) NOT NULL

);
CREATE SEQUENCE students_id_seq START WITH 1 INCREMENT BY 1;

INSERT INTO classes (class_id, class_name)
VALUES (1, '1a'),
       (2, '1b');

INSERT INTO students (student_id, firstname, patronymic, surname, date_of_birth, class_name)
VALUES (1, 'Иванов', 'Иванович', 'Иванов', '2013-03-12', '1a'),
 (2, 'Петр', 'Иванович', 'Иванов', '2013-03-12', '1a'),
 (3, 'Виктория', 'Алексеевна', 'Петрова', '2013-09-29', '1b'),
 (4, 'Олег', 'Алексеевич', 'Петров', '2014-02-03', '1b');
