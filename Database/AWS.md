# AWS RDS

## Note:
- To connect make sure you have a valid inbound rule in your RDS instance's security group
```
MYSQL
TCP
3306
0.0.0.0/0
```

- connect from the command line (or mysql workbench)
```
mysql -h myinstance.123456789012.us-east-1.rds.amazonaws.com -P 3306 -u mymasteruser -p
```
