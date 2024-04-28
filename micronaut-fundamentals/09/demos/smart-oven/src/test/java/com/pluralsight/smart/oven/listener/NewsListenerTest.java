package com.pluralsight.smart.oven.listener;

import com.pluralsight.smart.oven.common.KafkaBaseTest;
import com.pluralsight.smart.oven.common.NewsTestPublisher;
import com.pluralsight.smart.oven.event.Id;
import com.pluralsight.smart.oven.event.News;
import com.pluralsight.smart.oven.service.NewsService;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@MicronautTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NewsListenerTest extends KafkaBaseTest {

    @Inject
    NewsTestPublisher newsTestPublisher;

    @MockBean(NewsService.class)
    NewsService newsService() {
        return mock(NewsService.class);
    }

    @Inject
    NewsService newsService;

    @Captor
    ArgumentCaptor<Id> idCaptor = ArgumentCaptor.forClass(Id.class);

    @Captor
    ArgumentCaptor<News> newsCaptor = ArgumentCaptor.forClass(News.class);

    @Test
    @DisplayName("Should receive news")
    void shouldReceiveNews() throws InterruptedException {
        //GIVEN
        Id id = new Id();
        News news = new News("Listener", "Kafka Listener test");
        doNothing().when(newsService).newsReceived(any(), any());

        //WHEN
        newsTestPublisher.publishNews(id, news).blockingGet();
        Thread.sleep(100);

        //THEN
        verify(newsService, times(1)).newsReceived(idCaptor.capture(), newsCaptor.capture());
        assertEquals(id.getId(), idCaptor.getValue().getId());
        assertEquals(news.getTitle(), newsCaptor.getValue().getTitle());
    }
}
