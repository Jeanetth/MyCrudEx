package com.ues.edu.sv.ipam.crudipam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.ues.edu.sv.ipam.crudipam.sqlLite.Contactos;
import com.ues.edu.sv.ipam.crudipam.sqlLite.CapaBaseDatos;


public class AgregarContactos extends AppCompatActivity {



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

    Button agregar;
    Button buttonReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_contactos);
        agregar=findViewById(R.id.bottonAdd);
        buttonReturn = findViewById(R.id.btn_return);
        editNombre = findViewById(R.id.addName);
        editTelefono = findViewById(R.id.addNumber);
        editApellido = findViewById(R.id.addLastName);
        editDomicilio = findViewById(R.id.addAdress);
        editEdad = findViewById(R.id.addAge);
        editCorreo = findViewById(R.id.addEmail);


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
                apellido = editApellido.getText().toString();
                domicilio = editDomicilio.getText().toString();
                edad = editEdad.getText().toString();
                correo = editCorreo.getText().toString();

                Boolean vacio = true;

                if(
                        !nombre.isEmpty() && !apellido.isEmpty() &&
                        !domicilio.isEmpty() && !edad.isEmpty() &&
                        !correo.isEmpty() && !telefono.isEmpty()
                ){
                    vacio = false;
                }

                int edadInt = -1;
                try {
                    edadInt = Integer.parseInt(edad);
                } catch (NumberFormatException e) {
                    editEdad.setError("Ingrese una edad numérica válida");
                }



                String regex = "^[+]?[0-9]{8,13}$";



                if (vacio == false && Patterns.EMAIL_ADDRESS.matcher(correo).matches() && !(edadInt < 0 || edadInt > 120) &&  telefono.matches(regex)) {

                    Contactos contacto = new Contactos();
                    CapaBaseDatos datos = new CapaBaseDatos(getApplicationContext());

                    contacto.setNombre(nombre);
                    contacto.setTelefono(telefono);
                    contacto.setCorreo(correo);
                    contacto.setEdad(edad);
                    contacto.setDomicilio(domicilio);
                    contacto.setApellido(apellido);
                    datos.addContacto(contacto);
                    Toast.makeText(getApplicationContext(),"Contacto Agregado", Toast.LENGTH_SHORT).show();


                    Intent intent = new Intent(AgregarContactos.this, ListaContactos.class);
                    startActivity(intent);
                }else if(!Patterns.EMAIL_ADDRESS.matcher(correo).matches() && vacio == false &&
                         !(edadInt < 0 || edadInt > 120) &&  telefono.matches(regex)){

                    editCorreo.setError("Ingrese un correo electrónico válido");

                } else if( (edadInt < 0 || edadInt > 120) && Patterns.EMAIL_ADDRESS.matcher(correo).matches() &&
                        vacio == false && telefono.matches(regex)){

                    editEdad.setError("Ingrese una edad válida");

                } else if(!telefono.matches(regex) && !(edadInt < 0 || edadInt > 120) && Patterns.EMAIL_ADDRESS.matcher(correo).matches() &&
                        vacio == false) {

                    editTelefono.setError("Ingrese un número de teléfono válido");

                }else{

                    if (nombre.isEmpty()) {
                        editNombre.setError("Debe llenar este campo");

                    }

                    if (apellido.isEmpty()) {
                        editApellido.setError("Debe llenar este campo");

                    }

                    if (telefono.isEmpty()) {
                        editTelefono.setError("Debe llenar este campo");
                    }

                    if (correo.isEmpty()) {
                        editCorreo.setError("Debe llenar este campo");

                    }

                    if (domicilio.isEmpty()) {
                        editDomicilio.setError("Debe llenar este campo");
                    }

                    if (edad.isEmpty()) {
                        editEdad.setError("Debe llenar este campo");
                    }


                }

            }
        });
    }
}