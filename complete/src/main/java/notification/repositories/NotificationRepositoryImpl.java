package notification.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import notification.models.NotificationItem;

public class NotificationRepositoryImpl implements NotificationRepositoryCustom {
//	@Autowired
//	private MongoTemplate mongoTemplate;

	@Override
	public List<NotificationItem> getFilteredNotifications(String pf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NotificationItem> getNextFilteredNotificationsByLastId(String pf, String lastId) {
		// TODO Auto-generated method stub
		return null;
	}
}
