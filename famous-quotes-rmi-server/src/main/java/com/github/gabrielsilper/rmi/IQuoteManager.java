package com.github.gabrielsilper.rmi;

import com.github.gabrielsilper.models.Quote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IQuoteManager extends Remote {
    Quote save(Quote quote) throws RemoteException;
    Quote save(String message, String author, String language) throws RemoteException;
    List<Quote> getAll() throws RemoteException;
    Quote getById(long id) throws RemoteException;
}
