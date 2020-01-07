#!/bin/bash

mvn -Pheroku clean install

chmod -R 777 target