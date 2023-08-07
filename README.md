"# mongodb-poc" 

## MongoDB docker image
https://hub.docker.com/_/mongo-express

## MongoDB web console
http://localhost:28081/
(admin / changeme, see docker-compose.yaml)

## Swagger
http://localhost:8090/swagger-ui/index.html

1. Пример создания ИП вместе с его ФЛ:
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

2. Пример создания ИП со ссылкой на существующего ФЛ (подставь id существующего ФЛ):
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
3. Пример создания сделки вместе с участниками
```json
{
    "number": "Сделка-1",
    "amount": 11.22,
    "participants": [
        {
            "@class": "poc.mongodb.domain.LegalEntity",
            "name": "ООО Ромашка",
            "inn": "111222",
            "address": {
              "fullAddress": "Москва, 113327"
            }
        },
        {
          "@class": "poc.mongodb.domain.Individual",
          "fio": "Остап Бендер",
          "inn": "999000",
          "address": {
            "fullAddress": "Одесса, 123"
          }
        }
    ]
}
```
4. сс