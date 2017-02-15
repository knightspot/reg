package group.artifact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Autowired
	Replace replace;

	@Bean
	public Replace getSimpleReplace() {
		return new SimpleReplace();
	}
}
