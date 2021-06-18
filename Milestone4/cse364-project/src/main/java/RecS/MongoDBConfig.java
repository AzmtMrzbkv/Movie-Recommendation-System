package RecS;

import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoDBConfig {
    @Bean
    public MongoTemplate mongoTemplate(){
        return new MongoTemplate(MongoClients.create(), "user_db");
    }
}
