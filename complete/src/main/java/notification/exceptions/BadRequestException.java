package notification.exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BadRequestException extends RuntimeException {
	private String message;
}
