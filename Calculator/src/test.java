import java.util.Scanner;

public class test {
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		try {
			calculator calc = new calculator();
			System.out.print(calc.calculate(scan.next()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
