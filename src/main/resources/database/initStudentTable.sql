
DROP SEQUENCE IF EXISTS students_id_seq;

CREATE TABLE IF NOT EXISTS students
(
    student_id    INTEGER PRIMARY KEY,
    firstname  VARCHAR(200) NOT NULL,
    patronymic VARCHAR(200) NOT NULL,
    surname VARCHAR(50)  NOT NULL,
    date_of_birth date NOT NULL,
    class_id INTEGER REFERENCES classes(class_id)NOT NULL,
    random INTEGER
);
CREATE SEQUENCE students_id_seq START WITH 1 INCREMENT BY 1;
