package notification.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum WebsocketMessageEnumType {
	NOTIFICATION("NOTIFICATION"),
	BROADCAST("BROADCAST");
	
	private String type;
}
