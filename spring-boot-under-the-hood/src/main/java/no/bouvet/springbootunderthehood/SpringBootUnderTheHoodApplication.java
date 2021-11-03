package no.bouvet.springbootunderthehood;

import static java.lang.System.err;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootUnderTheHoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootUnderTheHoodApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ObjectMapper objectMapper) {
		return (args) -> {
			err.println(objectMapper.writeValueAsString(new Person("Ola", "Nordmann")));
		};
	}

	public static class Person {
		public final String firstName;
		public final String lastName;

		public Person(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}
	}

}
