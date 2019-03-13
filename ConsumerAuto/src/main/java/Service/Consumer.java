package Service;

import Entity.TestEntity;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @RabbitListener(queues = "${queue}", containerFactory = "containerFactory")
    public void processMessage(TestEntity content) {
        System.out.println("Gotten from queue test: " + content.toString());
    }

    @RabbitListener(queues = "${queue2}", containerFactory = "containerFactory")
    public void processMessage2(TestEntity content) {
        System.out.println("Gotten from queue test2: " + content.toString());
    }
}
