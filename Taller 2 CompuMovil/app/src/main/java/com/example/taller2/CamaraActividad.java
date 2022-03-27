package com.example.taller2;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.net.Uri;
import android.widget.ImageView;

import androidx.core.content.FileProvider;
import java.io.File;

public class CamaraActividad extends AppCompatActivity {

    Button seleccionar, camara;
    ImageView imagen;
    Uri uricamara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camara_actividad);

        seleccionar = findViewById(R.id.seleccionarImagen);
        camara = findViewById(R.id.camaraActividadCamara);
        imagen = findViewById(R.id.foto);

        File archivo = new File(getFilesDir(),"fotosDeCamara");
        uricamara = FileProvider.getUriForFile(this,getApplicationContext().getPackageName()+".fileprovider",archivo);

        ActivityResultLauncher<String> obtenerImagen = registerForActivityResult(
                new ActivityResultContracts.GetContent(),
                new ActivityResultCallback<Uri>() {
                    @Override
                    public void onActivityResult(Uri result) {
                        imagen.setImageURI(result);
                    }
                }
        );

        ActivityResultLauncher<Uri> tomarFoto = registerForActivityResult(
                new ActivityResultContracts.TakePicture(),
                new ActivityResultCallback<Boolean>() {
                    @Override
                    public void onActivityResult(Boolean result) {
                        imagen.setImageURI(uricamara);
                    }
                }
        );

        seleccionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerImagen.launch("image/*");
            }
        });

        camara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tomarFoto.launch(uricamara);
            }
        });

    }
}