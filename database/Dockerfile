FROM mysql:latest

MAINTAINER ybe.teamcook7@gmail.com

COPY init.sql /docker-entrypoint-initdb.d

ENV MYSQL_ROOT_PASSWORD=root

VOLUME /var/lib/mysql

EXPOSE 3306