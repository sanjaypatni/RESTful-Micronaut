package com.pluralsight.cloud.service.publisher;

import com.pluralsight.cloud.service.event.Id;
import com.pluralsight.cloud.service.event.News;
import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaClient
public interface NewsPublisher {

    @Topic("news")
    void publishNews(@KafkaKey Id id, News news);

}
