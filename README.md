# Logger example

## Create a logger
```java
//This creates a logger. You can create a new logger in each class, you don't have to create a service.
Logger logger = LoggerFactory.getLogger(ExampleController.class);
```

## Make it write to file
```
logging.file.path=logs/
logging.file.name=logs/application.log
```

include these two lines of code in your `application.properties` file and
spring will automatically make it write to file.

## Extra clarification on why we need logs.
1. When the application is running or after we have turned it off
Logs are our only insight to what happends or has happened in our system.
1. Logs are for the most part going to be used in automated systems(ex SIEM or fail2ban)
there for it is important to make it easy to parse log data into a format which computers can use.
1. Logs are neccesary for administrators such that they can debug problems(after it has been deployed),
detect secutiy issues(weird or malicious behavior) and forensics(if something has happened, we can found out why).

For your projects you do not have to make logging super advanced. It is enough for you to only log simple security issues(such as failed login atempts and when a user tries to access something which they don't have access to i.e a normal user trying to access admin resources) and access to resources(it is possible to configure the web proxy to do this, but for simplicity let's just have this done in the code). We also have more business related logs, the bidding history. This is not really connected to the integrity of the system, but it is included to give you the idea of keeping business related logs for security/backup/forensics/statistics reasons.

NOTE: The bidding history should be stored in your DB not the LOGS! The logs are just there for the possibility to go back and view if needed, they are not the main source to store business information. 