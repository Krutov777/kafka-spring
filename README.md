# Apache kafka + Spring Boot

### Installation:

##### install link apache kafka 2.13-2.6.0:
```
https://kafka.apache.org/downloads
```

### Start the kafka environment:

##### Go to kafka directory from terminal:
```bash
$ cd kafka 2.13-2.6.0
```

##### Start the ZooKeeper service
```bash
$ bin/zookeeper-server-start.sh config/zookeeper.properties
```

##### Start the Kafka broker service
```bash
$ bin/kafka-server-start.sh config/server.properties
```
