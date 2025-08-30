import models.Cidade;
import rmi.ICidadeManager;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class ConsultaCidadeCliente {
    private static final int port = 2000;

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(port);

        String[] registries = registry.list();

        for (String registryString : registries){
            System.out.println(registryString);
        }

        ICidadeManager cidadeManager = (ICidadeManager) registry.lookup("rmi://localhost:" + port + "/cidades");

        List<Cidade> cidades = cidadeManager.getCidadesbySiglaEstado("PA");

        for (Cidade cidade : cidades){
            System.out.println(cidade);
        }
    }
}