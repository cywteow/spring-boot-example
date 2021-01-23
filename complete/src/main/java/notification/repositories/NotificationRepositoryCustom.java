package notification.repositories;

import java.util.List;

import notification.models.NotificationItem;

public interface NotificationRepositoryCustom {
	List<NotificationItem> getFilteredNotifications(String pf);
	List<NotificationItem> getNextFilteredNotificationsByLastId(String pf, String lastId);
}
