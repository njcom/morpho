include $(CURDIR)/../../prelude.mk

# Tools in alphabetical order
tools := dotnet elasticsearch go haskell jvm kafka kibana logstash mariadb memcached mongodb nginx nodejs ocaml perl php playwright postgresql python rabbitmq redis ruby zeromq
docker-compose-cmd := docker-compose --file compose.yaml --env-file .env

###############################################################################

test:
	echo todo $(CURDIR)

start:
	$(docker-compose-cmd) up --build

start-detached:
	$(docker-compose-cmd) up --build --detach 

stop:
	$(docker-compose-cmd) down

check:
	$(docker-compose-cmd) config

clean:
	$(docker-compose-cmd) rm --force #-v

init:
	mkdir -vp $(tools)

.SILENT:
.PHONY: test start start-detached stop check clean init

## todo vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv

## login-py: login into `$(project_name)_django` container and run python.
#login-py:
#	$(call login,django,/usr/bin/python3)
### py: alias for the `login-py`.
#py: login-py
#
### login-django: login into the running `$(project_name)_django` container and run bash.
#login-django:
#	$(call login_sh,django)
### login: alias for the `login-django`.
#login: login-django
### sh: alias for the `login-django`.
#sh: login-django
#
### login-apache: login into the running `$(project_name)_apache` container and run bash.
#login-apache:
#	$(call login_sh,apache)
#
### login-mysql: login into the running `$(project_name)_mysql` container and run bash.
#login-mysql:
#	$(call login_sh,mysql)
#
### login-mongodb: login into the running `$(project_name)_mongodb` container and run bash.
#login-mongodb:
#	$(call login_sh,mongodb)
#
### login-mailhog: login into the running `$(project_name)_mailhog` container and run bash.
#login-mailhog:
#	$(call login_sh,mailhog)
#define login
#	docker exec -ti --rm -e COLUMNS=$(shell tput cols) -e LINES=$(shell tput lines) $(project_name)_$(1) $(2)
#endef
#
#define login_sh
#	$(call login,$(1),/bin/bash)
#endef