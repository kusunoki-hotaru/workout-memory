CREATE TABLE IF NOT EXISTS w_user(
 user_id VARCHAR(50) PRIMARY KEY
,password VARCHAR(100)
,user_name VARCHAR(50)
,birthday DATE
,age INT
,gender INT
 );
 
 
 CREATE TABLE IF NOT EXISTS w_entity(
  training VARCHAR(20) PRIMARY KEY
 ,body_parts VARCHAR(20)
 );