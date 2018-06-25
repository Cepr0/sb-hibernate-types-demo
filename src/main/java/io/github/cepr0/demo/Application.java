package io.github.cepr0.demo;

import com.vladmihalcea.hibernate.type.json.internal.JacksonUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import static java.util.Arrays.asList;

@RequiredArgsConstructor
@SpringBootApplication
public class Application {

	private final ParentRepo parentRepo;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@EventListener
	public void onReady(ApplicationReadyEvent e) {
		parentRepo.saveAll(asList(
				Parent.builder()
						.name("parent1")
						.phones(new String[]{"1234567", "7654321"})
						.emails(new String[]{"parent1@mail.com", "parent1@email.com"})
						.details(new Details("Some bio", "Some CV"))
						.children(asList(
								new Child("child1", 10),
								new Child("child2", 8)
						))
						.build(),
				Parent.builder()
						.name("parent2")
						.phones(new String[]{"12345678", "87654321"})
						.emails(new String[]{"parent2@mail.com", "parent2@email.com"})
						.details(new Details("Some bio", "Some CV"))
						.children(asList(
								new Child("child3", 12),
								new Child("child4", 10)
						))
						.properties(JacksonUtil.toJsonNode("{\"property1\":\"value1\"}"))
						.build()
				));
	}
}
