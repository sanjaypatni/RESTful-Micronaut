package com.pluralsight.cloud.service.listener;

import com.pluralsight.cloud.service.event.Id;
import com.pluralsight.cloud.service.event.Notification;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@KafkaListener(groupId = "notifications.listener")
public class NotificationsListener {

    private static final Logger logger
            = LoggerFactory.getLogger(NotificationsListener.class);

    @Topic("notifications")
    public void receive(@KafkaKey Id id, Notification notification) {
        logger.info("Notification received {}:{}",id, notification);
    }
}
