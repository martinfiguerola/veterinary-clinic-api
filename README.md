# Veterinary Clinic Rest Api

A veterinary clinic has a system where it has two classes:
Pet and Owner.
Each pet can have only one owner associated as responsible.
 


### Database Schema
```
Pet, with the attributes:
* id
* name,
* species
* breed
* color

Owner, with the attributes:
* id
* name
* lastname
* phoneNumber  

```

### Features
As the clinic will soon want to have a web application and a mobile application that can consult the same backend,
it is necessary to create an API that is capable of:

    1. Create CRUD of pets
    2. Create CRUD of owners
    3. Get the list of all pets of the species “dog” and breed “poodle”
    4. Get a list of the following combined data for a pet and its owner:
        - pet_name
        - species
        - breed
        - owner_name
        - owner_lastname
    5. For this last requirement, consider using the DTO pattern to create the corresponding response.git 

### Topics implemented
To implement each of the endpoints, consider the corresponding HTTP methods according to the action that needs to be carried out.
At the same time, consider the use of DTOs for the responses and all the good practices that you think can be applied.
Use JPA + Hibernate for the CRUD of data in a MySQL database.