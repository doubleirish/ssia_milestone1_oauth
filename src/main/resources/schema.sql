create table if not exists USER
(
	ID INT auto_increment
		primary key,
	USERNAME VARCHAR(45) not null,
	PASSWORD VARCHAR(45) not null
);

create table  if not exists AUTHORITY
(
	ID INT auto_increment
		primary key,
	USERNAME VARCHAR(45) not null,
	AUTHORITY VARCHAR(45) not null,
	constraint AUTHORITY_USER_USERNAME_FK
		foreign key (USERNAME) references USER (USERNAME)
);

