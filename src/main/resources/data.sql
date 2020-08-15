insert into USER (ID, USERNAME, PASSWORD) values (1, 'john' ,'12345');
insert into USER (ID, USERNAME, PASSWORD) values (2, 'admin' ,'secret');
INSERT INTO AUTHORITY ( USER_ID ,AUTHORITY ) values (1, 'ROLE_USER');
INSERT INTO AUTHORITY ( USER_ID ,AUTHORITY ) values (2, 'ROLE_ADMIN');

insert into CLIENT (ID, NAME, SECRET, REDIRECT_URI, SCOPE)
values (1, 'client','secret' ,'http://localhost:8181/', 'user');

insert into GRANT (CLIENT_ID, GRANT  ) values (1,  'authorization-code' );
insert into GRANT (CLIENT_ID, GRANT  ) values (1,  'password' );
insert into GRANT (CLIENT_ID, GRANT  ) values (1,  'client-credentials');
insert into GRANT (CLIENT_ID, GRANT  ) values (1,  'refresh-token' );
