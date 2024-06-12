CREATE DATABASE buoi24;

USE buoi24;

CREATE TABLE role
(
    id          INT NOT NULL AUTO_INCREMENT,
    name        VARCHAR(50),
    description VARCHAR(255),

    PRIMARY KEY (id)
);

CREATE TABLE user
(
    id         INT NOT NULL AUTO_INCREMENT,
    email      VARCHAR(50),
    password   VARCHAR(255),
    first_name VARCHAR(50),
    last_name  VARCHAR(50),
    username   VARCHAR(255),
    phone      VARCHAR(25),
    id_role    INT,

    PRIMARY KEY (id)
);


CREATE TABLE project
(
    id         INT NOT NULL AUTO_INCREMENT,
    name       VARCHAR(255),
    start_date TIMESTAMP,
    end_date   TIMESTAMP,

    PRIMARY KEY (id)
);

CREATE TABLE task
(
    id         INT NOT NULL AUTO_INCREMENT,
    name       VARCHAR(255),
    start_date TIMESTAMP,
    end_date   TIMESTAMP,

    id_user    INT,
    id_project INT,
    id_status  INT,

    PRIMARY KEY (id)
);

CREATE TABLE status
(
    id   INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(20),

    PRIMARY KEY (id)
);

ALTER TABLE user
    ADD CONSTRAINT FK_id_role_users FOREIGN KEY (id_role) REFERENCES role (id);

ALTER TABLE task
    ADD CONSTRAINT FK_id_user_tasks FOREIGN KEY (id_user) REFERENCES user (id),
    ADD CONSTRAINT FK_id_status_tasks FOREIGN KEY (id_status) REFERENCES status (id),
    ADD CONSTRAINT FK_id_project_tasks FOREIGN KEY (id_project) REFERENCES project (id);