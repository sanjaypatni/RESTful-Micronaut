package com.pluralsight.smart.oven.common;

import com.pluralsight.smart.oven.event.Id;
import com.pluralsight.smart.oven.event.News;
import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.reactivex.Single;

@KafkaClient
public interface NewsTestPublisher {

    @Topic("${kafka.topic.news}")
    Single<News> publishNews(@KafkaKey Id id, News news);
}
