package poc.mongodb.fw.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * todo Document type MongoDbConfig
 */
@Configuration
@EnableMongoRepositories("poc.mongodb.adapter.mongodb.repository")
public class MongoDbConfig {
}
