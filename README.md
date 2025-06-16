# Sprint 2 - Advanced Programming & Mobile Dev

## Integrantes do grupo:

- **Caio Caram de Souza** - RM: 552248
- **Isabella Ventura Diaz** - RM: 551793
- **Lucas Gabriel Gianini Moreira** - RM: 99921
- **Maria Eduarda de Carvalho Goda** - RM: 552276
- **Maria Eloisa da Silva Santos** - RM: 552294

## Como executar o projeto


1. Utilize a versão 24 do Java

2. Execute o comando para executar o programa:

<br>

```bash
mvn spring-boot:run
```

## Endpoints do projeto

- **POST** `/api/readings` - Salva nova leitura (sensorId, valor, timestamp)

- **GET** `/api/readings` - Lista todas leituras

- **GET** `/api/readings/{sensorId}` - Filtra por sensor

## Exemplos de requisição curl

### Salvar nova leitura
```bash
curl -X POST http://localhost:8080/api/readings \
  -H "Content-Type: application/json" \
  -d '{
    "sensorId": "sensor1",
    "valor": 40,
    "timestamp": "2025-04-15T10:30:00"
  }'
```

### Listar todas as leituras

```bash
curl -X GET http://localhost:8080/api/readings
```

### Filtrar leituras por sensor

```bash
curl -X GET http://localhost:8080/api/readings/1
```

## Localização do arquivo do banco de dados H2 Database

```
data/readings.mv.db
