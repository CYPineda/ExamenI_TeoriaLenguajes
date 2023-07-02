package com.example.exameni_teorialenguajes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*public void NuevoFut(View view){
        Intent nuevofut = new Intent(this, NuevoFut.class);
        startActivity(nuevofut);
    }*/

    public void ActivityIngresarNuevoFutbolista(View view){
        Intent nuevofut = new Intent(this, ActivityIngresarNuevoFutbolista.class);
        startActivity(nuevofut);
    }
    public void ActivityListFutbolista(View view){
        Intent ListaFut = new Intent(this, ActivityListFutbolista.class);
        startActivity(ListaFut);
    }
}