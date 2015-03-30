# Basic SQL

## Create Users

## Schema/Database
```sql
CREATE DATABASE my_db;

--delete database
DROP DATABASE my_db;

--show all databases
SHOW DATABASES;

--to switch default schema
USE my_db;

--show all tables in the selected database
SHOW TABLES;
```

## Create Table
```sql
CREATE TABLE test_table (
    book_id INT,
    title VARCHAR(255),
    author VARCHAR(255)
);

--delete
DROP TABLE test_table;
```
## Update Table
```sql
ALTER TABLE books
--to update existing columns
CHANGE COLUMN book_id book_id INT AUTO_INCREMENT PRIMARY KEY,

--to add new column
ADD COLUMN summary VARCHAR(255) NOT NULL
;
```

## Describe Table
```sql
DESCRIBE books;
```

## Insert Data

## Query Data

## Update Row

## Delete Row
