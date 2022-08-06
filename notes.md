## Goal
create a web scraper which can personalize keywords by kafka microservices with spring boot, MySQL
dockerize and deploy on aws

## kafka microservices
https://www.youtube.com/playlist?list=PLGRDMO4rOGcOlnu6QhogZDNFFwiwKh5X9

### install Kafka
https://kafka.apache.org/quickstart \
1. download .tgz file from website. extract
2. cmd in Kafka folder, start ZooKeeper server
    .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties 
    (ctrl-c twice to exit)
3. new cmd in Kafka folder, start Kafka server, port: 9092
    .\bin\windows\kafka-server-start.bat .\config\server.properties
    (ctrl-c twice to exit)
4. new cmd in Kafka folder, create topic
    .\bin\windows\kafka-topics.bat --create --topic topic-example --bootstrap-server localhost:9092
5. write event into topic
    .\bin\windows\kafka-console-producer.bat --topic topic-example --bootstrap-server localhost:9092
    >hello world
    >topic example 
    (ctrl-c to exit)
6. read event (similar to comsumer)
    .\bin\windows\kafka-console-consumer.bat --topic topic-example --from-beginning --bootstrap-server localhost:9092
    hello world
    topic example

## create 5 microservices
### create spring app in vscode
1. install Maven: https://phoenixnap.com/kb/install-maven-windows
2. install spring boot app dev extension pack
3. use Spring Initialz or https://start.spring.io/ to create spring app
    dependence: lomba, web, kafka, (Mysql, JPA)

### config app
1. set server.port in application.properties

### create DTO class and event
1. payload: info transfer by REST api \
payload can be in Json format \
spring transfer Json payload to DTO \
business layer transfer DTO to entity \
save entity to database \
2. create AccountEvent to send Account(DTO) to Kafka, AccountEvent is payload, send AccountEvent to Kafka

### make register-service as Kafka producer
    open zookeeper and kafka server
    config application.properties
    add dependency to base-domins
    create KafkaTopicConfig.java
    create AccountProducer.java

### make store-service as Kafka consumer
    add dependency to base-domins
    config application.properties
    create AccountConsumer.java

## create REST api
1. RegisterController.java
2. use py_client in DRFApi project to send request
3. use cmd in Kafka folder to read
    .\bin\windows\kafka-console-consumer.bat --topic topic-example --from-beginning --bootstrap-server localhost:9092

