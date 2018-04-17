# Micro-Service-Me-Up

> APPLIED PROJECT AND MINOR DISSERTATION

> Author: [Tangqi Feng](https://tangqifeng.github.io/) & Eduards Vagals

> Advised by:  Dr. Brian McGinley

## Feature Demo Video
[YouTube link](https://youtu.be/8Ow0CRWHyyU)

## Technology Review
![tech_img](https://user-images.githubusercontent.com/22374434/38877480-aec7b9b6-4256-11e8-9462-19d958487dc2.png)

## General Installations:

* Back-end installation requirements

  * [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) – programming language to develop, compile and run back-end microservices.

* Development tools installation requirements
  
  * [Maven](https://maven.apache.org/install.html) – package manager and versioning control tool for Java platform applications. Installs necessary project dependencies via POM.xml configuration file. Builds Java executable jars.
  
  * [Docker](https://docs.docker.com/install/) – automation tool for independent application deployment within isolated Linux instances inside Docker containers. Installs necessary application dependencies through Docker file or using Maven package manager where applicable.
  
  * [Git](https://git-scm.com/downloads) – project versioning control and collaborative tool for developing iterative projects within a group or solo. 
  
  * Maven packaging – microservices applications packaging commands.
  
    Run the following command in CLI within project root directory where POM.xml is located:

    ```$ mvn package -Dmaven.test.skip=true docker:build```

    NB: Maven creates Docker image for projects with Docker plugin in POM.xml

    Read our manual in [Wikis](https://github.com/TanqEdPublic/Micro-Service-Me-Up/wiki/Docker)
  
  * Docker deployment – running image in local environment differs from Cloud.

    ```$ docker run --name=ProjectName -p 8080:8080 -t ImageName```

* Front-end

  AngularJS + Spring – everything is done through Maven packaging and Docker deployment. Instructions above.

  ReactJS + libraries – requirements to develop and run ReactJS client application
  
  * First need to install [NodeJS](https://nodejs.org/en/)
  
    Setting up React base
    ``` $ npm install -g create-react-app ```
    ``` $ create-react-app my-app-name ```

    Downloading dependency libraries
    ``` $ npm install react-router –save ```
    ``` $ npm install react-router-dom –save ```
    ``` $ npm install bootstrap –save ```
    ``` $ npm install jquery –save ```
    ``` $ npm install popper.js –save ```
    ``` $ npm install reactstrap –save ```

    Run application
    ``` $ npm start ```
  
  * [Python](https://www.python.org/downloads/) – install Python 3+ for developing and running TanqEd OpenID platform.
    
    Python Flask + libraries for local developmen
    ``` $ pip3 install Flask ```
    ``` $ pip3 install requests ```
    
    Deploying with Docker will install necessary Python libraries through requirements.txt file.
    
    Run normal Docker command to create an image
    ``` $ docker build -t my-python-flask-image:lates . ```
    
    NB: don’t forget ‘.’ , a dot, indicating Docker file is in current directory.
    
  * Docker deployment

    Creating containers from images
    ``` $ docker run –name=ContainerName -p 8080:8080 -t ImageName ```
    NB: automatically will start the container 

    Start container manually
    ``` $ docker start ContainerName ```

    Stop container
    ``` $ docker stop ContainerName ```

    Enter console of the running container
    ``` $ docker attach ContainerName ```

* Cloud Development Site Instructions

  These instructions are related to software installation on Linux Centos instances hosted by AWS.
   
  * Back-end / Front-end development tools
    
    [Docker](https://docs.docker.com/install/linux/docker-ce/centos/) – installing Docker on Linux Centos 

    Docker command sequency to push images to Dockerhub
    
    1.Create a copy of an image for desired Dockerhub account
    
    ``` $ docker tag discovery tanqed/discovery:latest ```
    
    2.Push image to Dockerhub
    ``` $ docker push tanqed/discovery:latest ```

    Docker command to pull images from Dockerhub
    ``` $ docker pull tanqed/discovery:latest ```

    Docker command to create and start a new Java Spring application container in AWS
    
    ``` $ docker run -d –name ContainerName -e JAVA_TOOL_OPTIONS="-Dspring.profiles.active=aws" –-new="host" ```
    
  * [Maven](https://maven.apache.org/install.html) – Same usage as in local development environment
  * [Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git) – Same usage as in local development environment





  


  
  


