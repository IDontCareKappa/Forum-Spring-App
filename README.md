<h1  align='center'>Forum</h1>

## Key features
* Adding posts
* Edditing posts
* Deleting posts
* Authentication via Spring Security
* Preview of a every post in the forum
* Contact page with map and marked place
* Each post contains information about its author and creation date

## Technologies used to develop application
* Backend
  - Java
  - Spring Boot
  - Hibernate
  - Spring Security
  - H2/JPA
  - DevTools
  - Lombok
* Frontend
  - Thymeleaf
  - Bootstrap
  - HTML
  - CSS
  - OpenStreetMap/Leaflet
* Tools
  - IntelliJ IDEA

## Available endpoints

```
  [Home Page, all posts]  localhost:8080
  [Single post]           localhost:8080/post/{id}
  [New post form]         localhost:8080/addpost
  [Edit post]             localhost:8080/edit/{id}
  [Contact Page]          localhost:8080/contact
  [Logout]                localhost:8080/logout
  [Login]                 localhost:8080/login
```

## How it looks

<h3 align="center">Main page when the user is logged in</h3>
<img src="https://i.imgur.com/Zmg2jQd.png">

<h3 align="center">Post preview</h3>
<img src="https://i.imgur.com/2HBfmbI.png">

<h3 align="center">Edit post page</h3>
<img src="https://i.imgur.com/C73vpSj.png">

<h3 align="center">Contact page</h3>
<img src="https://i.imgur.com/tEXMxjy.png">

<h3 align="center">Main page when the user is not logged in</h3>
<img src="https://i.imgur.com/8otAEJh.png">
