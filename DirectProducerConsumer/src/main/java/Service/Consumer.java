package Service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues="${queue}")
public class Consumer {

    @RabbitHandler
    public void receive(String in) {
        System.out.println("Received " + in);
    }
}
