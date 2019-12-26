create table users (
	id uuid primary key,
	username VARCHAR (255) unique not null,
	first_name VARCHAR (255),
	last_name VARCHAR (255),
	email VARCHAR (255),
	password VARCHAR (255),
	devices VARCHAR (255)
);