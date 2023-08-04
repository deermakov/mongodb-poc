"# mongodb-poc" 

## MongoDB docker image
https://hub.docker.com/_/mongo-express

## MongoDB web console
http://localhost:28081/
(admin / changeme, see docker-compose.yaml)

## Swagger
http://localhost:8090/swagger-ui/index.html

Пример создания ИП вместе с его ФЛ:
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

Пример создания ИП со ссылкой на существующего ФЛ (подставь id существующего ФЛ):
```json
{
    "@class": "poc.mongodb.domain.IndividualEntrepreneur",
    "name": "ИП Бахарев 2",
    "individual": {
        "@class": "poc.mongodb.domain.Individual",
        "id": "64ccee1a6a7dce4e3a8a3f4f"
    },
    "selfEmployed": false
}
```
