package edu.grinnell.csc207.cohnhann.utils;

import java.math.BigInteger;

public class Calculator {


	public static BigInteger eval0(String calculate) {
		String[] split = StringUtils.splitAt(calculate, ' ');
		BigInteger answer = new BigInteger(split[0]);
		for (int i = 1; i < split.length; i++) {
			char ch = (split[i]).charAt(0);
			switch (ch) {
			case '+':
				answer = answer.add(new BigInteger(split[i + 1].toString()));
				i++;
				break;

			case '-':
				answer = answer.subtract(new BigInteger(split[i + 1].toString()));
				i++;
				break;

			case '*':
				answer = answer.multiply(new BigInteger(split[i + 1].toString()));
				i++;
				break;

			case '/':
				answer = answer.divide(new BigInteger(split[i + 1].toString()));
				i++;
				break;

			case '^':
				answer = answer.xor(new BigInteger(split[i + 1].toString()));
				i++;
				break;
			}// switch for operation
		}// for
		return answer;
	}//eval0 
}
