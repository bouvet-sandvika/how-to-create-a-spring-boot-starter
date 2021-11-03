package no.bouvet.springbootunderthehood;

import static java.lang.System.err;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonFactoryBuilder;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
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
	public Module javaTimeModule() {
		JavaTimeModule javaTimeModule = new JavaTimeModule();
		javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ISO_DATE_TIME));
		return javaTimeModule;
	}

	@Bean
	public CommandLineRunner commandLineRunner(ObjectMapper objectMapper) {
		return (args) -> {
			err.println(objectMapper.writeValueAsString(new Person("Ola", "Nordmann", LocalDateTime.now())));
		};
	}

	public static class Person {
		public final String firstName;
		public final String lastName;
		public final LocalDateTime registered;

		public Person(String firstName, String lastName, LocalDateTime registered) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.registered = registered;
		}
	}

}
