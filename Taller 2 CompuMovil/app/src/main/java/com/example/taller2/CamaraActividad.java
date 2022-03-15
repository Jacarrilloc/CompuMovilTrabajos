package com.example.taller2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CamaraActividad extends AppCompatActivity {

    Button seleccionar, camara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camara_actividad);

        seleccionar = findViewById(R.id.seleccionarImagen);
        camara = findViewById(R.id.camaraActividadCamara);

        seleccionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirGaleria();
            }
        });
    }

    private void abrirGaleria(){

    }
}