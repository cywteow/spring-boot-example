package notification.models;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("serial")
@Data
public class NotificationMsg extends NotificationItem implements Serializable {
	private List<User> users;
}
