package meetings.src.main.java.meetings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class MeetingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeetingsApplication.class, args);
	}
}
