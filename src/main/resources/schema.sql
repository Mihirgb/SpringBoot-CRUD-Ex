Drop TABLE IF EXISTS TEST;

CREATE TABLE TEST (
Blog_ID int not null primary key,
Blog_Name varchar(300),
Author varchar(50),
Date_pub timestamp default(CURRENT_TIME)
)