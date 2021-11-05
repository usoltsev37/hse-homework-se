#!/usr/bin/env bash

sudo docker rm app-db
sudo docker rmi guide-helper-db
sudo docker build -t guide-helper-db .
sudo docker run --entrypoint "/bin/bash" -it --name app-db -e MYSQL_ROOT_PASSWORD=hsepassword -p 3307:3306 -d guide-helper-db
sudo docker start app-db