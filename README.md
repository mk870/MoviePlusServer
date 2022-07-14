# MoviePlus  Server (Backend)
<img src="https://i.ibb.co/Hdq55GW/spring.jpg" alt="spring" border="0" align="center"> 

## Project Summary 
* This  is a Restful Spring boot application with CRUD operations that allow users to create an account to the movieplus app, save or add actors and movies , delete those actors and movies and login and out using spring security.
* It uses  Spring boot with Tomcat server as a framework.
* The app has 10 endpoints namely : /home, /signup, /verifyRegistration, /login, /savemovies, /saveactors, /movies, /actors, /movie/id and /actor/id.
* Uses Spring security and Jwt to secure these endpoints.
* Uses spring boot data jpa (hibernate) to persist data to a mysql database.


### **Resources Used**
***
**Java Version**: 18

**Dependencies**: Jwt Token, Hibernate, Spring security, Java Mail, TomcatServer, lombok, mysql-connector and Spring web.  
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=flat&logo=spring&logoColor=white) 	![JWT](https://img.shields.io/badge/JWT-black?style=flat&logo=JSON%20web%20tokens) 	![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=flat&logo=mysql&logoColor=white)

**For Web Framework Requirements**: pom.xml

**APIs**: None

### **EndPoints Building**
***
Built 3 Controllers, signupController, userActorsController and userMoviesController.
#### **User Account Creation Endpoints:** 
* **/signup (PostMethod)**: Takes in firstname, lastname, password and email for user signup. A Jwt token is created as an authentication tool, its stored on the database and also sent by java mail to user email for verification. The password is encrypted using BCryptPasswordEncoder.

* **/verifyToken  (GetMethod)**: validates the email token against the one on the database, once verified the account is enabled. 
* **/login  (GetMethod)**: A Jwt token is created and returned if user login credentials are valid. 


#### **UserActors Endpoints:**  
* **/saveactors (PostMethod)**:  saves users' actors to the database with all the actor's properties like name, gender, birthday, tmdb_id and birth_place. 
* **/actors (GetMethod)**:  retrieves all the saved actors of a client from the database.
* **/actor/id (DeleteMethod)** : deletes a specific actor by id from the database.

#### **UserMovies Endpoints:**  
* **/savemovies (PostMethod)**:  saves users' movies to the database with all the movie's properties like title, runtime, release_date and tmdb_id. 
* **/movies (GetMethod)**:  retrieves all the saved movies of a client from the database.
* **/movie/id (DeleteMethod)** : deletes a specific movie by id from the database.  

### **Data Storage**
Used Spring data JPA (Hibernate) to persist and retrieve data from a mysql database.  
Built 4 entities: 
* User Entity to store app users.
* VerificationToken Entity to store signup verification tokens.
* UserActors Entity to store favourite actors of users. 
* UserMovies Entity to store favourite movies of users.



### **Productionization**
***
In this step I deployed the mysql database to AWS and deployed the springboot app to Heroku cloud.

**Live Implemantation:** [MoviePlus](https://react-movieplus.netlify.app)
