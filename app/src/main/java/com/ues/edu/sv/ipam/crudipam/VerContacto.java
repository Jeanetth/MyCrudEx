package com.ues.edu.sv.ipam.crudipam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ues.edu.sv.ipam.crudipam.sqlLite.Contactos;


public class VerContacto  extends AppCompatActivity {


    TextView nombreView;
    TextView apellidoView;
    TextView telefonoView;
    TextView correoView;
    TextView edadView;
    TextView domicilioView;
    Button buttonReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actitvity_ver_contacto);

        nombreView = findViewById(R.id.nombre_text);
        apellidoView = findViewById(R.id.apellido_text);
        telefonoView = findViewById(R.id.telefono_text);
        correoView = findViewById(R.id.correo_text);
        edadView = findViewById(R.id.edad_text);
        domicilioView = findViewById(R.id.domicilio_text);

        Intent intent = getIntent();
        Contactos contactoSeleccionado = (Contactos) intent.getSerializableExtra("contactoSeleccionado");

        nombreView.setText(contactoSeleccionado.getNombre());
        apellidoView.setText(contactoSeleccionado.getApellido());
        telefonoView.setText("Telefono: " + contactoSeleccionado.getTelefono());
        correoView.setText("Correo: " + contactoSeleccionado.getCorreo());
        edadView.setText("Edad: "+ contactoSeleccionado.getEdad() + " años");
        domicilioView.setText("Domicilio: " + contactoSeleccionado.getDomicilio());

        buttonReturn = findViewById(R.id.btn_return);
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VerContacto.this, ListaContactos.class );
                startActivity(intent);
            }
        });


    }
}
