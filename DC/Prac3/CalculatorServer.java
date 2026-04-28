import java.rmi.*;
import java.rmi.registry.*;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            // Create the remote object
            Calculator calc = new Calculator();
            
            // Get the RMI registry
            Registry registry = LocateRegistry.createRegistry(1099);
            
            // Bind the remote object to the registry
            registry.rebind("Calculator", calc);
            System.out.println("CalculatorServer is ready.");
        } catch (Exception e) {
            System.out.println("CalculatorServer exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
