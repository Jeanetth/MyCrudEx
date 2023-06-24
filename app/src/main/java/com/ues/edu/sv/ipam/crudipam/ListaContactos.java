package com.ues.edu.sv.ipam.crudipam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
        Contactos contacto1 = new Contactos(1, "Juan", "123456789");
        Contactos contacto2 = new Contactos(2, "Ricardo", "987654321");
        Contactos contacto3 = new Contactos(3, "Godolfredo", "456789123");
        Contactos contacto4 = new Contactos(4, "Enrique", "456789123");
        Contactos contacto5 = new Contactos(4, "Enrique", "456789123");


        contactosList.add(contacto1);
        contactosList.add(contacto2);
        contactosList.add(contacto3);
        contactosList.add(contacto4);
        contactosList.add(contacto5);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // Puedes usar cualquier otro LayoutManager según tus necesidades
        ContactoAdapter adapter = new ContactoAdapter(contactosList);
        recyclerView.setAdapter(adapter);


    }
}
