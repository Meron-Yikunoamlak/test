# Safari com exam project documentation
This project demonstrates the implementation of the using Spring Boot 3.0. It includes the following features:

## Features
* All Employee model CRUD Operations
* Each question codes and function within their classes 	respectively

## Technologies
* Spring Boot 3.0
* Spring JPA
* Maven
* Lombok plugin
* Swagger API Documentation
 
## Getting Started
To get started with this project, you will need to have the following installed on your local machine:

* JDK 17+
* Maven 3+
* Postgresql 13+
* Docker (not necessary but i include a docker file so that you won't have to install postgress)


## NOW this are the questions answers one by one
Q1.d -> Remove methode is faster in linked list than in array b/c in linked list data are ordered in
        LIFO format (Last in first out format)
Q2.e -> The d/ce between equal method and equality operator is
        equals() method is used for compering string values
        whereas  equality operator used for compering objects, numbers or for checking nullability of an object
Q1.f -> The d/ce between method Overloading and method Overriding
        overriding -> method signature should be the same. like same return type,same parameters and same method name
        overloading -> method signature shouldn't be the same but method names should be.
Q1.g -> The d/ce between Inheritance and Abstraction
        Inheritance -> is the relation b/n parent class and child class.
                        the child class can inherit some or all methods in the parent class.
                        used to minimize redundancy of code.
        Abstraction -> used to hide details of a method. it gives a general overview of a method.








To build and run the project, follow these steps:

* Clone the repository: `git clone https://github.com/Meron-Yikunoamlak/SafariComExam.git`
* Navigate to the project directory: cd SafariComExam
* Build the project: mvn clean install
* Run the project: mvn spring-boot:run 

-> The application will be available at http://localhost:8083.
-> And the swagger api documentation will appeared at http://localhost:8083/swagger-ui/index.html.

