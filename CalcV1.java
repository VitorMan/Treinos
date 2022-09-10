/**
 * 
 */
/**
 * @author VitorManoel
 *
 */
package calculadoraV1;

import java.util.Scanner;

public class CalcV1 {
	//version 1.0
	public static void main(String args[]) {
		Scanner keyB = new Scanner(System.in);
		System.out.println("============================================================");
		System.out.println("                        Calculadora 1.0                     ");
		System.out.println("============================================================");
		System.out.println("\n");
		
		System.out.println("digite um numero e tecle enter");
		int a = keyB.nextInt();
		System.out.println("digite a operação desejada e tecle enter");
		String op=keyB.next();
		@SuppressWarnings("unused")
		boolean validOp = false;
		do{
			switch (op){
			case "+":
				validOp=true;
				System.out.println("digite um numero para somar e tecle enter");
				break;
			case "-":
				validOp=true;
				System.out.println("digite um numero para subtrair e tecle enter");
				break;
			case "X":
				validOp=true;
				System.out.println("digite um numero para multiplicar e tecle enter");
				break;
			case "*":
				validOp=true;
				System.out.println("digite um numero para multiplicar e tecle enter");
				break;
			case "/":
				validOp=true;
				System.out.println("digite um numero para dividir e tecle enter");
				break;
			default:
				System.out.println("Operação invalida \n digite a operação desejada e tecle enter");
				op = keyB.next();
				break;
			}
		}while(validOp==false);
		int b = keyB.nextInt();
		switch (op){
		case "+":
			System.out.println(a+b);
			break;
		case "-":
			System.out.println(a-b);
			break;
		case "X":
			System.out.println(a*b);
			break;
		case "*":
			System.out.println(a*b);
			break;
		case "/":
			System.out.println(a/b);
			break;
		}
		keyB.close();
	}
}
