package mongo_test4_fullproject;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import mongo_test4_fullproject.model.Person;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.data.mongodb.core.MongoTemplate;

public class MainClass {
    public static void main(String[] args) {
//        MongoOperations mongoOperations = new MongoTemplate(new Mongo(), "spring_mongo");
//        CodecRegistry personCodec = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
//                CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));
//
//        MongoCollection<Person> personCollection = new com.mongodb.MongoClient().getDatabase("spring_mongo")
//                .withCodecRegistry(personCodec)
//                .getCollection("person", Person.class);
//
        Person antonio = new Person("Antonio", 30);
//        Person kirill = new Person("Kirill", 35);
//
//        personCollection.insertOne(rustem);

    }
}