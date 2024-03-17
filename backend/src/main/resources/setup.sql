create database wiss_todos;

create user wiss_todo IDENTIFIED by "wiss_todo123";

GRANT ALL ON wiss_todos.* TO wiss_todo;
