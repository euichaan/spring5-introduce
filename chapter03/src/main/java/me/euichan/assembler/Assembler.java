package me.euichan.assembler;

import lombok.Getter;
import me.euichan.spring.ChangePasswordService;
import me.euichan.spring.MemberDao;
import me.euichan.spring.MemberRegisterService;

@Getter
public class Assembler {

	private MemberDao memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;

	public Assembler() {
		memberDao = new MemberDao();
		regSvc = new MemberRegisterService(memberDao);
		pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao);
	}
}
