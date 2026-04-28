import java.rmi.*;
import java.rmi.server.*;

public class Calculator extends UnicastRemoteObject implements ICalculator {
    public Calculator() throws RemoteException {}

    public int add(int a, int b) throws RemoteException {
        return a + b;
    }

    public int subtract(int a, int b) throws RemoteException {
        return a - b;
    }

    public int multiply(int a, int b) throws RemoteException {
        return a * b;
    }

    public int divide(int a, int b) throws RemoteException {
        if (b != 0)
            return a / b;
        else
            throw new ArithmeticException("Division by zero");
    }
}
