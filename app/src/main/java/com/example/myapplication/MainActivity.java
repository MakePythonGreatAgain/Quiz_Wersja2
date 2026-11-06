package com.example.myapplication;

import static android.view.View.INVISIBLE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    protected static  ArrayList<Pytanie> pytanieLista;
    private ImageView imageView;
    private Button buttonTak, buttonNie, buttonNastepny, buttonPodpowiedz;

    private TextView textPytanie;
    private int indexPytanie = 0;
   private double punkty = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        WstawPytania();
        imageView = findViewById(R.id.imageView2);
        textPytanie = findViewById(R.id.textView3);
        buttonTak = findViewById(R.id.button1);
        buttonNie = findViewById(R.id.button2);
        buttonNastepny = findViewById(R.id.button5);
        buttonPodpowiedz = findViewById(R.id.button6);
        buttonPodpowiedz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //intencja jawna wiemy za pomocą czego ją wykonamy
                        Intent intent = new Intent(MainActivity.this, Podpowiedz_Activity.class);
                        intent.putExtra("NRP", indexPytanie);   //Numer Pytania
                        startActivity(intent);
                    }
                }
        );
        WyswietlPytanie(0);
        buttonNastepny.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        indexPytanie++;
                        if(indexPytanie < pytanieLista.size())
                        {
                            WyswietlPytanie(indexPytanie);
                        }
                        else {
                            buttonNastepny.setVisibility(INVISIBLE);

                            for(Pytanie pytanie : pytanieLista)
                            {
                                if(pytanie.isCzyPoprawnaOdpowiedz())
                                {
                                    punkty++;
                                }
                            }
                            textPytanie.setText("Koniec. Punkty: " + punkty + " / 3");
                            buttonTak.setVisibility(INVISIBLE);
                            buttonNie.setVisibility(INVISIBLE);
                        }

                    }


                }
        );
        buttonTak.setOnClickListener(view -> {
            ustawOdpowiedz(true);
        });
        buttonNie.setOnClickListener(view -> {
            ustawOdpowiedz(false);
        });


    }

    private void ustawOdpowiedz(boolean odpowiedz)
    {
        if(odpowiedz == pytanieLista.get(indexPytanie).isOdpowiedz())
        {
            pytanieLista.get(indexPytanie).setCzyPoprawnaOdpowiedz(false);
        }
        else {
            pytanieLista.get(indexPytanie).setCzyPoprawnaOdpowiedz(true);
        }

    }

    private void WyswietlPytanie(int ktore)
    {
        Pytanie pytanie = pytanieLista.get(ktore);
        imageView.setImageResource(pytanie.getIdZdjecia());
        textPytanie.setText(pytanie.getIdPytanie());

    }


    private void WstawPytania()
    {
        pytanieLista = new ArrayList<>();
        pytanieLista.add(new Pytanie(R.drawable.folk,"Czy to jest folk?", true, "Folk to Folk"));
        pytanieLista.add(new Pytanie(R.drawable.fraud,"Czy to jest bum?", true, "Engel's OC"));
        pytanieLista.add(new Pytanie(R.drawable.folk2,"czy Nietzsche folk jest gorszy od fraud Striner?", false, "Nigdy"));


    }
}