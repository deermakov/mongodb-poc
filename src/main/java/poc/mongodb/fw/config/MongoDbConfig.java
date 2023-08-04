package poc.mongodb.fw.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("poc.mongodb.adapter.mongodb.repository")
public class MongoDbConfig {
}
