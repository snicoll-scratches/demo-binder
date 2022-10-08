package com.example.demobinder;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 * @author Stephane Nicoll
 */
@ConfigurationProperties("test")
public class TestProperties {

	/**
	 * Name element.
	 */
	private final SimpleElement one = new SimpleElement("1");

	/**
	 * Description element.
	 */
	private final SimpleElement two = new SimpleElement("2");

	public SimpleElement getOne() {
		return this.one;
	}

	public SimpleElement getTwo() {
		return this.two;
	}


	public static class SimpleElement {

		/**
		 * Element title.
		 */
		private String title;

		/**
		 * Element description.
		 */
		private String description;

		/**
		 * Element default value.
		 */
		private String value;

		public SimpleElement(String value) {
			this.value = value;
		}

		public String getTitle() {
			return this.title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return this.description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getValue() {
			return this.value;
		}

		public void setValue(String value) {
			this.value = value;
		}

	}
}
