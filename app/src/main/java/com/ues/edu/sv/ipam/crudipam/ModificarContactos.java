package com.ues.edu.sv.ipam.crudipam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ues.edu.sv.ipam.crudipam.sqlLite.CapaBaseDatos;
import com.ues.edu.sv.ipam.crudipam.sqlLite.Contactos;

public class ModificarContactos extends AppCompatActivity {

    Button buttonReturn;
    Button buttonActualizar;
    Button buttonEliminar;
    String nombre;
    String telefono;
    String apellido;
    String edad;
    String domicilio;
    String correo;


    EditText editNombre;
    EditText editTelefono;
    EditText editApellido;
    EditText editEdad;
    EditText editDomicilio;
    EditText editCorreo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_contactos);
        Intent intent = getIntent();
        Contactos contactoSeleccionado = (Contactos) intent.getSerializableExtra("contactoSeleccionado");
        editNombre = findViewById(R.id.nombreInput);
        editTelefono = findViewById(R.id.telefonoInput);
        editApellido = findViewById(R.id.apellidoInput);
        editCorreo = findViewById(R.id.correoInput);
        editEdad = findViewById(R.id.edadInput);
        editDomicilio = findViewById(R.id.domicilioInput);


        editNombre.setText(contactoSeleccionado.getNombre());
        editTelefono.setText(contactoSeleccionado.getTelefono());
        editEdad.setText(contactoSeleccionado.getEdad());
        editDomicilio.setText(contactoSeleccionado.getDomicilio());
        editApellido.setText(contactoSeleccionado.getApellido());
        editCorreo.setText(contactoSeleccionado.getCorreo());

        buttonReturn = findViewById(R.id.btn_return);
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ModificarContactos.this, ListaContactos.class );
                startActivity(intent);
            }
        });
        buttonActualizar = findViewById(R.id.actualizar);
        buttonActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre = editNombre.getText().toString();
                telefono = editTelefono.getText().toString();
                apellido = editApellido.getText().toString();
                domicilio = editDomicilio.getText().toString();
                edad= editEdad.getText().toString();
                correo=editCorreo.getText().toString();

                Contactos contacto = new Contactos();
                CapaBaseDatos datos = new CapaBaseDatos(getApplicationContext());

                contacto.setNombre(nombre);
                contacto.setTelefono(telefono);
                contacto.setCorreo(correo);
                contacto.setEdad(edad);
                contacto.setDomicilio(domicilio);
                contacto.setApellido(apellido);
                contacto.setID(contactoSeleccionado.getID());
                datos.updateContacto(contacto);
                Toast.makeText(getApplicationContext(),"contacto agregado", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(ModificarContactos.this, ListaContactos.class );
                startActivity(intent);

            }
        });

        buttonEliminar = findViewById(R.id.eliminar);
        buttonEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                Contactos contacto = new Contactos();
                CapaBaseDatos datos = new CapaBaseDatos(getApplicationContext());
                datos.deleteContacto(contactoSeleccionado);
                Intent intent = new Intent(ModificarContactos.this, ListaContactos.class);
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
