# Spring Security Authorization server
a spring security OAUTH2 authorization server with JPA backed clients/users on a H2 DB

verify h2-console schema and dml (should be secured)
```
  http://localhost:8080/h2-console
```

testing secured endpoints   
```
curl -u john:12345 http://localhost:8080/users
curl -u john:12345 http://localhost:8080/users/1
curl -u john:12345 http://localhost:8080/clients  
```   
## access-request using password grant 
```
# can be generated from postman
curl --location --u client:secret  -request POST \ 'localhost:8080/oauth/token?grant_type=password&username=john&password=12345&scope=read'  
```

## TODO access-request using client credentials grant 
```
curl --location -u client:secret --request POST 'http://localhost:8080/oauth/token?grant_type=client_credentials&scope=read'
```

## TODO refresh token
