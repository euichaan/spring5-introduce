package me.euichan.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import me.euichan.spring.ChangePasswordService;
import me.euichan.spring.MemberDao;
import me.euichan.spring.MemberInfoPrinter;
import me.euichan.spring.MemberListPrinter;
import me.euichan.spring.MemberPrinter;
import me.euichan.spring.MemberRegisterService;
import me.euichan.spring.MemberSummaryPrinter;
import me.euichan.spring.VersionPrinter;

@Configuration
public class AppCtx {

	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}

	@Bean
	public MemberRegisterService memberRegisterService() {
		return new MemberRegisterService();
	}

	@Bean
	public ChangePasswordService changePasswordService() {
		return new ChangePasswordService();
	}

	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}

	@Bean
	@Qualifier("printer")
	public MemberPrinter memberPrinter1() {
		return new MemberPrinter();
	}

	@Bean
	public MemberSummaryPrinter memberPrinter2() {
		return new MemberSummaryPrinter();
	}

	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter();
	}

	@Bean
	public MemberInfoPrinter infoPrinter() {
		return new MemberInfoPrinter();
	}

	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
}
