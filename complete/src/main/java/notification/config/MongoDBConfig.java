package notification.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.MongoTransactionManager;

//@Configuration
//public class MongoDBConfig {
//	//spring boot 2.2.6 can detect cluster with MongoDbFactory
//	@Bean
//	MongoTransactionManager transactionManager(MongoDbFactory dbFactory) {
//		return new MongoTransactionManager(dbFactory);
//	}
//	
//	//spring boot 2.3.3 cannot detect cluster
////	@Bean
////	MongoTransactionManager transactionManager(MongoDatabaseFactory dbFactory) {
////		return new MongoTransactionManager(dbFactory);
////	}
//}
