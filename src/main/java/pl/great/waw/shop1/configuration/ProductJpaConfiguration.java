package pl.great.waw.shop1.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

public class ProductJpaConfiguration {
    @Configuration
    @EnableJpaRepositories(basePackages = "pl.great.waw.shop1")
    @PropertySource("persistence-product.properties")
    @EnableTransactionManagement
    public class StudentJpaConfig {

        @Autowired
        private Environment env;

        @Bean
        public DataSource dataSource() {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
            dataSource.setUrl(env.getProperty("jdbc:postgresql://localhost:5432/shop"));
            dataSource.setUsername(env.getProperty("postgres"));
            dataSource.setPassword(env.getProperty("lol112233"));

            return dataSource;
        }

        // configure entityManagerFactory

        // configure transactionManager

        // configure additional Hibernate Properties
    }
}
