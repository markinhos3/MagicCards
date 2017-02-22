package com.example.markinhos3.magiccards.model;



public class Card {

    // me creo un enumerable para los palos de la baraja francesa
    public enum Suit {
        SPADES,
        HEARTS,
        DIAMONS,
        CLUBS
    }

    // vamos a trincar los datos de cartas (2 campos)
    private String suit; // palo de la baraja
    private String image;

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
