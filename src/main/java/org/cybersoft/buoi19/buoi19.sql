# Câu 1
SELECT e.name, d.department_name
FROM employees e
         JOIN buoi19.departments d ON e.department_id = d.department_id;

# Câu 2
SELECT e.name, p.project_name
FROM employees e
         JOIN employee_projects ep ON ep.employee_id = e.employee_id
         JOIN projects p ON p.project_id = ep.project_id;

# Câu 3
SELECT p.project_name, SUM(e.salary) AS total_salary
FROM employees e
         JOIN employee_projects ep ON ep.employee_id = e.employee_id
         JOIN projects p ON p.project_id = ep.project_id
         JOIN departments d ON e.department_id = d.department_id
GROUP BY p.project_id;

# Câu 4
SELECT e.name, e.salary, p.project_name
FROM employees e
         JOIN employee_projects ep ON ep.employee_id = e.employee_id
         JOIN projects p ON p.project_id = ep.project_id;

# Câu 5
SELECT e.name AS employee_name, e1.name AS manager_name, p.project_name
FROM employees e
         LEFT JOIN employees e1 ON e.manager_id = e1.employee_id
         JOIN employee_projects ep ON ep.employee_id = e.employee_id
         JOIN projects p ON p.project_id = ep.project_id;

# Câu 6 (1)
SELECT d.department_name, COUNT(1) AS total_employee_in_department_join_project
FROM employees e
         # Subquery lấy ra những employee đảm bảo có tham gia project và group lại bằng id phòng ban
         JOIN (SELECT e11.*
               FROM employees e11
                        JOIN employee_projects ep11 ON ep11.employee_id = e11.employee_id
                        JOIN projects p11 ON p11.project_id = ep11.project_id
                        JOIN departments d11 ON d11.department_id = e11.department_id
               GROUP BY e11.employee_id) AS e1 ON e1.employee_id = e.employee_id
         JOIN departments d ON d.department_id = e.department_id
GROUP BY d.department_id;

# Câu 6 (2)
SELECT d.department_name, COUNT(1)
FROM employees e
         JOIN departments d ON d.department_id = e.department_id
GROUP BY d.department_name;

# Câu 7
SELECT e11.project_id, e11.project_name, e.name, e.salary
FROM employees e
         JOIN (SELECT MAX(e11.salary) AS max_salary, p1.project_id, p1.project_name
               FROM employees e11
                        JOIN employee_projects ep1 ON e11.employee_id = ep1.employee_id
                        JOIN projects p1 ON p1.project_id = ep1.project_id
               GROUP BY p1.project_id) AS e11 ON e.salary = e11.max_salary
ORDER BY project_id;

# Câu 7 (2)
SELECT *
FROM employees e
         JOIN employee_projects ep ON e.employee_id = ep.employee_id
         JOIN projects p ON p.project_id = ep.project_id
WHERE e.salary = (SELECT MAX(e.salary)
                  FROM employees e
                           JOIN employee_projects ep ON e.employee_id = ep.employee_id);

# Câu 8
SELECT p.project_id, p.project_name, COUNT(1) AS total_employee
FROM projects p
         JOIN employee_projects ep ON ep.project_id = p.project_id
         JOIN employees e ON e.employee_id = ep.employee_id
GROUP BY p.project_id
ORDER BY total_employee;

# Câu 9
SELECT e.name, ROUND(AVG(e.salary), 2) AS average_salary, d.department_id, d.department_name
FROM employees e
         JOIN departments d ON d.department_id = e.department_id
         JOIN employee_projects ep ON ep.employee_id = e.employee_id
         JOIN projects p ON p.project_id = ep.project_id
GROUP BY e.employee_id;

# Câu 10
SELECT e.employee_id, e.name, d.department_id, d.department_name, p.project_id, p.project_name
FROM employees e
         JOIN departments d ON d.department_id = e.department_id
         JOIN employee_projects ep ON ep.employee_id = e.employee_id
         JOIN projects p ON p.project_id = ep.project_id;

# Câu 11
SELECT e.name, COUNT(1) AS total_project_employee_joined
FROM employees e
         JOIN departments d ON d.department_id = e.department_id
         JOIN employee_projects ep ON ep.employee_id = e.employee_id
         JOIN projects p ON p.project_id = ep.project_id
GROUP BY e.employee_id;

# Câu 12
SELECT d.department_name, COUNT(1) AS total_project_department_have
FROM departments d
         JOIN buoi19.projects p ON p.department_id = d.department_id
GROUP BY d.department_id;

# Câu 13
SELECT e11.project_id, e11.project_name, e.name, e.salary
FROM employees e
         JOIN (SELECT MIN(e11.salary) AS max_salary, p1.project_id, p1.project_name
               FROM employees e11
                        JOIN employee_projects ep1 ON e11.employee_id = ep1.employee_id
                        JOIN projects p1 ON p1.project_id = ep1.project_id
               GROUP BY p1.project_id) AS e11 ON e.salary = e11.max_salary
ORDER BY project_id;

# Câu 14
SELECT p.project_name
FROM projects p
         LEFT JOIN employee_projects ep ON ep.project_id = p.project_id
WHERE ep.employee_id IS NULL;

# Câu 15
SELECT e.employee_id,
       e.name,
       e.salary,
       test.department_id,
       test.department_name
FROM employees e
         JOIN (SELECT d11.department_id,
                      d11.department_name,
                      MAX(e11.salary) AS employee_highest_salary,
                      MIN(e11.salary) AS employee_lowest_salary
               FROM employees e11
                        JOIN departments d11 ON e11.department_id = d11.department_id
               GROUP BY d11.department_id) AS test
              ON test.department_id = e.department_id AND (test.employee_highest_salary = e.salary OR
                                                           test.employee_lowest_salary = e.salary)
ORDER BY test.department_id;

# Câu 16
SELECT d.department_name,
       p.project_name,
       total_employee_of_project,
       total_salary_of_project
FROM departments d
         JOIN projects p ON p.department_id = d.department_id
         JOIN (SELECT p11.project_id,
                      p11.project_name,
                      p11.department_id,
                      COUNT(e11.employee_id) AS total_employee_of_project,
                      SUM(e11.salary)        AS total_salary_of_project
               FROM employees e11
                        JOIN departments d11 ON d11.department_id = e11.department_id
                        JOIN employee_projects ep11 ON ep11.employee_id = e11.employee_id
                        JOIN projects p11 ON p11.project_id = ep11.project_id
               GROUP BY p11.project_id) AS test ON test.department_id = d.department_id;

# Câu 17
SELECT e.name
FROM employees e
         LEFT JOIN employee_projects ep ON ep.employee_id = e.employee_id
WHERE ep.project_id IS NULL;

# Câu 18
SELECT d.*, COUNT(1) AS total_project_on_department
FROM departments d
         JOIN projects p ON p.department_id = d.department_id
GROUP BY d.department_id;

# Câu 19
SELECT e.employee_id,
       e.name,
       e.salary,
       p.project_name,
       d.department_name
FROM employees e
         JOIN departments d ON d.department_id = e.department_id
         JOIN employee_projects ep ON ep.employee_id = e.employee_id
         JOIN projects p ON p.project_id = ep.project_id
         JOIN (SELECT d.*, MAX(e.salary) AS highest_salary
               FROM employees e
                        JOIN departments d ON d.department_id = e.department_id
               GROUP BY d.department_id) AS test
              ON test.department_id = d.department_id AND test.department_id = e.department_id AND
                 test.highest_salary = e.salary;

# Câu 20
SELECT d.department_id, d.department_name, SUM(e.salary) AS total_salary_employee_not_join_project
FROM employees e
         LEFT JOIN departments d ON d.department_id = e.department_id
         LEFT JOIN employee_projects ep ON ep.employee_id = e.employee_id
         LEFT JOIN projects p ON p.project_id = ep.project_id
WHERE ep.project_id IS NULL
  AND p.project_id IS NULL
GROUP BY d.department_id