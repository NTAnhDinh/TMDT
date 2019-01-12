package api.soccer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableResourceServer
public class SpringTmaApplication {
//	@Bean
//	RestTemplate restTemplate(OAuth2AuthorizedClientService clientService) {
//		return new RestTemplateBuilder()
//				.interceptors((ClientHttpRequestInterceptor) (httpRequest, bytes, execution) -> {
//
//					OAuth2AuthenticationToken token = OAuth2AuthenticationToken.class.cast(
//							SecurityContextHolder.getContext().getAuthentication());
//
//					OAuth2AuthorizedClient client = clientService.loadAuthorizedClient(
//							token.getAuthorizedClientRegistrationId(),
//							token.getName());
//
//					httpRequest.getHeaders().add(HttpHeaders.AUTHORIZATION, "Bearer " + client.getAccessToken().getTokenValue());
//
//					return execution.execute(httpRequest, bytes);
//				})
//				.build();
//	}
	public static void main(String[] args) {
		SpringApplication.run(SpringTmaApplication.class, args);
	}

}

