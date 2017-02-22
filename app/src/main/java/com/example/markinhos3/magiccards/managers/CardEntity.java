package com.example.markinhos3.magiccards.managers;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CardEntity {

    // parseo los datos principales
    @SerializedName("success") private boolean success;
    @SerializedName("cards") private List<Cards> cards;
    @SerializedName("deck_id") private String deck_id;
    @SerializedName("remaining") private int remaining;


    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getDeck_id() {
        return deck_id;
    }

    public void setDeck_id(String deck_id) {
        this.deck_id = deck_id;
    }

    public List<Cards> getCards() {
        return cards;
    }

    public void setCards(List<Cards> cards) {
        this.cards = cards;
    }


}