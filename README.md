An Application that show customer phone numbers list.

You can search by filters like : country name , country code and phone. 

Search button is used to do search action & reset button is to clear filtration
 
To Build The application using Docker :
1) Build docker image using the following command : docker build --tag=phone-numbers:latest .
2) Run docker container using the following command : docker run -p8080:8080 --name=phone-numbers phone-numbers:latest
3) To run container in background mode use :  docker run -d -p8080:8080 --name=phone-numbers phone-numbers:latest