package me.euichan.aop;

public class RecCalculator implements Calculator {

	@Override
	public long factorial(final long num) {
		if (num == 0) {
			return 1;
		}
		else return num * factorial(num - 1);
	}
}
