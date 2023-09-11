package me.euichan.aop;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcut {

	@Pointcut("execution(public * me.euichan.aop..*(..))")
	public void commonTarget() {

	}
}
