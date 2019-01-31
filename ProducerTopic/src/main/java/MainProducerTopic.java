import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"Config", "Controller", "Service"})
public class MainProducerTopic {
    public static void main(String[] args) {
        SpringApplication.run(MainProducerTopic.class);
    }
}
