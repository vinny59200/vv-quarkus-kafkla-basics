Quarkus Kafka Quickstart
========================

This project illustrates how Quarkus applications can interact with Apache Kafka using MicroProfile Reactive Messaging.

## Start the application
Launch kafka and zookeeper in Docker
```bash
docker run -p 2181:2181 -p 9092:9092 -e ADVERTISED_HOST=127.0.0.1  -e NUM_PARTITIONS=10 johnnypark/kafka-zookeeper
```

### Launch producer app
Open a terminal (Alt+ F12)
Go to consumer folder: 
```bash
cd ./producer
```
Launch the app: 
```bash
mvn quarkus:dev
```

### Launch consumer app
Open a terminal (Alt+ F12)
Go to consumer folder: 
```bash
cd ./consumer
```
Launch the app: 
```bash
mvn quarkus:dev
```
