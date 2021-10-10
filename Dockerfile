FROM openjdk:11-jre-slim
WORKDIR /app
COPY . /app/

RUN  apt update &&  apt install maven --no-install-recommends -y

RUN mvn flyway:migrate
ENTRYPOINT ["mvn","spring-boot:run"]

#ADD target/gig-platform-0.0.1-SNAPSHOT.jar /home/gig-platform.jar
#ENTRYPOINT ["java","-jar","/home/gig-platform.jar"]
