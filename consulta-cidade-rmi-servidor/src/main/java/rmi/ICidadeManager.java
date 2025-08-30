package rmi;

import models.Cidade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ICidadeManager extends Remote {
    List<Cidade> getCidades() throws RemoteException;
    List<Cidade> getCidadesbySiglaEstado(String sigla) throws RemoteException;
}
