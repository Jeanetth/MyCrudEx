package com.ues.edu.sv.ipam.crudipam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.ues.edu.sv.ipam.crudipam.sqlLite.Contactos;
import com.ues.edu.sv.ipam.crudipam.sqlLite.CapaBaseDatos;


public class AgregarContactos extends AppCompatActivity {



    String nombre;
    String telefono;
    EditText editNombre;
    EditText editTelefono;

    Button agregar;
    Button buttonReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_contactos);

        buttonReturn = findViewById(R.id.btn_return);
        editNombre = findViewById(R.id.addName);
        editTelefono = findViewById(R.id.addNumber);
        agregar=findViewById(R.id.bottonAdd);


        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgregarContactos.this, MainActivity.class );
                startActivity(intent);
            }


        });
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 nombre = editNombre.getText().toString();
                 telefono = editTelefono.getText().toString();

                 Contactos contacto = new Contactos();
                 CapaBaseDatos datos = new CapaBaseDatos(getApplicationContext());

                contacto.setNombre(nombre);
                contacto.setTelefono(telefono);
                datos.addContacto(contacto);
                Toast.makeText(getApplicationContext(),"contacto agregado", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(AgregarContactos.this, ListaContactos.class );
                startActivity(intent);
            }

        });
    }
}