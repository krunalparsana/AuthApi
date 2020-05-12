# AuthAPi

### Prerequisites
* java 1.8.x
* maven 3.x

### Steps To Setup

**1. Clone the repository**
```bash
    git clone https://github.com/krunalparsana/AuthApi
```

**2. Build project**
```bash
    mvn clean install
``` 

**3. Run project** 
```bash
    java -jar target/AuthApi-0.0.1-SNAPSHOT.jar
``` 
- OR-
```bash
    mvn spring-boot:run
```

**4. Open url**  
  
Open following url.
```
   http://localhost:8080/static/index.html 
```

  ## Explore apis 

The app defines following APIs. 
 
```   
    POST /signup   
    POST /login  
    GET /dummy    
    GET /logout
```

#### /signup API
* Use following body in signup api
```json
    {
      "email" : "Your valid email",
      "password" : "Your password"
    }
```
* In this body email should be valid 
* Email will be unique field in database


#### /login API
* Use following body in login api
```json
    {
      "email" : "Your email",
      "password" : "Your password"
    }
```
* Here email will be your registered email.
* API does not need authentication

#### /logout API
* This  will destroy your session and logout user

#### /dummy API
* This  will return ` 200 OK ` if authenticated
