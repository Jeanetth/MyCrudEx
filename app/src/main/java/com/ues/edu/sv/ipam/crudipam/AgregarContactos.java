package com.ues.edu.sv.ipam.crudipam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AgregarContactos extends AppCompatActivity {

    Button buttonReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_contactos);

        buttonReturn = findViewById(R.id.btn_return);
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgregarContactos.this, MainActivity.class );
                startActivity(intent);
            }
        });
    }
}