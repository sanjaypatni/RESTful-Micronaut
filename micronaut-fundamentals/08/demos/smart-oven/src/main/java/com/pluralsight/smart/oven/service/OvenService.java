package com.pluralsight.smart.oven.service;

import com.pluralsight.smart.oven.event.Id;
import com.pluralsight.smart.oven.event.Notification;
import com.pluralsight.smart.oven.publisher.NotificationsPublisher;
import io.reactivex.Single;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;

@Singleton
public class OvenService {

    private static final Logger logger
            = LoggerFactory.getLogger(OvenService.class);

    private NotificationsPublisher notificationsPublisher;

    public OvenService(NotificationsPublisher notificationsPublisher) {
        this.notificationsPublisher = notificationsPublisher;
    }

    public Single<Notification> startOven() {
        logger.info("Starting oven ...");

        Id id = new Id();
        Notification notification = new Notification("Oven started");
        return notificationsPublisher.publishNotification(id, notification);
    }
}
