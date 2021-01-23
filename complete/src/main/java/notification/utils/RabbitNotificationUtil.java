//package notification.utils;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import com.rabbitmq.client.AMQP.BasicProperties;
//import com.rabbitmq.client.Channel;
//import com.rabbitmq.client.Connection;
//import com.rabbitmq.client.ConnectionFactory;
//
//import notification.models.NotificationMsg;
//
//@Component
//public class RabbitNotificationUtil {
//	
//	private static String EXCHANGE_NAME = null;
//	private static String RABBIT_HOST = null;
//	private static String RABBIT_USERNAME = null;
//	private static String RABBIT_PASSWORD = null;
//	private static String RABBIT_PORT = null;
//	private static ConnectionFactory factory = null;
//	private static BasicProperties properties = new BasicProperties.Builder().contentType("application/json").build();
//
//	private static void initConnectionFactory() {
//		factory = new ConnectionFactory();
//		factory.setHost(RABBIT_HOST);
//		factory.setPort(Integer.parseInt(RABBIT_PORT));
//		factory.setUsername(RABBIT_USERNAME);
//		factory.setPassword(RABBIT_PASSWORD);
//	}
//	
//	@Value("${notification.rabbitmq.host}")
//	public void setHostName(String host) {
//		RABBIT_HOST = host;
//	}
//	
//	@Value("${notification.rabbitmq.username}")
//	public void setUserName(String username) {
//		RABBIT_USERNAME = username;
//	}
//	
//	@Value("${notification.rabbitmq.password}")
//	public void setPassword(String password) {
//		RABBIT_PASSWORD = password;
//	}
//	
//	@Value("${notification.rabbitmq.port}")
//	public void setPort(String port) {
//		RABBIT_PORT = port;
//	}
//	
//	@Value("${notification.rabbitmq.exchange}")
//	public void setExchangeName(String exchangeName) {
//		EXCHANGE_NAME = exchangeName;
//	}
//	
//	public static void send(NotificationMsg message) {
//		if (factory == null) {
//			initConnectionFactory();
//		}
//		
//		Connection connection = null;
//		Channel channel = null;
//		
//		try {
//			connection = factory.newConnection();
//			channel = connection.createChannel();
//			
//			channel.exchangeDeclarePassive(EXCHANGE_NAME);
//			ObjectMapper mapper = new ObjectMapper();
//			mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
//			mapper.findAndRegisterModules();
//			
//			Map<String, Object> obj = new HashMap<>();
//			obj.put("type", "NOTIFICATION");
//			obj.put("payload", message);
//			
//			String jsonMessage = mapper.writeValueAsString(obj);
//			channel.basicPublish(EXCHANGE_NAME, "", properties, jsonMessage.getBytes("UTF-8"));
//		}
//		catch(Exception e) {
//			
//		}
//		finally {
//			try {
//				channel.close();
//				connection.close();
//			}
//			catch(Exception e) {
//				
//			}
//		}
//	}
//}
