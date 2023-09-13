package me.euichan.main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import me.euichan.config.AppCtx;
import me.euichan.spring.Member;
import me.euichan.spring.MemberDao;

public class MainForMemberDao {

	private static MemberDao memberDao;
	private static DateTimeFormatter formatter;

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppCtx.class);
		memberDao = ac.getBean(MemberDao.class);
		formatter = DateTimeFormatter.ofPattern("MMddHHmmss");

		selectAll();
		updateMember();
		insertMember();

		ac.close();
	}

	private static void selectAll() {
		System.out.println("----- selectAll");
		final int total = memberDao.count();
		System.out.println("전체 데이터: = " + total);
		final List<Member> members = memberDao.selectAll();
		members.stream()
			.map(member -> member.getId() + ":" + member.getEmail() + ":" + member.getName())
			.forEach(System.out::println);
	}

	private static void updateMember() {
		System.out.println("----- updateMember");
		Member member = memberDao.selectByEmail("madvirus@madvirus.net");
		String oldPassword = member.getPassword();
		String newPassword = Double.toHexString(Math.random());
		member.changePassword(oldPassword, newPassword);

		memberDao.update(member);
		System.out.println("암호 변경: " + oldPassword + " > " + newPassword);
	}

	private static void insertMember() {
		System.out.println("----- insertMember");

		String prefix = formatter.format(LocalDateTime.now());
		final Member member = new Member(prefix + "@test.com", prefix, prefix, LocalDateTime.now());
		memberDao.insert(member);
		System.out.println(member.getId() + " 데이터 추가");
	}
}
