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

    public void setOnNewCardListener(CardApiManagerNewCardListener listener) {
        this.listener = listener;
    }

    public void newCard(Context context, Deck deck){
        // creo una cola de peticiones
        RequestQueue queue = Volley.newRequestQueue(context);

        String URL = "https://deckofcardsapi.com/api/deck/" + deck.getId() + "/draw/?count=1";

        // hago la petición
        StringRequest request = new StringRequest(URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) { // all ok
                Log.d("RESPONSE", response); // le paso la respuesta del servidor
                parseJSON(response);
            }
        }, new Response.ErrorListener(){ // not all ok
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("HORROR", "Connection went to shit to the tracks");
            }
        });

        // saco la petición con la cola
        queue.add(request);
    }

    // parseo del JSON
    private void parseJSON(String response) {
        Reader reader= new StringReader(response);
        Gson gson = new GsonBuilder().create();



        CardEntity cardEntity = gson.fromJson(reader, CardEntity.class);

        // manejo Card para hacer un mapeo de los datos
        Card card = new Card();
        card.setImage(cardEntity.getCards().get(0).getImage());

        switch (cardEntity.getCards().get(0).getSuit()){

            case "card.setSuit(String.valueOf(Card.Suit.CLUBS)":
                break;
            case "card.setSuit(String.valueOf(Card.Suit.HEARTS)":
                break;
            case "card.setSuit(String.valueOf(Card.Suit.SPADES)":
                break;
            case "card.setSuit(String.valueOf(Card.Suit.DIAMONDS)":
                break;
            default:
                card.setLeft(cardEntity.getRemaining());
        }

        // hago el listener
        if(listener !=null){
            listener.onNewCard(card);
        }
    }


}
