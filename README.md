# ParkingLotApplication
Parking Lot Microservice Application

### How to run application using Docker:

###### Step 1:
open a new terminal session in the directory of each Springboot app (ParkingLot, StatisticsService, TicketingService) and run the following command in each one:
- " mvn package "

build a docker image for these 3 spring boot applications by using the following commands on the directory of each app:
- " docker build -t parking-lot-app-docker . "
- " docker build -t ticketing-service-docker . "
- " docker build -t statistics-service-docker . "

OR
pull the images from the Docker Hub repo: https://hub.docker.com/repository/docker/atabbal/parking-lot-app
###### Step 2:
Go to the root directory of the project where docker-compose.yml is located and run the following command:
- "docker-compose up -d"

###### Step 3:
Docker will create 4 containers including the PostgreSQL container and run them.

###### Step 4:
You will be able to start your http requests to the services.


### How to run application in another way:
In each of the 3 Sprint Boot application, there is target folder that contains the .jar file

###### Step 1:
open a new terminal session on each application target directory, and run the following command: "java -jar <jarfilename>.jar"

###### Step 2:
After that each application has executed successfully, you will be able to start your http requests to the services.