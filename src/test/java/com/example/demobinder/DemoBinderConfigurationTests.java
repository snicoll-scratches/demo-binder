package com.example.demobinder;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;

class DemoBinderConfigurationTests {

	private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
			.withUserConfiguration(DemoBinderConfiguration.class);

	@Test
	void bindToNonConstructorArgumentFallbacksToValueObject() {
		contextRunner.withPropertyValues("test.one.description=custom").run((context) -> {
			assertThat(context).hasSingleBean(TestProperties.class);
			TestProperties testProperties = context.getBean(TestProperties.class);
			assertThat(testProperties.getOne().getDescription()).isEqualTo("custom");
		});
	}

	@Test
	void bindToConstructorArgumentFailsAsSetterIsRequired() {
		contextRunner.withPropertyValues("test.one.value=one").run((context) -> {
			assertThat(context).hasSingleBean(TestProperties.class);
			TestProperties testProperties = context.getBean(TestProperties.class);
			assertThat(testProperties.getOne().getValue()).isEqualTo("one");
		});
	}
}
