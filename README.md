## Search Engine Walmart Application

This project is an implementation of 'Desafio Walmart' and was made by 3 separate Docker containers that holds:

- MongoBD
- Spring Boot
- Angular

The entry point for a user is a website which is available under the
address: **http://localhost:4200/**

---

### Prerequisites

In order to run this application you need to install two tools: **Docker** & **Docker Compose**.

Instructions how to install **Docker** on [Ubuntu](https://docs.docker.com/install/linux/docker-ce/ubuntu/), [Windows](https://docs.docker.com/docker-for-windows/install/) , [Mac](https://docs.docker.com/docker-for-mac/install/) .

**Docker Compose** is already included in installation packs for *Windows* and *Mac*, so only Ubuntu users needs to follow [this instructions](https://docs.docker.com/compose/install/) .


### How to run it?

An entire application can be ran with a single command in a terminal:

```
$ docker-compose up -d
```

If you want to stop it use following command:

```
$ docker-compose down
```


---

#### mongodb (Database)
After running the app it can be accessible using this connectors:

- Database: *promotions*
- User: *productListUser*
- Password: *productListPassword*

Like other parts of application Mongo database is containerized and
the definition of its Docker container can be found in
*docker-compose.yml* file.

#### search-product-app (REST API)

This app is also put in Docker container and its definition can be found
in a file *search-product-ms/Dockerfile*. 


#### search-engine-front (Frontend)

This is a real endpoint for a user where they can search their favorite products. It consumes the REST API endpoints provided by
*search-product-app*.

It can be entered using link: **http://localhost:4200/**

Reference Image:
![Reference Image](https://github.com/mbalmaceda/prueba-walmart/blob/master/search-engine-front/src/assets/search-engine-walmart.png?raw=true)