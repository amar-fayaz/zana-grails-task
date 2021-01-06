Coding Task for Zana Tech Using GRAILS.
=================

Tasks
-----
1. Model 2 Domain Classes `Entity` and `Content` linked to each other in a one-to-many relationship
2. Add Examples
3. CRUD operations via REST Interface


**Grails Version -> 4.0.5**

Instructions
------------
1. git clone <link>
2. cd coding-challenge
3. `> grails run-app`
4. Open http://localhost:8080 in your browser
5. The links to `Entity`, `Content` and `Synonym` Controller Scaffold view are available in the landing page. 
6. A couple of example data is already available.


Description
-----------
Represented the problem as a relationship between Author (Entity), Book (Content) and Genre (Synonym). The names of the classes are kept as in the problem
statement for easy cross checking. There are currently two controllers - one for the scaffold view and one for the REST Interface (the documentation in the GRAILS
website is obscure about how to use them both together. Tried multiple ways and eventually kept it like this). As a result the links available are
* Entity  
    - localhost:8080/entity (Scaffold)
    - localhost:8080/entities (REST)

* Content  
    - localhost:8080/content (Scaffold)
    - localhost:8080/contents (REST)

* Synonym 
    - localhost:8080/synonym (Scaffold)
    - localhost:8080/synonyms (REST)

The REST links also allows for data to be linked via their name/title even if the ID is not provided. For POST and PUT actions, if one exists an object will be linked, else a new one will be created.

Testing the REST API
--------------------
Perform the following commands:  

### POST 
*  `curl -X POST -H 'Content-Type: application/json' -i http://localhost:8080/entities --data '{"title":"JK Rowling", "description":"1965", "contents":[{"title":"Harry Potter and the Philosophers Stone", "description":"1997"}], "synonyms":[{"name":"Children"}, {"name":"Novel"}, {"name":"Series"}]}' `   
Result: Adds a new Author(Entity) with a Book(Content). Genres(Synonym) *Children* and *Novel* already exists, so it just links to those and a new Genre *Series* is created

### GET
*  `curl -X GET -i http://localhost:8080/contents/3`  
Result: Gets the Book(Content) object with ID:3

### PUT
*  `curl -X PUT -H 'Content-Type: application/json' -i http://localhost:8080/entities/1 --data '{"synonyms": [{"name": "Children"}, {"name": "Novel"}]}'`  
Result: Adds the provided Genres(Synonym) to the the entity of ID:1. Since the Genres alread exist, they'll just be linked

### DELETE
*  `curl -X DELETE -i http://localhost:8080/contents/2`  
Result: Deletes the Book with ID:2. The other Objects and Links stay in place

#### The changes can be observed through the scaffold links.


Known Issues
------------
1. Multiple links for scaffold and REST
2. Adding Items via the scaffold view works inconsistently, with genres not showing up. (Investigated and found that the many to many mapping between Genre and Author is the issue. Haven't found a fix yet. The Genres will show up and work perfectly when added from the REST APIs)
3. Tried playing around with Authentication using the `spring-security-core`. Worked well with the scaffold view but authentication via REST API did not work.

