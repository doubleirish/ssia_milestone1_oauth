
use curl to test access to secured resources
```
curl  http://localhost:8080/h2-console

curl -u john:12345 http://localhost:8080/users  # requires USER ROLE ->ok
curl -u root:secret http://localhost:8080/users  # has ADMIN_ROLE ->fail

curl -u root:secret http://localhost:8080/clients # requires ADMIN_ROLE role ->ok
curl -u john:12345 http://localhost:8080/clients # only has USER_ROLE role ->fail
```   
## Client password grant to user

```
curl -v -XPOST -u client:secret http://localhost:8080/oauth/token?grant_type=password&username=john&password=12345&scope=read
```