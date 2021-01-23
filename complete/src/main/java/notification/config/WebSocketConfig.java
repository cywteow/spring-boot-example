//package notification.config;
//
//import java.security.Principal;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.server.ServerHttpRequest;
//import org.springframework.http.server.ServerHttpResponse;
//import org.springframework.http.server.ServletServerHttpRequest;
//import org.springframework.http.server.ServletServerHttpResponse;
//import org.springframework.messaging.simp.config.MessageBrokerRegistry;
//import org.springframework.web.socket.WebSocketHandler;
//import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
//import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
//import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
//import org.springframework.web.socket.server.HandshakeInterceptor;
//import org.springframework.web.socket.server.support.DefaultHandshakeHandler;
//
//import notification.models.UserPrincipal;
//
//@Configuration
//@EnableWebSocketMessageBroker
//public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
//	
//	@Override
//	public void configureMessageBroker(MessageBrokerRegistry config) {
//		config.enableSimpleBroker("/topic");
//		config.setApplicationDestinationPrefixes("/app");
//	}
//	
//	@Override
//	public void registerStompEndpoints(StompEndpointRegistry registry) {
//		registry.addEndpoint("/websocket").setAllowedOrigins("*").setHandshakeHandler(new DefaultHandshakeHandler(){
//			@Override
//			protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
//				return new UserPrincipal(attributes.get("userName").toString());
//			}
//		}).withSockJS().setInterceptors(new HandshakeInterceptor() {
//			
//			@Override
//			public void afterHandshake(ServerHttpRequest arg0, ServerHttpResponse arg1, WebSocketHandler arg2, Exception arg3) {
//				
//			}
//			
//			@Override
//			public boolean  beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
//				ServletServerHttpRequest servletServerRequest = (ServletServerHttpRequest) request;
//				HttpServletRequest servletRequest = servletServerRequest.getServletRequest();
//				HttpServletResponse servletResponse = ((ServletServerHttpResponse) response).getServletResponse();
//				//Check cookie from servletRequest
//				
//				attributes.put("userName", "cywteow");
//				return true;
//			}
//		});
//	}
//}
