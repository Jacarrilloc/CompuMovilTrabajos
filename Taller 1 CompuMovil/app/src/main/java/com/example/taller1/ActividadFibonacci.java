package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ActividadFibonacci extends AppCompatActivity {

    ImageButton fotoFibo;
    TextView impresion;
    String url = "https://es.wikipedia.org/wiki/Leonardo_de_Pisa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_fibonacci);

        fotoFibo = findViewById(R.id.cara);
        impresion = findViewById(R.id.FiboResult);

        String numero = getIntent().getStringExtra("numeros");

        String resulrado = calcularFibo(numero);

        impresion.setText(resulrado);

        fotoFibo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri _link = Uri.parse(url);
                Intent link = new Intent(Intent.ACTION_VIEW,_link);
                startActivity(link);
            }
        });
    }

    private String calcularFibo(String numero){
        String resultado = "";
        int numResult = 0;
        int num = Integer.parseInt(numero);
        int num1 = 0;
        int num2 = 1;

        for(int i = 1; i <= num ;i++ ){

            numResult = Fiborecursivo(i);
            resultado = resultado.concat(String.valueOf(numResult) + " \n");
        }

        return resultado;
    }

    private static int Fiborecursivo(int n){
        if(n==0){
            return 0;
        } else if (n==1){
            return 1;
        }else {
            return  Fiborecursivo(n-1) + Fiborecursivo(n - 2);
        }
    }
}