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


        if(listener !=null){
            listener.onNewCard(card);
        }
    }


}
