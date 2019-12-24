create table user_feeder (
    user_id uuid references users(id) not null,
    feeder_id uuid references feeders(id) not null,
);