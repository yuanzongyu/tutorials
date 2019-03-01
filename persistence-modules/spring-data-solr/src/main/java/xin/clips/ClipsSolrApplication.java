package xin.clips;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableConfigurationProperties
public class ClipsSolrApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ClipsSolrApplication.class).web(true).run(args);
    }
}
