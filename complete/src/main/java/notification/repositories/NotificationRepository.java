package notification.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import notification.models.Notification;

//@Repository
//public interface NotificationRepository extends MongoRepository<Notification, String>, NotificationRepositoryCustom {
//	
//	@Query("{'user.pf': ?0}")
//	Optional<Notification> findByUser(String pf);
//	
//	@Query("{$and: [{'notification._id': ?0}, {'user.pf': ?1}]}")
//	Optional<Notification> findNotificationByIdAndUser(String id, String pf);
//
//}
