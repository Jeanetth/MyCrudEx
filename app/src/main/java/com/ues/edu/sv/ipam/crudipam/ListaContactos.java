package com.ues.edu.sv.ipam.crudipam;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ues.edu.sv.ipam.crudipam.sqlLite.Contactos;

import java.util.ArrayList;
import java.util.List;

public class ListaContactos extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contactos);

        List<Contactos> contactosList = new ArrayList<>();
        Contactos contacto1 = new Contactos(1, "Nombre 1", "123456789");
        Contactos contacto2 = new Contactos(2, "Nombre 2", "987654321");
        Contactos contacto3 = new Contactos(3, "Nombre 3", "456789123");
        Contactos contacto4 = new Contactos(4, "Nombre 4", "456789123");

        contactosList.add(contacto1);
        contactosList.add(contacto2);
        contactosList.add(contacto3);
        contactosList.add(contacto4);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // Puedes usar cualquier otro LayoutManager según tus necesidades
        ContactoAdapter adapter = new ContactoAdapter(contactosList);
        recyclerView.setAdapter(adapter);


    }
}
