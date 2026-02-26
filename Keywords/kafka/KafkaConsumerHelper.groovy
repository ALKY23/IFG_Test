package kafka

import java.time.Duration

import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.serialization.StringDeserializer

class KafkaConsumerHelper {

	static String consumeMessage(String topic) {

		Properties props = new Properties()
		props.put("bootstrap.servers", "localhost:9092")
		props.put("group.id", "katalon-group-" + System.currentTimeMillis())
		props.put("key.deserializer", StringDeserializer.class.getName())
		props.put("value.deserializer", StringDeserializer.class.getName())
		props.put("auto.offset.reset", "earliest")

		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)
		consumer.subscribe(Arrays.asList(topic))

		def records = consumer.poll(Duration.ofSeconds(10))

		for (record in records) {
			consumer.close()
			return record.value()
		}

		consumer.close()
		return null
	}
}