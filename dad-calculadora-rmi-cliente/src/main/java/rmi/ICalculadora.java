package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICalculadora extends Remote {
    double somar (double valor1, double valor2) throws RemoteException;
    double subtrair (double valor1, double valor2) throws RemoteException;
    double multiplicar (double valor1, double valor2) throws RemoteException;
    double dividir (double valor1, double valor2) throws RemoteException;
}
