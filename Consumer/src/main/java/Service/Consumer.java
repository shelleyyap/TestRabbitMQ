package Service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @RabbitListener(queues={"${queue}", "${queue2}"})
    public void receive(String in) {
        System.out.println("Received " + in);
    }
}
