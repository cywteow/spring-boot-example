//package notification.config;
//
//import org.springframework.amqp.core.Base64UrlNamingStrategy;
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.FanoutExchange;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.rabbit.annotation.EnableRabbit;
//import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.listener.ConditionalRejectingErrorHandler;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.amqp.support.converter.MessageConverter;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.util.ErrorHandler;
//
//import notification.exceptions.RabbitExceptionHandler;
//
//@Configuration
//@EnableRabbit
//public class RabbitConfig {
//	@Value("${notification.rabbitmq.exchange}")
//	public String EXCHANGE_NAME;
//	
//	@Value("${notification.rabbitmq.queue-prefix}")
//	public String QUEUE_PREFIX;
//	
//	@Value("${notification.rabbitmq.username}")
//	public String USERNAME;
//	
//	@Value("${notification.rabbitmq.password}")
//	public String PASSWORD;
//	
//	@Value("${notification.rabbitmq.port}")
//	public String PORT;
//	
//	@Value("${notification.rabbitmq.host}")
//	public String HOST;
//	
//	@Bean
//	public FanoutExchange appExchange() {
//		return new FanoutExchange(EXCHANGE_NAME);
//	}
//	
//	@Bean
//	public Queue appQueue() {
//		String queueName = new Base64UrlNamingStrategy(QUEUE_PREFIX+".").generateName();
//		return new Queue(queueName, false, true, true);
//	}
//	
//	@Bean
//	public Binding declareBinding() {
//		return BindingBuilder.bind(appQueue()).to(appExchange());
//	}
//	
//	@Bean
//	public MessageConverter jsonMessageConverter() {
//		return new Jackson2JsonMessageConverter();
//	}
//	
//	@Bean
//	public ConnectionFactory initConnectionFactory() {
//		CachingConnectionFactory factory = new CachingConnectionFactory();
//		factory.setHost(HOST);
//		factory.setPort(Integer.parseInt(PORT));
//		factory.setUsername(USERNAME);
//		factory.setPassword(PASSWORD);
//		return factory;
//	}
//	
//	@Bean
//	public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
//		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//		factory.setConnectionFactory(connectionFactory);
//		factory.setErrorHandler(rabbitErrorHandler());
//		factory.setMessageConverter(jsonMessageConverter());
//		factory.setConcurrentConsumers(1);
//		factory.setMaxConcurrentConsumers(3);
//		return factory;	
//	}
//	
//	@Bean
//	public ErrorHandler rabbitErrorHandler() {
//		return new ConditionalRejectingErrorHandler(new RabbitExceptionHandler());
//	}
//}
