## *All test performed in Postman*

### User Sign Up
Method **POST**


<http://localhost:8080/api/signup>

```json
{"username": "donald", "password": "trump"}
```
***

### Login
Method **POST**
 
<http://localhost:8080/api/login>

**Body**  

```json
{"username": "donald", "password": "trump"}
```

***

### Logout

Method **GET**

<http://localhost:8080/api/logout>


***

### CRUD on Profiles

### Get All Profiles
Method **GET**

<http://localhost:8080/api/profiles>

***

### GET Profile by Id
Method **GET**

<http://localhost:8080/api/profiles/{id}>

***

### Create New Profile
Method  **POST**
 
<http://localhost:8080/api/profiles>

```json
   {
        "username": "DELL_ISRAEL",
        "user_type": "company",
        "languages": "English, Hebrew",
        "residence": "BeerSheva",
        "linkedin": "-",
        "phone": "+972 73 243 4233",
        "birthday": 19778400000,
        "company_name": "DELL ISRAEL",
        "password": "DELL321",
        "website": "www.DELLcom",
        "country": "Israel",
        "city_town": "BeerSheva",
        "street": "Yeelim Street",
        "house_building": "13",
        "postcode": "678654",
        "position": "Technical Manager",
        "lastName": "Eric",
        "firstName": "Cartman",
        "email": "Eric.Cartman@southpark.com"
    }
```
 
***

### Update existing Profile
Method **PUT**

<http://localhost:8080/api/profiles/{id}>

```json
{
        "id_user": 4,
        "username": "DELL_ISRAEL",
        "user_type": "company",
        "languages": "English, Hebrew",
        "residence": "BeerSheva",
        "linkedin": "-",
        "phone": "+972 73 243 4233",
        "lastName": "Eric",
        "firstName": "Cartman",
        "email": "Eric.Cartman@southpark.com",
        "birthday": 19778400000,
        "company_name": "DELL ISRAEL",
        "password": "DELL321",
        "website": "www.DELLcom",
        "country": "Israel",
        "city_town": "BeerSheva",
        "street": "Yeelim Street",
        "house_building": "13",
        "postcode": "678654",
        "position": "Technical Manager"
    }

```
    
***    
    
### Delete existing Profile by Id
Method **Delete**

<http://localhost:8080/api/profiles/{id}>

***

### Delete All Profiles
Method **Delete**

<http://localhost:8080/api/profiles/>
