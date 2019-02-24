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

    private String TOPIC = "test.topic";

    @Autowired
    private AmqpTemplate template;

    @Value("${queue}")
    private String queue;

    @Value("${queue2}")
    private String queue2;

    public void send() {
        TestEntity entity1 = new TestEntity("A.A", "Annabelle", 1);
        TestEntity entity2 = new TestEntity("A.B", "Benedict", 2);
        TestEntity entity3 = new TestEntity("B.A", "Charles", 3);
        TestEntity entity4 = new TestEntity("B.B", "Dickens", 4);
        TestEntity entity5 = new TestEntity("C.C", "Emily", 5);
//        String message = "Hello World";
//        String message2 = "Hello World2";
//        rabbitTemplate.convertAndSend(queue, message);
//        rabbitTemplate.convertAndSend(queue2, message2);
        template.convertAndSend(TOPIC, entity1.getRoutingKey(), entity1);
        System.out.println("Sent: " + entity1.toString());
        template.convertAndSend(TOPIC, entity2.getRoutingKey(), entity2);
        System.out.println("Sent: " + entity2.toString());
        template.convertAndSend(TOPIC, entity3.getRoutingKey(), entity3);
        System.out.println("Sent: " + entity3.toString());
        template.convertAndSend(TOPIC, entity4.getRoutingKey(), entity4);
        System.out.println("Sent: " + entity4.toString());
        template.convertAndSend(TOPIC, entity5.getRoutingKey(), entity5);
        System.out.println("Sent: " + entity5.toString());
    }

    public void sendError() {
        TestEntity entity1 = new TestEntity("A.A", "Annabelle", 1);
        TestEntity entity2 = new TestEntity("A.B", "Benedict", 2);
        TestEntity entity3 = new TestEntity("B.A", "Charles", 3);
        TestEntity entity4 = new TestEntity("B.B", "Dickens", 4);
        TestEntity entity5 = new TestEntity("C.C", "Emily", 5);
//        String message = "Hello World";
//        String message2 = "Hello World2";
//        rabbitTemplate.convertAndSend(queue, message);
//        rabbitTemplate.convertAndSend(queue2, message2);
        template.convertAndSend(TOPIC, entity1.getRoutingKey(), "hello1");
        System.out.println("Sent: " + entity1.toString());
        template.convertAndSend(TOPIC, entity2.getRoutingKey(), "hello2");
        System.out.println("Sent: " + entity2.toString());
        template.convertAndSend(TOPIC, entity3.getRoutingKey(), "hello3");
        System.out.println("Sent: " + entity3.toString());
        template.convertAndSend(TOPIC, entity4.getRoutingKey(), "hello4");
        System.out.println("Sent: " + entity4.toString());
        template.convertAndSend(TOPIC, entity5.getRoutingKey(), "hello5");
        System.out.println("Sent: " + entity5.toString());
    }

}
