package com.example.markinhos3.magiccards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.markinhos3.magiccards.managers.DeckApiManager;
import com.example.markinhos3.magiccards.model.Deck;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DeckApiManager apiManager = new DeckApiManager();

        // cuando llegue NewDeck hago cosas
        apiManager.setOnNewDeckListener(new DeckApiManager.DeckApiManagerNewDeckListener() {
            @Override
            public void onNewDeck(Deck deck) {
                //Log.d("","");
            }
        });
        apiManager.newDeck(this);
    }
}
