package cost;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
	/*
	 * input of a text 
	 * 
	 */
	public String inText(){
		Scanner s = new Scanner(System.in);
		String result="";
		try{
			result=s.nextLine();
		} catch(InputMismatchException e){
			System.out.println("Wrong input!");
			return inText();
		}
		return result;
	}
	
	/*
	 * input of numbers 
	 * 
	 */
	public int inNum(){
		Scanner i = new Scanner(System.in);
		int result=0;
		try{
			result=i.nextInt();
		} catch(InputMismatchException e){
			System.out.println("Wrong input!");
			return inNum();
		}
		return result;
	}
}
