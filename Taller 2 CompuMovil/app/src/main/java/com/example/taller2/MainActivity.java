package com.example.taller2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton camara,contactos, ubicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        camara = findViewById(R.id.botonCamara);
        contactos = findViewById(R.id.botonContacto);
        ubicacion = findViewById(R.id.botonUbicacion);

        camara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCamara(v);
            }
        });

        contactos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { clicContactos(v); }
        });

    }

    private void clickCamara(View v){
        Intent actividadCamara = new Intent(v.getContext(),CamaraActividad.class);
        startActivity(actividadCamara);
    }

    private void clicContactos(View v){
        Intent actividadContacto = new Intent(v.getContext(),ContactosActividad.class);
        startActivity(actividadContacto);
    }
}