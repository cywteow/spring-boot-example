package notification.models;

import lombok.Data;

@Data
public class Broadcast {
	private String variant;
	private String message;
	private User recipient;
	private Integer autoHideDuration;
}
