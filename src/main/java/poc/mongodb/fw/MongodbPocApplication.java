package poc.mongodb.fw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("poc.mongodb")
public class MongodbPocApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongodbPocApplication.class, args);
    }
}
