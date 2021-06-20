### App for moving data form kafka topic to postgres database table with apache camel.

---
#### Used technologies
- Apache Kafka
- Apache Camel
- Apache Camel Jpa

---
#### Flow

Kafka -> Camel Mapping -> PostgreSql

---
#### Environment:
- docker env can be found in `docker-compose.yaml` file
- control-center was added to env for cluster monitoring, \
  so cluster state can be checked by `http://localhost:9021/clusters` url.
  
---
---
#### Test scenario:
1. Run docker environment:
   ```
   docker compose up -d
   ```
   
2. Change local path to `superheroes.txt` in `produce-data.sh`

3. Produce test data to kafka topic:
   ```
   sh produce-data.sh
   ```
   
4. Run camel-kafka-jpa application

Result can be checked in `superheroes` table in local postgreSQL db.

**DB properties**:
```
url: jdbc:postgresql://localhost:5432/postgres
Username: super
Password: pas
```
