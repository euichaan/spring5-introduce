package me.euichan.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class ExeTimeAspect {

	@Around("CommonPointcut.commonTarget()")
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.nanoTime();
		try {
			Object result = joinPoint.proceed();
			return result;
		} finally {
			long finish = System.nanoTime();
			final Signature signature = joinPoint.getSignature();
			// System.out.println(joinPoint.getTarget().getClass().getName()); // 대상 객체 : 실제 핵심 기능을 실행하는 객체
			// System.out.println(signature.getName()); // 호출되는 메서드의 이름
			// System.out.println(signature.toLongString());
			// System.out.println(signature.toShortString());

			System.out.printf("%s.%s(%s) 실행 시간 : %d ns\n",
				joinPoint.getTarget().getClass().getSimpleName(),
				signature.getName(), Arrays.toString(joinPoint.getArgs()),
				finish - start);
		}
	}
}
