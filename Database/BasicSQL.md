# Basic SQL

## Create Users

## Schema/Database
```sql
CREATE DATABASE my_db;

//to switch default schema
USE my_db;
```

## Create Table
```sql
CREATE TABLE test_table (
    book_id INT,
    title VARCHAR(255),
    author VARCHAR(255)
);
```
## Update Table
```sql
ALTER TABLE books
CHANGE COLUMN book_id book_id INT AUTO_INCREMENT PRIMARY KEY
;

```


## Insert Data

## Query Data

## Update Row

## Delete Row
