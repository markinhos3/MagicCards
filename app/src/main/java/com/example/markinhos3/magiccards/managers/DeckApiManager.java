package com.example.markinhos3.magiccards.managers;


import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.markinhos3.magiccards.R;
import com.example.markinhos3.magiccards.model.Deck;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Reader;
import java.io.StringReader;

public class DeckApiManager {

    // me creo como una cte la dirección donde hago la petición que es fija
    private static final String NEW_DECK_REQUEST ="https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1";


    // ---- objeto que está interesado en la petición que hace new Deck; la única manera de devolver el Deck es crando una interface para hacer un objeto LISTENER

    public interface DeckApiManagerNewDeckListener{
        public void onNewDeck (Deck deck);
    }

    private DeckApiManagerNewDeckListener listener;

    public void setOnNewDeckListener(DeckApiManagerNewDeckListener listener){
        this.listener = listener;
    }
    // ---------------------------


    //------------- un método que me de un NUEVO Deck: al ejecutarlo con el contexto me crea una cola de peticiones de Volley ------------
    public void newDeck(Context context){ // es donde hago la petición de Volley -> necesito un contexto

        // creo una cola de peticiones
        RequestQueue queue = Volley.newRequestQueue(context); //aquí me pide el context

        //petición al servidor de las cartas
        StringRequest request = new StringRequest(NEW_DECK_REQUEST, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) { //all OK
                Log.d("RESPONSE", response); // le paso la respuesta del servidor

                parseJSON(response);
            }
        }, new Response.ErrorListener() { // not all OK
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("HORROR", "Connection went to shit to the tracks");

            }
        });

        // ahora LANZO la PETICIÓN; la cola saca la petición
        queue.add(request);
    }
    //----------------------------------------------


    // ----------- método para PARSEAR EL JASON: utilizamos GSON, con el Reader voy leyendo línea a línea y construyo cosas de tipo deckEntity
    private void parseJSON(String response) {

        //objeto que va a leer la respuesta y lo va a convertir en objeto
        Gson gson = new GsonBuilder().create();

        Reader reader = new StringReader(response);
        //objeto que me creará JSON al parsearlo
        DeckEntity deckEntity = gson.fromJson(reader, DeckEntity.class);

        //voy a manejar el Deck (que tiene los campos que me interesan a mi) no el DeckEntity: hago un MAPEO DE LOS DATOS
        Deck deck = new Deck();
        deck.setId(deckEntity.getDeck_id());
        deck.setRemaining(deckEntity.getRemaining());

        // hago el listener
        if (listener != null){
            listener.onNewDeck(deck);
        }
    }

}
