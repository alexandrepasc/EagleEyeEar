#!/bin/bash

cp devDocker/hibernate.dev src/main/resources/hibernate.properties

mvn -Pdev clean install

chmod -R 777 target