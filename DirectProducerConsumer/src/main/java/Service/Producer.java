package Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${queue}")
    private String queue;

    @Value("${queue2}")
    private String queue2;

    public void send() {
        String message = "Hello World";
        String message2 = "Hello World2";
        rabbitTemplate.convertAndSend(queue, message);
        rabbitTemplate.convertAndSend(queue2, message2);
    }
}
