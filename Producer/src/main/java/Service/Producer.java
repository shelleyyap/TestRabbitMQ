package Service;

import Entity.TestEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private AmqpTemplate template;

//    @Value("${queue}")
//    private String queue;
//
//    @Value("${queue2}")
//    private String queue2;
    @Value("${queues}")
    private String[] queues;

    public void send() {
        TestEntity entity1 = new TestEntity("A", "Annabelle", 1);
        TestEntity entity2 = new TestEntity("B", "Benedict", 2);
        TestEntity entity3 = new TestEntity("B", "Charles", 3);
////        String message = "Hello World";
////        String message2 = "Hello World2";
////        rabbitTemplate.convertAndSend(queue, message);
////        rabbitTemplate.convertAndSend(queue2, message2);
//        template.convertAndSend(queue, entity1);
//        System.out.println("Sent: " + entity1.toString());
//        template.convertAndSend(queue, entity2);
//        System.out.println("Sent: " + entity2.toString());
//        template.convertAndSend(queue, entity3);
//        System.out.println("Sent: " + entity3.toString());
//        template.convertAndSend(queue2, entity1);
//        System.out.println("Sent: " + entity1.toString());
//        template.convertAndSend(queue2, entity2);
//        System.out.println("Sent: " + entity2.toString());

        template.convertAndSend(queues[0], entity1);
        System.out.println("Sent: " + entity1.toString());
        template.convertAndSend(queues[0], entity2);
        System.out.println("Sent: " + entity2.toString());
        template.convertAndSend(queues[0], entity3);
        System.out.println("Sent: " + entity3.toString());
        template.convertAndSend(queues[1], entity1);
        System.out.println("Sent: " + entity1.toString());
        template.convertAndSend(queues[1], entity2);
        System.out.println("Sent: " + entity2.toString());
    }

}
