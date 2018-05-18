# Log Message
This is repository used to store application log message by using Spring-boot, RabbitMQ and ELK Stack (Elasticsearch, Logstash and Kibana)
On this repository, We just develop a simple case.

## Expectation
- Orders (orderNumber, productId, amount)
- The Orders (Json format) will be sent to RabbitMQ when call to the API
- Monitoring data from Kibana

## Main flow
- 1/ POST to API endpoint http://localhost:8080/log/send-message (Go to http://localhost:8080/swagger-ui.html, you will see more detail)
- 2/ Spring-boot sends Order (Json format) to RabbitMQ through "Exchange" and bind to to "Queue".
- 3/ Logstash will ship Order from Queue, then filters and output to Elasticsearch.
- 4/ Elasticsearch indexing data
- 5/ Kibana get data from Elasticsearch to visualization

## Requirements
- Java 8
- Maven 3.5.x
- Spring-boot 2.0.x
- Docker

## Installation
- Git clone
`$ git clone https://github.com/codekooking/log-service.git`
- Start RabbitMQ server and ELK Stack servers
`$ cd ./log-service/docker`
`$ docker-compose up -d`
- Start Spring-boot application
`$ cd ../`
`$ mvn clean install`
`$ mvn spring-boot:run`
- Perform test
You can found postman collection here "./log-service/postman/collection.json"
- Monitoring
	- Kibana: [http://localhost:5601](http://localhost:5601)
	- RabbitMQ Management [http://localhost:15672](http://localhost:15672)

## API documents - Swagger
- Swagger UI: http://localhost:8080/swagger-ui.html
- Swagger API docs: http://localhost:8080/v2/api-docs

## Reference
- http://www.baeldung.com/swagger-2-documentation-for-spring-rest-api