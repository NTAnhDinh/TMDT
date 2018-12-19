package spring.relationship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

import io.katharsis.spring.boot.v3.KatharsisConfigV3;

@Import(KatharsisConfigV3.class)
@SpringBootApplication
public class SpringKatharsisJsonApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SpringKatharsisJsonApplication.class, args);
	}

}

