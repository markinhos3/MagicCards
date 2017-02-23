package com.example.markinhos3.magiccards.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.markinhos3.magiccards.R;
import com.example.markinhos3.magiccards.managers.CardApiManager;
import com.example.markinhos3.magiccards.managers.DeckApiManager;
import com.example.markinhos3.magiccards.model.Card;
import com.example.markinhos3.magiccards.model.Deck;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

   private Deck deck;

    @BindView(R.id.activity_main___cards_remain_text) TextView cardsRemain;
    @BindView(R.id.activity_main___card_image) ImageView cardImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        DeckApiManager apiManager = new DeckApiManager();
        apiManager.setOnNewDeckListener(new DeckApiManager.DeckApiManagerNewDeckListener() {
            @Override
            public void onNewDeck(Deck deckFromJson) {
                cardsRemain.setText("" + deckFromJson.getRemaining());
                deck = deckFromJson;
            }
        });
        apiManager.newDeck(this);

        cardImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CardApiManager cardApiManager = new CardApiManager();
                cardApiManager.setListener(new CardApiManager.CardApiManagerNewCardListener() {
                    @Override
                    public void onNewCard(Card card) {

                        // Añadiendo Picasso
                        Picasso.with(MainActivity.this).load(card.getImage()).placeholder(R.drawable.card_back).into(cardImage);
                        cardsRemain.setText("" + card.getLeft());
                    }
                });
                cardApiManager.newCard(v.getContext(), deck);
            }
        });


    }
}
