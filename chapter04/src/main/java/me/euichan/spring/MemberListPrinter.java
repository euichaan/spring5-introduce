package me.euichan.spring;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberListPrinter {

	private MemberDao memberDao;
	private MemberPrinter printer;

	public MemberListPrinter() {
	}

	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
		members.forEach(m -> printer.print(m));
	}

	@Autowired
	public void setMemberDao(final MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Autowired
	@Qualifier("printer")
	public void setPrinter(final MemberPrinter printer) {
		this.printer = printer;
	}
}
