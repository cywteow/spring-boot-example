package notification.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotificationItem implements Serializable {
	@Id
	private String id;
	private String lastId;
	private String application;
	private String title;
	private String message;
	private String url;
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime timestamp;
	private boolean read;
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime fetch;
	private Integer fetchCount;
	private Integer count;
	
	public NotificationItem(NotificationMsg message) {
		this.id = message.getId();
		this.application = message.getApplication();
		this.title = message.getTitle();
		this.message = message.getMessage();
		this.url = message.getUrl();
		this.timestamp = message.getTimestamp();
	}
	
	public boolean equalsCluster(NotificationItem item) {
		if(this.application.equalsIgnoreCase(item.getApplication()) && 
				this.title.equalsIgnoreCase(item.getTitle()) && 
				this.message.equalsIgnoreCase(item.getMessage()) &&
				this.url.equalsIgnoreCase(item.getUrl()) &&
				this.read == item.isRead()) {
			
			if(item.getFetch() != null && this.fetch != null) {
				if(item.getFetch().equals(this.fetch)) {
					return true;
				}
			}
			else if (item.getFetch() == null && this.fetch == null) {
				return true;
			}
		}
		return false;
	}
}
