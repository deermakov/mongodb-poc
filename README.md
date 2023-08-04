"# mongodb-poc" 

## MongoDB docker image
https://hub.docker.com/_/mongo-express

## MongoDB web console
http://localhost:28081/
(admin / changeme, see docker-compose.yaml)

## Swagger
http://localhost:8090/swagger-ui/index.html

������ �������� �� ������ � ��� ��:
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

������ �������� �� �� ������� �� ������������� �� (�������� id ������������� ��):
```json
{
    "@class": "poc.mongodb.domain.IndividualEntrepreneur",
    "name": "�� ������� 2",
    "individual": {
        "@class": "poc.mongodb.domain.Individual",
        "id": "64ccee1a6a7dce4e3a8a3f4f"
    },
    "selfEmployed": false
}
```
