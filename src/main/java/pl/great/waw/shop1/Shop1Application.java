package pl.great.waw.shop1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Configuration
@EnableWebMvc
public class Shop1Application {

	public static void main(String[] args) {
		SpringApplication.run(Shop1Application.class, args);
	}

}
