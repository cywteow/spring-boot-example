package notification.models;

import lombok.Data;
import notification.enums.WebsocketMessageEnumType;

@Data
public class WebsocketMessage {
	private String type;
	private Broadcast data;
	
	public WebsocketMessage(WebsocketMessageEnumType type) {
		this.type = type.getType();
	}
	
	public WebsocketMessage(WebsocketMessageEnumType type, Broadcast data) {
		this.type = type.getType();
		this.data = data;
	}
}
