package me.euichan.main;

import me.euichan.aop.ExeTimeCalculator;
import me.euichan.aop.ImplCalculator;
import me.euichan.aop.RecCalculator;

public class MainProxy {

	public static void main(String[] args) {
		final ExeTimeCalculator ttCal1 = new ExeTimeCalculator(new ImplCalculator());
		System.out.println(ttCal1.factorial(20));

		final ExeTimeCalculator ttCal2 = new ExeTimeCalculator(new RecCalculator());
		System.out.println(ttCal2.factorial(20));
	}
}
