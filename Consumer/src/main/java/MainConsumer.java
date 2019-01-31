import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"Config", "Service"})
public class MainConsumer {
    public static void main(String[] args) {
        SpringApplication.run(MainConsumer.class);
    }
}
