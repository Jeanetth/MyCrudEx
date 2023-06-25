package com.ues.edu.sv.ipam.crudipam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ues.edu.sv.ipam.crudipam.sqlLite.CapaBaseDatos;
import com.ues.edu.sv.ipam.crudipam.sqlLite.Contactos;

import java.util.ArrayList;
import java.util.List;

public class ListaContactos extends AppCompatActivity {

    Button buttonReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contactos);
        buttonReturn = findViewById(R.id.btn_return2);
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListaContactos.this, MainActivity.class );
                startActivity(intent);
            }
        });
        List<Contactos> contactosList = new ArrayList<>();
        CapaBaseDatos listaContactos = new CapaBaseDatos(getApplicationContext());
        contactosList= listaContactos.getContactos();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // Puedes usar cualquier otro LayoutManager según tus necesidades
        ContactoAdapter adapter = new ContactoAdapter(contactosList);
        recyclerView.setAdapter(adapter);


    }
}
