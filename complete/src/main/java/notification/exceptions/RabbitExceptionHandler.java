package notification.exceptions;

import org.springframework.amqp.rabbit.listener.ConditionalRejectingErrorHandler;
import org.springframework.amqp.rabbit.support.ListenerExecutionFailedException;

public class RabbitExceptionHandler extends ConditionalRejectingErrorHandler.DefaultExceptionStrategy {

	@Override
	public boolean isFatal(Throwable t) {
		if(t instanceof ListenerExecutionFailedException) {
			ListenerExecutionFailedException lefe = (ListenerExecutionFailedException) t;
		}
		return super.isFatal(t);
	}
	
	@Override
	public boolean isUserCauseFatal(Throwable t) {
		if (t instanceof ListenerExecutionFailedException) {
			ListenerExecutionFailedException lefe = (ListenerExecutionFailedException) t;
		}
		return super.isUserCauseFatal(t);
	}
}
