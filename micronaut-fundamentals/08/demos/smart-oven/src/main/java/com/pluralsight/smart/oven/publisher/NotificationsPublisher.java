package com.pluralsight.smart.oven.publisher;

import com.pluralsight.smart.oven.event.Id;
import com.pluralsight.smart.oven.event.Notification;
import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.reactivex.Single;

@KafkaClient
public interface NotificationsPublisher {

    @Topic("${kafka.topic.notifications}")
    Single<Notification> publishNotification(@KafkaKey Id id, Notification notification);

}
