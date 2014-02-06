package edu.grinnell.csc207.cohnhann.utils;


public class StringUtils {
	public static String[] splitAt(String str, char split) {
		int place = 0;
		int length = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == split)
				length++;
		}//for- finds needed length for splitString

		String[] splitString = new String[length + 1];
		StringBuffer element = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == split) {
				splitString[place] = element.toString();
				place++;
				element.delete(0, element.length());
			} //if- places element then resets if char is the split 
			else {
				element.append(str.charAt(i));
			}//adds to element 
		}//for- goes thru each place in splitString
		splitString[place] = element.toString();
		return splitString;
	}//splitAt

	public static String[] splitCSV(String str) {
		/*
		 * This does not work. At this point there is nothing else I can do. I also
		 * don't know where I am even going anymore/ don't know what I was trying to do. 
		 */
		int length = 0;
		int place = 0;
		int counter = 0;
		StringBuffer element = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '\"') {
				i++;
				while (str.charAt(i) != '\"') {
					i++;
				}//while- skips over non \"
			}//if- finds \" 
			if (str.charAt(i) == ',') {
				length++;
			}//if- to find length for split string
		}//for- length for splitString

		String[] splitString = new String[length + 1];
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '\"') {
				counter++;
				i++;
			}//if- finds a \"
			if (counter == 0) {
				if (str.charAt(i) == ',') {
					splitString[place] = element.toString();
					place++;
				}//if- adds element and goes to next place
				else {
					element.append(str.charAt(i));
				}//else- adds to the element 

			}//if there is no \"
			if (counter >= 1) {
				while (str.charAt(i) != '\"' && str.charAt(i + 1) != '\"') {
					if (str.charAt(i) != '\"') {
						element.append(str.charAt(i));
						i++;
					}// if- adds to element

				}// while- searches for double quotes
				if (str.charAt(i) == '\"' && str.charAt(i + 1) == '\"') {
					element.append(str.charAt(i));
					i += 2;
					counter = 0;
				}// if- when double quotes 
				if (str.charAt(i) == '\"') {
					splitString[place] = element.toString();
					place++;
				}// if- only one quote, place element
			}// if- when there is a beginning quote
		}//for- goes thru each element 
		return splitString; 

	}//splitCSV

	public static String deLeet(String str) {
		StringBuffer leet = new StringBuffer(str);
		for (int i = 0; i < leet.length(); i++)
			switch (leet.charAt(i)) {
			case '+':
				leet.setCharAt(i, 't');
				break;
			case '3':
				leet.setCharAt(i, 'e');
				break;
			case '1':
				leet.setCharAt(i, 'l');
				break;
			case '0':
				leet.setCharAt(i, 'o');
				break;
			case '@':
				leet.setCharAt(i, 'a');
				break;
			case '|':
				if (leet.charAt(i + 1) == '3') {
					leet.replace(i, i + 2, "b");
					break;

				}
				if (leet.charAt(i + 1) == '\\') {
					leet.replace(i, i + 3, "n");
					break;
				}

			}
		return leet.toString();

	}// deLeet

	public static String nameGame(String name) {

		char[] vowels = { 'a', 'e', 'i', 'o', 'u', 'y' };
		StringBuffer stub = new StringBuffer(name.toLowerCase());
		String newStub = "";

		for (int i = 0; i < name.length(); i++) {
			for (int v = 0; v < vowels.length; v++) {
				if (stub.charAt(i) == vowels[v]) {
					newStub = stub.substring(i, stub.length()).toString();
					break;
				}//if vowel set newStuf
			}//for compare for vowel
			if (newStub.length() != 0)
				break; //if to stop for loop
		}//for find the first vowel

		return name + "!\n" + name + ", " + name + " bo B" + newStub
				+ " Bonana fanna fo F" + newStub + "\n" + "Fee fy mo M"
				+ newStub + ", " + name + "!";

	}//nameGame

}
/*
 * Used for finding functions: 
 * http://docs.oracle.com/javase/7/docs/api/java/lang/StringBuffer.html#insert(int, char)
 * http://docs.oracle.com/javase/6/docs/api/java/math/BigInteger.html
 * Forgot that switch is a thing:
 * http://stackoverflow.com/questions/10458719/efficiency-switch-statements-over-if-statements
 * Forgot that while is a thing:
 * http://www.tutorialspoint.com/java/java_loop_control.htm
 */
