package notification.enums;

import java.text.MessageFormat;
import java.util.EnumSet;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum EmailEnum {
	USER_ADDED("useradded"),
	USER_REMOVED("userremoved"),
	FORWARD("forward"),
	APPROVED("approve");
	
	@NonNull
	private String prefix;
	private String subject;
	private String content;
	private String sender;
	private String linkUrl;
	
	public String getContent(String... params) {
		try {
			String text = null;
			if(params.length > 0) {
				MessageFormat mf = new MessageFormat(content);
				text = mf.format(params, new StringBuffer(), null).toString();
			}
			return text;
		}
		catch(Exception e) {
			return null;
		}
	}
	
	public String getSubject(String... params) {
		try {
			String text = null;
			if(params.length > 0) {
				MessageFormat mf = new MessageFormat(subject);
				text = mf.format(params, new StringBuffer(), null).toString();
			}
			return text;
		}
		catch(Exception e) {
			return null;
		}
	}
	
	@Component
	@PropertySource("classpath:email.properties")
	public static class EmailEnumInjector{
		private static final String SUBJECT = ".subject";
		private static final String CONTENT = ".content";
		
		@Autowired
		private Environment env;
		
		@PostConstruct
		public void postConstruct() {
			for (EmailEnum eachEnum: EnumSet.allOf(EmailEnum.class)) {
				eachEnum.subject = env.getProperty(eachEnum.getPrefix()+SUBJECT);
				eachEnum.content = env.getProperty(eachEnum.getPrefix()+CONTENT);
				eachEnum.sender = env.getProperty("email.sender");
			}
		}
	}
}
