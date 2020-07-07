CREATE TABLE tarefa (
	id bigint auto_increment PRIMARY KEY,
	tarefa varchar(255) not null,
	status tinyint(1) not null
);