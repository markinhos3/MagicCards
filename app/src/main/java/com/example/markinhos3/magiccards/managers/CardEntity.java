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

    // para la clase Cards
    public class Cards{
        @SerializedName("image") private String image;
        @SerializedName("value") private String value;
        @SerializedName("suit") private String suit;
        @SerializedName("code") private String code;


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



        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }


}