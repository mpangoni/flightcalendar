CREATE TABLE accounts
(
	id IDENTITY,
	
	email varchar(64) NOT NULL,
	
	firstName varchar(128) DEFAULT NULL,
	lastName varchar(128) DEFAULT NULL,
	
	firstAddress varchar(128) DEFAULT NULL,
	secondAddress varchar(128) DEFAULT NULL,
	
	city varchar(64) DEFAULT NULL,
	state varchar(64) DEFAULT NULL,
	zipcode varchar(8) DEFAULT NULL,
	
	PRIMARY KEY(id) 
);

CREATE UNIQUE INDEX email_idx on accounts (email);