package notification.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfig {
	@Bean
	public WebMvcConfigurer coorsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("*")
						.allowCredentials(true)
						.allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
						.allowedHeaders("accept", "content-type");
			}
		};
	}
}
