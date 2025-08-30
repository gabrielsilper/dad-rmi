package servidor;

import rmi.ICalculadora;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

public class Calculadora extends UnicastRemoteObject implements ICalculadora {
    protected Calculadora() throws RemoteException {
        super();
    }

    protected Calculadora(int port) throws RemoteException {
        super(port);
    }

    @Override
    public double somar(double valor1, double valor2) throws RemoteException {
        System.out.printf("Método somar chamado com valores: %.2f e %.2f\n", valor1, valor2);
        return valor1 + valor2;
    }

    @Override
    public double subtrair(double valor1, double valor2) throws RemoteException {
        System.out.printf("Método subtrair chamado com valores: %.2f e %.2f\n", valor1, valor2);
        return valor1 - valor2;
    }

    @Override
    public double multiplicar(double valor1, double valor2) throws RemoteException {
        System.out.printf("Método multiplicar chamado com valores: %.2f e %.2f\n", valor1, valor2);
        return valor1 * valor2;
    }

    @Override
    public double dividir(double valor1, double valor2) throws RemoteException {
        System.out.printf("Método dividir chamado com valores: %.2f e %.2f\n", valor1, valor2);
        return valor1/valor2;
    }
}
