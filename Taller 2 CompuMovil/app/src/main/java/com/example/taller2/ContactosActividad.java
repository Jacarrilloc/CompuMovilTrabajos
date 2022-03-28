package com.example.taller2;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ListView;
import android.widget.Toast;

public class ContactosActividad extends AppCompatActivity {

    String[] mProjection;
    Cursor mCursor;
    ContactsAdapter mContactsAdapter;
    ListView mlista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos_actividad);

        mlista = findViewById(R.id.listaContactos);

        mProjection = new String[]{
                ContactsContract.Profile._ID,
                ContactsContract.Profile.DISPLAY_NAME_PRIMARY
        };
        mCursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,
                mProjection, null, null, null);

        mContactsAdapter = new ContactsAdapter(this, null, 0);
        mlista.setAdapter(mContactsAdapter);
        getSinglePermission.launch(Manifest.permission.READ_CONTACTS);

    }

    ActivityResultLauncher<String> getSinglePermission = registerForActivityResult(
            new ActivityResultContracts.RequestPermission(),
            new ActivityResultCallback<Boolean>() {
                @Override
                public void onActivityResult(Boolean result) {
                    if(result == true){
                        initView();
                    }else{

                    }
                }
            });

    public void initView(){
        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_CONTACTS)==
                PackageManager.PERMISSION_GRANTED){
            mCursor=getContentResolver().query(
                    ContactsContract.Contacts.CONTENT_URI,
                    mProjection, null, null, null);
            mContactsAdapter.changeCursor(mCursor);
        }
    }

}