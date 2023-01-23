

<h1 align="center">
<img src="https://img.freepik.com/premium-vector/quiz-logo-with-speech-bubble-icon_149152-812.jpg?w=2000" width="300">
</h1><br>

# 🤯 Quiz server applying Mysql and Spring Boot with JPA

[![Code style: black](https://img.shields.io/badge/code%20style-black-000000.svg)](https://github.com/psf/black)

## 🔩  How install the server

```sh
docker network create app-spring
cd MvanProject/Service/mysql/
docker build -t mysql-spring .
docker run -d --name mysql-spring --network app-spring mysql-spring:latest
cd ..
cd quiz/
docker build -t app-spring .
docker run --rm -it --name app-spring -p 8080:8080 --network app-spring app-spring:latest
```

## 🔎 Search

| Search Type     | Command      | Result     |
| ------------- | ------------- | -------- |
| GET          | http://localhost:8080/preguntas         | Every answer and question of the Quiz  |
| GET           | http://localhost:8080/preguntas/<something>         | All questions with the indicated word are displayed  |
| DELETE           | http://localhost:8080/<ID>         | The question containing that ID will be deleted  |
| POST - PUT           | http://localhost:8080/         | Questions can be introduced or updated  |


