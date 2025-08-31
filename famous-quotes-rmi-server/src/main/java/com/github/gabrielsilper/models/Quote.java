package com.github.gabrielsilper.models;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Quote implements Serializable {
    @Serial
    private final static long serialVersionUID = 1L;
    private long id;
    private String message;
    private String author;
    private String language;

    public Quote(String message, String author, String language) {
        this.message = message;
        this.author = author;
        this.language = language;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Quote quote = (Quote) o;
        return id == quote.id && Objects.equals(message, quote.message) && Objects.equals(author, quote.author) && Objects.equals(language, quote.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, author, language);
    }

    @Override
    public String toString() {
        return "Quote{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", author='" + author + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
