# Katalon API & Kafka Automation
---

## Part 1 – REST API Testing

API used:
https://gorest.co.in/public/v2

### Test Coverage
- Create User (POST)
- Get User (GET)
- Update User (PUT)
- Delete User (DELETE)

### How to Run API Test

1. Open project in Katalon
2. Set token in:
   Profiles → default

Example:
BASE_URL = https://gorest.co.in/public/v2  
TOKEN = your_actual_token  

3. Run Test Suite
---

## Part 2 – Kafka Consumer Testing

Kafka is running locally using Docker.  
Katalon acts as a consumer and validates the message payload.

### Start Kafka (Docker)

Start Zookeeper:
docker run -d --name zookeeper -p 2181:2181 wurstmeister/zookeeper

Start Kafka:
docker run -d --name kafka -p 9092:9092 \
-e KAFKA_ZOOKEEPER_CONNECT=host.docker.internal:2181 \
-e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://localhost:9092 \
-e KAFKA_LISTENERS=PLAINTEXT://0.0.0.0:9092 \
wurstmeister/kafka

Verify:
docker ps

---

### Produce Test Message

docker exec -it kafka bash

kafka-console-producer.sh --topic test-topic --bootstrap-server localhost:9092

Send:
{"event":"user_created","userId":123}

---

### Run Kafka Test or Test Suite

Expected result:
Message is consumed and validated successfully.

---
