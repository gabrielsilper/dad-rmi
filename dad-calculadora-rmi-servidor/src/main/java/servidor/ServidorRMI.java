package servidor;

import rmi.ICalculadora;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServidorRMI {
    private final static int port = 2000;

    public static void main(String[] args) throws RemoteException {
        ICalculadora calculadora = new Calculadora();

        Registry registry = LocateRegistry.createRegistry(port);
        registry.rebind("rmi://localhost:" + port + "/calculadora", calculadora);

        System.out.println("Servidor RMI iniciado na porta " + port + "...");
    }
}
