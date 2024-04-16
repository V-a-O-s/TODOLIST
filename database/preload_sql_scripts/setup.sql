CREATE DATABASE wiss_todos;
USE wiss_todos;
CREATE USER wiss_user IDENTIFIED BY "a";
GRANT ALL ON wiss_todos.* TO wiss_user;
