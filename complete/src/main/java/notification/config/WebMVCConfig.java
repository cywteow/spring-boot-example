package notification.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import notification.interceptors.LoginInterceptor;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor()).excludePathPatterns("/actuator/**", "/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**");
	}
	
	@Bean
	public LoginInterceptor loginInterceptor() {
		return new LoginInterceptor();
	}
}
