package pl.great.waw.shop1.Configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "pl.great.waw.shop1.Mapper")
public class AppConfig {
}