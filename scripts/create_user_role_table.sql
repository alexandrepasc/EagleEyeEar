create table user_role (
    user_id uuid references users(id),
    role_id uuid references roles(id)
);