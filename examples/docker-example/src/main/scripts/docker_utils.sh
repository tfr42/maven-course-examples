#!/bin/sh
docker_nuke()
{
    docker ps -q | xargs docker stop
    docker ps -q -a | xargs docker rm;
}

docker_rmi_none()
{
    docker images | grep '<none>' | awk '{ print $3 }' | xargs docker rmi;
}

docker_go()
{
   docker run --rm -t -i $@;
}

docker_status()
{
    docker ps -a;
}