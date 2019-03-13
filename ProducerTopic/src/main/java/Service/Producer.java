package Service;

import Entity.TestEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Service
public class Producer {
    Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    private String TOPIC = "test.topic";

    @Autowired
    private RabbitTemplate template;

    @Value("${queue}")
    private String queue;

    @Value("${queue2}")
    private String queue2;

    boolean sent;
    boolean isCallbackSet = false;

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
        setupCallback();
        template.convertAndSend(TOPIC, entity1.getRoutingKey(), entity1, new CorrelationData(entity1.getName()));
        template.convertAndSend(TOPIC, entity2.getRoutingKey(), entity2, new CorrelationData(entity2.getName()));
        template.convertAndSend(TOPIC, entity3.getRoutingKey(), entity3, new CorrelationData(entity3.getName()));
        template.convertAndSend(TOPIC, entity4.getRoutingKey(), entity4, new CorrelationData(entity4.getName()));
        template.convertAndSend(TOPIC, entity5.getRoutingKey(), entity5, new CorrelationData(entity5.getName()));
    }

    public void setupCallback() {
        if (!isCallbackSet) {
            template.setConfirmCallback((correlation, ack, reason) -> {
                if (correlation != null) {
                    System.out.println("Received " + (ack ? " ack " : " nack ") + "for correlation: " + correlation);
                    this.sent = true;
                } else {
                    System.out.println("Confirm NOT received");
                    this.sent = false;
                }
            });

            template.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
                System.out.println("Returned: " + message + "\nreplyCode: " + replyCode
                        + "\nreplyText: " + replyText + "\nexchange/rk: " + exchange + "/" + routingKey);
            });
            isCallbackSet = true;
        }
    }

    public void sendError(){
        TestEntity entity1 = new TestEntity("A.A", "Annabelle", 1);
        TestEntity entity2 = new TestEntity("A.B", "Benedict", 2);
        TestEntity entity3 = new TestEntity("B.A", "Charles", 3);
        TestEntity entity4 = new TestEntity("B.B", "Dickens", 4);
        TestEntity entity5 = new TestEntity("C.C", "Emily", 5);
//        String message = "Hello World";
//        String message2 = "Hello World2";
//        rabbitTemplate.convertAndSend(queue, message);
//        rabbitTemplate.convertAndSend(queue2, message2);
//        template.convertAndSend(TOPIC, entity1.getRoutingKey(), "hello1");
//        System.out.println("Sent: " + entity1.toString());
//        template.convertAndSend(TOPIC, entity2.getRoutingKey(), "hello2");
//        System.out.println("Sent: " + entity2.toString());
//        template.convertAndSend(TOPIC, entity3.getRoutingKey(), "hello3");
//        System.out.println("Sent: " + entity3.toString());
//        template.convertAndSend(TOPIC, entity4.getRoutingKey(), "hello4");
//        System.out.println("Sent: " + entity4.toString());
        template.setConfirmCallback((correlation, ack, reason) -> {
            if (correlation != null) {
                System.out.println("Received " + (ack ? " ack " : " nack ") + "for correlation: " + correlation);
                this.sent = true;
            } else {
                this.sent = false;
            }
        });
        template.convertAndSend(TOPIC, entity5.getRoutingKey(), "hello5", new CorrelationData("hello5"));
        if (sent) {
            System.out.println("Confirm received");
        } else {
            System.out.println("Confirm NOT received");
        }
    }

}
