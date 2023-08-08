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

Отношение Deal : Party = M:N (Party.deals - Deal.participants), отсюда циркулярная зависимость этих java-бинов и stack overflow в Jackson при их сериализации в JSON.

Для устранения этой проблемы логично не считывать соответствующие данные при выборке, но например через projections это не получится:<br>
в документации сказано "_Projections must not be applied to DBRefs_",
и если всё-таки попробовать сделать такую логику в repository

`@Query(value = "select d from Deal d", fields = "{'participants.inn': 0 }")
List<Deal> findAll();`<br>
то будет exception "_Invalid path reference participants.inn; Associations can only be pointed to directly or via their id property_".
Очевидно, это потому, что у нас Deal.participants считывается через `@DocumentReference`

Поэтому примемен костыль - очистка данных уже после считывания, см. `MongoDbAdapter.getAllParties()` и `MongoDbAdapter.getAllDeals()`,
а на java beans навешена аннотация `@JsonInclude(JsonInclude.Include.NON_NULL)`, чтобы пустые поля не светились.