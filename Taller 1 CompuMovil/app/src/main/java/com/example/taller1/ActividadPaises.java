package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ActividadPaises extends AppCompatActivity {

    ListView listaPaises;
    ArrayList<Pais> paises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_paises);

        listaPaises = findViewById(R.id.ListaPaises);

        try {
            JSONObject lecturaJson = new JSONObject(loadJSONFromAsset());
            JSONArray paisesJsonArray = lecturaJson.getJSONArray("paises");
            Pais ingresado = null;
            paises = new ArrayList<>();

            for(int i = 0 ; i < paisesJsonArray.length() ; i++){
                JSONObject jsonObject = paisesJsonArray.getJSONObject(i);
                String nombre_pais = jsonObject.getString("nombre_pais");
                String capital = jsonObject.getString("capital");
                String nombre_pais_int = jsonObject.getString("nombre_pais_int");
                String sigla = jsonObject.getString("sigla");
                ingresado = new Pais(capital,nombre_pais,nombre_pais_int,sigla);
                paises.add(ingresado);
            }
        }catch (JSONException e){

        }

        ArrayAdapter<Pais> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,paises);

        listaPaises.setAdapter(adapter);

        listaPaises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String seleccionPais = listaPaises.getItemAtPosition(position).toString();
                Intent InformacionPais = new Intent(getBaseContext(),InfoPais.class);
                Bundle info = new Bundle();
                info.putString("seleccionKey",seleccionPais);

                Pais enviar = seleccion(seleccionPais);

                info.putString("CapitalKey", enviar.capital);
                info.putString("intKey",enviar.nombre_pais_int);
                info.putString("SiglaKey",enviar.sigla);

                InformacionPais.putExtra("Bundle",info);
                startActivity(InformacionPais);
            }
        });

    }

    public Pais seleccion(String nombre){
        Pais encontrado = null;
        Pais aux;

        for(int i = 0 ; i<paises.size() ; i++)
        {
            aux = paises.get(i);
            if(aux.nombre_pais == nombre)
                encontrado = paises.get(i);
        }
        return encontrado;
    }

    public String loadJSONFromAsset(){
        String json = null;
        try {
            InputStream is =this.getAssets().open("paises.json");
            int size = is.available();
            byte[] buffer = new  byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer,"UTF-8");
        }catch (IOException ex){
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}