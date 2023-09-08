package me.euichan.spring;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {

	private Long id;
	private String email;
	private String password;
	private String name;
	private LocalDateTime registerDateTime;

	public Member(final String email, final String password, final String name, final LocalDateTime registerDateTime) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.registerDateTime = registerDateTime;
	}

	public void changePassword(String oldPassword, String newPassword) {
		if (!password.equals(oldPassword)) {
			throw new WrongIdPasswordException();
		}
		this.password = newPassword;
	}
}
