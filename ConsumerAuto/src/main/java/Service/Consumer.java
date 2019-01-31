package Service;

import Entity.TestEntity;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @RabbitListener(queues = "${queue}")
    public void processMessage(TestEntity content) {
        System.out.println("Gotten from queue test: " + content.toString());
    }

    @RabbitListener(queues = "${queue2}")
    public void processMessage2(TestEntity content) {
        System.out.println("Gotten from queue test2: " + content.toString());
    }

    @RabbitListener(queues = "${queue3}")
    public void processMessage3(TestEntity content) {
        System.out.println("Gotten from queue test3: " + content.toString());
    }
}
