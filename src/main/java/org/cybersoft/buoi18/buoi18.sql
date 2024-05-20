CREATE DATABASE IF NOT EXISTS buoi18;

USE buoi18;

CREATE TABLE employees
(
    employee_id   INT PRIMARY KEY,
    employee_name VARCHAR(255),
    salary        DECIMAL(10, 2),
    start_date    DATE,
    department_id INT
);

CREATE TABLE access_rights
(
    access_id    INT PRIMARY KEY,
    employee_id  INT,
    access_level VARCHAR(255),
    FOREIGN KEY (employee_id) REFERENCES employees (employee_id)
);

CREATE TABLE departments
(
    department_id   INT PRIMARY KEY,
    department_name VARCHAR(255)
);

INSERT INTO employees (employee_id, employee_name, salary, start_date, department_id)
VALUES (1, 'John Doe', 60000, '2021-01-15', 1),
       (2, 'Jane Smith', 70000, '2020-05-20', 2),
       (3, 'Bob Johnson', 55000, '2022-03-10', 1),
       (4, 'Alice Williams', 80000, '2021-08-05', 3),
       (5, 'Charlie Brown', 65000, '2020-12-01', 2);

INSERT INTO departments (department_id, department_name)
VALUES (1, 'IT'),
       (2, 'Sales'),
       (3, 'HR');

INSERT INTO access_rights (access_id, employee_id, access_level)
VALUES (1, 1, 'Admin'),
       (2, 2, 'User'),
       (3, 3, 'User'),
       (4, 4, 'Admin'),
       (5, 5, 'User');


# Câu 1
SELECT *
FROM employees;

# Câu 2
SELECT employee_name, salary
FROM employees;

# Câu 3
SELECT *
FROM employees
WHERE salary > 50000.00;

# Câu 4
SELECT departments.department_name, COUNT(1) AS total
FROM employees
         JOIN departments ON employees.department_id = departments.department_id
GROUP BY departments.department_id;

# Câu 5
SELECT employee_name
FROM employees
ORDER BY employee_name;

# Câu 6
SELECT *
FROM employees
         JOIN departments ON employees.department_id = departments.department_id
WHERE employees.salary >= 40000.00
  AND employees.salary <= 60000.00
ORDER BY employees.salary;

# Câu 7
SELECT SUM(employees.salary) AS total_salary
FROM employees;

# Câu 8
SELECT employees.employee_name, departments.department_name
FROM employees
         JOIN departments ON employees.department_id = departments.department_id;

# Câu 9
SELECT departments.department_name, COUNT(1) AS total_employee
FROM employees
         JOIN departments ON employees.department_id = departments.department_id
GROUP BY departments.department_id
HAVING total_employee >= 3;

# Câu 10
SELECT *
FROM employees e
         JOIN departments d ON e.department_id = d.department_id
WHERE d.department_name = 'IT'
   OR d.department_name = 'Sales';

# Câu 11
SELECT *
FROM employees e
WHERE e.start_date >= '2020-01-01';

# Câu 12
SELECT SUM(e.salary) DIV COUNT(1) AS sum_salary
FROM employees e;

# Câu 13
SELECT d.department_name, COUNT(employee_id) AS total
FROM employees e
         RIGHT JOIN departments d
                    ON e.department_id = d.department_id
GROUP BY d.department_name;

# Câu 14
SELECT *
FROM employees e
ORDER BY e.salary DESC
LIMIT 5;

# Câu 15
SELECT *
FROM employees e
WHERE e.employee_name LIKE 'A%';

# Câu 16
SELECT e.employee_name, ar.access_level
FROM employees e
         JOIN access_rights ar ON e.employee_id = ar.employee_id
WHERE ar.access_level = 'ADMIN';

# Câu 17
SELECT d.department_name, SUM(e.salary) AS total_salary
FROM employees e
         RIGHT JOIN departments d ON e.department_id = d.department_id
GROUP BY 1;

# Câu 18
SELECT *
FROM employees e
ORDER BY e.start_date;

# Câu 19
SELECT e.employee_name, e.salary, d.department_name
FROM employees e
         RIGHT JOIN departments d ON e.department_id = d.department_id
         RIGHT JOIN (SELECT MAX(e11.salary) AS max_salary, e11.department_id
                     FROM employees e11
                     GROUP BY e11.department_id) AS e1
                    ON e.department_id = e1.department_id AND e.salary = e1.max_salary;
# Câu 20
SELECT e.employee_name, d.department_name, d.department_id, ar.access_level
FROM employees e
         LEFT JOIN access_rights ar ON e.employee_id = ar.employee_id
         RIGHT JOIN departments d ON e.department_id = d.department_id;