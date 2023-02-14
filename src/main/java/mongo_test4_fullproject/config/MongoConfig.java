//package mongo_test4_fullproject.config;
//
//import com.mongodb.ConnectionString;
//import com.mongodb.MongoClientSettings;
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//import java.util.Collection;
//import java.util.Collections;
//
//                  // we don't need to create bean in this config as long as we extends from AbstractMongoClientConfiguration
//@Configuration
//@EnableMongoRepositories(basePackages = "mongo_test4_fullproject.repository")
//public class MongoConfig extends AbstractMongoClientConfiguration {
//    @Override
//    protected String getDatabaseName() {
//        return "spring_mongo";
//    }
//
//    @Override
//    public MongoClient mongoClient() {
//        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/test");
//        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
//                .applyConnectionString(connectionString)
//                .build();
//        return MongoClients.create(mongoClientSettings);
//    }
//
//    @Override
//    protected Collection getMappingBasePackages() {
//        return Collections.singleton("spring_mongodb_test");   // название проекта
//    }
//}