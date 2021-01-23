package notification.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private String pf;
	private String name;
	private String directorate;
	private String section;
	private String email;
	
	public User(String pf) {
		this.pf = pf;
	}
}
