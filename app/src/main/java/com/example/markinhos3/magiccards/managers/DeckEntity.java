package com.example.markinhos3.magiccards.managers;

// clase para sacar las cosas del objeto de la dirección: https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1
/*
{
        "remaining": 52,
        "success": true,
        "deck_id": "9rh0uat27tg4",
        "shuffled": true
        }
*/

// parsear es comprobar que la sintaxis es correcta -> trocear en cachos el código que se recibe

import com.google.gson.annotations.SerializedName;

public class DeckEntity { // en el ENTITY => SE PARSEA TODDO aunque luego en el DECK SE UTILICE SÓLO LO QUE QUERAMOS DE ESE PARSEO

    // cojo/parseo todos los datos aunque luego use sólo 2
    @SerializedName("remaining") private int remaining;
    @SerializedName ("deck_id") private String deck_id;
    @SerializedName ("success") private boolean success;
    @SerializedName ("shuffled") private boolean shuffled;

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public String getDeck_id() {
        return deck_id;
    }

    public void setDeck_id(String deck_id) {
        this.deck_id = deck_id;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isShuffled() {
        return shuffled;
    }

    public void setShuffled(boolean shuffled) {
        this.shuffled = shuffled;
    }
}


