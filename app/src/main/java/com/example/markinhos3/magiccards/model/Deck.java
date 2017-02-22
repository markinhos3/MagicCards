package com.example.markinhos3.magiccards.model;



public class Deck {
    private int remaining;
    private String id;

    // necesito constructor vacío para poder usar REALM
    public Deck(){

    }

    // constructor del Deck que le pase el id
    public Deck(String id) {
        this.id = id;
    }

    // métodos de las vbles privadas
    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    //---------------
}
