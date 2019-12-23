create table user_role (
    user_id uuid references users(id) not null,
    role_id uuid references roles(id) not null
);