package ro.tm.siit.homework.w2d2;

public class CalculatorApp {

	public static void main(String[] args) {
		double result;
		double firstOperand = Double.parseDouble(args[0]);
		String operator = args[1];
		double secondOperand = Double.parseDouble(args[2]);
	
		switch (operator) {
			case "+":
				result = firstOperand + secondOperand;
				System.out.println("Result = " + result);
				break;
			case "-":
				result = firstOperand - secondOperand;
				System.out.println("Result = " + result);
				break;
			case "x":
				result = firstOperand * secondOperand;
				System.out.println("Result = " + result);
				break;
			case "/":
				if (secondOperand == 0) {
					System.out.println("Division not possible");
				} else {
					result = firstOperand / secondOperand;
					System.out.println("Result = " + result);
				}
				break;
			default:
				System.out.println("Operator not recognized");
				break;
		}
	}
}
