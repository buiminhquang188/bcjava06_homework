CREATE DATABASE crmapp;
USE crmapp;

CREATE TABLE roles
(
    id          INT AUTO_INCREMENT,
    name        VARCHAR(50),
    description VARCHAR(50),

    PRIMARY KEY (id)
);

CREATE TABLE users
(
    id         INT AUTO_INCREMENT,
    password   VARCHAR(255),
    first_name VARCHAR(50),
    last_name  VARCHAR(50),
    username   VARCHAR(255),
    phone      VARCHAR(12),
    id_role    INT,

    PRIMARY KEY (id)
);

CREATE TABLE task
(
    id         INT AUTO_INCREMENT,
    id_user    INT,
    id_project INT,
    id_status  INT,
    name       VARCHAR(255),
    start_date TIMESTAMP DEFAULT NOW(),
    end_date   TIMESTAMP NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE project
(
    id         INT AUTO_INCREMENT,
    name       VARCHAR(255),
    start_date TIMESTAMP DEFAULT NOW(),
    end_date   TIMESTAMP NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE status
(
    id   INT AUTO_INCREMENT,
    name VARCHAR(10),

    PRIMARY KEY (id)
);

ALTER TABLE users
    ADD CONSTRAINT FK_id_role_users FOREIGN KEY (id_role) REFERENCES roles (id);
ALTER TABLE task
    ADD CONSTRAINT FK_id_user_task FOREIGN KEY (id_user) REFERENCES users (id);
ALTER TABLE task
    ADD CONSTRAINT FK_id_project_task FOREIGN KEY (id_project) REFERENCES project (id);
ALTER TABLE task
    ADD CONSTRAINT FK_id_status_task FOREIGN KEY (id_status) REFERENCES status (id);