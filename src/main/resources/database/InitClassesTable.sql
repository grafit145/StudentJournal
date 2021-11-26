DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS classes;
DROP SEQUENCE IF EXISTS classes_id_seq;
CREATE TABLE IF NOT EXISTS classes
(
    class_id INTEGER PRIMARY KEY,
    class_name VARCHAR(10) UNIQUE NOT NULL
);
CREATE SEQUENCE classes_id_seq START WITH 1 INCREMENT BY 1;

DROP SEQUENCE IF EXISTS students_id_seq;

CREATE TABLE IF NOT EXISTS students
(
    student_id    INTEGER PRIMARY KEY,
    firstname  VARCHAR(200) NOT NULL,
    patronymic VARCHAR(200) NOT NULL,
    surname VARCHAR(50)  NOT NULL,
    date_of_birth date NOT NULL,
    class_name VARCHAR(10) REFERENCES classes(class_name)NOT NULL

);
CREATE SEQUENCE students_id_seq START WITH 1 INCREMENT BY 1;
