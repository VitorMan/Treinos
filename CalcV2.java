package calculadoraV2;

//import java.text.DecimalFormat;
import java.util.Scanner;

public class CalcV2 {
	static void print(int in) {
		System.out.println(in);
	}
	static void print(String in) {
		System.out.println(in);
	}
	static void print(double in) {
		System.out.println(in);
	}
	public static void main(String args[]) {
		int a,b,op,result;
		print("==================================================");
		print("                Calculadora v2                    ");
		print("==================================================");
		
		Scanner keyB = new Scanner(System.in);
		
		System.out.println("digite um numero e tecle enter");
		a = keyB.nextInt();
		System.out.println("digite o numero que representa a operacao desejada e tecle enter \n "
				+ "1:soma \n "
				+ "2:subtracao \n "
				+ "3:multiplicacao \n "
				+ "4:divisao \n "
				+ "5:exponenciacao \n "
				+ "6:raiz quadrada");
		op = keyB.nextInt();
		boolean validOp=false;
		//DecimalFormat Format = new DecimalFormat("#,##0.00");
		do{
			switch(op) {
			case 1:
				validOp=true;
				System.out.println("digite um numero para somar e tecle enter");
				b=keyB.nextInt();
				result = a+b;
				print(a+"+"+b+"= "+result);
				break;
			case 2:
				validOp=true;
				System.out.println("digite um numero para subtrair e tecle enter");
				b=keyB.nextInt();
				result = a-b;
				print(a+"-"+b+"= "+result);
				break;
			case 3:
				validOp=true;
				System.out.println("digite um numero para multiplicar e tecle enter");
				b=keyB.nextInt();
				result =a*b;
				print(a+"*"+b+"= "+result);
				break;
			case 4:
				validOp=true;
				System.out.println("digite um numero para dividir e tecle enter");
				b=keyB.nextInt();
				result= a/b;
				print(a+"/"+b+"= "+result);
				break;
			case 5:
				validOp=true;
				System.out.println("digite um numero para elevar e tecle enter");
				b=keyB.nextInt();
				result=(int)Math.pow(a, b);
				print(a+"^"+b+"= "+result);
				break;
			case 6:
				validOp=true;
				print((int)Math.sqrt(a));
				break;
			default:
				System.out.println("Operação invalida \n digite a operação desejada e tecle enter");
				op = keyB.nextInt();
				break;
			}
		}while(validOp==false);
		keyB.close();
	}
}
