set your local mysql server
in application.yml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://127.0.0.1:3306/dt55?characterEncoding=utf-8&useSSL=false&serverTimezone=UTC
    username: root
    password: 123456
