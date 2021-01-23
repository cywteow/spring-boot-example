//package notification.controllers;
//
//import org.springframework.amqp.AmqpRejectAndDontRequeueException;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.configurationprocessor.json.JSONException;
//import org.springframework.boot.configurationprocessor.json.JSONObject;
//import org.springframework.stereotype.Service;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import notification.enums.WebsocketMessageEnumType;
//import notification.models.Broadcast;
//import notification.models.NotificationMsg;
//import notification.services.NotificationService;
//
//@Service
//public class RabbitReceiver {
//	@Autowired
//	private NotificationService notificationService;
//	
//	@RabbitListener(queues = "#{appQueue.name}")
//	public void receiveMessage(Message message) throws JSONException, JsonMappingException, JsonProcessingException {
//		String body = new String (message.getBody());
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//		mapper.findAndRegisterModules();
//		try {
//			JSONObject tempJsonObject = new JSONObject(body);
//			String type = tempJsonObject.optString("type");
//			
//			if(type.equalsIgnoreCase(WebsocketMessageEnumType.NOTIFICATION.getType())) {
//				String payload = tempJsonObject.getString("payload");
//				NotificationMsg msg = mapper.readValue(payload, NotificationMsg.class);
//				notificationService.sendPrivateMessage(msg);
//			}
//			else if (type.equalsIgnoreCase(WebsocketMessageEnumType.BROADCAST.getType())) {
//				String payload = tempJsonObject.getString("payload");
//				Broadcast msg = mapper.readValue(payload, Broadcast.class);
//				notificationService.sendBroadcastMessage(msg);
//			}
//		}
//		catch(JSONException | JsonMappingException e) {
//			throw new AmqpRejectAndDontRequeueException(e.getMessage());
//		}
//	}
//}
