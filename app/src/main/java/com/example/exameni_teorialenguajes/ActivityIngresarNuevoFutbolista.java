package com.example.exameni_teorialenguajes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.exameni_teorialenguajes.configuracion.ConfigDB;
import com.example.exameni_teorialenguajes.configuracion.SQLiteConnection;

public class ActivityIngresarNuevoFutbolista extends AppCompatActivity {



    EditText id, nombres, apellidos, edad;
    Spinner paises,posicion;
    Button btningresarfut;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_nuevo_futbolista);

        id = (EditText) findViewById(R.id.txtid);
        nombres = (EditText) findViewById(R.id.txtnombrefut);
        apellidos = (EditText) findViewById(R.id.txtapellidofut);
        paises = (Spinner) findViewById(R.id.cmbpaisesfut);
        posicion = (Spinner) findViewById(R.id.cmbposicionesfut);
        edad = (EditText) findViewById(R.id.txtedadfut);
        btningresarfut = (Button) findViewById(R.id.btningresarfut);

        btningresarfut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertar_datos();
            }
        });
    }

    private void insertar_datos() {
        SQLiteConnection conexion = new SQLiteConnection(this, ConfigDB.namebd, null,1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ConfigDB.nombres,nombres.getText().toString());
        values.put(ConfigDB.apellidos,apellidos.getText().toString());
        values.put(ConfigDB.paises,paises.getSelectedItem().toString());
        values.put(ConfigDB.posiciones,posicion.getSelectedItem().toString());
        values.put(ConfigDB.edad,edad.getText().toString());

        Long resultado = db.insert(ConfigDB.tblfutbolistas, ConfigDB.id, values);
        if(resultado > 0)
        {
            Toast.makeText(getApplicationContext(), "Registro ingresado con exito",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Registro no se ingreso",Toast.LENGTH_LONG).show();
        }

        db.close();

        ClearScreen();
    }

    private void ClearScreen()
    {
        nombres.setText(ConfigDB.Empty);
        apellidos.setText(ConfigDB.Empty);
        edad.setText(ConfigDB.Empty);
    }

    public void Menu(View view){
        Intent menu = new Intent(this, MainActivity.class);
        startActivity(menu);
    }

}