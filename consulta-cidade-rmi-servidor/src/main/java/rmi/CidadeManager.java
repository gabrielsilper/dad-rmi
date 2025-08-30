package rmi;

import models.Cidade;
import models.Estado;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class CidadeManager extends UnicastRemoteObject implements ICidadeManager{
    private final List<Cidade> cidades = new ArrayList<>();

    private void carregaCidades(){
        Estado estado1 = new Estado("Amazonas", "AM");
        Estado estado2 = new Estado("Pará", "PA");

        cidades.add(new Cidade("Manaus", estado1));
        cidades.add(new Cidade("Iranduba", estado1));
        cidades.add(new Cidade("Itacoatiara", estado1));

        cidades.add(new Cidade("Belém", estado2));

        System.out.println("Cidades carregadas...");
    }

    public CidadeManager() throws RemoteException {
        super();
        carregaCidades();
    }

    @Override
    public List<Cidade> getCidades() {
        System.out.println("Método getCidades invocado.");
        return cidades;
    }

    @Override
    public List<Cidade> getCidadesbySiglaEstado(String sigla) throws RemoteException {
        return cidades.stream().filter(cidade -> cidade.getEstado().getSigla().equals(sigla)).toList();
    }
}
