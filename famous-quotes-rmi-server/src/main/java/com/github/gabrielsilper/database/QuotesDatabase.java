package com.github.gabrielsilper.database;

import com.github.gabrielsilper.models.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QuotesDatabase {
    private static final Logger log = LoggerFactory.getLogger(QuotesDatabase.class);
    private final List<Quote> quotes;
    private long currentID;

    public QuotesDatabase() {
        this.quotes = new ArrayList<>();
        this.currentID = 1;
        log.info("Database iniciado!");
    }

    public Quote save(Quote quote) {
        quote.setId(currentID);
        quotes.add(quote);
        log.info("Nova citação salva com id {}.", currentID);
        currentID++;
        return quote;
    }

    public Quote save(String message, String author, String language) {
        Quote quote = new Quote(message, author, language);
        return save(quote);
    }

    public List<Quote> findAll() {
        log.info("Todas as citações retornadas");
        return quotes;
    }

    public Quote findById(long id) {
        Optional<Quote> findedQuote = quotes.stream().filter(quote -> quote.getId() == id).findFirst();

        if (findedQuote.isPresent()) {
            log.info("Citação com id {} encontrada!", id);
            return findedQuote.get();
        }

        log.warn("Nenhuma citação encontrada com id {}!", id);
        return null;
    }
}
