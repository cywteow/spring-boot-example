package notification.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

//@Document(collection = "notifications")
@Data
public class Notification {
	@Id
	private String id;
	private User user;
	private List<NotificationItem> notifications;
	private Integer unread;
	@Version
	private long version;
}
