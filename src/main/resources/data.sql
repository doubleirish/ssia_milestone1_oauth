insert into USER (ID, USERNAME, PASSWORD) values (1, 'john' ,'{bcrypt}$2a$10$8h303SvVBEGutbgI.yTPUeZwhWH5JVir4Kg3PHYa39BOLhVt4/E8K');
insert into USER (ID, USERNAME, PASSWORD) values (2, 'admin' ,'{bcrypt}$2a$10$/P.aSovhLIF3yKIbeaUmJODXCJ2jj2otFIVi8gJV/A1C0CSOeEq4u');
INSERT INTO AUTHORITY ( USER_ID ,AUTHORITY ) values (1, 'ROLE_USER');
INSERT INTO AUTHORITY ( USER_ID ,AUTHORITY ) values (2, 'ROLE_ADMIN');

insert into CLIENT (ID, NAME, SECRET, REDIRECT_URI, SCOPE)
values (1, 'client','{bcrypt}$2a$10$/P.aSovhLIF3yKIbeaUmJODXCJ2jj2otFIVi8gJV/A1C0CSOeEq4u' ,'http://localhost:8181/', 'read');

insert into GRANT (CLIENT_ID, GRANT  ) values (1,  'authorization_code' );
insert into GRANT (CLIENT_ID, GRANT  ) values (1,  'password' );
insert into GRANT (CLIENT_ID, GRANT  ) values (1,  'client_credentials');
insert into GRANT (CLIENT_ID, GRANT  ) values (1,  'refresh_token' );
