# MySQL Setup
* download tar distribution
* extract to MYSQL_BASE_DIR
* edit /etc/my.cnf
```
[mysqld]
basedir = /Users/lbibera/Documents/Apps/mysql
datadir = /Users/lbibera/Documents/Apps/mysql/mydata
port = 3306
innodb=OFF 
ignore-builtin-innodb 
skip-innodb
default-storage-engine=myisam 
default-tmp-storage-engine=myisam
sql_mode=NO_ENGINE_SUBSTITUTION,STRICT_TRANS_TABLES
```
* add ownership of mysql directory to the mysql user
```
shell> cd MYSQL_BASE_DIR
shell> sudo chown -R mysql .
shell> sudo chgrp -R mysql .
```
* setup server
```
./mysql/scripts/mysql_install_db
```
* start server
```
./mysql/bin/mysqld
```
