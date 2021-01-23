package notification.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import notification.models.Broadcast;
import notification.models.Notification;
import notification.models.NotificationItem;
import notification.models.NotificationMsg;

@Service
public class NotificationService {

//	@Autowired
//	private SimpMessagingTemplate messageTemplate;
//	@Autowired
//	private NotificationRepository notificationRepository;
	
	public void sendPrivateMessage(NotificationMsg message) {
		
	}

	public Notification getFilteredNotificationsAndUpdateFetch(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public Notification getNextNotification(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public void sendBroadcastMessage(Broadcast msg) {
		// TODO Auto-generated method stub
		
	}

	public void markAsRead(NotificationItem item) {
		// TODO Auto-generated method stub
		
	}
	
	
}
