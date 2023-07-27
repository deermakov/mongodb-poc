package poc.mongodb.fw.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * todo Document type MongoDbConfig
 */
@Configuration
@EnableMongoRepositories("poc.mongodb.adapter.mongodb.repository")
public class MongoDbConfig {
}
