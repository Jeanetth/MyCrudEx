package com.ues.edu.sv.ipam.crudipam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.ues.edu.sv.ipam.crudipam.sqlLite.Contactos;

public class ModificarContactos extends AppCompatActivity {
    Button buttonReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_contactos);
        Intent intent = getIntent();
        Contactos contactoSeleccionado = (Contactos) intent.getSerializableExtra("contactoSeleccionado");
        EditText nombreEditText = findViewById(R.id.nombreInput);
        EditText telefonoEditText = findViewById(R.id.telefonoInput);

        nombreEditText.setText(contactoSeleccionado.getNombre());
        telefonoEditText.setText(contactoSeleccionado.getTelefono());

        buttonReturn = findViewById(R.id.btn_return);
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ModificarContactos.this, ListaContactos.class );
                startActivity(intent);
            }
        });
    }


    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_contactos);

    }
     */
}
