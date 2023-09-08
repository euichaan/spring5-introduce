package me.euichan.spring;

public class Greeter {

	private String format;

	public String greet(String guest) {
		return String.format(format, guest);
	}

	public void setFormat(final String format) {
		this.format = format;
	}
}
