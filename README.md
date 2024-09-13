# CQRS Pattern

This project implements a CQRS pattern using Kafka for event streaming, PostgreSQL for data storage, Elasticsearch for querying, and Avro for serialization. It is built using Spring Boot and follows Domain-Driven Design (DDD) principles.

## Project Structure

````
com.semihtumay.cqrspattern
│
├── application
│   ├── command
│   │   ├── CreateProductCommand.java
│   │   ├── UpdateProductCommand.java
│   │   └── ProductCommandHandler.java
│   ├── query
│   │   ├── dto
│   │   │   └──ProductResponse.java
│   │   ├── mapper
│   │   │   └──ProductMapper.java
│   │   └── ProductQueryHandler.java
│   └── event
│       ├── ProductCreatedEvent.java
│       └── ProductUpdatedEvent.java
│
├── domain
│   ├── Product.java
│
├── infrastructure
│   ├── repository
│   │   └── ProductRepository.java
│   ├── event
│   │   └── KafkaEventPublisher.java
│   │   └── ProductEventListener.java
│   ├── elasticsearch
│   │   ├── ElasticsearchService.java
│   │   └── ElasticsearchConfig.java
│
└── api
    ├── ProductController.java

````

## Technologies Used

- **Java 21**
- **Spring Boot 3.3.3**
- **Apache Kafka**
- **Elasticsearch**
- **Avro (for event serialization)**
- **PostgreSQL**
- **Docker**

## API Endpoints

1) Create a Product
````
POST /api/v1/products

{
  "name": "test",
  "price": 20000,
  "stock": 50
}

````
2) Update a Product

````
PUT /api/v1/products/{id}

{
  "name": "test",
  "price": 22000,
  "stock": 45
}


````
3) Get a Product by ID
````
GET /api/v1/products/{id}
````

4) Search Products by Name
````
GET /api/v1/products/search?name=iphone
````


## Avro Integration

Avro is used to serialize product events before publishing to Kafka. The events are stored in a compact binary format, making it efficient for message streaming.

Example Avro schema:

````
{
  "type": "record",
  "name": "ProductCreatedEvent",
  "namespace": "com.semihtumay.cqrspattern.application.event",
  "fields": [
    {"name": "id", "type": "string"},
    {"name": "name", "type": "string"},
    {"name": "price", "type": "string"},
    {"name": "stock", "type": "int"}
  ]
}


````

````
{
  "type": "record",
  "name": "ProductUpdatedEvent",
  "namespace": "com.semihtumay.cqrspattern.application.event",
  "fields": [
    { "name": "id", "type": "string" },
    { "name": "name", "type": ["null", "string"], "default": null },
    { "name": "price", "type": ["null", "string"], "default": null },
    { "name": "stock", "type": ["null", "int"], "default": null }
  ]
}
````

## Getting Started

### Step 1: Clone the Repository

```bash
git clone https://github.com/Semihtumay/cqrs-pattern.git
cd cqrs-pattern
```

### Step 2: Set Up Docker
Ensure Docker is installed and running on your system. Then, start the services:

```bash
docker-compose -f docker-compose.yml up -d
```

This will start the following services:

- **Zookeeper: Coordinates distributed Kafka brokers.**
- **Kafka: Message broker for product events.**
- **Schema Registry: Manages Avro schemas.**
- **Kafka UI: Interface for managing Kafka topics.**
- **PostgreSQL: Database for product information.**
- **Elasticsearch: Search engine for querying product data.**

````
version: '3'
services:
  zookeeper:
    image: confluentinc/cp-zookeeper:latest
    container_name: zookeeper
    ports:
      - "2181:2181"
    environment:
      ZOOKEEPER_CLIENT_PORT: 2181
      ZOOKEEPER_TICK_TIME: 2000
    networks:
      - my-network

  broker:
    image: confluentinc/cp-kafka:latest
    container_name: broker
    ports:
      - "9092:9092"
    depends_on:
      - zookeeper
    environment:
      KAFKA_BROKER_ID: 1
      KAFKA_ZOOKEEPER_CONNECT: 'zookeeper:2181'
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://broker:29092,PLAINTEXT_HOST://localhost:9092
      KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: PLAINTEXT:PLAINTEXT,PLAINTEXT_HOST:PLAINTEXT
      KAFKA_INTER_BROKER_LISTENER_NAME: PLAINTEXT
      KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1
    networks:
      - my-network

  schema-registry:
    image: confluentinc/cp-schema-registry:latest
    hostname: schema-registry
    container_name: schema-registry
    depends_on:
      - broker
    ports:
      - "8081:8081"
    environment:
      SCHEMA_REGISTRY_HOST_NAME: schema-registry
      SCHEMA_REGISTRY_KAFKASTORE_BOOTSTRAP_SERVERS: broker:29092
      SCHEMA_REGISTRY_LISTENERS: http://0.0.0.0:8081
    networks:
      - my-network

  kafka-ui:
    image: provectuslabs/kafka-ui:latest
    container_name: kafka-ui
    ports:
      - "8080:8080"
    environment:
      KAFKA_CLUSTERS_0_NAME: broker
      KAFKA_CLUSTERS_0_BOOTSTRAPSERVERS: broker:29092
      KAFKA_CLUSTERS_0_ZOOKEEPER: zookeeper:2181
    networks:
      - my-network

  elasticsearch:
    image: docker.elastic.co/elasticsearch/elasticsearch:8.15.1
    environment:
      - discovery.type=single-node
      - validate_after_inactivity=0
      - max_open_files=65536
      - max_content_length_in_bytes=100000000
      - transport.host=elasticsearch
      - xpack.security.enabled=false
    volumes:
      - $HOME/app:/var/app
    ports:
      - "9200:9200"
      - "9300:9300"
    networks:
      - my-network

  postgresql:
    image: postgres:11.1-alpine
    container_name: postgresql
    environment:
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: 210821
      POSTGRES_DB: cqrs_db
    ports:
      - "5432:5432"
    networks:
      - my-network

networks:
  my-network:
    driver: bridge

````

### Step 3: Build and Run the Application
Ensure Docker is installed and running on your system. Then, start the services:

```bash
./mvnw clean install
./mvnw spring-boot:run
```