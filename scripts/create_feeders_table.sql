create table feeders (
	id uuid primary key,
	user_id uuid references users(id),
	pack_name VARCHAR (255),
	pack_id VARCHAR (255),
	pack_group VARCHAR (255),
	pack_artifact VARCHAR (255),
	pack_release_date int8
);