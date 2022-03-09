package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button BotonFibonacci;
    Button BotonFactorial;
    Button BotonPaises;

    EditText numeros;

    TextView factorial;

    Spinner opcionFact;

    static int contadorActividades = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BotonFibonacci = findViewById(R.id.BotonFibonacci);
        BotonFactorial = findViewById(R.id.BotonFactorial);
        BotonPaises = findViewById(R.id.BotonPaises);

        opcionFact = findViewById(R.id.OpcionFact);

        numeros = findViewById(R.id.IngresarNumeros);

        factorial = findViewById(R.id.TextoFactorial);

        BotonFibonacci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (numeros.getText().toString().trim().equalsIgnoreCase(""))
                {
                    Toast.makeText(MainActivity.this, "No se ha Ingresado un Numero para Calcular Fibonacci", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent vistaFibonaccci = new Intent(v.getContext(),ActividadFibonacci.class);
                    vistaFibonaccci.putExtra("numeros",numeros.getText().toString());
                    startActivity(vistaFibonaccci);

                    String Actual = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                    contadorActividades = contadorActividades + 1;
                    factorial.setText(Integer.toString(contadorActividades) + "\nACTUALIZACION: " + Actual);
                }
            }
        });


        BotonFactorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String seleccion = opcionFact.getSelectedItem().toString();
                    Intent vistaFactorial = new Intent(v.getContext(),ActividadFactorial.class);
                    vistaFactorial.putExtra("seleccion",seleccion);
                    startActivity(vistaFactorial);
                    String Actual = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                    contadorActividades = contadorActividades + 1;
                    factorial.setText(Integer.toString(contadorActividades) + "\nACTUALIZACION: " + Actual);
            }
        });


        BotonPaises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vistaPaises = new Intent(v.getContext(),ActividadPaises.class);
                startActivity(vistaPaises);
            }
        });
    }
}

