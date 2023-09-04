package me.euichan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import me.euichan.spring.ChangePasswordService;
import me.euichan.spring.MemberDao;
import me.euichan.spring.MemberInfoPrinter;
import me.euichan.spring.MemberListPrinter;
import me.euichan.spring.MemberPrinter;
import me.euichan.spring.MemberRegisterService;

@Configuration
public class AppCtx {

	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}

	@Bean
	public MemberRegisterService memberRegisterService() {
		return new MemberRegisterService(memberDao());
	}

	@Bean
	public ChangePasswordService changePasswordService() {
		ChangePasswordService changePasswordService = new ChangePasswordService();
		changePasswordService.setMemberDao(memberDao());
		return changePasswordService;
	}

	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}

	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter(memberDao(), memberPrinter());
	}

	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter memberInfoPrinter = new MemberInfoPrinter();
		memberInfoPrinter.setMemberDao(memberDao());
		memberInfoPrinter.setPrinter(memberPrinter());
		return memberInfoPrinter;
	}
}
