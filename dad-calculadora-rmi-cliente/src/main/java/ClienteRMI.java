import rmi.ICalculadora;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClienteRMI {
    private final static String host = "";
    private final static int port = 2000;


    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(port);

        String[] registries = registry.list();

        for (String registryString: registries){
            System.out.println(registryString);
        }

        ICalculadora calculadora = (ICalculadora) registry.lookup("rmi://localhost:2000/calculadora");

        double somar = calculadora.multiplicar(10, 30);
        System.out.println(somar);
    }
}