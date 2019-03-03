# Run the service with the db container
mvn clean compile package spring-boot:run -Pinclude-docker -Dspring.profiles.active=local -DskipTests

# Run the tests 
mvn clean compile test 
