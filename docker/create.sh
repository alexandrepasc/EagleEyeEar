#!/bin/bash

cp docker/Dockerfile_template docker/Dockerfile

docker build -f docker/Dockerfile -t eagleeyeear-img .

docker run -t -d --name eagleeyeear -v $(pwd):/home/EagleEyeEar eagleeyeear-img

rm -f docker/Dockerfile
