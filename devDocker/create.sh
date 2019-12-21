#!/bin/bash

cp devDocker/Dockerfile_template devDocker/Dockerfile

docker build -f devDocker/Dockerfile -t dev-eagleeyeear-img .

docker run -t -d --name dev-eagleeyeear -v $(pwd):/home/EagleEyeEar dev-eagleeyeear-img

rm -f devDocker/Dockerfile
