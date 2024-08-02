CREATE TABLE IF NOT EXISTS product
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    name          VARCHAR(255)          NULL,
    `description` VARCHAR(255)          NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

-- auto-generated definition
CREATE TABLE IF NOT EXISTS department
(
    id          BIGINT AUTO_INCREMENT
        PRIMARY KEY,
    name        VARCHAR(255) NULL,
    description VARCHAR(255) NULL
);



CREATE TABLE IF NOT EXISTS employee
(
    id            BIGINT AUTO_INCREMENT
        PRIMARY KEY,
    name          VARCHAR(255) NULL,
    phone_number  VARCHAR(255) NULL,
    department_id BIGINT       NULL,
    CONSTRAINT FK_EMPLOYEE_ON_DEPARTMENT
        FOREIGN KEY (department_id) REFERENCES department (id)
);