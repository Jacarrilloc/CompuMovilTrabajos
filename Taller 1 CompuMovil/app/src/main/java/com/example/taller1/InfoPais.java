package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoPais extends AppCompatActivity {

    TextView nombrePais,capital,IntPais,sigla;
    ImageView bandera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_pais);

        nombrePais = findViewById(R.id.nombrePais);
        capital = findViewById(R.id.capitalPais);
        IntPais = findViewById(R.id.nombreIntPais);
        sigla = findViewById(R.id.nombreSigla);
        bandera = findViewById(R.id.bandera);

        Bundle informacion = getIntent().getBundleExtra("Bundle");

        String nombre = informacion.getString("seleccionKey");
        String capitalP = informacion.getString("CapitalKey");
        String intPais = informacion.getString("intKey");
        String siglaP = informacion.getString("SiglaKey");

        String ruta = informacion.getString("SiglaKey").toLowerCase();
        bandera.setImageResource(getResources().getIdentifier(ruta,"drawable",getPackageName()));

        nombrePais.setText(nombre);
        capital.setText("CAPITAL: " + capitalP);
        IntPais.setText("NOMBRE PAIS INT: " + intPais);
        sigla.setText("SIGLA: " + siglaP);

    }
}