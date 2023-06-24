package com.ues.edu.sv.ipam.crudipam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonAdd;
    Button buttonListaContactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = findViewById(R.id.btn_add);
        buttonListaContactos = findViewById(R.id.lista_contactos);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AgregarContactos.class);
                startActivity(intent);
            }
        });

        buttonListaContactos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir la actividad de modificar contactos
                Intent actividad = new Intent(MainActivity.this, ListaContactos.class);
                startActivity(actividad);
            }
        });




    }
}
