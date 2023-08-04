"# mongodb-poc" 

## MongoDB docker image
https://hub.docker.com/_/mongo-express

## MongoDB web console
http://localhost:28081/
(admin / changeme, see docker-compose.yaml)

## Swagger
http://localhost:8090/swagger-ui/index.html

Пример ИП:
```json
{
    "@class": "poc.mongodb.domain.IndividualEntrepreneur",
    "name": "ИП Бахарев",
    "individual": {
        "@class": "poc.mongodb.domain.Individual",
        "fio": "Бахарев Петр Петрович",
        "address": {
            "fullAddress": "Москва, 113327"
        }
    },
    "selfEmployed": true
}
```

Пример ФЛ:
```json
{
    "@class": "poc.mongodb.domain.Individual",
    "fio": "Иванов Иван Иваныч"
}
```