CREATE TABLE IF NOT EXISTS students
(
    id        INT          NOT NULL AUTO_INCREMENT,
    full_name VARCHAR(255) NOT NULL,
    gender    CHAR(3),
    age       INT,
    city      VARCHAR(255),
    weight     DECIMAL(15, 4),
    PRIMARY KEY (ID)
    );

INSERT INTO students(full_name, gender, age, city, weight)
VALUES ('Nguyễn Thành Nhân', 'Nam', 19, 'Cần Thơ', 56.5674),
       ('Phạm Thu Hương', 'Nữ', 20, 'Vĩnh Long', 72.456),
       ('Nguyễn Như Ngọc', 'Nữ', 20, 'Sóc Trăng', 85.387),
       ('Bùi Thanh Bảo', 'Nam', 19, 'Sóc Trăng', 49.3),
       ('Lê Mỹ Nhân', 'Nữ', 22, 'Cần Thơ', 62.963),
       ('Tần Thục Bảo', 'Nam', 35, 'An Giang', 55.5678),
       ('Trịnh Bảo Kim', 'Nam', 44, 'Bạc Liêu', 67.34);

SELECT * from students;