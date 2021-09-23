package za.co.wethink.store;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 
 * @author ebe
 *
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@EnableWebMvc
@Configuration
@ImportResource("classpath:application-config.xml")
public class Application {
	
	private static final Logger LOGGER = LogManager.getLogger(Application.class);

	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
	
	@Value("${allowedOrigins}")
	private String allowedOrigins;
	
    @Bean
    public WebMvcConfigurer configurer(){
      return new WebMvcConfigurer(){
        @Override
        public void addCorsMappings(CorsRegistry registry) {
          String[] origins = allowedOrigins.split(",");
          Arrays.asList(origins).stream().forEach(origin -> LOGGER.info(origin));
          registry.addMapping("/**").allowedOrigins(origins);
        }
  };
}
    
}
