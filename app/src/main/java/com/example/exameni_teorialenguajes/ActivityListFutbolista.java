package com.example.exameni_teorialenguajes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.exameni_teorialenguajes.configuracion.ConfigDB;
import com.example.exameni_teorialenguajes.configuracion.SQLiteConnection;
import com.example.exameni_teorialenguajes.configuracion.futbolistas;

import java.util.ArrayList;

public class ActivityListFutbolista extends AppCompatActivity {

    SQLiteConnection conexion;
    ListView list;
    ArrayList<futbolistas> listfutbolistas;
    ArrayList<String> arreglofutbolistas;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_futbolista);

        conexion = new SQLiteConnection(this, ConfigDB.namebd, null, 1);
        list = (ListView) findViewById(R.id.ListaFut);

        ObtenerTabla();

        ArrayAdapter apd = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arreglofutbolistas);
        list.setAdapter(apd);

    }

    private void ObtenerTabla()
    {
        SQLiteDatabase db = conexion.getReadableDatabase();
        futbolistas futbol = null;
        listfutbolistas = new ArrayList<futbolistas>();

        // Cursor de Base de Datos
        Cursor cursor = db.rawQuery(ConfigDB.SelectTBFutbolistas,null);

        // recorremos el cursor
        while(cursor.moveToNext())
        {
            futbol = new futbolistas();
            futbol.setId(cursor.getInt(0));
            futbol.setNombres(cursor.getString(1));
            futbol.setApellidos(cursor.getString(2));
            futbol.setPaises(cursor.getString(3));
            futbol.setPosiciones(cursor.getString(4));
            futbol.setEdad(cursor.getInt(5));
            listfutbolistas.add(futbol);
        }

        cursor.close();

        fillData();
    }

    private void fillData()
    {
        arreglofutbolistas = new ArrayList<String>();

        for(int i=0; i < listfutbolistas.size(); i++)
        {
            arreglofutbolistas.add(listfutbolistas.get(i).getId() + " - "
                    +listfutbolistas.get(i).getNombres() + " "
                    +listfutbolistas.get(i).getApellidos() + " - "
                    +listfutbolistas.get(i).getPaises());
        }
    }

    public void Menu(View view){
        Intent menu = new Intent(this, MainActivity.class);
        startActivity(menu);
    }
}