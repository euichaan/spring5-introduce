package me.euichan.aop;

public class ImplCalculator implements Calculator{

	@Override
	public long factorial(final long num) {
		long start = System.currentTimeMillis();
		long result = 1;
		for (long i = 1; i <= num; i++) {
			result *= i;
		}
		long end = System.currentTimeMillis();
		System.out.printf("ImplCalculator.factorial(%d) 실행 시간 = %d\n", num, (start - end));
		return result;
	}
}
