package tr.com.muskar.alphaVantageApi.config;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@RequiredArgsConstructor
public class ApplicationStartupConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
//                .setConnectTimeout(Duration.ofMillis(80000))
//                .setReadTimeout(Duration.ofMillis(60000))
                .build();
    }
}
