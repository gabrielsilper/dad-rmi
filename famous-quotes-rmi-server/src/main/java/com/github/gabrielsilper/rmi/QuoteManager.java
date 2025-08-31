package com.github.gabrielsilper.rmi;

import com.github.gabrielsilper.database.QuotesDatabase;
import com.github.gabrielsilper.models.Quote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class QuoteManager extends UnicastRemoteObject implements IQuoteManager{
    private final QuotesDatabase quotesDB;

    public QuoteManager(QuotesDatabase quotesDB) throws RemoteException {
        super();
        this.quotesDB = quotesDB;
    }

    @Override
    public Quote save(Quote quote) throws RemoteException {
        return quotesDB.save(quote);
    }

    @Override
    public Quote save(String message, String author, String language) throws RemoteException {
        return quotesDB.save(message, author, language);
    }

    @Override
    public List<Quote> getAll() throws RemoteException {
        return quotesDB.findAll();
    }

    @Override
    public Quote getById(long id) throws RemoteException {
        return quotesDB.findById(id);
    }
}
