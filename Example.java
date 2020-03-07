import java.util.InputMismatchException;
import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true) {
            try {
                System.out.print("Input 1st Number: ");
                int x = scan.nextInt();
    
                System.out.print("Input 2nd Number: ");
                int y = scan.nextInt();

                double z = x / y;
                System.out.println("The quotient is: " + z);
                break;
            } catch(ArithmeticException e) {
                System.out.println("Arithmetic Exception");
                System.out.println("Try again");
            } catch(InputMismatchException e) {
                System.out.println("Input valid value.");
                System.out.println("Try again");         
            }

        }
        scan.close();
    }
}