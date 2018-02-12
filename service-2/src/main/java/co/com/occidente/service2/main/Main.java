package co.com.occidente.service2.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = { "co.com.occidente.service2" })
@EnableJpaRepositories(basePackages = { "co.com.occidente.data.repository" })
@EntityScan(basePackages = { "co.com.occidente.data.model" })
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}
