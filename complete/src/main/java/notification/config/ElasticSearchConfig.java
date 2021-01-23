//package notification.config;
//
//import org.apache.http.HttpHost;
//import org.elasticsearch.client.RestClient;
//import org.elasticsearch.client.RestHighLevelClient;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class ElasticSearchConfig {
//	@Value("${datasource.elasticsearch.url}")
//	private String url;
//	@Value("$P{datasource.elasticsearch.port}")
//	private int port;
//	
//	@Bean(destroyMethod = "close")
//	public RestHighLevelClient elasticsearchClient() {
//		return new RestHighLevelClient(RestClient.builder(new HttpHost(url, port, "http")));
//	}
//}
