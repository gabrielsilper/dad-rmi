package com.github.gabrielsilper;

import com.github.gabrielsilper.database.QuotesDatabase;
import com.github.gabrielsilper.rmi.QuoteManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    private static final int port = 2000;
    private static final Logger log = LoggerFactory.getLogger(RMIServer.class);

    public static void main(String[] args) throws RemoteException {
        QuotesDatabase db = new QuotesDatabase();

        QuoteManager quoteManager = new QuoteManager(db);

        Registry registry = LocateRegistry.createRegistry(port);

        registry.rebind("rmi://localhost:" + port + "/quotes", quoteManager);

        log.info("Servidor RMI escutando na porta {}...", port);
    }
}
