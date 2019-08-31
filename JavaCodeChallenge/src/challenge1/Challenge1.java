package challenge1;

import java.util.Scanner;

public class Challenge1 {

	public static void main(String[] args) {
		int cgn = getComputerNumber();
		String output = "";
		int guessNum = 1;
		while (!output.equals("MMM")) {
			int usn = getUserInput(guessNum++);
			output = getOutput(cgn, usn);
			System.out.print("cryptic message : " + output + "\n");
		}
		System.out.println("final output : " + (guessNum - 1));
	}
	
	static int getComputerNumber() {
		// computer generates a 3 digit number
		return 573;
	}
	
	@SuppressWarnings("resource")
	static int getUserInput(int guessNum) {
		// user inputs a 3 digit number
		System.out.print("guess " + guessNum + " : ");
		return new Scanner(System.in).nextInt();
	}
	
	static String getOutput(int cgn, int usn) {

		// if value and index of a digit matches, it is M
		// if none matches, it is X
		// else value matches, but at different index P
		
		int[] cgnDigits = getDigits(cgn);
		int[] usnDigits = getDigits(usn);
		
		String returnString = "";
		
		for(int i = 0; i < cgnDigits.length; i++) {
			int j = 0;
			for(; j < usnDigits.length; j++){
				if (cgnDigits[i] == usnDigits[j]) {
					if(i == j) {
						returnString += "M";
						break;
					}
					else {
						returnString += "P";
						break;
					}
				}
			}
			if (j==3)
				returnString += "X";
		}
		
		return returnString;
	}
	
	static int[] getDigits(int number) {
		int[] returnDigits = new int[3];
		int i = 2;
		while(number!=0) {
			returnDigits[i--] = number % 10;
			number -= number%10;
			number /= 10;
		}
		
		return returnDigits;
	}
}
