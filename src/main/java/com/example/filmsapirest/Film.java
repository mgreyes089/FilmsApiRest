package com.example.filmsapirest;

public class Film {

    private String title;
    private String author;
    private boolean isPorn;

    public Film(String title, String author, boolean isPorno) throws Exception {
        checkTitle (title);
        checkAuthor(author);
        this.title = title;
        this.author = author;
        this.isPorn = isPorn;
    }

    private void checkTitle(String title) throws Exception {
        if (title.equals("")) throw new Exception();
    }

    private void checkAuthor(String author) throws Exception {
        if (author.equals("")) throw new Exception();
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isPorn() {
        return isPorn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) throws Exception {
        checkAuthor(author);
        this.author = author;
    }

    public void setIsPorn(boolean porn) {
        this.isPorn = isPorn;
    }


}
