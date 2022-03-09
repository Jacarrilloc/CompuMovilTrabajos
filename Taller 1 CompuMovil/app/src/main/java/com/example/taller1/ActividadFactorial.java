package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActividadFactorial extends AppCompatActivity {

    TextView respuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_factorial);

        respuesta = findViewById(R.id.resultadoF);

        String envio = getIntent().getStringExtra("seleccion");
        String inpresion = calcularImpresion(envio);
        int resultado = factorial(envio);
        String imprimir ="Operación: " + inpresion + "\n"+ "Resultado: " + Integer.toString(resultado);

        respuesta.setText(imprimir);
    }

    private int factorial(String numero){
        int dato = Integer.parseInt(numero);
        int resultado = 1;

        if(dato == 1)
            return dato;

        while(dato != 0)
        {
            resultado = resultado * dato;
            dato--;
        }

        return resultado;
    }

    private String calcularImpresion(String numero)
    {
        if (Integer.parseInt(numero) == 1)
            return numero;
        String procesado = "";
        int it = 0;
        while(it != Integer.parseInt(numero))
        {
            if(it==0)
            {
                it++;
            }
            procesado = procesado.concat(String.valueOf(it) + "*");
            it++;
        }
        procesado = procesado.concat(String.valueOf(it));
        return procesado;
    }
}