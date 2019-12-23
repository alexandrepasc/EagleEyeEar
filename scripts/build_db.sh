#!/bin/bash

psql -h 172.17.0.2 -p 5432 -U postgres -w -f create_db.sql

psql -h 172.17.0.2 -p 5432 -U postgres -w -d eagleeye_db -f create_user_table.sql

psql -h 172.17.0.2 -p 5432 -U postgres -w -d eagleeye_db -f create_feeders_table.sql

psql -h 172.17.0.2 -p 5432 -U postgres -w -d eagleeye_db -f create_roles_table.sql

psql -h 172.17.0.2 -p 5432 -U postgres -w -d eagleeye_db -f create_user_role_table.sql

psql -h 172.17.0.2 -p 5432 -U postgres -w -d eagleeye_db -f insert_roles_data.sql

psql -h 172.17.0.2 -p 5432 -U postgres -w -d eagleeye_db -f insert_maven_data.sql

psql -h 172.17.0.2 -p 5432 -U postgres -w -d eagleeye_db -f insert_pypi_data.sql