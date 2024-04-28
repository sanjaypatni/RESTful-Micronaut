package com.pluralsight.smart.oven.service;

import com.pluralsight.smart.oven.event.Id;
import com.pluralsight.smart.oven.event.News;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;

@Singleton
public class NewsService {

    private static final Logger logger
            = LoggerFactory.getLogger(NewsService.class);

    public void newsReceived(Id id, News news) {
        logger.info("News received {}:{}",id, news);
    }
}
