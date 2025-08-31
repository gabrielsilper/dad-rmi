package com.github.gabrielsilper;

import com.github.gabrielsilper.models.Quote;
import com.github.gabrielsilper.rmi.IQuoteManager;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
    private static final int port = 2000;

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(port);

        IQuoteManager quoteManager = (IQuoteManager) registry.lookup("rmi://localhost:" + port + "/quotes");

        quoteManager.save("Life is what happens when you're busy making other plans.", "John Lennon", "en-US");
        quoteManager.save("The greatest glory in living lies not in never falling, but in rising every time we fall.", "Nelson Mandela", "en-US");
        quoteManager.save("In the end, we will remember not the words of our enemies, but the silence of our friends.", "Martin Luther King Jr.", "en-US");

        for (Quote quote : quoteManager.getAll()){
            System.out.println(quote);
        }
    }
}
