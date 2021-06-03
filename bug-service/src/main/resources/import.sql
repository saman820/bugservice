-- start spring boot server, and visit: http://localhost:8080/h2 to access the h2 db tables

-- populate the status table
insert into status(status) values('Pending');
insert into status(status) values('Accepted');
insert into status(status) values('Resolved');
insert into status(status) values('Rejected');

-- populate the roles table
insert into roles(role) values('admin_user');
insert into roles(role) values('normal_user');

-- populate the users table
insert into users(first_name, last_name, username, password, role_id) values('Firsta', 'Lasta', 'useraa', 'Passw0rd', 1);
insert into users(first_name, last_name, username, password, role_id) values('Firstb', 'Lastb', 'userbb', 'Passw0rd', 1);
insert into users(first_name, last_name, username, password, role_id) values('Firstc', 'Lastc', 'usercc', 'Passw0rd', 2);
insert into users(first_name, last_name, username, password, role_id) values('Firstd', 'Lastd', 'userdd', 'Passw0rd', 2);
insert into users(first_name, last_name, username, password, role_id) values('Firste', 'Laste', 'useree', 'Passw0rd', 2);
insert into users(first_name, last_name, username, password, role_id) values('Firstf', 'Lastf', 'userff', 'Passw0rd', 2);

-- populate the bugs table
insert into bugs(user_id_fk, status_id_fk, description, submission_date) values(3, 3, 'My Angular component does not auto-refresh', current_timestamp);
insert into bugs(user_id_fk, status_id_fk, description, submission_date) values(3, 3, 'My React component does not auto-refresh', current_timestamp);
insert into bugs(user_id_fk, status_id_fk, description, submission_date) values(4, 2, 'My Spring component does not auto-refresh', current_timestamp);
insert into bugs(user_id_fk, status_id_fk, description, submission_date) values(4, 2, 'My Java component does not auto-refresh', current_timestamp);
insert into bugs(user_id_fk, status_id_fk, description, submission_date) values(5, 2, 'My SQL component does not auto-refresh', current_timestamp);
insert into bugs(user_id_fk, status_id_fk, description, submission_date) values(5, 2, 'My PostgreSQL component does not auto-refresh', current_timestamp);
insert into bugs(user_id_fk, status_id_fk, description, submission_date) values(5, 2, 'My Javascript component does not auto-refresh', current_timestamp);
insert into bugs(user_id_fk, status_id_fk, description, submission_date) values(5, 2, 'My Typescript component does not auto-refresh', current_timestamp);
insert into bugs(user_id_fk, status_id_fk, description, submission_date) values(6, 2, 'My Docker component does not auto-refresh', current_timestamp);
insert into bugs(user_id_fk, status_id_fk, description, submission_date) values(6, 2, 'My CSS component does not auto-refresh', current_timestamp);
insert into bugs(user_id_fk, status_id_fk, description, submission_date) values(6, 2, 'My HTML component does not auto-refresh', current_timestamp);
insert into bugs(user_id_fk, status_id_fk, description, submission_date) values(6, 2, 'My Teapot component does not auto-refresh', current_timestamp);

-- populate the solutions table
insert into solutions(user_id_fk, bug_id_fk, status, solution, submission_date) values(3, 1, true, 'Corrent solution for Angular component does not auto-refresh', current_timestamp);
insert into solutions(user_id_fk, bug_id_fk, status, solution, submission_date) values(3, 2, true, 'Corrent solution for React component does not auto-refresh', current_timestamp);
insert into solutions(user_id_fk, bug_id_fk, status, solution, submission_date) values(4, 2, false, 'Wrong solution for React component does not auto-refresh', current_timestamp);
insert into solutions(user_id_fk, bug_id_fk, status, solution, submission_date) values(5, 2, false, 'Wrong solution for React component does not auto-refresh', current_timestamp);