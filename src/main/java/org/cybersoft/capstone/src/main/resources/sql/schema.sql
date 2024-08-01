CREATE
    DATABASE crmapp;
USE
    crmapp;


CREATE TABLE users_roles
(
    id            INT AUTO_INCREMENT,
    id_permission INT,
    id_user       INT,
    licensed      INT,

    PRIMARY KEY (id)
);

CREATE TABLE roles
(
    id          INT AUTO_INCREMENT,
    name        VARCHAR(255),
    description VARCHAR(50),

    PRIMARY KEY (id)
);

CREATE TABLE roles_detail
(
    id            INT AUTO_INCREMENT,
    action        VARCHAR(20),
    action_name   VARCHAR(100),
    action_code   VARCHAR(20),
    url           VARCHAR(50),
    method        VARCHAR(20),
    check_action  VARCHAR(20),
    `order`       INT,
    id_permission INT,

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
    name VARCHAR(50),

    PRIMARY KEY (id)
);

CREATE TABLE users_project
(
    id         INT AUTO_INCREMENT,
    id_project INT,
    id_user    INT,

    PRIMARY KEY (id)
);

ALTER TABLE roles_detail
    ADD CONSTRAINT FK_id_permission FOREIGN KEY (id_permission) REFERENCES roles (id);

ALTER TABLE users_roles
    ADD CONSTRAINT FK_id_user_permission FOREIGN KEY (id_user) REFERENCES users (id),
    ADD CONSTRAINT FK_id_permission_user FOREIGN KEY (id_permission) REFERENCES roles (id);

ALTER TABLE users_project
    ADD CONSTRAINT FK_id_project_users FOREIGN KEY (id_project) REFERENCES project (id),
    ADD CONSTRAINT FK_id_users_project FOREIGN KEY (id_user) REFERENCES users (id);

ALTER TABLE users
    ADD CONSTRAINT FK_id_role_users FOREIGN KEY (id_role) REFERENCES roles (id);
ALTER TABLE task
    ADD CONSTRAINT FK_id_user_task FOREIGN KEY (id_user) REFERENCES users (id);
ALTER TABLE task
    ADD CONSTRAINT FK_id_project_task FOREIGN KEY (id_project) REFERENCES project (id);
ALTER TABLE task
    ADD CONSTRAINT FK_id_status_task FOREIGN KEY (id_status) REFERENCES status (id);

INSERT INTO roles(name, description)
VALUES ('ADMIN', 'Administrator'),
       ('USER', 'User'),
       ('LEADER', 'Leader');


INSERT INTO crmapp.roles_detail (action, action_name, action_code, url, method, check_action, `order`, id_permission)
VALUES ('VIEW', 'View statistic', 'VIEW_STATISTIC', '/', 'GET', '1', NULL, 1),
       ('VIEW', 'View create member', 'VIEW_CREATE_MEMBER', '/user-add', 'GET', '1', NULL, 1),
       ('CREATE', 'Create member', 'CREATE_MEMBER', '/user-add', 'POST', '1', NULL, 1),
       ('EDIT', 'Edit member', 'EDIT_MEMBER', '/user/*', 'PUT', '1', NULL, 1),
       ('DELETE', 'Delete member', 'DELETE_MEMBER', '/user/*', 'DELETE', '1', NULL, 1),
       ('VIEW', 'View member', 'VIEW_MEMBER', '/user-details/*', 'GET', '1', NULL, 1),
       ('VIEW', 'View members', 'VIEW_MEMBERS', '/user-table', 'GET', '1', NULL, 1),
       ('VIEW', 'View members project', 'VIEW_MEMBERS_PROJECT', '/user-table', 'GET', '0', NULL, 1),
       ('VIEW', 'View all members', 'VIEW_ALL_MEMBERS', '/user-table', 'GET', '1', NULL, 1),
       ('VIEW', 'View create task', 'VIEW_CREATE_TASK', '/task-add', 'GET', '1', NULL, 1),
       ('CREATE', 'Create task', 'CREATE_TASK', '/task-add', 'POST', '1', NULL, 1),
       ('EDIT', 'Edit task', 'EDIT_TASK', '/task/*', 'PUT', '1', NULL, 1),
       ('EDIT', 'Edit task', 'EDIT_PROGRESS_TASK', '/task/*', 'PUT', '1', NULL, 1),
       ('DELETE', 'Delete task', 'DELETE_TASK', '/task/*', 'DELETE', '1', NULL, 1),
       ('VIEW', 'View task', 'VIEW_TASK', '/task/*', 'GET', '1', NULL, 1),
       ('VIEW', 'View tasks', 'VIEW_TASKS', '/task', 'GET', '1', NULL, 1),
       ('VIEW', 'View project tasks', 'VIEW_PROJECT_TASKS', '/task', 'GET', '0', NULL, 1),
       ('VIEW', 'View all tasks', 'VIEW_ALL_TASKS', '/task', 'GET', '1', NULL, 1),
       ('VIEW', 'View create role', 'VIEW_CREATE_ROLE', '/role-add', 'GET', '1', NULL, 1),
       ('CREATE', 'Create role', 'CREATE_ROLE', '/role-add', 'POST', '1', NULL, 1),
       ('EDIT', 'Edit role', 'EDIT_ROLE', '/role/*', 'PUT', '1', NULL, 1),
       ('DELETE', 'Delete role', 'DELETE_ROLE', '/role/*', 'DELETE', '1', NULL, 1),
       ('VIEW', 'View role', 'VIEW_ROLE', '/role/*', 'GET', '1', NULL, 1),
       ('VIEW', 'View roles', 'VIEW_ROLES', '/role-table', 'GET', '1', NULL, 1),
       ('VIEW', 'View create project', 'VIEW_CREATE_PROJECT', '/groupwork-add', 'GET', '1', NULL, 1),
       ('CREATE', 'Create project', 'CREATE_PROJECT', '/groupwork-add', 'POST', '1', NULL, 1),
       ('EDIT', 'Edit project', 'EDIT_PROJECT', '/groupwork/*', 'PUT', '1', NULL, 1),
       ('DELETE', 'Delete project', 'DELETE_PROJECT', '/groupwork/*', 'DELETE', '1', NULL, 1),
       ('VIEW', 'View project', 'VIEW_PROJECT', '/groupwork/*', 'GET', '1', NULL, 1),
       ('VIEW', 'View project', 'VIEW_PROJECT_DETAILS', '/groupwork-details/*', 'GET', '1', NULL, 1),
       ('VIEW', 'View projects', 'VIEW_PROJECTS', '/groupwork', 'GET', '1', NULL, 1),
       ('VIEW', 'View projects', 'VIEW_ALL_PROJECTS', '/groupwork', 'GET', '1', NULL, 1),
       ('VIEW', 'View profile tasks', 'VIEW_PROFILE_TASKS', '/profile', 'GET', '1', NULL, 1),
       ('VIEW', 'View profile task detail', 'VIEW_PROFILE_TASK', '/profile-edit', 'GET', '1', NULL, 1),
       ('EDIT', 'Edit profile task detail', 'EDIT_PROFILE_TASK', '/profile-edit', 'PUT', '1', NULL, 1),

       ('VIEW', 'View statistic', 'VIEW_STATISTIC', '/', 'GET', '1', NULL, 3),
       ('VIEW', 'View create member', 'VIEW_CREATE_MEMBER', '/user-add', 'GET', '0', NULL, 3),
       ('CREATE', 'Create member', 'CREATE_MEMBER', '/user-add', 'POST', '0', NULL, 3),
       ('EDIT', 'Edit member', 'EDIT_MEMBER', '/user/*', 'PUT', '1', NULL, 3),
       ('DELETE', 'Delete member', 'DELETE_MEMBER', '/user/*', 'DELETE', '1', NULL, 3),
       ('VIEW', 'View member', 'VIEW_MEMBER', '/user-details/*', 'GET', '1', NULL, 3),
       ('VIEW', 'View members', 'VIEW_MEMBERS', '/user-table', 'GET', '0', NULL, 3),
       ('VIEW', 'View members project', 'VIEW_MEMBERS_PROJECT', '/user-table', 'GET', '1', NULL, 3),
       ('VIEW', 'View all members', 'VIEW_ALL_MEMBERS', '/user-table', 'GET', '0', NULL, 3),
       ('VIEW', 'View create task', 'VIEW_CREATE_TASK', '/task-add', 'GET', '1', NULL, 3),
       ('CREATE', 'Create task', 'CREATE_TASK', '/task-add', 'POST', '1', NULL, 3),
       ('EDIT', 'Edit task', 'EDIT_TASK', '/task/*', 'PUT', '1', NULL, 3),
       ('EDIT', 'Edit task', 'EDIT_PROGRESS_TASK', '/task/*', 'PUT', '1', NULL, 3),
       ('DELETE', 'Delete task', 'DELETE_TASK', '/task/*', 'DELETE', '1', NULL, 3),
       ('VIEW', 'View task', 'VIEW_TASK', '/task/*', 'GET', '1', NULL, 3),
       ('VIEW', 'View tasks', 'VIEW_TASKS', '/task', 'GET', '1', NULL, 3),
       ('VIEW', 'View project tasks', 'VIEW_PROJECT_TASKS', '/task', 'GET', '1', NULL, 3),
       ('VIEW', 'View all tasks', 'VIEW_ALL_TASKS', '/task', 'GET', '0', NULL, 3),
       ('VIEW', 'View create role', 'VIEW_CREATE_ROLE', '/role-add', 'GET', '0', NULL, 3),
       ('VIEW', 'View create role', 'CREATE_ROLE', '/role-add', 'GET', '0', NULL, 3),
       ('CREATE', 'Create role', 'CREATE_ROLE', '/role-add', 'POST', '0', NULL, 3),
       ('EDIT', 'Edit role', 'EDIT_ROLE', '/role/*', 'PUT', '0', NULL, 3),
       ('DELETE', 'Delete role', 'DELETE_ROLE', '/role/*', 'DELETE', '0', NULL, 3),
       ('VIEW', 'View role', 'VIEW_ROLE', '/role/*', 'GET', '0', NULL, 3),
       ('VIEW', 'View roles', 'VIEW_ROLES', '/role-table', 'GET', '0', NULL, 3),
       ('VIEW', 'View create project', 'VIEW_CREATE_PROJECT', '/groupwork-add', 'GET', '1', NULL, 3),
       ('CREATE', 'Create project', 'CREATE_PROJECT', '/groupwork-add', 'POST', '1', NULL, 3),
       ('EDIT', 'Edit project', 'EDIT_PROJECT', '/groupwork/*', 'PUT', '1', NULL, 3),
       ('DELETE', 'Delete project', 'DELETE_PROJECT', '/groupwork/*', 'DELETE', '1', NULL, 3),
       ('VIEW', 'View project', 'VIEW_PROJECT', '/groupwork/*', 'GET', '1', NULL, 3),
       ('VIEW', 'View project', 'VIEW_PROJECT_DETAILS', '/groupwork-details/*', 'GET', '1', NULL, 3),
       ('VIEW', 'View projects', 'VIEW_PROJECTS', '/groupwork', 'GET', '1', NULL, 3),
       ('VIEW', 'View projects', 'VIEW_ALL_PROJECTS', '/groupwork', 'GET', '0', NULL, 3),
       ('VIEW', 'View profile tasks', 'VIEW_PROFILE_TASKS', '/profile', 'GET', '1', NULL, 3),
       ('VIEW', 'View profile task detail', 'VIEW_PROFILE_TASK', '/profile-edit', 'GET', '1', NULL, 3),
       ('EDIT', 'Edit profile task detail', 'EDIT_PROFILE_TASK', '/profile-edit', 'PUT', '1', NULL, 3),

       ('VIEW', 'View statistic', 'VIEW_STATISTIC', '/', 'GET', '1', NULL, 2),
       ('VIEW', 'View create member', 'VIEW_CREATE_MEMBER', '/user-add', 'GET', '0', NULL, 2),
       ('CREATE', 'Create member', 'CREATE_MEMBER', '/user-add', 'POST', '0', NULL, 2),
       ('EDIT', 'Edit member', 'EDIT_MEMBER', '/user/*', 'PUT', '0', NULL, 2),
       ('DELETE', 'Delete member', 'DELETE_MEMBER', '/user/*', 'DELETE', '0', NULL, 2),
       ('VIEW', 'View member', 'VIEW_MEMBER', '/user-details/*', 'GET', '0', NULL, 2),
       ('VIEW', 'View members', 'VIEW_MEMBERS', '/user-table', 'GET', '0', NULL, 2),
       ('VIEW', 'View members project', 'VIEW_MEMBERS_PROJECT', '/user-table', 'GET', '0', NULL, 2),
       ('VIEW', 'View all members', 'VIEW_ALL_MEMBERS', '/user-table', 'GET', '0', NULL, 2),
       ('VIEW', 'View create task', 'VIEW_CREATE_TASK', '/task-add', 'GET', '0', NULL, 2),
       ('CREATE', 'Create task', 'CREATE_TASK', '/task-add', 'POST', '0', NULL, 2),
       ('EDIT', 'Edit task', 'EDIT_TASK', '/task/*', 'PUT', '0', NULL, 2),
       ('EDIT', 'Edit task', 'EDIT_PROGRESS_TASK', '/task/*', 'PUT', '1', NULL, 2),
       ('DELETE', 'Delete task', 'DELETE_TASK', '/task/*', 'DELETE', '0', NULL, 2),
       ('VIEW', 'View task', 'VIEW_TASK', '/task/*', 'GET', '1', NULL, 2),
       ('VIEW', 'View tasks', 'VIEW_TASKS', '/task', 'GET', '1', NULL, 2),
       ('VIEW', 'View project tasks', 'VIEW_PROJECT_TASKS', '/task', 'GET', '0', NULL, 2),
       ('VIEW', 'View all tasks', 'VIEW_ALL_TASKS', '/task', 'GET', '0', NULL, 2),
       ('VIEW', 'View create role', 'VIEW_CREATE_ROLE', '/role-add', 'GET', '0', NULL, 2),
       ('VIEW', 'View create role', 'CREATE_ROLE', '/role-add', 'GET', '0', NULL, 2),
       ('CREATE', 'Create role', 'CREATE_ROLE', '/role-add', 'POST', '0', NULL, 2),
       ('EDIT', 'Edit role', 'EDIT_ROLE', '/role/*', 'PUT', '0', NULL, 2),
       ('DELETE', 'Delete role', 'DELETE_ROLE', '/role/*', 'DELETE', '0', NULL, 2),
       ('VIEW', 'View role', 'VIEW_ROLE', '/role/*', 'GET', '0', NULL, 2),
       ('VIEW', 'View roles', 'VIEW_ROLES', '/role-table', 'GET', '0', NULL, 2),
       ('VIEW', 'View create project', 'VIEW_CREATE_PROJECT', '/groupwork-add', 'GET', '0', NULL, 2),
       ('CREATE', 'Create project', 'CREATE_PROJECT', '/groupwork-add', 'POST', '0', NULL, 2),
       ('EDIT', 'Edit project', 'EDIT_PROJECT', '/groupwork/*', 'PUT', '0', NULL, 2),
       ('DELETE', 'Delete project', 'DELETE_PROJECT', '/groupwork/*', 'DELETE', '0', NULL, 2),
       ('VIEW', 'View project', 'VIEW_PROJECT', '/groupwork/*', 'GET', '0', NULL, 2),
       ('VIEW', 'View project', 'VIEW_PROJECT_DETAILS', '/groupwork-details/*', 'GET', '0', NULL, 2),
       ('VIEW', 'View projects', 'VIEW_PROJECTS', '/groupwork', 'GET', '0', NULL, 2),
       ('VIEW', 'View projects', 'VIEW_ALL_PROJECTS', '/groupwork', 'GET', '0', NULL, 2),
       ('VIEW', 'View profile tasks', 'VIEW_PROFILE_TASKS', '/profile', 'GET', '1', NULL, 2),
       ('VIEW', 'View profile task detail', 'VIEW_PROFILE_TASK', '/profile-edit', 'GET', '1', NULL, 2),
       ('EDIT', 'Edit profile task detail', 'EDIT_PROFILE_TASK', '/profile-edit', 'PUT', '1', NULL, 2);

INSERT INTO users_roles(id_permission, id_user, licensed)
VALUES (1, 1, 1),
       (2, 2, 1),
       (3, 3, 1);

INSERT INTO status(name)
VALUES ('Đã hoàn thành'),
       ('Đang thực hiện'),
       ('Chưa thực hiện');