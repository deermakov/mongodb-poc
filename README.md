"# mongodb-poc" 

## MongoDB docker image
https://hub.docker.com/_/mongo-express

## MongoDB web console
http://localhost:28081/
(admin / changeme, see docker-compose.yaml)

## Swagger
http://localhost:8090/swagger-ui/index.html

������ ��:
```json
{
    "@class": "poc.mongodb.domain.IndividualEntrepreneur",
    "name": "�� �������",
    "individual": {
        "@class": "poc.mongodb.domain.Individual",
        "fio": "������� ���� ��������",
        "address": {
            "fullAddress": "������, 113327"
        }
    },
    "selfEmployed": true
}
```

������ ��:
```json
{
    "@class": "poc.mongodb.domain.Individual",
    "fio": "������ ���� ������"
}
```