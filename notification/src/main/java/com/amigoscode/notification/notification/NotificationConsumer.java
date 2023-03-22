package com.amigoscode.notification.notification;

import com.amigoscode.clients.notification.NotificationRequest;
import com.amigoscode.notification.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class NotificationConsumer {

    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consumer(NotificationRequest notificationRequest) {
        log.info("consumed {} from queue", notificationRequest);
        notificationService.send(notificationRequest);
    }

}
