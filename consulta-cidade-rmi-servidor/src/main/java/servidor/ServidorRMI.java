package servidor;

import rmi.CidadeManager;
import rmi.ICidadeManager;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServidorRMI {
    private static final int port = 2000;

    public static void main(String[] args) throws RemoteException {
        ICidadeManager cidadeManager = new CidadeManager();

        Registry registry = LocateRegistry.createRegistry(port);

        registry.rebind("rmi://localhost:" + port + "/cidades", cidadeManager);

        System.out.println("Servidor RMI iniciado na porta " + port + "...");
    }
}
