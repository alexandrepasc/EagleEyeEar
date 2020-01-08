#!/bin/bash

cp hibernate.heroku ../src/main/resources/hibernate.properties

mvn -Pheroku clean install

chmod -R 777 target

cp hibernate.dev ../src/main/resources/hibernate.properties