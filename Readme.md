# Achievement Server

This is the server needed for this app: https://github.com/Marcoge/gesterachievementapp

How to setup this server:
- clone git repository
- import into Eclipse as Maven project
- you will need to setup an Apache Tomcat 8.0 within Eclipse to run this application
- you will need a PostgreSQL database running for the application to run
- specify database connection details in src/main/hibernate.cfg.xml
- please make sure database is empty (no tables) and visit the following location with your browser after first start of application: localhost:8080/GesterAchievementServer/webapi/myresource (please adjust if Tomcat is not running on port 8080). This will create the tables and some data in the database.
