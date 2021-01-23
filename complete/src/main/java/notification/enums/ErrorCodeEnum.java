package notification.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import notification.exceptions.BadRequestException;

@AllArgsConstructor
@Getter
public enum ErrorCodeEnum {
	//401 Unauthorized
	NO_TOKEN_FOUND("401001", "No token found, You are not authorized to access this service"),
	INVALID_TOKEN("401002", "Invalid token, You are not authorized to access this service"),
	UNAUTHORIZED_USER("401003", "You are not an authorized user"),
	
	//404 Not found
	NOTIFICATION_NOT_FOUND("404001", "Notification is not found");
	
	private final String code;
	private final String description;
	
	public static ErrorCodeEnum parse(String code) {
		for(ErrorCodeEnum errorcodeEnum : ErrorCodeEnum.values()) {
			if(errorcodeEnum.getCode().equalsIgnoreCase(code)) {
				return errorcodeEnum;
			}
		}
		throw new BadRequestException("Invalid ErrorCode");
	}
}
