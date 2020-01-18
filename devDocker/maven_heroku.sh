#!/bin/bash

cp devDocker/hibernate.heroku src/main/resources/hibernate.properties

cp devDocker/config.heroku src/main/resources/config.properties

mvn clean install

chmod -R 777 target

cp devDocker/hibernate.dev src/main/resources/hibernate.properties

cp devDocker/config.dev src/main/resources/config.properties