
public class calculator {

	private static String[] RomanNumerals = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

	public static String calculate(String input) throws Exception {
		
		int operation;
		String[] variables;
		if (input.contains("+")) {
			operation = 1;
			variables = input.split("\\+");
		} else if (input.contains("-")) {
			operation = 2;
			variables = input.split("\\-");
		} else if (input.contains("*")) {
			operation = 3;
			variables = input.split("\\*");
		} else if (input.contains("/")) {
			operation = 4;
			variables = input.split("\\/");
		} else throw new Exception("Found no operation symbol");
		
		if (variables.length != 2) throw new Exception("");
		
		int variable1;
		int variable2;	
		boolean numeralType = checkNumberType(variables);
		
		if (numeralType) {
			variable1 = convertFromRoman(variables[0]);
			variable2 = convertFromRoman(variables[1]); 
		} else {
			variable1 = Integer.parseInt(variables[0]);
			variable2 = Integer.parseInt(variables[1]);
		}
		
		int variableResult = 0;
		if (operation == 1) {
			variableResult = variable1 + variable2;
		} else if (operation == 2) {
			variableResult = variable1 - variable2;
		} else if (operation == 3) {
			variableResult = variable1 * variable2;
		} else if (operation == 4) {
			variableResult = variable1 / variable2;
		}
		
		if (numeralType) {
			return convertToRoman(variableResult);
		} else {
			return String.valueOf(variableResult);
		}
		
	}
		
	private static boolean checkNumberType(String[] input) throws Exception {
		boolean i1 = checkIfNumberIsRoman(input[0]);
		boolean i2 = checkIfNumberIsRoman(input[1]);
		if (i1 && i2) return true;
		else if (!i1 && !i2) return false;
		throw new Exception("Numbers don't match");
	}
	
	private static boolean checkIfNumberIsRoman(String input) {
		for (String s : RomanNumerals) {
			if (s.equals(input)) return true;
		}
		return false;
	}

	private static String convertToRoman(int i) throws Exception{
		if (i <= 10) return RomanNumerals[i - 1];
		else if (i <= 39) {
			String result = "";
			while (i > 10) {
				i -= 10;
				result += RomanNumerals[9];
			}
			result += RomanNumerals[i-1];
			return result;
		} else if (i == 40) return "XL";
		else if (i <= 49) {
			return "XL" + RomanNumerals[i-40-1];
		} else if (i == 50) return "L";
		else if (i <= 89) {
			String result = "L";
			i -= 50;
			while (i > 10) {
				i -= 10;
				result += RomanNumerals[9];
			}
			result += RomanNumerals[i-1];
			return result;
		} else if (i == 90) return "XC";
		else if (i < 99) {
			return "XC" + RomanNumerals[i-90-1];
		} else if (i == 100) return "C";
		throw new Exception("Number out of range");
	}
	
	private static int convertFromRoman(String s) throws Exception {
		int i = 1;
		for (String rom : RomanNumerals) {
			if (s.equals(rom)) return i;
			i++;
		}
		throw new Exception("Couldn't convert numeral from roman");
	}
	
}
