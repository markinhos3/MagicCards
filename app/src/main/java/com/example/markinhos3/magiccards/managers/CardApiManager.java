package com.example.markinhos3.magiccards.managers;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.markinhos3.magiccards.model.Card;
import com.example.markinhos3.magiccards.model.Deck;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Reader;
import java.io.StringReader;

public class CardApiManager {

    public interface CardApiManagerNewCardListener{
        public void onNewCard(Card card);
    }

    private CardApiManagerNewCardListener listener;

    public void setListener(CardApiManagerNewCardListener listener) {
        this.listener = listener;
    }

    public void newCard(Context context, Deck deck){
        RequestQueue queue = Volley.newRequestQueue(context);

        String url = "https://deckofcardsapi.com/api/deck/" + deck.getId() + "/draw/?count=1";
        Log.d("URL",url);

        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("RESPONSE", response);
                parseJSON(response);
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("HORROR", "Connection went to shit to the tracks");
            }
        });

        queue.add(request);
    }

    private void parseJSON(String response) {
        Reader reader= new StringReader(response);
        Gson gson = new GsonBuilder().create();

        CardEntity cardEntity = gson.fromJson(reader, CardEntity.class);

        Card card = new Card();
        card.setImage(cardEntity.getCards().get(0).getImage());
        if(cardEntity.getCards().get(0).getSuit().equals(Card.Suit.CLUBS)){
            card.setSuit(Card.Suit.CLUBS);
        }else if(cardEntity.getCards().get(0).getSuit().equals(Card.Suit.HEARTS)){
            card.setSuit(Card.Suit.HEARTS);
        }else if(cardEntity.getCards().get(0).getSuit().equals(Card.Suit.SPADES)){
            card.setSuit(Card.Suit.SPADES);
        }else if(cardEntity.getCards().get(0).getSuit().equals(Card.Suit.DIAMONDS)) {
            card.setSuit(Card.Suit.DIAMONDS);
        }
        card.setLeft(cardEntity.getRemaining());

        if(listener !=null){
            listener.onNewCard(card);
        }
    }


}
