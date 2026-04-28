import java.rmi.*;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            // Get the registry and look up the remote object
            ICalculator calc = (ICalculator) Naming.lookup("rmi://" + args[0] + "/Calculator");
            
            // Call remote methods
            System.out.println("Addition: " + calc.add(5, 3));
            System.out.println("Subtraction: " + calc.subtract(5, 3));
            System.out.println("Multiplication: " + calc.multiply(5, 3));
            System.out.println("Division: " + calc.divide(5, 3));
        } catch (Exception e) {
            System.out.println("CalculatorClient exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
