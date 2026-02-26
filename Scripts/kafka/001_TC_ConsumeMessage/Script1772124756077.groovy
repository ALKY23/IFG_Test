import groovy.json.JsonSlurper
import kafka.KafkaConsumerHelper

def topic = "test-topic"

def message = KafkaConsumerHelper.consumeMessage(topic)

println("Received: " + message)

assert message != null : "No message received from Kafka topic: ${topic}"

def json = new JsonSlurper().parseText(message)

assert json.event == "user_created" : "Event mismatch"
assert json.userId == 123 : "UserId mismatch"

println("Kafka message validated successfully.")