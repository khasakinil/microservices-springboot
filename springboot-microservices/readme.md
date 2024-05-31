#Endpoints :
> http://localhost:8080/rest/message
> http://localhost:8080/rest/fortune

#Actuators: For monitor and manage the application
> Add the dependency for actualtors
> update the application.properties file for allowing the endpoints

> http://localhost:8080/actuator/info
> http://localhost:8080/actuator/health
> http://localhost:8080/actuator/beans
> http://localhost:8080/actuator/threaddump
> http://localhost:8080/actuator/mappings

#spring security
> add dependency spring-boot-starter-security
provide user name and password in application.properties as
spring.security.user.name=username
spring.security.user.password=password
> If we dont provide username and password, then spring provides user as 'user' and password as generated password on console


